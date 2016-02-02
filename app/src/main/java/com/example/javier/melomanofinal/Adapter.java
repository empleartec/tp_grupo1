package com.example.javier.melomanofinal;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Javier on 01/02/2016.
 */
public class Adapter extends BaseAdapter{

    private final Fragment context;
    private final List<Genero> generos;
    private ListGenero listener;

    public Adapter(Fragment context,  List<Genero> generos){

        this.context = context;
        this.generos = generos;
        this.listener =(ListGenero)context;

    }



    @Override
    public int getCount() {
        return generos.size();
    }

    @Override
    public Genero getItem(int position) {
        return generos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context.getContext()).inflate(R.layout.item, parent, false);
        final Genero genero = getItem(position);
        setContenido(view, genero);
        setOnClick(view, genero);
        return view;
    }

    private void setOnClick(View view, final Genero genero) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.tellTheListenerThatADisciplineWasSelected(genero);
            }
        });
    }

    private void setContenido(View view, Genero genero) {
        TextView disciplinaNombreView = (TextView) view.findViewById(R.id.texto);
        disciplinaNombreView.setText(genero.getNombre());

    }
}
