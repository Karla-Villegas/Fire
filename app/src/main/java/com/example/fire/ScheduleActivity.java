package com.example.fire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.fire.adminSQLite.DaoDB;
import com.example.fire.adminSQLite.RegisterActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
public class ScheduleActivity extends AppCompatActivity {

    EditText nombretarea, descripcion_tarea;
    TextView tvfecha, tvhora;
    Button guardar;
    private Spinner spinerCategorias;
    private Cursor fila;
    private String alarma, descripcion, titulo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Intent i = getIntent();

        nombretarea       = findViewById(R.id.TituloTarea);
        descripcion_tarea = findViewById(R.id.Descripcion);
        tvfecha           = findViewById(R.id.tvFecha);
        tvhora            = findViewById(R.id.tvHora);

        //llenar spinner categorias
        spinerCategorias = (Spinner) findViewById(R.id.SpCategorias);
        String[] categorias = {"Ejercicio", "Social", "Personal"};
        spinerCategorias.setAdapter(new ArrayAdapter<String>(ScheduleActivity.this, android.R.layout.simple_spinner_dropdown_item, categorias));

        guardar = (Button) findViewById(R.id.GuardarTarea);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registrarTareas();
                servicio();
                Toast.makeText(ScheduleActivity.this, "agregado correctamente", Toast.LENGTH_LONG).show();
            }
        });




    } //..................FIN DEL METODO ONCREATE..............

    //metodo para levantar calendario
    public void openCalendar(View view) {
        Calendar cal = Calendar.getInstance();
        int anio     = cal.get(Calendar.YEAR);
        int mes      = cal.get(Calendar.MONTH);
        int dia      = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(ScheduleActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String fecha = dayOfMonth + "/" + (month + 1) + "/" + year;

                tvfecha.setText(fecha);

            }
        }, anio, mes, dia);
        dpd.show();
    }

    //metodo para levantar reloj
    public void openWatch(View view) {
        Calendar c = Calendar.getInstance();
        int hora   = c.get(Calendar.HOUR_OF_DAY);
        int minuto = c.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(ScheduleActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                tvhora.setText(String.format("%02d:%02d", hourOfDay, minute));

            }
        }, hora, minuto, false);
        tpd.show();
    }


    //METODO PARA REGISTRAR TAREAS
    final DaoDB daoDB = new DaoDB(this);
    public void registrarTareas(){
        SQLiteDatabase BaseDatos = daoDB.getWritableDatabase();

            String tarea_nombre      = nombretarea.getText().toString();
            String tarea_descripcion = descripcion_tarea.getText().toString();
            String tarea_tvfecha     = tvfecha.getText().toString();
            String tarea_tvhora      = tvhora.getText().toString();

        if(!tarea_nombre.isEmpty() && !tarea_descripcion.isEmpty() && !tarea_tvfecha.isEmpty() && !tarea_tvhora.isEmpty()){
            ContentValues datosTarea = new ContentValues();
            datosTarea.put("nombre", tarea_nombre);
            datosTarea.put("descripcion", tarea_descripcion);
            datosTarea.put("fecha", tarea_tvfecha);
            datosTarea.put("hora", tarea_tvhora);

            BaseDatos.insert("tareas", null, datosTarea);
            BaseDatos.close();

            nombretarea.setText("");
            descripcion_tarea.setText("");
            tvfecha.setText("");
            tvhora.setText("");
            Toast.makeText(ScheduleActivity.this, "agregado correctamente", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(ScheduleActivity.this, "Debes llenar todos los campos!!", Toast.LENGTH_LONG).show();
        }
    }

    //SERVICIO DE LA ALARMA
    public void servicio() {
        Intent intent_service_alarm = new Intent(getApplicationContext(), MyAlarmReceiver.class);
        final PendingIntent pIntent = PendingIntent.getBroadcast(this, MyAlarmReceiver.REQUEST_CODE, intent_service_alarm, PendingIntent.FLAG_UPDATE_CURRENT);
        long firstMillis = System.currentTimeMillis(); //first run of alarm is immediate // aranca la palicacion
        int intervalMillis = 1 * 3 * 1000; //3 segundos
        AlarmManager alarm = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
        alarm.setInexactRepeating(AlarmManager.RTC_WAKEUP, firstMillis, intervalMillis, pIntent);
    }






}