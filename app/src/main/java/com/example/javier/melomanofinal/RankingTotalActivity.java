package com.example.javier.melomanofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.javier.melomanofinal.clienteRest.ConexionServidor;
import com.example.javier.melomanofinal.clienteRest.MelomanoService;
import com.example.javier.melomanofinal.dominio.PuntajeDePartida;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class RankingTotalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking_total);


    }
}
