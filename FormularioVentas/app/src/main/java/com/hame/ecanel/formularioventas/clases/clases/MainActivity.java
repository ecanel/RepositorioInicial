package com.hame.ecanel.formularioventas.clases.clases;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hame.ecanel.formularioventas.R;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvCorrelativo;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvUsuario;
import com.hame.ecanel.formularioventas.clases.clases.conexionBD.FvConexion;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        mHandler = new Handler();
        mHandler.postDelayed(rRunnable, 2_000);
    }

    //Metodo para ejecutar en segundo plano
    public Runnable rRunnable = new Runnable(){

        @Override
        public void run() {
            iniciarLogin();
        }
    };

    public void iniciarLogin(){
        crearUsuario();
        Intent intent = new Intent(this, IngresoActivity.class);
        startActivity(intent);
        finish();
    }

    public void crearUsuario(){
        //Se validad si existe el usuario de lo contrario se crea, esto es para tener acceso y por falta de un mantenimiento de usuarios
        if(!FvUsuario.validarUsuario("System","sys",context)){
            FvUsuario usuario = new FvUsuario("System","Emanuel Canel", "sys", context);
            usuario.insertar();
        }
    }

}
