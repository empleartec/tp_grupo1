package com.example.javier.melomanofinal;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.javier.melomanofinal.adapter.RankingAdapter;
import com.example.javier.melomanofinal.dominio.PuntajeDePartida;

import java.util.List;

public class RankingFragment extends Fragment {

    public RankingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ranking,
                container, false);
        return view;
    }

    public void armarlista(List<PuntajeDePartida> puntajes){
        ListView lista = (ListView) getView().findViewById(R.id.rankinglview);
        RankingAdapter listaAdaptada = new RankingAdapter( this, puntajes);
        lista.setAdapter(listaAdaptada);
    }

}
