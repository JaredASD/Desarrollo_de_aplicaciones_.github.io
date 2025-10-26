/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */

public class Tarea {
    private int id;
    private String nombreEstudiante;
    private String nombre;
    private String descripcion;
    private String fechaEntrega;
    private String estado;

    // 🔹 Constructor sin ID (para cuando se crea desde la vista antes de guardarla)
    public Tarea(String nombreEstudiante, String nombre, String descripcion, String fechaEntrega, String estado) {
        this.nombreEstudiante = nombreEstudiante;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    // 🔹 Constructor con ID (para cuando la traemos desde la BD)
    public Tarea(int id, String nombreEstudiante, String nombre, String descripcion, String fechaEntrega, String estado) {
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    // 🔹 Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}