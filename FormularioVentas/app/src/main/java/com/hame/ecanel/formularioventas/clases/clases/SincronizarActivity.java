package com.hame.ecanel.formularioventas.clases.clases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hame.ecanel.formularioventas.R;

public class SincronizarActivity extends AppCompatActivity {

    public EditText etEquipo;
    public EditText etDireccionWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sincronizar);
       initComponents();
    }

    public void initComponents(){
        etEquipo = findViewById(R.id.txtEquipo);
        etDireccionWeb = findViewById(R.id.txtDireccionWebService);
    }

    public void Sincronizar(View view){
        String vEquipo = etEquipo.getText().toString();
        String vDireccionWeb = etDireccionWeb.getText().toString();

        if(validarIngresoEquipo(vEquipo)){
            if(validarIngresoDireccionWeb(vDireccionWeb)){
                //Sincronizar
            }else{
                String message = "Ingrese dirección web.";
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }else {
            String message = "Ingrese equipo.";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }

    }

    public boolean validarIngresoEquipo(String pEquipo){
        if((pEquipo != null) && (!pEquipo.trim().isEmpty()) )
            return true;
        return false;
    }

    public boolean validarIngresoDireccionWeb(String pDireccion){
        if((pDireccion != null) && (!pDireccion.trim().isEmpty()) )
            return true;
        return false;
    }
}
