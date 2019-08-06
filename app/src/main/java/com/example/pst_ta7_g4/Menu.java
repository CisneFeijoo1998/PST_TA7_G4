package com.example.pst_ta7_g4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Menu extends AppCompatActivity {

    ListView lista;

    String[][] datos = {
            {"Churrasco Montado", "$5,99", "La carne y la menestra aportan a nuestra dieta proteínas de alta calidad y aminoácidos esenciales para un desarrollo muscular adecuado, mientras que los huevos ayudan a fortalecer los huesos, ya que son una fuente natural de vitamina D, la misma que interviene en la generación del tejido óseo.", "$5,99"},
            {"Mega Apanada", "$5,99", "La carne aporta vitamina B, Zinc y proteínas, esto nos ayuda a tener un mejor desarrollo muscular, además de darnos una muy buena digestión.", "$5,99"},
            {"Especialidad del filete", "$7,85", "Al consumir pollo, ensalada y menestra, aportas a tu dieta proteínas de alta calidad, fibra y antioxidantes importantes. Consumir pollo ayuda a que la piel nunca se seque ya que posee vitamina B2,  encargada de reparar los tejidos de la piel.", "7,85"},
            {"Menestras Especiales", "$7,25", "Los antioxidantes presentes en la proteína de la carne, pollo o cerdo, se combinan en este platillo para llenar de energía tu organismo y lograr una buena digestión, ya que estarás consumiendo alta cantidad de fibra.\n" +
                    "Recuerda que puedes combinar entre carne, pollo o chuleta.", "$7,25"}

    };

    int[] datosImg = {R.drawable.menu_churrascomontado, R.drawable.menu_megaapanada, R.drawable.menu_espepollo, R.drawable.menestras_especiales};
    private Object Integer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        lista = (ListView) findViewById(R.id.Lista);

        lista.setAdapter(new Adaptador(this, datos, datosImg));


        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Intent visorDetalles = new Intent(view.getContext(), VisorMenu.class);
                visorDetalles.putExtra("TIT", datos[position][0]);
                visorDetalles.putExtra("DET", datos[position][2]);
                visorDetalles.putExtra("IMG", datosImg[position]);
                startActivity(visorDetalles);

            }
        });


    }


}
