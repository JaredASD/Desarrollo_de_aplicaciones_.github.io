/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Hexagono {
    private double lado;
    private double perimetro;
    private double area;

    public Hexagono() {
    }

    public Hexagono(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        // Fórmula área del hexágono regular: (3√3 / 2) * lado²
        return ((3 * Math.sqrt(3)) / 2) * lado * lado;
    }

    public double calcularPerimetro() {
        return 6 * lado;
    }

    public double getArea() {
        return this.area;
    }

    public double getPerimetro() {
        return this.perimetro;
    }
}
