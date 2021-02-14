package com.example.fire;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.fire.adminSQLite.Chores;
import com.example.fire.adminSQLite.DaoDB;
import com.example.fire.adminSQLite.User;

import java.util.ArrayList;


public class SettingsFragment extends Fragment {

    Button ButtonCerrarSesion, ButtonEditar;
    TextView txtnombre, txtusuario;
    ArrayList<User> listUser;
    RecyclerView recyclerView;
    Adapter adapter;



    public SettingsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification, container, false);

        ButtonCerrarSesion = view.findViewById(R.id.cerrarSesion);
        ButtonEditar       = view.findViewById(R.id.editar);
        txtnombre          = view.findViewById(R.id.nombre);
        txtusuario         = view.findViewById(R.id.usuario);


        ButtonCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), MainActivity.class));
                getActivity().finish();
            }
        });

//        consultarUser();
        return view;

    }


    private void consultarUser() {

        final DaoDB daoDB = new DaoDB(getContext());
        SQLiteDatabase db = daoDB.getReadableDatabase();
        User user = null;
        Cursor cursor = db.rawQuery("SELECT * FROM usuarios", null);
        while (cursor.moveToNext()){
            user = new User();
            user.setId(cursor.getInt(0));
            user.setNombre(cursor.getString(1));
            user.setUsuario(cursor.getString(2));
            user.setContrasenia(cursor.getString(3));
            listUser.add(user);
        }
        Log.e("DATOS TAREAS", "REGISTROS" + listUser);


    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

}