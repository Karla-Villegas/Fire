package com.example.fire;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrincipalActivity extends AppCompatActivity {

    /* Variables de inicialización */
    BottomNavigationView bottomNavigationView;
    Deque<Integer> integerDeque = new ArrayDeque<>(3);
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        /* Asignación de variables */
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        /* Home Fragment en la deque list*/
        integerDeque.push(R.id.bn_home);

        /*Cargar fragmento*/
        loadFragment(new HomeFragment());

        /* Fragment seleccionado por default */
        bottomNavigationView.setSelectedItemId(R.id.bn_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                /*Obtener el id del item del menú*/
                int id = item.getItemId();

                /*Condición*/
                if (integerDeque.contains(id)) {
                    /*Cuando la lista deque contiene el id seleccionada*/
                    if (id == R.id.bn_home) {
                        /*Cuando el id seleccionado es igual a la id del fragmento home*/
                        if (integerDeque.size() != 1) {
                            /*Cuando el tamaño de la lista deque no es igual a 1*/
                            if (flag) {
                                /* Cuando flag es verdadero*/
                                /* Se agrega el fragment home en la lista deque*/
                                integerDeque.addFirst(R.id.bn_home);
                                /* Setea flag como false */
                                flag = false;
                            }
                        }
                    }
                    /*Remueve el id seleccionado de la lista deque*/
                    integerDeque.remove(id);
                }
                /* Push al id seleccionado en la lista deque*/
                integerDeque.push(id);

                /*Load fragment*/
                loadFragment(getFragment(item.getItemId()));

                /*Return true*/
                return true;
            }
        });
    }

    /*Hooola*/

    private Fragment getFragment(int itemId) {
        switch (itemId) {
            case R.id.bn_ajustes:
                /*Inserta el checked en el menú*/
                bottomNavigationView.getMenu().getItem(0).setChecked(true);
                /*Return Notification fragment*/
                return new SettingsFragment();
            case R.id.bn_home:
                /*Inserta el checked en el menú*/
                bottomNavigationView.getMenu().getItem(1).setChecked(true);
                /*Return Home fragment*/
                return  new HomeFragment();
            case R.id.bn_dashboard:
                /*Inserta el checked en el menú*/
                bottomNavigationView.getMenu().getItem(2).setChecked(true);
                /*Return dashboard fragment*/
                return new DashboardFragment();

        }
        /*Insertar checked default home fragment*/
        bottomNavigationView.getMenu().getItem(1).setChecked(true);

        /*Return HomeFragment*/
        return new HomeFragment();
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment, fragment, fragment.getClass().getSimpleName())
                .commit();

    }

    @Override
    public void onBackPressed() {
        /*super.onBackPressed();*/

        /* Ir al fragment anterior */
        integerDeque.pop();

        /*Condición*/
        if (!integerDeque.isEmpty()){
            /*Cuando la lista deque no está vacía*/
            /*Cargar el fragmento*/
            loadFragment(getFragment(integerDeque.peek()));
        } else {
            /*Cuando dequelist está vacía*/
            /*Terminar la actividad*/
            finish();
        }
    }
}