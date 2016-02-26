package com.example.javier.melomanofinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  implements ListGenero.OnGenreSelectedListener {

    TextView GenSeleccionado;
    EditText GenIngresado;
    private List<String> generos = new ArrayList<>();
    private android.support.v7.widget.SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.GenSeleccionado = (TextView) findViewById(R.id.GeneroSeleccionado);
        this.GenIngresado = (EditText) findViewById(R.id.editText);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbarMain);
        toolbar.setTitle(R.string.TitleMainActivity);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void onGenreSelected(String genero) {

        boolean dual_pane = getResources().getBoolean(R.bool.dual_plane);
        if (dual_pane) {
            MuestraCancionFragment fragment = (MuestraCancionFragment) getSupportFragmentManager().findFragmentById(R.id.detalleFragment);
            fragment.setFragmentPorGenero(genero);

        } else {
            Intent intent = new Intent(this, DetalleActivity.class);
            intent.putExtra("genero", genero);
            startActivity(intent);
        }
    }

    @Override
    public void pasarGeneros(List<String> generos) {
        searchView.setVisibility(View.VISIBLE);
        this.generos = generos;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_item, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        this.searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                if (query.length() == 0) {

                } else {
                    List<String> filtradas = filtrar(generos, query);
                    ((ListGenero) getSupportFragmentManager().findFragmentById(R.id.listFragment)).armarLista(filtradas);
                }
                return false;
            }



            @Override
            public boolean onQueryTextChange(String newText) {
                List<String> filtradas = filtrar(generos, newText);
                ((ListGenero) getSupportFragmentManager().findFragmentById(R.id.listFragment)).armarLista(filtradas);
                return false;
            }
        });
        searchView.setVisibility(View.INVISIBLE);

        return true;
    }

    private List<String> filtrar(List<String> generos, String query) {
        List<String> filtrados = new ArrayList<String>();
        for(String genero : generos){
            if(genero.toLowerCase().contains(query.toLowerCase())){
                filtrados.add(genero);
            }
        }
        return filtrados;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}



