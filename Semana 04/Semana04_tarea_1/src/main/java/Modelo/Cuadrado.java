/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */
public class Cuadrado {

    private double lado;
    private double perimetro;
    private double area;

    public Cuadrado() {
    }

    public Cuadrado (double lado){
        this.lado= lado;
    } 
            
    public double getLado(){ 
        return lado; 
    } 

    public void setLado (double lado){ 
        this.lado=lado; 
    }
    public double calcularArea(){ 
        return lado * lado;
    }
    
    public double calcularPerimetro (){ 
        return 4 * lado; 
    } 
    public double getArea(){ 
        return this.area; 
    } 
    public double getPerimetro(){ 
        return this.perimetro; 
    } 
}