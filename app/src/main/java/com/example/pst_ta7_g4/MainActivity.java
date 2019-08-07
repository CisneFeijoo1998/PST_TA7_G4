package com.example.pst_ta7_g4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //Metodo asignado a img_Encabezado que permite acceder al Acicity "Infromacion"
    public void toInformacion(View view) {
        Intent i = new Intent(this, Informacion.class );
        startActivity(i);
    }

    //Metodo asignado a img_reserva que permite acceder al Acicity "reservaActivity"
    public void toReserva(View view) {
        Intent i = new Intent(this,reservaActivity.class);
        startActivity(i);
    }

    //Metodo asignado a img_menu que permite acceder al Acicity "Menu"
    public void toMenu(View view) {
        Intent i = new Intent(this, Menu.class);
        startActivity(i);
    }
}
