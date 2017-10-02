package com.hame.ecanel.formularioventas.clases.clases;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.hame.ecanel.formularioventas.R;
import com.hame.ecanel.formularioventas.clases.clases.conexionBD.FvConexion;

public class VentasActivity extends AppCompatActivity {
    public SQLiteDatabase db;
    public Context context;
    public FvConexion conexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ventas);
        context = this;
        conexion = new FvConexion(context);
        initComponentes();


    }

    public void   initComponentes(){
        db = conexion.getReadableDatabase();
    Cursor cursor = db.query(conexion.tablaUsuario,null,null,null,null,null,null);
        if(cursor.moveToFirst())
        {
            Toast.makeText(context, "si hay datos", Toast.LENGTH_LONG).show();

        }

        int nombre = cursor.getColumnIndexOrThrow(conexion.nombreUsuario.replace(" ", ""));
        int usuario = cursor.getColumnIndexOrThrow(conexion.idUsuario.replace(" ", ""));
        int clave = cursor.getColumnIndexOrThrow(conexion.passwordUsuario.replace(" ", ""));

//Recorremos el cursor
        for(cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()){
            String name = cursor.getString(nombre);
            String phoneNumber = cursor.getString(usuario);
            String password = cursor.getString(clave);

            Toast.makeText(this,name,Toast.LENGTH_LONG).show();
            Toast.makeText(this,phoneNumber,Toast.LENGTH_LONG).show();
            Toast.makeText(this,password,Toast.LENGTH_LONG).show();
        }


    }
}
