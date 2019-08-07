package com.example.pst_ta7_g4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Mapa extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }
    //Este metodo permite dar al boton la accion de regresar a la activity Informacion.
    public void regresar(View view) {
        Intent i = new Intent(this,Informacion.class );
        startActivity(i);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Agregamos una nueva marca en la ubicacion del restaurante en quito, segun sus coordenadas de latitud y longitud.

        LatLng quito = new LatLng(-0.2525943, -78.5224697);
        mMap.addMarker(new MarkerOptions().position(quito).title("Restaurante en Quito")); //Añadimos un titulo a la marca
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(quito,15));

        // Agregamos una nueva marca en la ubicacion del restaurante en guayaquil, segun sus coordenadas de latitud y longitud.
        LatLng gye = new LatLng(-2.1275976, -79.9069422);
        mMap.addMarker(new MarkerOptions().position(gye).title("Restaurante en Guayaquil"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(gye,15));
    }
}