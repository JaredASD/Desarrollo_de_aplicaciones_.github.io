/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Conversion {
    private String tipo;
    private double valorEntrada;
    private double valorSalida;

    public Conversion(String tipo, double valorEntrada, double valorSalida) {
        this.tipo = tipo;
        this.valorEntrada = valorEntrada;
        this.valorSalida = valorSalida;
    }

    public String getTipo() { return tipo; }
    public double getValorEntrada() { return valorEntrada; }
    public double getValorSalida() { return valorSalida; }

    @Override
    public String toString() {
        return tipo + ": " + valorEntrada + " → " + valorSalida;
    }
}
