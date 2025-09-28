/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea_04_1;
import Controlador.Controlador;
import Vista.Vista;
/**
 *
 * @author User
 */
public class Tarea_04_1 {
  public static void main(String[] args) {
        // Crear la vista
        Vista vista = new Vista();

        // Crear el controlador y enlazarlo con la vista
        Controlador controlador = new Controlador(vista);

        // Hacer visible la vista
        vista.setVisible(true);
    }
}