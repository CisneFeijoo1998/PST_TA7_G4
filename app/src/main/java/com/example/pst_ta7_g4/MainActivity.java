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
    public void button(View view) {
        Intent i = new Intent(this, Informacion.class );
        startActivity(i);
    }


    public void toReserva(View view) {
        Intent i = new Intent(this,reservaActivity.class);
        startActivity(i);
    }
}
