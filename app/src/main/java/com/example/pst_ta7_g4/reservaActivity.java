package com.example.pst_ta7_g4;

import android.Manifest;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.util.Calendar;

public class reservaActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String CERO = "0";
    private static final String BARRA = "/";
    private static final String DOS_PUNTOS = ":";
    private static final int SMS_PERMISSION_CONSTANT = 0;

    private final Calendar c = Calendar.getInstance();


    private final int mes = c.get(Calendar.MONTH);
    private final int dia = c.get(Calendar.DAY_OF_MONTH);
    private final int anio = c.get(Calendar.YEAR);


    private EditText etFecha;

    private final int hora = c.get(Calendar.HOUR_OF_DAY);
    private final int minuto = c.get(Calendar.MINUTE);

    private EditText etHora;

    private EditText etNumero;
    private EditText etNombre;
    private EditText etCedula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);
        ActivityCompat.requestPermissions(reservaActivity.this, new String[]{Manifest.permission.SEND_SMS}
                , SMS_PERMISSION_CONSTANT);
        //Widget EditText donde se mostrara la fecha obtenida
        etFecha = findViewById(R.id.et_mostrar_fecha_picker);
        //Widget ImageButton del cual usaremos el evento clic para obtener la fecha
        ImageButton ibObtenerFecha = findViewById(R.id.ib_obtener_fecha);
        //Evento setOnClickListener - clic
        ibObtenerFecha.setOnClickListener(this);

        //Widget EditText donde se mostrara la hora obtenida
        etHora = findViewById(R.id.et_mostrar_hora_picker);
        //Widget ImageButton del cual usaremos el evento clic para obtener la hora
        ImageButton ibObtenerHora = findViewById(R.id.ib_obtener_hora);
        //Evento setOnClickListener - clic
        ibObtenerHora.setOnClickListener(this);

        //EditText que contienen datos del cliente.
        etNumero = findViewById(R.id.editText4);
        etNombre = findViewById(R.id.editText5);
        etCedula = findViewById(R.id.editText6);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ib_obtener_fecha:
                obtenerFecha();
                break;
            case R.id.ib_obtener_hora:
                obtenerHora();
                break;
        }
    }

    /**
     * Se hace uso de un cuadro de dialogo para escoger la fecha para la reserva. Viene como predeterminado la fecha
     * del dispositivo.
     */
    private void obtenerFecha(){
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //Esta variable lo que realiza es aumentar en uno el mes ya que comienza desde 0 = enero
                final int mesActual = month + 1;
                //Formateo el día obtenido: antepone el 0 si son menores de 10
                String diaFormateado = (dayOfMonth < 10)? CERO + dayOfMonth :String.valueOf(dayOfMonth);
                //Formateo el mes obtenido: antepone el 0 si son menores de 10
                String mesFormateado = (mesActual < 10)? CERO + mesActual :String.valueOf(mesActual);
                //Muestro la fecha con el formato deseado
                etFecha.setText(diaFormateado + BARRA + mesFormateado + BARRA + year);


            }
        },anio, mes, dia);
        recogerFecha.show();

    }

    /**
     * Se hace uso de un cuadro de dialogo para escoger la hora de la reserva. Viene como predeterminado la hora actual
     * del dispositivo.
     */
    private void obtenerHora(){
        TimePickerDialog recogerHora = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //Formateo el hora obtenido: antepone el 0 si son menores de 10
                String horaFormateada =  (hourOfDay < 10)? CERO + hourOfDay : String.valueOf(hourOfDay);
                //Formateo el minuto obtenido: antepone el 0 si son menores de 10
                String minutoFormateado = (minute < 10)? CERO + minute :String.valueOf(minute);
                //Obtengo el valor a.m. o p.m., dependiendo de la selección del usuario
                String AM_PM;
                if(hourOfDay < 12) {
                    AM_PM = "a.m.";
                } else {
                    AM_PM = "p.m.";
                }
                //Muestro la hora con el formato deseado
                etHora.setText(horaFormateada + DOS_PUNTOS + minutoFormateado + " " + AM_PM);
            }
        }, hora, minuto, false);

        recogerHora.show();
    }

    /**
     * Se hace uso de SMS Manager para el envio de SMS a un numero telefonico. Ademas de crear
     * cuadros de alerta de dialogo y toasts segun convenga.
     * @param view Al ser presionado el boton correspondiente al método.
     */
    public void reservar(View view) {
        if(!(etNumero.getText().toString().equals("")|etNombre.getText().toString().equals("")|etCedula.getText().toString().equals("")|etFecha.getText().toString().equals("")|etHora.getText().toString().equals(""))){
            try {
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage(etNumero.getText().toString(), null, "Su solicitud de reserva ha sido aceptada:\nFecha:" + etFecha.getText().toString() + "\nHora:" + etHora.getText().toString() + "\nA nombre de:" + etNombre.getText().toString() + "\nC.I:" + etCedula.getText().toString(), null, null);
                limpiarCampos();

                AlertDialog.Builder alerta = new AlertDialog.Builder(reservaActivity.this);
                alerta.setMessage("Se ha enviado una confirmacion via SMS de su reserva.");
                alerta.setTitle("!Lo esperamos!");
                alerta.setCancelable(true);

                AlertDialog dialogo = alerta.create();
                dialogo.show();

            }catch (Exception e){
                Toast.makeText(this,"Hubo un error al enviar el mensaje",Toast.LENGTH_LONG).show();
            }
        }else{
            AlertDialog.Builder alerta = new AlertDialog.Builder(reservaActivity.this);
            alerta.setMessage("Por favor, brinde los datos solicitados.");
            alerta.setTitle("Campos vacíos detectados");
            alerta.setCancelable(true);

            AlertDialog dialogo = alerta.create();
            dialogo.show();
        }
    }

    public void limpiar(View view) {
        limpiarCampos();
    }

    /**
     * Metodo que limpia los campos del formulario
     */
    private void limpiarCampos(){
        etNumero.setText("");
        etNombre.setText("");
        etCedula.setText("");
        etFecha.setText("");
        etHora.setText("");
    }
}
