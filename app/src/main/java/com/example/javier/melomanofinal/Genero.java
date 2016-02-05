package com.example.javier.melomanofinal;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Genero implements Parcelable {
    public String nombre;


    public Genero(String nombre){
        this.nombre=nombre;
    }

    protected Genero(Parcel in) {
        nombre = in.readString();
    }

    public static final Creator<Genero> CREATOR = new Creator<Genero>() {
        @Override
        public Genero createFromParcel(Parcel in) {
            return new Genero(in);
        }

        @Override
        public Genero[] newArray(int size) {
            return new Genero[size];
        }
    };

    public String getNombre(){return nombre;}


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String toString() {
        return getNombre();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(nombre);

    }
}
