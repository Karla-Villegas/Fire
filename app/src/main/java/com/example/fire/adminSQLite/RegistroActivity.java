package com.example.fire.adminSQLite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.fire.MainActivity;
import com.example.fire.R;

public class RegistroActivity  extends AppCompatActivity {

    EditText txt_RegNombre, txt_RegUsuario, txt_RegContraseña;
    Button btn_registrar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txt_RegNombre = (EditText)findViewById(R.id.txt_RegNombre);
        txt_RegUsuario = (EditText)findViewById(R.id.txt_RegUsuario);
        txt_RegContraseña = (EditText)findViewById(R.id.txt_RegContraseña);
        btn_registrar = (Button)findViewById(R.id.btn_registrar);

        final DaoDB daoDB = new DaoDB(getApplicationContext());


        btn_registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daoDB.AgreagarUser(
                        txt_RegNombre.getText().toString(),
                        txt_RegUsuario.getText().toString(),
                        txt_RegContraseña.getText().toString()
                );
                Toast.makeText(RegistroActivity.this, "agregado correctamente", Toast.LENGTH_LONG).show();

                Intent i = new Intent(RegistroActivity.this, MainActivity.class);
                RegistroActivity.this.startActivity(i);
            }
        });

    }
}
