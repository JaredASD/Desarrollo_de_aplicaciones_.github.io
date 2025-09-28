/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tarea_04_2;
import Vista.*;
import Controlador.*;

public class Tarea_04_2 {
    public static void main(String[] args) {
        LoginVista login = new LoginVista();
        ConversionVista conversion = new ConversionVista();
        ResultadosVista resultados = new ResultadosVista();

        Controlador controlador = new Controlador(login, conversion, resultados);

        login.setVisible(true);
    }
}
