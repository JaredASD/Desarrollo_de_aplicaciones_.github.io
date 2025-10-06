/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador {

    private Login vista;

    public Controlador(Login vista) {
        this.vista = vista;

        // Agregamos listeners
        this.vista.agregarIngresarListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarLogin();
            }
        });

        this.vista.agregarSalirListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void validarLogin() {
        String usuario = vista.obtenerUsuario();
        String clave = vista.obtenerClave();
        String rol = vista.obtenerRol();

        if(usuario.isEmpty() || clave.isEmpty()){
            vista.mostrarMensaje("Debe ingresar usuario y clave obligatoriamente");
            return;
        }

        if(usuario.equals("alumno") && clave.equals("123") && rol.equals("Estudiante")) {
            vista.mostrarMensaje("Bienvenido Estudiante");
            // Aquí abrirías la ventana de estudiante
        } 
        else if(usuario.equals("docente") && clave.equals("456") && rol.equals("Docente")) {
            vista.mostrarMensaje("Bienvenido Docente");
            // Aquí abrirías la ventana de docente
        } 
        else {
            vista.mostrarMensaje("Credenciales incorrectas");
            vista.limpiarCampos();
        }
    }
}