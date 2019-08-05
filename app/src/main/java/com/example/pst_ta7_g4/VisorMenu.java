package com.example.pst_ta7_g4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class VisorMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_menu);

        ImageView img = (ImageView) findViewById(R.id.visormenu);
        TextView titulo = (TextView) findViewById(R.id.titulo);
        TextView detalles = (TextView) findViewById(R.id.descripcion);


        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        if(b!=null) {
            img.setImageResource(b.getInt("IMG"));
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
        }

    }
}
