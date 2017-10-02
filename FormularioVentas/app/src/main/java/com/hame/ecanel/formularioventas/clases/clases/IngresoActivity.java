package com.hame.ecanel.formularioventas.clases.clases;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.hame.ecanel.formularioventas.R;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvCliente;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvCorrelativo;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvUsuario;
import com.hame.ecanel.formularioventas.clases.clases.conexionBD.FvConexion;

public class IngresoActivity extends AppCompatActivity {
    public EditText etUsuario;
    public EditText etClave;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        initComponents();
        //ObtenerClientes();
        //ObtenerCorrelativo();
    }

    public void initComponents() {
        etUsuario = (EditText) findViewById(R.id.txtUsuario);
        etClave = (EditText) findViewById(R.id.txtClave);
        context = this;
    }

    public void validarIngreso(View view) {

        String textUsuario = etUsuario.getText().toString();
        String textClave = etClave.getText().toString();

        if (validarIngresoUsuario(textUsuario)) {
            if (validarIngresoClave(textClave)) {
                if (FvUsuario.validarUsuario(textUsuario, textClave,context)){//((textUsuario.compareToIgnoreCase("System") == 0) && (textClave.compareToIgnoreCase("Sys") == 0)) {
                    Intent intent = new Intent(this, ClienteConsultaActivity.class);
                    startActivity(intent);
                } else {
                    String message = "Usuario o clave invalida.";
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show();

                }
            } else {
                String message = "Ingrese clave.";
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();

            }
        } else {
            String message = "Ingrese usuario.";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        }

    }

    public boolean validarIngresoUsuario(String pUsuario){
        if((pUsuario != null) && (!pUsuario.trim().isEmpty()) )
            return true;
        return false;
    }

    public boolean validarIngresoClave(String pClave){
        if((pClave != null) && (!pClave.trim().isEmpty()))
            return true;
        return false;
    }

    public void ObtenerClientes(){

        FvCliente cliente = new FvCliente(context);
        Cursor cursor = cliente.obtener();
        if(cursor != null){
            if(cursor.moveToFirst())
            {
                Toast.makeText(context, "si hay datos", Toast.LENGTH_LONG).show();

            }

//Recorremos el cursor
            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
                String name = cursor.getString(0);
                String phoneNumber = cursor.getString(1);
                String password = cursor.getString(2);

                Toast.makeText(this,name,Toast.LENGTH_LONG).show();
                Toast.makeText(this,phoneNumber,Toast.LENGTH_LONG).show();
                Toast.makeText(this,password,Toast.LENGTH_LONG).show();
            }
        }
    }

    public void ObtenerCorrelativo(){

        FvCorrelativo correlativo = new FvCorrelativo(context);
        Cursor cursor = correlativo.obtener();
        if(cursor != null){
            if(cursor.moveToFirst())
            {
                Toast.makeText(context, "si hay datos", Toast.LENGTH_LONG).show();

            }

//Recorremos el cursor
            for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
                String name = cursor.getString(0);
                String phoneNumber = cursor.getString(1);
                String password = cursor.getString(2);

                Toast.makeText(this,name,Toast.LENGTH_LONG).show();
                Toast.makeText(this,phoneNumber,Toast.LENGTH_LONG).show();
                Toast.makeText(this,password,Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(context, "no hay datos", Toast.LENGTH_LONG).show();

        }
    }
}
