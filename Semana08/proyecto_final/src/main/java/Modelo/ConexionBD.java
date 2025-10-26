/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.List;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexionBD{
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_tareas?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // cambia si tienes otro usuario
    private static final String PASSWORD = "jaredmeza3656+"; // cambia si pusiste contraseña a MySQL

    private Connection conexion;

    public ConexionBD() {
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("✅ Conexión exitosa a MySQL.");
        } catch (SQLException e) {
            System.out.println("❌ Error de conexión: " + e.getMessage());
        }
    }

    // ========== GESTIÓN DE USUARIOS ==========
    public Usuario validarUsuario(String usuario, String clave) {
    String sql = "SELECT * FROM estudiantes WHERE nombre_usuario=? AND clave=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                    rs.getString("nombre_usuario"),
                    rs.getString("clave")
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al buscar usuario: " + e.getMessage());
        }
        return null;
}

    public void agregarUsuario(Usuario u) {
        String sql = "INSERT INTO estudiantes (nombre_usuario, clave) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getClave());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
     public Usuario buscarUsuario(String usuario, String clave) {
        String sql = "SELECT * FROM estudiantes WHERE nombre_usuario=? AND clave=?";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                    rs.getString("nombre_usuario"),
                    rs.getString("clave")
                );
            }
        } catch (SQLException e) {
            System.err.println("❌ Error al buscar usuario: " + e.getMessage());
        }
        return null;
    }

    // Método para registrar un nuevo usuario (usado en el registro)
    public boolean registrarUsuario(Usuario u) {
        String sql = "INSERT INTO estudiantes (nombre_usuario, clave) VALUES (?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, u.getNombreUsuario());
            ps.setString(2, u.getClave());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("❌ Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }
    public Connection getConexion() {
        return conexion;
    }

    // ========== GESTIÓN DE TAREAS ==========
    public boolean agregarTarea(Tarea t) {
       
        String sql = "INSERT INTO tareas (nombre_estudiante, titulo, descripcion, fecha_entrega, estado) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(sql)) { 
            System.out.println("📝 Insertando tarea de: " + t.getNombreEstudiante()
    + " | Nombre: " + t.getNombre() 
    + " | Estado: " + t.getEstado());
            ps.setString(1, t.getNombreEstudiante());
            ps.setString(2, t.getNombre());
            ps.setString(3, t.getDescripcion());
            ps.setString(4, t.getFechaEntrega());
            ps.setString(5, t.getEstado());
            ps.executeUpdate();
             System.out.println("✅ Tarea guardada correctamente.");
            return true;
        } catch (SQLException e) {
            System.err.println("❌ Error al guardar tarea: " + e.getMessage());
            return false; // ❌ devolvemos false si falló
        }
    }
    public List<Tarea> obtenerTareasPorUsuario(String nombreUsuario) {
    List<Tarea> lista = new ArrayList<>();
    String sql = "SELECT * FROM tareas WHERE nombre_estudiante = ?";
    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setString(1, nombreUsuario);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Tarea t = new Tarea(
                rs.getInt("id"),
                rs.getString("nombre_estudiante"),
                rs.getString("titulo"),
                rs.getString("descripcion"),
                rs.getString("fecha_entrega"),
                rs.getString("estado")
            );
            lista.add(t);
        }
    } catch (SQLException e) {
        System.out.println("❌ Error al obtener tareas: " + e.getMessage());
    }
    return lista;
}

    public List<Tarea> obtenerTareas() {
        List<Tarea> lista = new ArrayList<>();
        String sql = "SELECT * FROM tareas";
        try (Statement st = conexion.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Tarea t = new Tarea(
                    rs.getInt("id"),
                    rs.getString("nombre_estudiante"),
                    rs.getString("titulo"),
                    rs.getString("descripcion"),
                    rs.getString("fecha_entrega"),
                    rs.getString("estado")
                );
                lista.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean eliminarTarea(int id, String nombreUsuario) {
    String sql = "DELETE FROM tareas WHERE id=? AND nombre_estudiante=?";
    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setInt(1, id);
        ps.setString(2, nombreUsuario);
        int filas = ps.executeUpdate();
        return filas > 0;
    } catch (SQLException e) {
        System.err.println("❌ Error al eliminar tarea: " + e.getMessage());
        return false;
    }
}

    public boolean marcarComoCompletada(String titulo, String nombreUsuario) {
    String sql = "UPDATE tareas SET estado='Completada' WHERE titulo=? AND nombre_estudiante=?";
    try (PreparedStatement ps = conexion.prepareStatement(sql)) {
        ps.setString(1, titulo);
        ps.setString(2, nombreUsuario);
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        System.err.println("❌ Error al marcar tarea como completada: " + e.getMessage());
        return false;
    }
}
}