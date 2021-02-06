package com.example.fire.adminSQLite;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fire.MainActivity;
import com.example.fire.R;

public class RegisterActivity extends AppCompatActivity {

    EditText txt_RegNombre, txt_RegUsuario, txt_RegContrasenia;
    TextView Txt_titulo;
    Button btn_registrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt_RegNombre = (EditText)findViewById(R.id.txt_RegNombre);
        txt_RegUsuario = (EditText)findViewById(R.id.txt_RegUsuario);
        txt_RegContrasenia = (EditText)findViewById(R.id.txt_RegContrasenia);
        btn_registrar = (Button)findViewById(R.id.btn_registrar);

        Typeface DisplayRegular = Typeface.createFromAsset(getAssets(),"font/SFUIDisplayRegular.otf");
        Txt_titulo = findViewById(R.id.Txt_titulo);
        Txt_titulo.setTypeface(DisplayRegular);

        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarUsuarios();
            }
        });

    }
    final DaoDB daoDB = new DaoDB(this);
    //METODO PARA REGISTRAR USUARIOS
    public void registrarUsuarios(){
        SQLiteDatabase BaseDatos = daoDB.getWritableDatabase();

        String nombre = txt_RegNombre.getText().toString();
        String usuario = txt_RegUsuario.getText().toString();
        String contrasenia = txt_RegContrasenia.getText().toString();

        if(!nombre.isEmpty() && !usuario.isEmpty() && !contrasenia.isEmpty()){
            ContentValues datosUsuario = new ContentValues();

            datosUsuario.put("nombre", nombre);
            datosUsuario.put("usuario", usuario);
            datosUsuario.put("contrasenia", contrasenia);

            BaseDatos.insert("usuarios", null, datosUsuario);
            BaseDatos.close();

            txt_RegNombre.setText("");
            txt_RegUsuario.setText("");
            txt_RegContrasenia.setText("");

            Toast.makeText(RegisterActivity.this, "agregado correctamente", Toast.LENGTH_LONG).show();
            Intent i = new Intent(RegisterActivity.this, MainActivity.class);
            RegisterActivity.this.startActivity(i);

        } else {
            Toast.makeText(RegisterActivity.this, "Debes llenar todos los campos!!", Toast.LENGTH_LONG).show();
        }
    }

}
