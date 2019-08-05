package com.example.pst_ta7_g4;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto;
    String[][] datos;
    int[] datosImg;

    public Adaptador(Context contexto, String[][] datos, int[] imagenes)
    {
        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = imagenes;

        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView plato = (TextView) vista.findViewById(R.id.nombreplato);
        TextView valor = (TextView) vista.findViewById(R.id.valorplato);

        ImageView imagen = (ImageView) vista.findViewById(R.id.imageFood);

        plato.setText(datos[i][0]);
        valor.setText(datos[i][1]);
        imagen.setImageResource(datosImg[i]);



//        imagen.setTag(i);
//
//        imagen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent visorImagen = new Intent(contexto, VisorImagen.class);
//                visorImagen.putExtra("IMG", datosImg[(Integer)v.getTag()]);
//                contexto.startActivity(visorImagen);
//            }
//        });


        return vista;
    }

    @Override
    public int getCount() {
        return datosImg.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


}
