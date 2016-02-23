package com.example.javier.melomanofinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.javier.melomanofinal.clienteRest.ConexionServidor;
import com.example.javier.melomanofinal.clienteRest.MelomanoService;
import com.example.javier.melomanofinal.dominio.PuntajeDePartida;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class PartidaTerminadaActivity extends AppCompatActivity {

    private String genero;
    private Integer puntaje;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida_terminada);

        genero = getIntent().getStringExtra("genero");
        puntaje = getIntent().getIntExtra("puntaje", 0);
        editText = (EditText) findViewById(R.id.editText);

        RankingFragment fragment = (RankingFragment) getSupportFragmentManager().findFragmentById(R.id.rankingPorGeneroFragment);
        fragment.armarlista(genero);


    }

    public void enviarDatos(View v){
        MelomanoService meServices = ConexionServidor.createMelomanoService();
        meServices.setPuntaje(new PuntajeDePartida(editText.getText().toString(),getIntent().getIntExtra("puntaje", 0), getIntent().getStringExtra("genero")), new Callback<Boolean>() {
            @Override
            public void success(Boolean value, Response response) {
                Log.d("debug",response.getBody().toString());
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("debug", error.getMessage());
            }
        });
    }

}

