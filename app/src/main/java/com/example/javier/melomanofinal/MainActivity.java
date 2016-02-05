package com.example.javier.melomanofinal;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity  implements ListGenero.OnDisciplineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
    public void onDisciplineSelected(Genero genero) {

        boolean dual_pane = getResources().getBoolean(R.bool.dual_plane);
        if(dual_pane){
            MuestraCancionFragment fragment = (MuestraCancionFragment) getSupportFragmentManager().findFragmentById(R.id.detalleFragment);
            fragment.setDiscipline(genero);

        } else {
            Intent intent = new Intent (this,DetalleActivity.class);
            intent.putExtra("genero",  genero);
            startActivity(intent);}
    }
}
