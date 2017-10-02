package com.hame.ecanel.formularioventas.clases.clases.clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hame.ecanel.formularioventas.clases.clases.conexionBD.FvConexion;

import static com.hame.ecanel.formularioventas.clases.clases.conexionBD.FvConexion.Usuario;

/**
 * Created by ecanel on 27/09/2017.
 */

public class FvUsuario {

   //Inicio de Propiedades
    public String IdUsuario;
    public String Nombre;
    public String Password;
    private static FvConexion cn;
    private static  SQLiteDatabase db;

    public String getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        IdUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    //Fin de propiedades

    //Inicio Constructor
    public FvUsuario(String pIdUsuario, String pNombre, String pPassword, Context pContext) {
        this.IdUsuario = pIdUsuario;
        this.Nombre = pNombre;
        this.Password = pPassword;
        cn = new FvConexion(pContext);
    }

    public FvUsuario(Context context)
    {
        cn = new FvConexion(context);
        this.IdUsuario = "";
        this.Nombre = "";
        this.Password = "";
        //contxt = context;
    }

    //Fin de Constructor

    //Inicio Metodos ABC

    //Llenar Datos
    public  ContentValues obtenerValores (){
        ContentValues valor = new ContentValues();
        valor.put(FvConexion.idUsuario, getIdUsuario() );
        valor.put(FvConexion.nombreUsuario, getNombre());
        valor.put(FvConexion.passwordUsuario, getPassword());
        return valor;
    }

    //Insert
    public void insertar()
    {
        db = cn.getWritableDatabase();
        db.insert(FvConexion.tablaUsuario,null,obtenerValores());
    }

    //Select
    public static  boolean validarUsuario(String pUsuario, String pClave, Context context){

        cn = new FvConexion(context);
        db = cn.getReadableDatabase();
        String WHERE = cn.idUsuario.replace(" ","")  + "=? and " + cn.passwordUsuario.replace(" ","") +  "=?";
        String[] whereArgs = {pUsuario, pClave};
        Cursor cQuery = db.query(cn.tablaUsuario, null, WHERE, whereArgs, null, null, null);
        if(cQuery.moveToFirst())
        {
            return true;
        }
        return false;
    }

    //Fin Metodos ABC

}
