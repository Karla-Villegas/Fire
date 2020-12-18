package com.example.fire;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fire.adminSQLite.DaoDB;
import com.example.fire.adminSQLite.RegisterActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonLogin;
    TextView Registro;
    EditText USUARIO, CONTRASEÑA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*......INTENT A LA ACTIVIDAD REGISTRO......*/
        Registro = findViewById(R.id.TextoRegistro);
        Registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*.......INTEN PRINCIPAL.......*/
                Intent intentRegistro = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intentRegistro);
            }
        });
        /*............................................*/


        final DaoDB daoDB = new DaoDB(getApplicationContext());

        buttonLogin = findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USUARIO = findViewById(R.id.Usuario);
                CONTRASEÑA = findViewById(R.id.Contraseña);

                Cursor cursor = daoDB.ConsultarUserPass(USUARIO.getText().toString(), CONTRASEÑA.getText().toString());
                if (cursor.getCount()> 0){
                    Intent i = new Intent(MainActivity.this, PrincipalActivity.class);
                    MainActivity.this.startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "usuario y/o password incorrectos", Toast.LENGTH_LONG).show();
                }
                USUARIO.setText("");
                CONTRASEÑA.setText("");
                USUARIO.findFocus();

            }
        });


    }
}