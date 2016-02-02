package com.example.javier.melomanofinal;

import android.content.Context;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javier on 01/02/2016.
 */
public class GeneroStore {
    public static List<Genero> getAll(Context ctx) {
        List<Genero> generos = new ArrayList<>();
        generos.add(new Genero("ROCK"));
        generos.add(new Genero("POP"));
        generos.add(new Genero("CUMBIA"));
        generos.add(new Genero("REGGETON"));
        generos.add(new Genero("TANGO"));
        generos.add(new Genero("REGGAE"));
        generos.add(new Genero("ELECTRONICA"));
        generos.add(new Genero("..."));
        return generos;
    }

    public static List<Genero> filtrar(List<Genero> generos,String nombre) {
        List<Genero> disciplinasADevolver = new ArrayList<Genero>();

        for (Genero genero : generos) {
            if(genero.equals(nombre)){
                disciplinasADevolver.add(genero);
            }
        }
        return disciplinasADevolver;
    }
}
