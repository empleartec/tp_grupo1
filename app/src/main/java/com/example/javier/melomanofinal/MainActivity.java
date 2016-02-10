package com.example.javier.melomanofinal;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements ListGenero.OnDisciplineSelectedListener {

    TextView GenSeleccionado;
    EditText GenIngresado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.GenSeleccionado = (TextView) findViewById(R.id.GeneroSeleccionado);
        this.GenIngresado = (EditText) findViewById(R.id.editText);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onDisciplineSelected(Genero genero) {

        boolean dual_pane = getResources().getBoolean(R.bool.dual_plane);
        if (dual_pane) {
            MuestraCancionFragment fragment = (MuestraCancionFragment) getSupportFragmentManager().findFragmentById(R.id.detalleFragment);
            fragment.setDiscipline(genero);

        } else {
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtra("genero", genero);
            startActivity(intent);
        }
    }




}


