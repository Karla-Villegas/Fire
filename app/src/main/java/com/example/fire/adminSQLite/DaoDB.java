package com.example.fire.adminSQLite;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DaoDB extends SQLiteOpenHelper {

    public static final String NOMBRE_BD = "db_fire";
    public static final int Version = 1;
    public static final String CREAR_TABLA_USUARIOS = "CREATE TABLE IF NOT EXISTS usuarios (id_user INTEGER primary key autoincrement, nombre TEXT, usuario TEXT, contrasenia TEXT)";
    public static final String CREAR_TABLA_TAREAS = "CREATE TABLE IF NOT EXISTS tareas (id_tarea INTEGER primary key autoincrement, nombre TEXT, descripcion TEXT, fecha DATE, hora TIME)";
    public static final String CREAR_TABLA_CATEGORIAS = "CREATE TABLE IF NOT EXISTS categorias (id_categorias INTEGER primary key autoincrement, nombre TEXT)";
    public static final String INSERT_CATEGORIAS = "INSERT INTO categorias (nombre) VALUES ('Eventos'), ('Personal'), ('Salud'), ('Deporte'), ('Meta')";

    public DaoDB(Context context) {
        super(context, NOMBRE_BD, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREAR_TABLA_USUARIOS);
        db.execSQL(CREAR_TABLA_TAREAS);
        db.execSQL(CREAR_TABLA_CATEGORIAS);
        db.execSQL(INSERT_CATEGORIAS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    /*.......METODO PARA VALIDAR USUARIOS.........*/
    public Cursor ConsultarUserPass(String usuario, String contrasenia) throws SQLException {

        Cursor mcursor = null;
        mcursor = this.getReadableDatabase().query("usuarios", new String[]{"nombre", "usuario", "contrasenia"},
                "usuario like '"+usuario+"' and contrasenia like '"+contrasenia+"'", null, null, null, null);
        return mcursor;
    }

}
