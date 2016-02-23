package com.example.javier.melomanofinal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Javier on 01/02/2016.
 */
public class ListGenero extends Fragment {
    private OnDisciplineSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_genero,
                container, false);

        ListView lista = (ListView) view.findViewById(R.id.listageneros);
        GenerosAdapter listaAdaptada = new GenerosAdapter( this, GeneroStore.getAll(this.getActivity()));
        lista.setAdapter(listaAdaptada);
        return view;
    }

    public void armarLista(List<Genero> generos) {

        ListView lista = (ListView) getView().findViewById(R.id.listageneros);
        GenerosAdapter listaAdaptada = new GenerosAdapter(this, generos);
        lista.setAdapter(listaAdaptada);
    }

    public interface OnDisciplineSelectedListener {
        void onDisciplineSelected(Genero genero);
    }

    @Override
    public void onAttach(Activity context) {
        super.onAttach(context);
        if (context instanceof OnDisciplineSelectedListener) {
            listener = (OnDisciplineSelectedListener) context;
        } else {
            throw new ClassCastException(context.toString()
                    + " must implement DisciplinesListFragment.OnDisciplineSelectedListener");
        }
    }

    public void tellTheListenerThatADisciplineWasSelected(Genero generos) {
        listener.onDisciplineSelected(generos);
    }

}
