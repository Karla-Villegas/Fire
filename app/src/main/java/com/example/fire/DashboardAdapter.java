package com.example.fire;

import android.view.Choreographer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fire.adminSQLite.Chores;

import java.util.ArrayList;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {

    ArrayList<Chores> listaTareas;

    public DashboardAdapter(ArrayList<Chores> listaTareas) {
        this.listaTareas = listaTareas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_tareas, null, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.nombre_tarea.setText(listaTareas.get(position).getNombre());
        holder.descripcion.setText(listaTareas.get(position).getDescripcion());

    }

    @Override
    public int getItemCount() {
        return listaTareas.size();
    }

    public void clear() {
        listaTareas.clear();

    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nombre_tarea, descripcion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre_tarea = itemView.findViewById(R.id.nombre_tarea);
            descripcion  = itemView.findViewById(R.id.descripcion);

        }
    }
}
