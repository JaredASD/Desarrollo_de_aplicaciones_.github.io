/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {
    private static Connection conn = null;

    // Conectar o crear la base de datos
    public static Connection conectar() {
        try {
            if (conn == null) {
                Class.forName("org.sqlite.JDBC");
                conn = DriverManager.getConnection("jdbc:sqlite:tareas.db");
                System.out.println("✅ Conexión establecida con SQLite");

                crearTablasYUsuarios(); // crea estructura básica si no existe
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        }
        return conn;
    }

    // Crear tabla de usuarios (solo la primera vez)
    private static void crearTablasYUsuarios() {
        try (Statement st = conn.createStatement()) {
            // Crear tabla si no existe
            String sqlTabla = """
                CREATE TABLE IF NOT EXISTS usuarios (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    nombre_usuario TEXT NOT NULL,
                    contraseña TEXT NOT NULL,
                    nombre_completo TEXT,
                    rol TEXT NOT NULL
                );
            """;
            st.execute(sqlTabla);

            // Insertar usuarios predeterminados si no existen
            String sqlDocente = """
                INSERT INTO usuarios (nombre_usuario, contraseña, nombre_completo, rol)
                SELECT 't01261j', '60105104', 'Profesor Principal', 'Docente'
                WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE nombre_usuario = 'docente');
            """;

            String sqlEstudiante = """
                INSERT INTO usuarios (nombre_usuario, contraseña, nombre_completo, rol)
                SELECT 't01298h', '62426993', 'Alumno de Prueba', 'Estudiante'
                WHERE NOT EXISTS (SELECT 1 FROM usuarios WHERE nombre_usuario = 'estudiante');
            """;

            st.execute(sqlDocente);
            st.execute(sqlEstudiante);

            System.out.println("✅ Tabla y usuarios creados (si no existían)");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al crear tabla o usuarios: " + e.getMessage());
        }
    }

    public static void cerrar() {
        try {
            if (conn != null) {
                conn.close();
                conn = null;
                System.out.println("🔒 Conexión cerrada");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage());
        }
    }
}