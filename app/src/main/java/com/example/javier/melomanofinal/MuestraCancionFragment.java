package com.example.javier.melomanofinal;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;




/**
 * Created by Javier on 04/02/2016.
 */
public class MuestraCancionFragment extends Fragment implements View.OnClickListener{

    TextView texto;
    EditText palabraIngresada;
    Button botonOk;
    private TextView Puntaje;
    private int puntaje2;



    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.muestra_cancion, container, false);
        return view;

    }
    public void setDiscipline(Genero genero) {
        ((TextView)getView().findViewById(R.id.GeneroSeleccionado)).setText(genero.getNombre());
       this.texto= ((TextView)getView().findViewById(R.id.GeneroSeleccionado));
        this.palabraIngresada= ((EditText)getView().findViewById(R.id.editText));
        this.botonOk=((Button)getView().findViewById(R.id.BotonOk));
        botonOk.setOnClickListener(this);

        this.Puntaje = ((TextView)getView().findViewById(R.id.puntaje));

        puntaje2= (int) 0;


    }

    @Override
    public void onClick(View view) {
        if (botonOk == view) {
            int id = 555;
            if (this.Validar()) {
                puntaje2 += 10;
                this.texto.setText("correcto");

                tiempoDeEspera();
                this.Puntaje.setText("puntaje: " + puntaje2);
                LimpiarCampos();


            }
            else {
                this.Puntajety.setText("incorrecto");
                tiempoDeEspera();
                LimpiarCampos();


            }
        }

    }

    private void tiempoDeEspera()
    {
        try {
            Thread.sleep(1000);
        } catch(InterruptedException e) {}
    }


    public void LimpiarCampos(){
        this.texto.setText("");
        this.palabraIngresada.setText("");

    }


    private boolean Validar(){

        String nom = this.palabraIngresada.getText().toString();


        if (nom.equals("hola") )
        {
            return true;
        }
        else
        {
            return false;
        }
    }


}
