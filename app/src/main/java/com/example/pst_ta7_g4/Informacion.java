package com.example.pst_ta7_g4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;


public class Informacion extends AppCompatActivity {
    Spinner horario;   //Instanciamos el objeto Spinner

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion);

        horario=(Spinner)findViewById(R.id.spinner);
       //Se crea un ArrayAdapter
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.horario, android.R.layout.simple_spinner_item);
        //Se setea el spinner con el adapter
        horario.setAdapter(adapter);
    }
    //este metodo permite dar la funcion al boton para poder volver a la pagina principal
    public void volver(View view) {
        Intent i = new Intent(this,MainActivity.class );
        startActivity(i);
    }

    //este metodo permite dar la funcion al boton para poder ir a la actividad donde se mostrara el mapa con la ubicacion de los restaurantes.
    public void mapa(View view) {
        Intent i = new Intent(this, Mapa.class );
        startActivity(i);
    }

}
