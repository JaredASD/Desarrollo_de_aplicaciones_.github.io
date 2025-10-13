/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.apps_proy;

import Modelo.Conexion;
import Vista.*;
import Controlador.*;

/**
 *
 * @author User
 */
public class Apps_proy {

    public static void main(String[] args) {
         try { javax.swing.UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); } 
        catch (Exception e) { System.out.println("No se pudo aplicar tema visual"); }
        Conexion.conectar();
        Login vista = new Login();
        Controlador controlador = new Controlador(vista);
        vista.setVisible(true);
    }
}