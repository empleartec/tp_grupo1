package com.example.javier.melomanofinal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * Created by Javier on 04/02/2016.
 */
public class MuestraCancionFragment extends Fragment implements View.OnClickListener{

    TextView texto;
    EditText palabraIngresada;
    Button botonOk;
    private TextView Puntaje;
    private int puntaje2;
    Button opcion1;
    Button opcion2;
    Button opcion3;
    Button opcion4;
    Button nombreCancion1;
    Button nombreCancion2;
    int x;
    CancionRep canciones;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.muestra_cancion, container, false);
        canciones = new CancionRep("hola","chau","zxc","zxcz");
        return view;

    }
    public void setDiscipline(Genero genero) {
        ((TextView)getView().findViewById(R.id.GeneroSeleccionado)).setText(genero.getNombre());
       this.texto= ((TextView)getView().findViewById(R.id.GeneroSeleccionado));
        this.palabraIngresada= ((EditText)getView().findViewById(R.id.editText));
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


        setCanciones();





        this.Puntaje = ((TextView)getView().findViewById(R.id.puntaje));
        puntaje2= (int) 0;
    }

    public void BotonClick(){

    }


    public void onClick(View view) {

         if( opcion1==view){
            if (this.Validar()) {
                puntaje2 += 10;
                this.texto.setText("correcto");
                tiempoDeEspera();
                this.Puntaje.setText("puntaje: " + puntaje2);
                opcion1.setEnabled(false);

                x+=1;
                LimpiarCampos();
            }
            else {
                this.Puntaje.setText("incorrecto");
                tiempoDeEspera();
                x+=2;
                LimpiarCampos();
            }
        }
        else if(opcion2 ==view){
            if (this.Validar2()) {
                puntaje2 += 10;
                this.texto.setText("correcto");
                tiempoDeEspera();
                this.Puntaje.setText("puntaje: " + puntaje2);
                opcion2.setEnabled(false);

                x+=1;
                LimpiarCampos();

            }
            else {
                this.Puntaje.setText("incorrecto");
                tiempoDeEspera();
                x+=2;
                LimpiarCampos();
            }

        }
        else if(opcion3 ==view){
            if (this.Validar3()) {
                puntaje2 += 10;
                this.texto.setText("correcto");
                tiempoDeEspera();
                this.Puntaje.setText("puntaje: " + puntaje2);
                opcion3.setEnabled(false);

                x+=1;
                LimpiarCampos();
            }
            else {
                this.Puntaje.setText("incorrecto");
                tiempoDeEspera();
                x+=2;
                LimpiarCampos();
            }

        }
        else if(opcion4 ==view){
            if (this.Validar4()) {
                puntaje2 += 10;
                this.texto.setText("correcto");
                tiempoDeEspera();
                this.Puntaje.setText("puntaje: " + puntaje2);
                opcion4.setEnabled(false);

                x+=1;
                LimpiarCampos();
            }
            else {
                this.Puntaje.setText("incorrecto");
                tiempoDeEspera();
                x+=2;
                LimpiarCampos();
            }

        }

    }


    private void tiempoDeEspera()
    {
        try {
            Thread.sleep(700);
        } catch(InterruptedException e) {}
    }


    public void LimpiarCampos(){
        if (x>=2) {
            this.texto.setText("");
            this.opcion1.setText("");
            this.opcion2.setText("");
            this.opcion3.setText("");
            this.opcion4.setText("");
            x=0;
        }

    }
    public void RellenarCampos(){
        this.opcion1.setText("lala");
        this.opcion2.setText("lala");
        this.opcion3.setText("lala");
        this.opcion4.setText("lala");
    }


    private boolean Validar(){
        String opcion1 = this.opcion1.getText().toString();
        return opcion1.equals(canciones.getPalabraCorrectaUno()) ;
    }
    private boolean Validar2() {
        String opcion2 = this.opcion2.getText().toString();
        return  opcion2.equals(canciones.getPalabraCorrectaDos());

    }
    private boolean Validar3() {
        String opcion3 = this.opcion3.getText().toString();
        return opcion3.equals(canciones.getPalabraIncorrectaUno());

    }
    private boolean Validar4() {
        String opcion4 = this.opcion4.getText().toString();
        return opcion4.equals(canciones.getPalabraIncorrectaDos());
    }

    public void setCanciones(){
        this.opcion1.setText("hola");
        this.opcion2.setText("chau");
        this.opcion3.setText("perro");
        this.opcion4.setText("gato");


    }


}
