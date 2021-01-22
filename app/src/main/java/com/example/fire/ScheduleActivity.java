package com.example.fire;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
public class ScheduleActivity extends AppCompatActivity {

    TextView tv, tvhora, titulo_agenda;
    Button guardar;
    private Spinner spinerCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Intent i = getIntent();

        tv = (TextView) findViewById(R.id.tv);
        tvhora = (TextView) findViewById(R.id.tvHora);
        guardar = (Button) findViewById(R.id.GuardarTarea);
        titulo_agenda = findViewById(R.id.titulo_agenda);

        //agregar tipografia
        Typeface DisplayRegular = Typeface.createFromAsset(getAssets(),"font/SFUIDisplayRegular.otf");
        titulo_agenda = findViewById(R.id.titulo_agenda);
        titulo_agenda.setTypeface(DisplayRegular);

        //llenar spinner categorias
        spinerCategorias = (Spinner) findViewById(R.id.SpCategorias);
        String[] categorias = {"Ejercicio", "Social", "Personal", "categoria 1", "categoria 2", "categoria 3"};
        spinerCategorias.setAdapter(new ArrayAdapter<String>(ScheduleActivity.this, android.R.layout.simple_spinner_dropdown_item, categorias));


    }

    public void openCalendar(View view) {
        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(ScheduleActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                String fecha = dayOfMonth + "/" + (month +1) + "/" + year;
                tv.setText(fecha);

            }
        }, anio, mes, dia);
        dpd.show();
    }

    public void openWatch(View view) {

        Calendar c = Calendar.getInstance();
        int hora = c.get(Calendar.HOUR_OF_DAY);
        int minuto = c.get(Calendar.MINUTE);

        TimePickerDialog tpd = new TimePickerDialog(ScheduleActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                tvhora.setText(hourOfDay + ":" + minute);

            }
        }, hora, minuto, false);
        tpd.show();
    }


}