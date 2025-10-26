/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.*;
import Vista.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;

public class ControladorEstudiante {

    private EstudianteVista vista;
    private ConexionBD baseDatos;
    private Usuario usuario;

    public ControladorEstudiante(EstudianteVista vista, ConexionBD baseDatos) {
    this.vista = vista;
    this.baseDatos = baseDatos;
    this.usuario = vista.getUsuario();
    this.vista.agregarAgregarListener(new ListenerAgregar());
    this.vista.agregarCompletarListener(new ListenerCompletar());
    this.vista.agregarEliminarListener(new ListenerEliminar());
    this.vista.agregarCalcularListener(new ListenerCalcular());
    this.vista.agregarSalirListener(new ListenerSalir());
    
    mostrarTareasEstudiante();
}


 private void mostrarTareasEstudiante() {
    List<Tarea> tareas = baseDatos.obtenerTareasPorUsuario(usuario.getNombreUsuario());
    vista.actualizarTabla(tareas);
}
    // ---------------------- LISTENERS ----------------------

    // Agregar tarea
    class ListenerAgregar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
             String nombre = vista.getNombre().trim();
            String descripcion = vista.getDescripcion().trim();
            String fecha = vista.getFecha().trim();
            String estado = vista.getEstado();

            if (nombre.isEmpty() || descripcion.isEmpty() || fecha.isEmpty()) {
            vista.mostrarMensaje("Por favor complete todos los campos.");
            return;
        }

        // 2️⃣ Validar formato de fecha (YYYY-MM-DD)
        if (!fecha.matches("\\d{4}-\\d{2}-\\d{2}")) {
            vista.mostrarMensaje("La fecha debe tener el formato YYYY-MM-DD (por ejemplo: 2025-10-20).");
            return;
        }

        // 3️⃣ Validar si la fecha es real (no 2025-13-40)
        try {
            java.time.LocalDate.parse(fecha); // lanza excepción si es inválida
        } catch (Exception ex) {
            vista.mostrarMensaje("La fecha ingresada no es válida. Ejemplo correcto: 2025-10-20");
            return;
        }
            Tarea nueva = new Tarea(
                    usuario.getNombreUsuario(), nombre, descripcion, fecha, estado);
            
             boolean ok = baseDatos.agregarTarea(nueva);

            vista.mostrarMensaje("✅ Tarea agregada correctamente.");
            vista.limpiarCampos();
            vista.actualizarTabla(baseDatos.obtenerTareas());
        }
    }

    // Marcar como completada
    class ListenerCompletar implements ActionListener {

        private String titulo;
        @Override
         public void actionPerformed(ActionEvent e) {
            String nombreTarea = vista.getTareaSeleccionada();
            if (nombreTarea == null) {
                vista.mostrarMensaje("Seleccione una tarea de la tabla para completarla.");
                return;
            }

             boolean resultado = baseDatos.marcarComoCompletada(titulo, usuario.getNombreUsuario());
            if (resultado) {
                vista.mostrarMensaje("✅ Tarea marcada como completada.");
            } else {
                vista.mostrarMensaje("❌ No se encontró la tarea seleccionada.");
            }

            vista.actualizarTabla(baseDatos.obtenerTareas());
        }
    }

    // Eliminar tarea
    class ListenerEliminar implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int fila = vista.getTablaTareas().getSelectedRow();

        if (fila == -1) {
            vista.mostrarMensaje("Por favor, seleccione una tarea para eliminar.");
            return;
        }

        int id = (int) vista.getTablaTareas().getValueAt(fila, 0); // columna 0 = id
        boolean ok = baseDatos.eliminarTarea(id, usuario.getNombreUsuario());

        if (ok) {
            vista.mostrarMensaje("✅ Tarea eliminada correctamente.");
            mostrarTareasEstudiante(); // refrescar tabla
        } else {
            vista.mostrarMensaje("⚠️ No se encontró la tarea a eliminar.");
        }
    }
}

    // Calcular avance
    class ListenerCalcular implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Tarea> tareas = baseDatos.obtenerTareas();
            int total = tareas.size();
            long pendientes = tareas.stream().filter(t -> t.getEstado().equalsIgnoreCase("Pendiente")).count();
            long enProceso = tareas.stream().filter(t -> t.getEstado().equalsIgnoreCase("En Proceso")).count();
            long completadas = tareas.stream().filter(t -> t.getEstado().equalsIgnoreCase("Completada")).count();

            String mensaje = "📊 RESUMEN DE TAREAS:\n\n" +
                    "Total: " + total + "\n" +
                    "Pendientes: " + pendientes + "\n" +
                    "En proceso: " + enProceso + "\n" +
                    "Completadas: " + completadas;

            vista.mostrarMensaje(mensaje);
        }
    }

    // Cerrar sesión
    class ListenerSalir implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            vista.dispose();
            Login loginVista = new Login();
            new ControladorLogin(loginVista, baseDatos);
            loginVista.setVisible(true);
        }
    }
}