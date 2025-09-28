/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private LoginVista loginVista;
    private ConversionVista conversionVista;
    private ResultadosVista resultadosVista;
    private List<Conversion> conversiones;

    public Controlador(LoginVista l, ConversionVista c, ResultadosVista r) {
        this.loginVista = l;
        this.conversionVista = c;
        this.resultadosVista = r;
        this.conversiones = new ArrayList<>();

        // Login
    loginVista.agregarLoginListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String usuario = loginVista.getUsuario();
        String clave   = loginVista.getClave();
        String rol     = loginVista.getRol();

        if(usuario.isEmpty() || clave.isEmpty()) {
            javax.swing.JOptionPane.showMessageDialog(null, 
                "Debe ingresar usuario y contraseña.", 
                "Error", 
                javax.swing.JOptionPane.ERROR_MESSAGE);
            return; // No continúa
        }

        // Aquí podrías validar usuarios reales, pero por ahora 
        // solo verificamos que no esté vacío
        if(rol.equals("Estudiante")) {
            conversionVista.setVisible(true);
        } else {
            resultadosVista.mostrarResultados(conversiones);
            resultadosVista.setVisible(true);
        }
        loginVista.setVisible(false);
    }
});

        // Conversion estudiante
        conversionVista.agregarCalcularListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tipo = conversionVista.getTipoConversion();
                double valor = conversionVista.getValor();
                double resultado = 0;

                switch(tipo) {
                    case "Metros → Kilómetros": resultado = valor / 1000; break;
                    case "Kilómetros → Metros": resultado = valor * 1000; break;
                    case "Metros → Pies": resultado = valor * 3.281; break;
                    case "Pies → Metros": resultado = valor / 3.281; break;
                }

                Conversion conv = new Conversion(tipo, valor, resultado);
                conversiones.add(conv);
                conversionVista.mostrarResultado(conv.toString());
            }
        });

        conversionVista.agregarRegresarListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                conversionVista.setVisible(false);
                loginVista.setVisible(true);
            }
        });

        resultadosVista.agregarRegresarListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultadosVista.setVisible(false);
                loginVista.setVisible(true);
            }
        });
    }
}
