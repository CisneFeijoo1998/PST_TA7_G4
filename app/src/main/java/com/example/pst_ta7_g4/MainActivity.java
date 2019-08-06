package com.example.pst_ta7_g4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }



    public void toInformacion(View view) {
        Intent i = new Intent(this, Informacion.class );
        startActivity(i);
    }


    public void toReserva(View view) {
        Intent i = new Intent(this,reservaActivity.class);
        startActivity(i);
    }

    public void toMenu(View view) {
        Intent i = new Intent(this, Menu.class);
        startActivity(i);
    }
}
