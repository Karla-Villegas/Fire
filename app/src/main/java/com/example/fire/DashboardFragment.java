package com.example.fire;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.fire.adminSQLite.DaoDB;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */


public class DashboardFragment extends Fragment {

    /*RecyclerView recyclerView;
    ArrayList<Chores> dataholder;*/

        ListView listViewTareas;
    ArrayList<String> listaInformacion;
    ArrayList<Chores> listaDeTareas;


    Button agregar;

    public DashboardFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Intent del boton agragar tareas que lleva a la vista registro de tareas
        agregar = (Button) v.findViewById(R.id.BotonAgregar);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ScheduleActivity.class);
                startActivity(i);

            }
        });

//        recyclerView = v.findViewById(R.id.recyclerV_Tareas);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        dataholder = new ArrayList<>();

        final DaoDB daoDB = new DaoDB(getApplicationContext());

        listViewTareas = v.findViewById(R.id.listaTareas);

        consultarListaTareas();

        return v;
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



}