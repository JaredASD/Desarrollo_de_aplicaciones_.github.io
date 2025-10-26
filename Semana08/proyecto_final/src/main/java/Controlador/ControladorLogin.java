/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.BaseDatosSimulada;
import Modelo.ConexionBD;
import Modelo.Usuario;
import Vista.Login;
import Vista.RegistroVista;
import Vista.EstudianteVista;
import Vista.DocenteVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorLogin {
    private Login vista;
    private ConexionBD baseDatos;

    public ControladorLogin(Login vista, ConexionBD baseDatos) {
        this.vista = vista;
        this.baseDatos = baseDatos;
        this.vista.agregarIngresarListener(new LoginListener());
        this.vista.agregarRegistrarListener(new RegistroListener());
    }


    class LoginListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usuario = vista.getUsuario();
            String clave = vista.getClave();

            if (usuario.isEmpty() || clave.isEmpty()) {
            vista.mostrarMensaje("Por favor complete ambos campos.");
            return;
        }
            // 🧑‍🏫 Si el usuario es el docente (predefinido)
            if (usuario.equalsIgnoreCase("docente") && clave.equals("1234")) {
    vista.mostrarMensaje("Inicio de sesión exitoso. ¡Bienvenido Docente!");
    vista.dispose();

    DocenteVista vistaDocente = new DocenteVista();
    new ControladorDocente(vistaDocente, baseDatos);
    vistaDocente.setVisible(true);
    return;
}

// 🎓 Si el usuario es un estudiante registrado
        Usuario u = baseDatos.validarUsuario(usuario, clave);

if (u != null) {
    vista.mostrarMensaje("Inicio de sesión exitoso. ¡Bienvenido, " + u.getNombreUsuario() + "!");
    vista.dispose();

    EstudianteVista ventanaEstudiante = new EstudianteVista(u);
    new ControladorEstudiante(ventanaEstudiante, baseDatos);
    ventanaEstudiante.setVisible(true);
} else {
    vista.mostrarMensaje("Usuario o contraseña incorrectos.");
}
        }
}
    class RegistroListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.dispose();
            RegistroVista registroVista = new RegistroVista();
            new ControladorRegistro(registroVista, baseDatos);
            registroVista.setVisible(true);
        }
    }
}