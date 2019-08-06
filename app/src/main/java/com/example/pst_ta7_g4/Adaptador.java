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


//Esta clase controlara nuestro adaptador
public class Adaptador extends BaseAdapter {

    private static LayoutInflater inflater = null;

    Context contexto; //entorno de la aplicacion
    String[][] datos; //matriz de datos principales
    int[] datosImg; //matriz de datos id imagen

    public Adaptador(Context contexto, String[][] datos, int[] imagenes)
    {
        this.contexto = contexto;
        this.datos = datos;
        this.datosImg = imagenes;

        //sirve para instanciar el archivo de diseño xml creado.
        inflater = (LayoutInflater)contexto.getSystemService(contexto.LAYOUT_INFLATER_SERVICE);
    }
    //Controlara la posicion que nos esten enviando para presentar los datos
    //Este metodo, nos devuelve un contador, por cada elemento que se genere ira incrementando de forma
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final View vista = inflater.inflate(R.layout.elemento_lista, null);

        TextView plato = (TextView) vista.findViewById(R.id.nombreplato);
        TextView valor = (TextView) vista.findViewById(R.id.valorplato);
        ImageView imagen = (ImageView) vista.findViewById(R.id.imageFood);

        //asignamos los valores, por medio de un contador
        //0 y 1 corresponden al nombre de plato y su valor
        plato.setText(datos[i][0]);
        valor.setText(datos[i][1]);
        imagen.setImageResource(datosImg[i]);

        return vista;
    }

    //retornara los datos "datosImg", obtendra el total de elementos que hay
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
