package com.example.javier.melomanofinal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Javier on 04/02/2016.
 */
public class MuestraCancionFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.muestra_cancion, container, false);
        return view;
    }
    public void setDiscipline(Genero genero) {
        ((TextView)getView().findViewById(R.id.GeneroSeleccionado)).setText(genero.getNombre());

    }
}
