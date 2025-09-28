/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Triangulo {
    private double lado;
    private double perimetro;
    private double area;

    public Triangulo() {
    }

    public Triangulo(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        // fórmula del área de un triángulo equilátero: (√3 / 4) * lado²
        return (Math.sqrt(3) / 4) * lado * lado;
    }

    public double calcularPerimetro() {
        return 3 * lado;
    }

    public double getArea() {
        return this.area;
    }

    public double getPerimetro() {
        return this.perimetro;
    }
}

