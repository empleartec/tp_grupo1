package com.example.javier.melomanofinal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Javier on 04/02/2016.
 */
public class DetalleActivity extends AppCompatActivity {
    public static final String EXTRA_URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getBoolean(R.bool.dual_plane)) {
            finish();
            return;
        }


        Genero genero = (Genero) getIntent().getParcelableExtra("genero");

        setContentView(R.layout.activity_detalle);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String url = extras.getString(EXTRA_URL);

            MuestraCancionFragment detailFragment = (MuestraCancionFragment) getSupportFragmentManager().findFragmentById(R.id.detalleFragment);
            detailFragment.setDiscipline(genero);
        }
    }
}
