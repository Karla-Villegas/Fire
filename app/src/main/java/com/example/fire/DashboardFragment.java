package com.example.fire;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.fire.adminSQLite.Chores;
import com.example.fire.adminSQLite.DaoDB;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class DashboardFragment extends Fragment {

    ArrayList<Chores> listTareas;
    RecyclerView recyclerView;
    DashboardAdapter adapter;

    Button agregar;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        final DaoDB daoDB = new DaoDB(getContext());
        SQLiteDatabase db = daoDB.getReadableDatabase();
        listTareas = new ArrayList<>();
        recyclerView = v.findViewById(R.id.rv_tareas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        consultarListaTareas();
        adapter = new DashboardAdapter(listTareas);
        recyclerView.setAdapter(adapter);


        // Intent del boton agragar tareas que lleva a la vista registro de tareas
        agregar = (Button) v.findViewById(R.id.BotonAgregar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ScheduleActivity.class);
                startActivity(i);

            }
        });

        return v;
    }

    private void consultarListaTareas() {

        final DaoDB daoDB = new DaoDB(getContext());
        SQLiteDatabase db = daoDB.getReadableDatabase();
        Chores chores = null;
        Cursor cursor = db.rawQuery("SELECT * FROM tareas", null);
        while (cursor.moveToNext()){
            chores = new Chores();
            chores.setId_tareas(cursor.getInt(0));
            chores.setNombre(cursor.getString(1));
            chores.setDescripcion(cursor.getString(2));
            chores.setFecha(cursor.getString(3));
            chores.setHora(cursor.getString(4));

            listTareas.add(chores);
        }
        Log.e("DATOS TAREAS", "REGISTROS" + listTareas);


    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onResume() {
        adapter.clear();
        consultarListaTareas();
        adapter = new DashboardAdapter(listTareas);
        recyclerView.setAdapter(adapter);

        super.onResume();
    }
}