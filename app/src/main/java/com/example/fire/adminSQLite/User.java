package com.example.fire.adminSQLite;

public class User {

    int id_user;
    String nombre, usuario, contrasenia;

    public User() {}

    public User(int id_user, String nombre, String usuario, String contrasenia) {
        this.id_user = id_user;
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_user=" + id_user +
                ", nombre='" + nombre + '\'' +
                ", usuario='" + usuario + '\'' +
                ", contrasenia='" + contrasenia + '\'' +
                '}';
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
