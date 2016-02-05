package com.example.javier.melomanofinal;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity  implements ListGenero.OnDisciplineSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onDisciplineSelected(Genero genero) {
        // TODO - if a discipline is selected, we should do something with it (show it maybe?)
        /* TODO - Si una disciplina se selecciona, debemos hacer algo con ella, como mostrarla en
                  otro fragment o abrir un nuevo activity.. */
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
