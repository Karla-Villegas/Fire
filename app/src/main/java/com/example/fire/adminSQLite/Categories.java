package com.example.fire.adminSQLite;

public class Categories {

    int id_categorias;
    String nombre;


    public Categories() { }

    public Categories(int id_categorias, String nombre) {
        this.id_categorias = id_categorias;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "id_categorias=" + id_categorias +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public int getId_categorias() {
        return id_categorias;
    }

    public void setId_categorias(int id_categorias) {
        this.id_categorias = id_categorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
