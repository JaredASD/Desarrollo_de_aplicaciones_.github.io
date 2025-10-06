/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.apps_proy;

import Vista.Login;
import Controlador.Controlador;

/**
 *
 * @author User
 */
public class Apps_proy {

    public static void main(String[] args) {
        Login vista = new Login();
        Controlador controlador = new Controlador(vista);
        vista.setVisible(true);
    }
}