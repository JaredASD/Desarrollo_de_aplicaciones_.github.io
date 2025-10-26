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
    private String nombreUsuario;
    private String clave;

    public Usuario( String nombreUsuario, String contraseña) {
        this.nombreUsuario = nombreUsuario;
        this.clave = contraseña;
    }

    public String getNombreUsuario() { return nombreUsuario; }
    public String getClave() { return clave; }
    
    @Override
    public String toString() {
        return "Usuario{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}
