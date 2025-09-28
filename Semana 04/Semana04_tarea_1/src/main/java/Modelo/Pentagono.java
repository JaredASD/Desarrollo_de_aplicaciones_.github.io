/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Pentagono {
    private double lado;
    private double perimetro;
    private double area;

    public Pentagono() {
    }

    public Pentagono(double lado) {
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        this.lado = lado;
    }

    public double calcularArea() {
        // Fórmula área del pentágono regular: (1/4) * √(5(5+2√5)) * lado²
        return (0.25) * Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * lado * lado;
    }

    public double calcularPerimetro() {
        return 5 * lado;
    }

    public double getArea() {
        return this.area;
    }

    public double getPerimetro() {
        return this.perimetro;
    }
}
