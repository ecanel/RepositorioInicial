package com.hame.ecanel.formularioventas.clases.clases.clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.hame.ecanel.formularioventas.clases.clases.conexionBD.FvConexion;

/**
 * Created by ecanel on 28/09/2017.
 */

public class FvCorrelativo {
    //Propiedades

    public int idTabla;
    public String nombreTabla;
    public int correlativo;
    private   FvConexion cn;
    private   SQLiteDatabase db;

    public int getIdTabla() {
        return idTabla;
    }

    public void setIdTabla(int idTabla) {
        this.idTabla = idTabla;
    }

    public String getNombreTabla() {
        return nombreTabla;
    }

    public void setNombreTabla(String nombreTabla) {
        this.nombreTabla = nombreTabla;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    //Constructor
       public FvCorrelativo(int idTabla, String nombreTabla, int correlativo, Context pContext) {
        this.idTabla = idTabla;
        this.nombreTabla = nombreTabla;
        this.correlativo = correlativo;
        cn = new FvConexion(pContext);
    }

    public FvCorrelativo(int idTabla, String nombreTabla, Context pContext) {
        this.idTabla = idTabla;
        this.nombreTabla = nombreTabla;
        cn = new FvConexion(pContext);
    }


    public FvCorrelativo() {
        this.idTabla = 0;
        this.nombreTabla = "";
        this.correlativo = 0;
    }

    public FvCorrelativo(Context context){
        cn = new FvConexion(context);
    }
    //Metodoa ABC

    public ContentValues obtenerValores (int pIdTabla, String pNombreTabla, int pCorrelativo){
        ContentValues valor = new ContentValues();
        valor.put(FvConexion.idTabla, pIdTabla );
        valor.put(FvConexion.nombreTabla, pNombreTabla);
        valor.put(FvConexion.correlativo,pCorrelativo);
        return valor;
    }

    public void insertar(int pIdTabla, String pNombreTabla, int pCorrelativo,Context pContext)
    {
        cn = new FvConexion(pContext);
        db = cn.getWritableDatabase();
        db.insert(FvConexion.tablaCorrelativo,null,obtenerValores(pIdTabla,pNombreTabla,pCorrelativo));
    }

    public void actualizar(String pNombreTabla, int pCorrelativo){
        db = cn.getWritableDatabase();
        ContentValues valores = new ContentValues();
        valores.put("Correlativo",pCorrelativo);
        db.update(FvConexion.tablaCorrelativo,valores,"NombreTabla=" + "'" + pNombreTabla+"'",null);
    }

    //Select todos
    public Cursor obtener(){

        db = cn.getReadableDatabase();
        Cursor cQuery = db.query(cn.tablaCorrelativo, null, null, null, null, null, null);
        if(cQuery.moveToFirst())
        {
            return cQuery;
        }
        return null;

    }
    //Select
    public Cursor obtener(String pNombreTabla, Context pContext){
        cn = new FvConexion(pContext);
        db = cn.getReadableDatabase();
        Cursor cQuery = db.query(cn.tablaCorrelativo, null, "NombreTabla=" +"'" + pNombreTabla.replace(" ","")+"'", null, null, null, null);
        if(cQuery.moveToFirst())
        {
            return cQuery;
        }
        return null;

    }

    public int obtenerCorrelativo(int pidTabla, String pNombreTabla, Context pContext){


        db = cn.getReadableDatabase();
        int correlativo = 0;
        Cursor cQuery = obtener(pNombreTabla, pContext);
        if(cQuery != null){
            if(cQuery.moveToFirst()) {
                //int posicion = cQuery.getInt(2);
                int codigo = cQuery.getInt(2);
                correlativo = codigo + 1;
                actualizar(pNombreTabla, correlativo);
            }
        }
        else{
            //Cuando se la primera vez
            correlativo =  1;
            insertar(pidTabla,pNombreTabla,correlativo,pContext);
        }
        return correlativo;
    }
}
