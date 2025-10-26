/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.BaseDatosSimulada;
import Modelo.Tarea;
import Modelo.ModeloTareas;
import Vista.DocenteVista;
import Vista.Login;

import Modelo.ConexionBD;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControladorDocente {

    private DocenteVista vista;
    private ConexionBD baseDatos;

    public ControladorDocente(DocenteVista vista, ConexionBD baseDatos) {
        this.vista = vista;
        this.baseDatos = baseDatos;

        // Asignar listeners (usa los métodos getters que tenga tu vista)
        this.vista.agregarBuscarListener(new FiltrarListener());
        this.vista.agregarActualizarListener(new ActualizarListener());
        this.vista.agregarAvanceListener(new VerAvanceListener());
        this.vista.agregarSalirListener(new SalirListener());

        // Mostrar al inicio
        mostrarTareas();
    }


    // Cargar todas las tareas desde el modelo a la tabla
    private void mostrarTareas() {
        DefaultTableModel tablaModel = (DefaultTableModel) vista.getTablaTareas().getModel();
        tablaModel.setRowCount(0); // limpiar

        List<Tarea> tareas = baseDatos.obtenerTareas(); // lista de objetos Tarea
        for (Tarea t : tareas) {
            tablaModel.addRow(new Object[]{
                    t.getNombreEstudiante(),
                    t.getNombre(),
                    t.getDescripcion(),
                    t.getFechaEntrega(),
                    t.getEstado()
            });
        }
    }

    // Filtrar por texto y estado
    private void filtrarTareas() {
    String textoFiltro = vista.getTextoBuscar().trim().toLowerCase(); // texto de búsqueda
    String estadoFiltro = vista.getFiltroEstado(); // ya es String (ej: "Todos", "Pendiente"...)

    DefaultTableModel tablaModel = (DefaultTableModel) vista.getTablaTareas().getModel();
    tablaModel.setRowCount(0);

    List<Tarea> tareas = baseDatos.obtenerTareas();
    for (Tarea t : tareas) {
        boolean coincideNombre = textoFiltro.isEmpty()
                || t.getNombre().toLowerCase().contains(textoFiltro)
                || t.getDescripcion().toLowerCase().contains(textoFiltro)
                || t.getNombreEstudiante().toLowerCase().contains(textoFiltro); // 👈 También busca por estudiante

        boolean coincideEstado = estadoFiltro == null
                || estadoFiltro.equalsIgnoreCase("Todos")
                || t.getEstado().equalsIgnoreCase(estadoFiltro);

        if (coincideNombre && coincideEstado) {
            tablaModel.addRow(new Object[]{
                    t.getNombreEstudiante(), // 👈 Se agrega esta columna
                    t.getNombre(),
                    t.getDescripcion(),
                    t.getFechaEntrega(),
                    t.getEstado()
            });
        }
    }
}

    // Mostrar avance general (porcentajes)
    private void verAvance() {
        List<Tarea> tareas = baseDatos.obtenerTareas();
        if (tareas.isEmpty()) {
            vista.mostrarMensaje("No hay tareas registradas.");
            return;
        }
        int total = tareas.size();
        long completadas = tareas.stream().filter(t -> t.getEstado().equalsIgnoreCase("Completada")).count();
        double porcentaje = (completadas * 100.0) / total;
        vista.mostrarMensaje(String.format("Total: %d\nCompletadas: %d\nAvance: %.2f%%", total, completadas, porcentaje));
    }

    // Actualizar (recargar todo)
    private void actualizar() {
        mostrarTareas();
    }

    // ---------- LISTENERS ----------
    class FiltrarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            filtrarTareas();
        }
    }

    class ActualizarListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            actualizar();
        }
    }

    class VerAvanceListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            verAvance();
        }
    }

    class SalirListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.dispose();
            Login loginVista = new Login();
            new ControladorLogin(loginVista, baseDatos);
            loginVista.setVisible(true);
    }
    }
}