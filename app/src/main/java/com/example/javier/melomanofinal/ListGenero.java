package com.example.javier.melomanofinal;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.javier.melomanofinal.adapter.GenerosAdapter;
import com.example.javier.melomanofinal.clienteRest.ConexionServidor;
import com.example.javier.melomanofinal.clienteRest.MelomanoService;
import com.example.javier.melomanofinal.dominio.PuntajeDePartida;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Javier on 01/02/2016.
 */
public class ListGenero extends Fragment {
    private OnDisciplineSelectedListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.lista_genero,
                container, false);
        final ListGenero fragment = this;
        MelomanoService meServices = ConexionServidor.createMelomanoService();
        meServices.getGeneros(new Callback<List<String>>() {
            @Override
            public void success(List<String> genres, Response response) {
                ListView lista = (ListView) view.findViewById(R.id.listageneros);
                GenerosAdapter listaAdaptada = new GenerosAdapter(fragment, genres);
                lista.setAdapter(listaAdaptada);
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

        return view;
    }

    public void armarLista(List<String> generos) {

        ListView lista = (ListView) getView().findViewById(R.id.listageneros);
        GenerosAdapter listaAdaptada = new GenerosAdapter(this, generos);
        lista.setAdapter(listaAdaptada);
    }

    public interface OnDisciplineSelectedListener {
        void onDisciplineSelected(String genero);
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

    public void tellTheListenerThatADisciplineWasSelected(String generos) {
        listener.onDisciplineSelected(generos);
    }

}
