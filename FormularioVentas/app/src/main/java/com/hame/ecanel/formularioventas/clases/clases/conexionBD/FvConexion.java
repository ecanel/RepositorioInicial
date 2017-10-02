package com.hame.ecanel.formularioventas.clases.clases.conexionBD;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.VisibleForTesting;
import android.util.Log;

/**
 * Created by ecanel on 27/09/2017.
 */

public class FvConexion extends SQLiteOpenHelper {

    // Generales
    public static final int versionBD = 1;
    private static final String text_type = " TEXT";
    private static final String int_type = " Int";
    private static final String coma = " , ";
    private SQLiteDatabase mdb;
    public static final String nombreBD = "FormularioVentas.db";

    //Tabla Usuario
    public static final String tablaUsuario = " Usuario";
    public static final String idUsuario = " IdUsuario";
    public static final String nombreUsuario = " Nombre";
    public static final String passwordUsuario = " Password";

    //Tabla Cliente
    public static final String tablaCliente = "Cliente";
    public static final String idCliente = "IdCliente";
    public static final String nombreCliente ="Cliente";
    public static final String direccionCliente ="Direccion";
    public static final String nitCliente = "Nit";
    public static final String telefonoCliente ="Telefono";
    public static final String correoCliente = "Correo";
    public static final String contactoCliente = "Contacto";


    //Tabla correlativos
    public static final String tablaCorrelativo = "Correlativo";
    public static final String idTabla = "IdTabla";
    public static final String nombreTabla = "NombreTabla";
    public static final String correlativo ="Correlativo";

    //Tabla imagen
    public static final String tablaImagen = "Imagen";
    public static final String idImagen = "IdImagen";
    public static final String nombreImagen = "NombreImagen";
    public static final String pathImagen = "PathImagen";
    public static final String IdClienteImg = "IdCliente";

    public static final String Usuario = "Create table " + tablaUsuario + "("
            + idUsuario + text_type + coma
            + nombreUsuario + text_type + coma
            + passwordUsuario + text_type
            + ");";

    public static final String Cliente = "Create table " + tablaCliente + "("
            + idCliente + int_type + coma
            + nombreCliente + text_type + coma
            + direccionCliente + text_type+ coma
            + nitCliente + text_type + coma
            + telefonoCliente + text_type+ coma
            + correoCliente + text_type + coma
            + contactoCliente + text_type
            + ");";

    public static final String Correlativo = "Create table " + tablaCorrelativo + "("
            + idTabla + int_type + coma
            + nombreTabla + text_type + coma
            + correlativo + int_type
            + ");";

    public static final String Imagen = "Create table " + tablaImagen + "("
            + idImagen + int_type + coma
            + nombreImagen + text_type + coma
            + pathImagen + text_type + coma
            + IdClienteImg + int_type
            + ");";

    public FvConexion(Context context) {
        super(context, nombreBD, null, versionBD);
    }

    public  void openReadTable(){
        mdb = this.getReadableDatabase();
    }

    public void openWriteTable(){
        mdb = this.getWritableDatabase();
    }

    public void FvConexion(){
        if (mdb != null){
            mdb.close();
        }
    }

    @Override
    public void onOpen(SQLiteDatabase sqldb)
    {
        super.onOpen(sqldb);
        if (!sqldb.isReadOnly())
        {
            sqldb.execSQL("PRAGMA foreing_keys=ON;");
        }
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.e("query", Usuario);
        sqLiteDatabase.execSQL(Usuario);
        Log.e("query", Cliente);
        sqLiteDatabase.execSQL(Cliente);
        Log.e("query", Correlativo);
        sqLiteDatabase.execSQL(Correlativo);
        Log.e("query", Imagen);
        sqLiteDatabase.execSQL(Imagen);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
