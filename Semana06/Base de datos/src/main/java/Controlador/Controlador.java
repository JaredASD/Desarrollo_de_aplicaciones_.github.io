/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.*;
import Vista.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class Controlador {
    private Login loginVista;

    public Controlador(Login vista) {
        this.loginVista = vista;

        loginVista.agregarLoginListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!loginVista.validarCampos()) return;

                String usuario = loginVista.getUsuario();
                String clave = loginVista.getClave();
                String rol = loginVista.getRol();

                if (validarUsuario(usuario, clave, rol)) {
                    JOptionPane.showMessageDialog(loginVista, "Bienvenido " + usuario + " (" + rol + ")");
                    // Aquí luego abriremos el menú principal o vista de tareas
                } else {
                    JOptionPane.showMessageDialog(loginVista, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    private boolean validarUsuario(String user, String pass, String rol) {
        Connection conn = Conexion.conectar();
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contraseña = ? AND rol = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.setString(3, rol);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error en validación: " + e.getMessage());
        }
        return false;
    }
}