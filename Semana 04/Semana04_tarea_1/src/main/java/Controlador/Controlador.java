/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;


import Modelo.Cuadrado;
import Modelo.Triangulo;
import Modelo.Pentagono;
import Modelo.Hexagono;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador {
    private final Vista vista;

    public Controlador(Vista vista) {
        this.vista = vista;

        // Listener del botón Calcular
        this.vista.agregarCalcularListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcular();
            }
        });

        // Listener del botón Nuevo
        this.vista.agregarNuevoListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevo();
            }
        });

        // Listener del botón Salir
        this.vista.agregarSalirListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salir();
            }
        });
    }

    // Método para calcular el área y perímetro
     public void calcular() {
        double lado = vista.obtenerLado();
        String figura = vista.obtenerFigura();

        // 🔹 Validación
        if (lado <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor mayor que 0.");
            return;
        }
        if (lado > 200) {
            JOptionPane.showMessageDialog(null, "Ingrese un valor menor o igual a 150.");
            return;
        }

        double area = 0;
        double perimetro = 0;

        switch (figura) {
            case "Cuadrado":
                Cuadrado c = new Cuadrado(lado);
                area = c.calcularArea();
                perimetro = c.calcularPerimetro();
                break;
            case "Triángulo":
                Triangulo t = new Triangulo(lado);
                area = t.calcularArea();
                perimetro = t.calcularPerimetro();
                break;
            case "Pentágono":
                Pentagono p = new Pentagono(lado);
                area = p.calcularArea();
                perimetro = p.calcularPerimetro();
                break;
            case "Hexágono":
                Hexagono h = new Hexagono(lado);
                area = h.calcularArea();
                perimetro = h.calcularPerimetro();
                break;
        }

        // Mostrar resultados en la vista
        vista.mostrarResultados(area, perimetro);

        // Dibujar la figura
        vista.dibujarFigura(figura, (int) lado);

        // 🔹 Redimensionar la ventana para mostrar todo
        vista.setSize(700, 500);
    }

    // Método para limpiar los campos
    public void nuevo() {
        vista.limpiarCampos();
        vista.setSize(500, 400); // volver al tamaño inicial
    }

    // Método para salir
    public void salir() {
        System.exit(0);
    }
}