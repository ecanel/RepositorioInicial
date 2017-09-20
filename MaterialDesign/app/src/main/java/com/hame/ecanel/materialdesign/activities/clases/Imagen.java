package com.hame.ecanel.materialdesign.activities.clases;

/**
 * Created by ecanel on 19/09/2017.
 */

public class Imagen {

    public  String nombreImagen;
    public  int imagen;

    public String getNombreImagen() {
        return nombreImagen;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

    public Imagen(String nombreImagen, int imagen) {
        this.nombreImagen = nombreImagen;
        this.imagen = imagen;
    }
}
