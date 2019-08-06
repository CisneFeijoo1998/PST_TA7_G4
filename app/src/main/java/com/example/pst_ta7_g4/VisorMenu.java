package com.example.pst_ta7_g4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VisorMenu extends AppCompatActivity {


    //cuando se de clic en algun elemento de la lista
    // nos mande a esta actividad y se muestre los respectivos datos
    //de cada plato
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor_menu);

        //declaramos los elementos y obtenemos la informacion que se esta obteniendo
        TextView titulo = (TextView) findViewById(R.id.titulo);
        TextView detalles = (TextView) findViewById(R.id.descripcion);
        ImageView img = (ImageView) findViewById(R.id.visormenu);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        //si no es nuelo, obtenemos el titulo, descripcion e imagen
        if(b!=null) {
            titulo.setText(b.getString("TIT"));
            detalles.setText(b.getString("DET"));
            img.setImageResource(b.getInt("IMG"));
        }
    }

    //metodo para volver al menu
    public void volver(View view) {
        Intent i = new Intent(this, Menu.class);
        startActivity(i);
    }
}
