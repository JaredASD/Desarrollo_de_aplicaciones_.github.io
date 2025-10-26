/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.apps_proy;

import Modelo.ConexionBD;
import Controlador.ControladorLogin;
import Modelo.BaseDatosSimulada;
import Modelo.Tarea;
import Vista.Login;

public class Apps_proy {
    public static void main(String[] args) {
        // 1️⃣ Crear la base de datos simulada
        ConexionBD baseDatos = new ConexionBD();

        // 2️⃣ Estudiantes registrados
        // 2️⃣ Crear la vista del login
        Login loginVista = new Login();

        // 3️⃣ Crear el controlador del login y vincularlo con la vista y la base de datos
        new ControladorLogin(loginVista, baseDatos);

        // 4️⃣ Mostrar la vista del login
        loginVista.setVisible(true);
    }
}