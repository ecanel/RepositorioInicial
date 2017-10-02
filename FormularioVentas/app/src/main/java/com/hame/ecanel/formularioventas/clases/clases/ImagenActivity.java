package com.hame.ecanel.formularioventas.clases.clases;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.hame.ecanel.formularioventas.R;
import com.hame.ecanel.formularioventas.clases.clases.adapters.itemRecyclerAdapter;
import com.hame.ecanel.formularioventas.clases.clases.adapters.itemRecyclerAdapterImagen;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvCliente;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvImagen;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImagenActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    public itemRecyclerAdapterImagen itemAdapter;
    private Context context;
    private List<FvImagen> lstImagen;
    private static final int CAPTURA_DE_IMAGENES = 1;
    public String mensaje = "No se encontro camara";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imagen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;
        recyclerView = findViewById(R.id.rv_item_list_img);
        initComponents();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (camaraDisponible(context)) {
                    abrirCamara();
                } else {
                    Snackbar.make(view, getBaseContext().getString(R.string.falta_camara_sistema), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });
    }

    public void abrirCamara() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(getTemporal(this)));
            startActivityForResult(takePictureIntent, CAPTURA_DE_IMAGENES);
        }
    }

    private boolean camaraDisponible(Context context) {
        if (context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }

    private File getTemporal(Context context) {
        final File path = new File(Environment.getExternalStorageDirectory(), context.getPackageName());
        if (!path.exists()) {
            path.mkdir();
        }
        return new File(path + ".tmp");
    }
    public void  initComponents(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        lstImagen = new ArrayList<>();
        if(lstImagen.size() >0){
            itemAdapter = new itemRecyclerAdapterImagen(context,lstImagen);
            recyclerView.setAdapter(itemAdapter);
        }

    }

    public void consultaClientes(View view){
        Intent intent = new Intent(this, ClienteConsultaActivity.class);
        startActivity(intent);;
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CAPTURA_DE_IMAGENES:
                    File file = getTemporal(this);
                    Bitmap bitmap = escalarBitmap(file.getAbsolutePath(), 4);
                    lstImagen.add(new FvImagen(1,"Imagen 01",file.getAbsolutePath(),1,bitmap));
                    itemAdapter = new itemRecyclerAdapterImagen(context,lstImagen);
                    recyclerView.setAdapter(itemAdapter);
                    break;
            }
        } else {
        }
    }

    public Bitmap escalarBitmap(String uri, Integer factor) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = factor;
        bmOptions.inPurgeable = true;
        return rotarBitmap(uri, BitmapFactory.decodeFile(uri, bmOptions));
    }

    private Bitmap rotarBitmap(String Url, Bitmap bitmap) {
        try {
            ExifInterface exifInterface = new ExifInterface(Url);
            int orientacion = exifInterface.getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            Matrix matrix = new Matrix();

            if (orientacion == 6) {
                matrix.postRotate(90);
            } else if (orientacion == 3) {
                matrix.postRotate(180);
            } else if (orientacion == 8) {
                matrix.postRotate(270);
            }

            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (Exception e) {

        }
        return bitmap;
    }
}
