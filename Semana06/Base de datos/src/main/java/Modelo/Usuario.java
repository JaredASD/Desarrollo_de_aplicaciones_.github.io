/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author User
 */


public class Usuario {
    private int id;
    private String nombreUsuario;
    private String contraseña;
    private String nombreCompleto;
    private String rol;

    public Usuario(int id, String nombreUsuario, String contraseña, String nombreCompleto, String rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
    }

    public int getId() { 
        return id; 
    }
    public String getNombreUsuario() { return nombreUsuario; }
    public String getContraseña() { return contraseña; }
    public String getNombreCompleto() { return nombreCompleto; }
    public String getRol() { return rol; }
}