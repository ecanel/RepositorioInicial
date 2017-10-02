package com.hame.ecanel.formularioventas.clases.clases.clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;

import com.hame.ecanel.formularioventas.clases.clases.conexionBD.FvConexion;

/**
 * Created by ecanel on 29/09/2017.
 */

public class FvImagen {

    //Region de propiedades
    public int idImagen;
    public String nombreImagen;
    public String pathImagen;
    public int idClienteImg;
    public Bitmap bImagen;

    private FvConexion cn;
    private SQLiteDatabase db;

    public Bitmap getbImagen() {
        return bImagen;
    }

    public void setbImagen(Bitmap bImagen) {
        this.bImagen = bImagen;
    }

    public int getIdImagen() {
        return idImagen;
    }

    public int getIdClienteImg() {
        return idClienteImg;
    }

    public void setIdClienteImg(int idClienteImg) {
        this.idClienteImg = idClienteImg;
    }

    public void setIdImagen(int idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    //Region de constructor
    public FvImagen(int idImagen, String nombreImagen, String pathImagen, int idClienteImg, Bitmap bImagen) {
        this.idImagen = idImagen;
        this.nombreImagen = nombreImagen;
        this.pathImagen = pathImagen;
        this.idClienteImg = idClienteImg;
        this.bImagen = bImagen;
    }

    public FvImagen() {
        this.idImagen = 0;
        this.nombreImagen = "";
        this.pathImagen = "";
        this.idClienteImg = 0;

    }
    //Inicio ABC

    //Llenar Datos
    public ContentValues obtenerValores (String pTipoMetodo, Context pContext){

        ContentValues valor = new ContentValues();
        if(pTipoMetodo.compareToIgnoreCase("Insertar")==0){
            valor.put(FvConexion.idImagen, obtenerCorrelativo(pContext) );
        }else {
            valor.put(FvConexion.idImagen, getIdImagen() );
        }
        valor.put(FvConexion.nombreImagen, getIdImagen());
        valor.put(FvConexion.pathImagen,getPathImagen());
        valor.put(FvConexion.IdClienteImg,getIdClienteImg());
        return valor;
    }

    //Insert
    public void insertar(Context pContext)
    {
        db = cn.getWritableDatabase();
        db.insert(FvConexion.tablaImagen,null,obtenerValores("Insertar",pContext));
    }

    public void actualizar(Context pContext){

        db = cn.getWritableDatabase();
        db.update(FvConexion.tablaImagen,obtenerValores("Actualizar",pContext),"IdImagen=" + getIdImagen(),null);
    }

    public void eliminar(int pIdImagen){
        db = cn.getWritableDatabase();
        db.delete(FvConexion.tablaImagen,"IdImagen=" + pIdImagen,null);
    }

    public int obtenerCorrelativo(Context context){

        int correlativo = 0;
        FvCorrelativo correl = new FvCorrelativo(context);
        correlativo = correl.obtenerCorrelativo(2,"Imagen",context);
        return correlativo;
    }
}
