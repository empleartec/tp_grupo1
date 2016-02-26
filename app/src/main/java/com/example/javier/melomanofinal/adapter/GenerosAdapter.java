package com.example.javier.melomanofinal.adapter;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.javier.melomanofinal.Genero;
import com.example.javier.melomanofinal.ListGenero;
import com.example.javier.melomanofinal.R;

import java.util.List;

/**
 * Created by Javier on 01/02/2016.
 */
public class GenerosAdapter extends BaseAdapter{

    private final Fragment context;
    private  List<String> generos;
    private ListGenero listener;

    public GenerosAdapter(Fragment context, List<String> generos){

        this.context = context;
        this.generos = generos;
        this.listener =(ListGenero)context;

    }



    @Override
    public int getCount() {
        return generos.size();
    }

    @Override
    public String getItem(int position) {
        return generos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context.getActivity()).inflate(R.layout.item, parent, false);
        final String genero = getItem(position);
        setContenido(view, genero);
        setOnClick(view, genero);
        return view;
    }

    private void setOnClick(View view, final String genero) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.tellTheListenerThatAGenreWasSelected(genero);
            }
        });
    }

    private void setContenido(View view, String genero) {
        TextView disciplinaNombreView = (TextView) view.findViewById(R.id.texto);
        disciplinaNombreView.setText(genero);

    }

    public void setGeneros(List<String> generos){
        this.generos = generos;
    }

}
