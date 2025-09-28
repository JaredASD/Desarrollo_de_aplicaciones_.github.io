/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class PanelDibujo {
    private int[] xPoints;
    private int[] yPoints;
    private int n;

    public PanelDibujo(int n, int centroX, int centroY, int radio) {
        this.n = n;
        xPoints = new int[n];
        yPoints = new int[n];

        // Calcular ángulos y coordenadas
        for (int i = 0; i < n; i++) {
            double angulo = 2 * Math.PI * i / n - Math.PI / 2; // empieza hacia arriba
            xPoints[i] = centroX + (int)(radio * Math.cos(angulo));
            yPoints[i] = centroY + (int)(radio * Math.sin(angulo));
        }
    }

    public int[] getXPoints() {
        return xPoints;
    }

    public int[] getYPoints() {
        return yPoints;
    }

    public int getNumeroLados() {
        return n;
    }
}

