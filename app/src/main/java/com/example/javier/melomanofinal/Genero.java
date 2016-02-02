package com.example.javier.melomanofinal;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Genero  {
    public String nombre;


    public Genero(String nombre){
        this.nombre=nombre;
    }
    public String getNombre(){return nombre;}


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String toString() {
        return getNombre();
    }

    }
