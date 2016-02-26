package com.example.javier.melomanofinal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.javier.melomanofinal.clienteRest.ConexionServidor;
import com.example.javier.melomanofinal.clienteRest.MelomanoService;
import com.example.javier.melomanofinal.dominio.Cancion;

import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Javier on 04/02/2016.
 */
public class MuestraCancionFragment extends Fragment implements View.OnClickListener{
    TextView cancionIncompleta;
    TextView texto;
    Button botonOk;
    private TextView Puntaje;
    private int puntaje2;
    Button opcion1;
    Button opcion2;
    Button opcion3;
    Button opcion4;
    Button nombreCancion1;
    Button nombreCancion2;
    Cancion cancion;
    List<Cancion> canciones;
    String palabraAComparar;
    private int palabrasIngresadas = 0;
    private int preguntasContestadas =0 ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.muestra_cancion, container, false);


        return view;

    }
    public void setFragmentPorGenero(String genero) {
        ponerReferenciasALosBotones(genero);
        this.obtenerCanciones(genero);

    }

    public void ponerReferenciasALosBotones(String genero) {
        this.texto= ((TextView)getView().findViewById(R.id.GeneroSeleccionado));
        texto.setText(genero);
        this.cancionIncompleta=((TextView)getView().findViewById(R.id.cancion));
        this.opcion1=((Button)getView().findViewById(R.id.opcion));
        opcion1.setOnClickListener(this);
        this.opcion2 =((Button)getView().findViewById(R.id.opcionDos));
        opcion2.setOnClickListener(this);
        this.opcion3 =((Button)getView().findViewById(R.id.opcionTres));
        opcion3.setOnClickListener(this);
        this.opcion4 =((Button)getView().findViewById(R.id.opcionCuatro));
        opcion4.setOnClickListener(this);
        this.nombreCancion1 =((Button)getView().findViewById(R.id.nombreCancion1));
        nombreCancion1.setOnClickListener(this);
        this.nombreCancion2 =((Button)getView().findViewById(R.id.nombreCancion2));
        nombreCancion2.setOnClickListener(this);
        this.Puntaje = ((TextView)getView().findViewById(R.id.puntaje));
        puntaje2 = 0;
    }

    private void obtenerCanciones(String genero) {
        MelomanoService mserv = ConexionServidor.createMelomanoService();
        mserv.getCancionPorGenero(getActivity().getIntent().getStringExtra("genero").toLowerCase(), new Callback<List<Cancion>>() {
            @Override
            public void success(List<Cancion> cancions, Response response) {
                canciones = cancions;
                cancion = canciones.get(0);
                if(cancion!=null){
                    rellenarCampos(cancion);
                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });

    }

    public void rellenarCampos(Cancion c){
        this.cancionIncompleta.setText(cancion.getCancionIncompleta());
        this.opcion1.setText(cancion.getPrimeraPalabra());
        this.opcion2.setText(cancion.getSegundaPalabra());
        this.opcion3.setText(cancion.getPalabraIncorrectaUno());
        this.opcion4.setText(cancion.getPalabraIncorrectaDos());
        this.nombreCancion1.setText(cancion.getNombre());
        this.nombreCancion2.setText(cancion.getPrimerPregunta());
        this.palabraAComparar = cancion.getPrimeraPalabra();
        this.preguntasContestadas = 0;
        this.palabrasIngresadas = 0 ;
    }

    public void onClick(View v){
        Button b = (Button) v;
        if(esUnBotonDePregunta(v)){
           if( validarPregunta(b)){
               texto.setText("" + (puntaje2 + 4));
               puntaje2 = puntaje2 +4;
           }
        }
        else {

            if (this.validar(b)) {
                texto.setText("" + (puntaje2 + 2));
                puntaje2 = puntaje2 + 2;

            }
            actualizarPalabraAComparar();

        }
        verSiHayQueActualizarCancion();
        verSiNoTerminoPartida();
    }

    private void verSiHayQueActualizarCancion() {
        if(palabrasIngresadas==2 && preguntasContestadas ==1 && !(cancion.getNombre().equals(canciones.get(4).getNombre())))
            actualizarCancion();
    }

    private boolean validarPregunta(Button b) {
        preguntasContestadas = preguntasContestadas + 1;
        return cancion.getNombre().equals(b.getText());
    }

    public boolean esUnBotonDePregunta(View v){
        return v == nombreCancion1 || v == nombreCancion2;
    }

    private void actualizarCancion() {
        cancion= canciones.get((canciones.indexOf(cancion)+1));
        rellenarCampos(cancion);
    }

    private boolean validar(Button b){
        palabrasIngresadas = palabrasIngresadas + 1;
        return palabraAComparar.equals(b.getText())&&palabrasIngresadas<3;
    }

    private void verSiNoTerminoPartida(){
       if(palabrasIngresadas==2 && preguntasContestadas ==1&& cancion.getNombre().equals(canciones.get(4).getNombre())) {
          DetalleActivity activity = (DetalleActivity) getActivity();
       activity.terminoJugada(puntaje2);}
    }

    private void actualizarPalabraAComparar() {

        if(palabraAComparar.equals(cancion.getPrimeraPalabra())){palabraAComparar=cancion.getSegundaPalabra();}
    }



}

