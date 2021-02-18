package com.example.fire.adminSQLite;

public class Chores {

    int id_tareas;
    String nombre, descripcion, fecha, hora;
    int id_user;
    int id_categorias;

    public Chores() {}

    public Chores(int id_tareas, String nombre, String descripcion, String fecha, String hora, int id_user, int id_categorias) {
        this.id_tareas = id_tareas;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.id_user = id_user;
        this.id_categorias = id_categorias;
    }

    public int getId_tareas() {
        return id_tareas;
    }

    public void setId_tareas(int id_tareas) {
        this.id_tareas = id_tareas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_categorias() {
        return id_categorias;
    }

    public void setId_categorias(int id_categorias) {
        this.id_categorias = id_categorias;
    }
}
