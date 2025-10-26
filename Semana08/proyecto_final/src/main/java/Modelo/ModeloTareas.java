/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;
import java.util.List;

public class ModeloTareas {

    private List<Tarea> listaTareas;

    public ModeloTareas() {
        listaTareas = new ArrayList<>();
    }

    // ------------------ MÉTODOS CRUD ------------------

    public void agregarTarea(Tarea tarea) {
        listaTareas.add(tarea);
    }

    public void actualizarEstado(int indice, String nuevoEstado) {
        if (indice >= 0 && indice < listaTareas.size()) {
            listaTareas.get(indice).setEstado(nuevoEstado);
        }
    }

    public void eliminarTarea(int indice) {
        if (indice >= 0 && indice < listaTareas.size()) {
            listaTareas.remove(indice);
        }
    }

    // Devuelve todas las tareas como una lista de arreglos para la tabla
    public List<Object[]> getListaTareas() {
        List<Object[]> datos = new ArrayList<>();
        for (Tarea t : listaTareas) {
            datos.add(new Object[]{t.getNombre(), t.getDescripcion(), t.getFechaEntrega(), t.getEstado()});
        }
        return datos;
    }

    // Devuelve la lista real de objetos Tarea (por si se necesita después)
    public List<Tarea> getTareas() {
        return listaTareas;
    }

    // ------------------ FILTRAR ------------------
    public List<Object[]> filtrarTareas(String nombreFiltro, String estadoFiltro) {
        List<Object[]> filtradas = new ArrayList<>();
        for (Tarea t : listaTareas) {
            boolean coincideNombre = t.getNombre().toLowerCase().contains(nombreFiltro.toLowerCase()) || nombreFiltro.isEmpty();
            boolean coincideEstado = estadoFiltro.equals("Todos") || t.getEstado().equalsIgnoreCase(estadoFiltro);

            if (coincideNombre && coincideEstado) {
                filtradas.add(new Object[]{t.getNombre(), t.getDescripcion(), t.getFechaEntrega(), t.getEstado()});
            }
        }
        return filtradas;
    }
}
