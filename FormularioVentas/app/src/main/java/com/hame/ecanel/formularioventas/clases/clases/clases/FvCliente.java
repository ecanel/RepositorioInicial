package com.hame.ecanel.formularioventas.clases.clases.clases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.hame.ecanel.formularioventas.clases.clases.conexionBD.FvConexion;

/**
 * Created by ecanel on 27/09/2017.
 */

public class FvCliente {
    //Inicio Propiedades
    public int idCliente;
    public String nombre;
    public String direccion;
    public String nit;
    public String telefono;
    public String correo;
    public String contacto;
    public String imagen;
    private FvConexion cn;
    private SQLiteDatabase db;

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setNombre(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }



    //Fin propiedades

    //Inicio constructor

    public FvCliente(int idCliente, String nombre, String direccion, String nit, String telefono, String correo, String contacto, Context pContext) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.telefono = telefono;
        this.correo = correo;
        this.contacto = contacto;
        cn = new FvConexion(pContext);
    }

    public FvCliente(int idCliente, String nombre, String direccion, String nit, String telefono, String correo, String contacto) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.direccion = direccion;
        this.nit = nit;
        this.telefono = telefono;
        this.correo = correo;
        this.contacto = contacto;

    }

    public FvCliente() {
        this.nombre = "";
        this.direccion = "";
        this.nit = "";
        this.telefono = "";
        this.correo = "";
        this.contacto = "";
        this.imagen="";
    }

    public FvCliente(Context pContext) {
        cn = new FvConexion(pContext);
    }
    //Fin constructor

    //Inicio ABC

    //Llenar Datos
    public ContentValues obtenerValores (String pTipoMetodo,Context pContext){

        ContentValues valor = new ContentValues();
        if(pTipoMetodo.compareToIgnoreCase("Insertar")==0){
            valor.put(FvConexion.idCliente, obtenerCorrelativo(pContext) );
        }else {
            valor.put(FvConexion.idCliente, getIdCliente() );
        }
        valor.put(FvConexion.nombreCliente, getNombre());
        valor.put(FvConexion.direccionCliente,getDireccion());
        valor.put(FvConexion.nitCliente,getNit());
        valor.put(FvConexion.telefonoCliente,getTelefono());
        valor.put(FvConexion.correoCliente, getCorreo());
        valor.put(FvConexion.contactoCliente, getContacto());
        return valor;
    }

    //Insert
    public void insertar(Context pContext)
    {
        db = cn.getWritableDatabase();
        db.insert(FvConexion.tablaCliente,null,obtenerValores("Insertar",pContext));
    }

    public void actualizar(Context pContext){

        db = cn.getWritableDatabase();
        db.update(FvConexion.tablaCliente,obtenerValores("Actualizar",pContext),"idCliente=" + getIdCliente(),null);
    }

    public void eliminar(int pIdCliente){
        db = cn.getWritableDatabase();
        db.delete(FvConexion.tablaCliente,"idCliente=" + pIdCliente,null);
    }

    //Select todos
    public Cursor obtener(){

        db = cn.getReadableDatabase();
        Cursor cQuery = db.query(cn.tablaCliente, null, null, null, null, null, null);
        if(cQuery.moveToFirst())
        {
            return cQuery;
        }
        return null;

    }
    //Select
    public Cursor obtener(int pIdCliente){

        db = cn.getReadableDatabase();
        Cursor cQuery = db.query(cn.tablaCliente, null, "idCliente=" +pIdCliente, null, null, null, null);
        if(cQuery.moveToFirst())
        {
            return cQuery;
        }
        return null;

    }

    public int obtenerCorrelativo(Context context){

        int correlativo = 0;
        FvCorrelativo correl = new FvCorrelativo(context);
        correlativo = correl.obtenerCorrelativo(1,"Cliente",context);
        return correlativo;
    }
    //Fin ABC
}
