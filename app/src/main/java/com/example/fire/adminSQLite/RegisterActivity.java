package com.example.fire.adminSQLite;

import android.content.Intent;
import android.graphics.Typeface;
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

    EditText txt_RegNombre, txt_RegUsuario, txt_RegContraseña;
    TextView Txt_titulo;
    Button btn_registrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        txt_RegNombre = (EditText)findViewById(R.id.txt_RegNombre);
        txt_RegUsuario = (EditText)findViewById(R.id.txt_RegUsuario);
        txt_RegContraseña = (EditText)findViewById(R.id.txt_RegContraseña);
        btn_registrar = (Button)findViewById(R.id.btn_registrar);

        Typeface DisplayRegular = Typeface.createFromAsset(getAssets(),"font/SFUIDisplayRegular.otf");
        Txt_titulo = findViewById(R.id.Txt_titulo);
        Txt_titulo.setTypeface(DisplayRegular);


        final DaoDB daoDB = new DaoDB(getApplicationContext());


        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daoDB.AgregarUser(
                        txt_RegNombre.getText().toString(),
                        txt_RegUsuario.getText().toString(),
                        txt_RegContraseña.getText().toString()
                );
                Toast.makeText(RegisterActivity.this, "agregado correctamente", Toast.LENGTH_LONG).show();


                Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                RegisterActivity.this.startActivity(i);
            }
        });

    }
}
