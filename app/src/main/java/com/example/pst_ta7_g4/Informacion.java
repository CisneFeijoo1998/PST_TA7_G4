package com.example.pst_ta7_g4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


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

    public void volver(View view) {
        Intent i = new Intent(this,MainActivity.class );
        startActivity(i);
    }

    public void mapa(View view) {
        Intent i = new Intent(this, Mapa.class );
        startActivity(i);
    }

}
