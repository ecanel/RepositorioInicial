package com.hame.ecanel.formularioventas.clases.clases;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hame.ecanel.formularioventas.R;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvCliente;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvCorrelativo;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvUsuario;

public class ClienteActivity extends AppCompatActivity implements OnMapReadyCallback {
    public EditText etCodCliente;
    public EditText etClliente;
    public EditText etDireccion;
    public EditText etNit;
    public EditText etTelefono;
    public EditText etCorreo;
    public EditText etContacto;
    private GoogleMap mMap;
    private Context context;
    public Button btBorrar;
    public Button btSincronizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initComponents();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void initComponents(){
        etCodCliente =  findViewById(R.id.txtCodigoCliente);
        etClliente =  findViewById(R.id.txtCliente);
        etDireccion =  findViewById(R.id.txtDireccion);
        etNit =  findViewById(R.id.txtNit);
        etTelefono =  findViewById(R.id.txtTelefono);
        etCorreo = findViewById(R.id.txtCorreo);
        etContacto = findViewById(R.id.txtContacto);
        btBorrar = findViewById(R.id.btnBorrar);
        btSincronizar = findViewById(R.id.btnSincronizar);
        context= this;
        int codCliente = getIntent().getIntExtra("codCliente",0);
        obtenerDatosCliente(codCliente);
    }

    public void obtenerDatosCliente(int pCodCliente){

        Log.e("Codigo",""+pCodCliente);
        if(pCodCliente !=0){

            FvCliente cliente = new FvCliente(context);
            Cursor cur = cliente.obtener(pCodCliente);
            if(cur != null){
                etCodCliente.setText(cur.getString(0));
                etClliente.setText(cur.getString(1));
                etDireccion.setText(cur.getString(2));
                etNit.setText(cur.getString(3));
                etTelefono.setText(cur.getString(4));
                etCorreo.setText(cur.getString(5));
                etContacto.setText(cur.getString(6));
                validarEstadoBoton();

            }

        }
    }

    public void grabar(View view){
        int vCodCliente = Integer.parseInt(etCodCliente.getText().toString());
        String vCliente = etClliente.getText().toString();
        String vDireccion = etDireccion.getText().toString();
        String vNit = etNit.getText().toString();
        String vTelefono = etTelefono.getText().toString();
        String vCorreo = etCorreo.getText().toString();
        String vContacto = etContacto.getText().toString();

        if(validarIngresoCliente(vCliente) ){
            if(validarIngresoDireccion(vDireccion)){
                if(validarIngresoNit(vNit)){
                    if(validarIngresoTelefono(vTelefono)){
                        if(validarIngresoCorreo(vCorreo)){
                            if(validarIngresoContacto(vContacto)){

                                FvCliente cliente = new FvCliente(vCodCliente,vCliente,vDireccion,vNit,vTelefono,vCorreo,vContacto,context);
                                if(vCodCliente == 0)
                                    cliente.insertar(context);
                                else
                                    cliente.actualizar(context);

                                String message = "Datos ingresados correctamente.";
                                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(this, ImagenActivity.class);
                                startActivity(intent);

                            }else {
                                String message = "Ingrese contacto.";
                                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                            }
                        }else {
                            String message = "Ingrese correo electronico.";
                            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                        }
                    }else {
                        String message = "Ingrese la número de telefono.";
                        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                    }
                }else{
                    String message = "Ingrese el número de nit.";
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                }
            }else {
                String message = "Ingrese la dirección.";
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
        else {
            String message = "Ingrese el nombre del cliente..";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    public boolean validarIngresoCliente(String pCliente){
        if((pCliente != null) && (!pCliente.trim().isEmpty()) )
            return true;
        return false;
    }

    public boolean validarIngresoDireccion(String pDireccion){
        if((pDireccion != null) && (!pDireccion.trim().isEmpty()) )
            return true;
        return false;
    }

    public boolean validarIngresoNit(String pNit){
        if((pNit != null) && (!pNit.trim().isEmpty()) )
            return true;
        return false;
    }

    public boolean validarIngresoTelefono(String pTelefono){
        if((pTelefono != null) && (!pTelefono.trim().isEmpty()) )
            return true;
        return false;
    }

    public boolean validarIngresoCorreo(String pCorreo){
        if((pCorreo != null) && (!pCorreo.trim().isEmpty()) )
            return true;
        return false;
    }

    public boolean validarIngresoContacto(String pContacto){
        if((pContacto != null) && (!pContacto.trim().isEmpty()) )
            return true;
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void abrirSincronizar(View view){
        Intent intent = new Intent(this, SincronizarActivity.class);
        startActivity(intent);
    }

    public void borrarCliente(View view){
        FvCliente cliente = new FvCliente(context);
        cliente.eliminar(Integer.parseInt(etCodCliente.getText().toString()));

        //String message = "El cliente se ha borrado satisfactoriamente.";
        //Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        Intent intento = new Intent();
        this.setResult(ClienteConsultaActivity.RESULT_OK, intento);
        finish();
    }

    public void validarEstadoBoton(){
        btBorrar = (Button) findViewById(R.id.btnBorrar);
        btBorrar.setVisibility(View.VISIBLE);

        btSincronizar = findViewById(R.id.btnSincronizar);
        btSincronizar.setVisibility(View.VISIBLE);
    }

}
