package com.hame.ecanel.impparcelable.Clases;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ecanel on 6/09/2017.
 */
public class ClaseSalon implements Parcelable {

    String nombre;
    String descripcion;
    List<Alumno> alumnos;

    public ClaseSalon() {
        nombre = "";
        descripcion = "";
        alumnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    protected ClaseSalon(Parcel in) {
        nombre = in.readString();
        descripcion = in.readString();
        if (in.readByte() == 0x01) {
            alumnos = new ArrayList<Alumno>();
            in.readList(alumnos, Alumno.class.getClassLoader());
        } else {
            alumnos = null;
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(descripcion);
        if (alumnos == null) {
            dest.writeByte((byte) (0x00));
        } else {
            dest.writeByte((byte) (0x01));
            dest.writeList(alumnos);
        }
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<ClaseSalon> CREATOR = new Parcelable.Creator<ClaseSalon>() {
        @Override
        public ClaseSalon createFromParcel(Parcel in) {
            return new ClaseSalon(in);
        }

        @Override
        public ClaseSalon[] newArray(int size) {
            return new ClaseSalon[size];
        }
    };
}