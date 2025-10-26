/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ConexionBD;
import Modelo.Usuario;
import Modelo.BaseDatosSimulada;
import Vista.RegistroVista;
import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class ControladorRegistro {

      private RegistroVista vista;
      private ConexionBD baseDatos;

    public ControladorRegistro(RegistroVista vista, ConexionBD baseDatos) {
        this.vista = vista;
        this.baseDatos = baseDatos;
        this.vista.agregarRegistrarListener(new RegistrarListener());
        this.vista.agregarCancelarListener(new VolverListener());
    }


    class RegistrarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = vista.getUsuario();
        String clave = vista.getClave();
        String confirmar = vista.getConfirmacion(); // nuevo campo

        if (nombre.isEmpty() || clave.isEmpty() || confirmar.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos son obligatorios");
            return;
        }

        if (!clave.equals(confirmar)) {
            JOptionPane.showMessageDialog(vista, "Las contraseñas no coinciden");
            return;
        }

        Usuario nuevo = new Usuario(nombre, clave);
        baseDatos.agregarUsuario(nuevo);
        JOptionPane.showMessageDialog(vista, "Usuario registrado con éxito");

        // opcional: limpiar los campos después del registro
        vista.limpiarCampos();
    }
    }
    
    class VolverListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.dispose();
            Login loginVista = new Login();
            new ControladorLogin(loginVista, baseDatos);
            loginVista.setVisible(true);
        }
    }
}