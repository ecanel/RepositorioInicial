package com.hame.ecanel.impparcelable.Vistas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ForwardingListener;
import android.util.Log;

import com.hame.ecanel.impparcelable.Clases.Alumno;
import com.hame.ecanel.impparcelable.Clases.ClaseSalon;
import com.hame.ecanel.impparcelable.R;

import java.util.ArrayList;
import java.util.List;

public class RecibeInformacion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibe_informacion);

        ClaseSalon cs = getIntent().getParcelableExtra("DatosEnviados");

        Log.i("Curso", cs.getNombre());
        Log.i("Descripción Curso", cs.getDescripcion());


        List<Alumno> lstAlumnos = cs.getAlumnos();

        for(int i = 0; i<lstAlumnos.size() ;i++)
        {
            Log.i("Nombre Alumno", lstAlumnos.get(i).getNombre());
            Log.i("Apellido Alumno", lstAlumnos.get(i).getApellido());
        }
        Log.i("MainActivity","Fin");
    }
}
