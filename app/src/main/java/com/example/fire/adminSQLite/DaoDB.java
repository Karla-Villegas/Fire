package com.example.fire.adminSQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DaoDB extends SQLiteOpenHelper {

    public static final String NOMBRE_BD = "db_fire";
    public static final int Version = 1;
    public static final String CREAR_TABLA_USUARIOS = "CREATE TABLE IF NOT EXISTS usuarios " +
                                                        "(id_user INTEGER primary key autoincrement, nombre TEXT, usuario TEXT, contraseña TEXT)";



    public DaoDB(Context context) {
        super(context, NOMBRE_BD, null, Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREAR_TABLA_USUARIOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /*.......METODO PARA AGREGAR USUARIOS.........*/
    public void AgreagarUser(String nombre, String usuario, String contraseña){

        SQLiteDatabase BaseDatos = getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("nombre", nombre);
        valores.put("usuario", usuario);
        valores.put("contraseña", contraseña);

        BaseDatos.insert("usuarios", null, valores);
        BaseDatos.close();
    }

    /*.......METODO PARA VALIDAR USUARIOS.........*/
    public Cursor ConsultarUserPass(String usuario, String contraseña) throws SQLException {

        Cursor mcursor = null;
        mcursor = this.getReadableDatabase().query("usuarios", new String[]{"nombre", "usuario", "contraseña"},
                "usuario like '"+usuario+"' and contraseña like '"+contraseña+"'", null, null, null, null);
        return mcursor;
    }
}
