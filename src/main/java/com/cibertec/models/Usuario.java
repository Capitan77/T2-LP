package com.cibertec.models;

public class Usuario {

    //Creamos la clase usuario con los atributos id; nombre; contrasena
    //establecemos los constructores
    //establecemos los GETS
    //establecemos los SETS

    private int id;
    private String nombre;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
