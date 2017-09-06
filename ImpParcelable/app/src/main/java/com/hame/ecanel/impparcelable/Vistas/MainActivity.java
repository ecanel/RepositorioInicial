package com.hame.ecanel.impparcelable.Vistas;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.hame.ecanel.impparcelable.Clases.Alumno;
import com.hame.ecanel.impparcelable.Clases.ClaseSalon;
import com.hame.ecanel.impparcelable.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Handler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHandler = new Handler();
        mHandler.postDelayed(receiveRunnable,5_000);
    }

    private Runnable receiveRunnable = new Runnable() {
        @Override
        public void run() {
            startReceveInfo();
        }
    };

    private  void startReceveInfo(){
        Intent intent = new Intent(this, RecibeInformacion.class);
        ClaseSalon cs = new ClaseSalon();
        ArrayList<Alumno> lstAlumno = new ArrayList<>();
        Alumno al = new Alumno();
        al.setNombre("Emanuel");
        al.setApellido("Canel");
        lstAlumno.add(al);
        al = new Alumno();
        al.setNombre("Luis");
        al.setApellido("Perez");
        lstAlumno.add(al);

        cs.setNombre("Matematica");
        cs.setDescripcion("Curso de vacaciones.");
        cs.setAlumnos(lstAlumno);

        intent.putExtra("DatosEnviados",cs);
        //Mandar informacion entre ventanas
        //intent.putExtra("DatoString","ValorString");
        Log.i("MainActivity","Inicio");
        startActivity(intent);
        finish();
    }
}
