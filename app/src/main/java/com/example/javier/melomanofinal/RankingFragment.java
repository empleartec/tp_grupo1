package com.example.javier.melomanofinal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.javier.melomanofinal.adapter.RankingAdapter;
import com.example.javier.melomanofinal.clienteRest.ConexionServidor;
import com.example.javier.melomanofinal.clienteRest.MelomanoService;
import com.example.javier.melomanofinal.dominio.PuntajeDePartida;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RankingFragment extends Fragment {

    public RankingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_ranking,
                container, false);
        MelomanoService meServices = ConexionServidor.createMelomanoService();
        meServices.getPuntaje(new Callback<List<PuntajeDePartida>>() {
            @Override
            public void success(List<PuntajeDePartida> pjs, Response response) {
                armarlista(pjs,view);

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
        return view;

    }

    public void armarlista(List<PuntajeDePartida> puntajes,View v ){
        ListView lista = (ListView) v.findViewById(R.id.rankinglview);
        RankingAdapter listaAdaptada = new RankingAdapter( this, puntajes);
        lista.setAdapter(listaAdaptada);
    }

    public void armarlista(String genero ){
        MelomanoService meServices = ConexionServidor.createMelomanoService();
        meServices.getPuntajePorGenero(genero, new Callback<List<PuntajeDePartida>>() {
            @Override
            public void success(List<PuntajeDePartida> pjs, Response response) {
                armarlista(pjs, getView());

            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

}
