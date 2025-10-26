/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import java.util.ArrayList;
import java.util.List;

public class BaseDatosSimulada {
    private ArrayList<Usuario> usuarios = new ArrayList<>();
     private static List<Tarea> tareas = new ArrayList<>();

     public List<Tarea> getTareas() {
    return tareas;
}
    public void agregarUsuario(Usuario u) {
        usuarios.add(u);
    }

    public Usuario buscarUsuario(String nombre, String clave) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equals(nombre) && u.getClave().equals(clave)) {
                return u;
            }
        }
        return null;
    }


    // Registrar estudiante
    public boolean registrarUsuario(String nombreUsuario, String contraseña) {
        for (Usuario u : usuarios) {
            if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return false; // usuario ya existe
            }
        }
        usuarios.add(new Usuario( nombreUsuario, contraseña));
        return true;
    }

    // Verificar credenciales
    public boolean validarUsuario(String nombreUsuario, String contraseña) {
    for (Usuario u : usuarios) {
        if (u.getNombreUsuario().equalsIgnoreCase(nombreUsuario) &&
            u.getClave().equals(contraseña)) {
            return true; // Coincide usuario y contraseña
        }
    }
    return false; // No encontró coincidencia
}
    
  public static void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }

    /**
     * Elimina una tarea por su nombre.
     */
    public static boolean eliminarTarea(String nombreTarea) {
        for (Tarea t : tareas) {
            if (t.getNombre().equalsIgnoreCase(nombreTarea)) {
                tareas.remove(t);
                return true;
            }
        }
        return false;
    }

    /**
     * Retorna todas las tareas registradas.
     */
    public static List<Tarea> obtenerTareas() {
        return tareas;
    }

    /**
     * Cambia el estado de una tarea a "Completada".
     */
    public static boolean marcarComoCompletada(String nombreTarea) {
        for (Tarea t : tareas) {
            if (t.getNombre().equalsIgnoreCase(nombreTarea)) {
                t.setEstado("Completada");
                return true;
            }
        }
        return false;
    }

    /**
     * Limpia todas las tareas (solo para pruebas o reinicio).
     */
    public static void limpiarTareas() {
        tareas.clear();
    }
}