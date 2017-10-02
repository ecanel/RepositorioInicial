package com.hame.ecanel.formularioventas.clases.clases;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.hame.ecanel.formularioventas.R;
import com.hame.ecanel.formularioventas.clases.clases.adapters.itemRecyclerAdapter;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvCliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteConsultaActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public itemRecyclerAdapter itemAdapter;
    private Context context;
    private List<FvCliente> lstCliente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente_consulta);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;
        recyclerView = findViewById(R.id.rv_item_list);
        initComponents();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                       .setAction("Action", null).show();
                ingresoCliente();
            }
        });
    }
    public void ingresoCliente(){
        Intent intent = new Intent(this, ClienteActivity.class);
        startActivity(intent);
    }

    public void  initComponents(){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        /*lstCliente = new ArrayList<>();

        lstCliente.add(new FvCliente(1,"Emanuel","O calle A","2939","d","d","d"));
        lstCliente.add(new FvCliente(1,"Isaias","O calle B","3636","d","d","d"));
        lstCliente.add(new FvCliente(1,"Elias","O calle C","2558","d","d","d"));*/

        llenarListaClientes();

    }

    public void llenarListaClientes(){
        FvCliente cliente = new FvCliente(context);
        Cursor cur =  cliente.obtener();
        if(cur != null){
            if(cur.moveToFirst())
            {
                itemAdapter = new itemRecyclerAdapter(context,cur);
                recyclerView.setAdapter(itemAdapter);
            }
        }
    }

    public void editarDatos(int pIdCliente){

        Intent intent = new Intent(this,ClienteActivity.class);
        intent.putExtra("codCliente",pIdCliente);
        startActivityForResult(intent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK)
        {
            switch (requestCode)
            {
                case 1:
                    llenarListaClientes();
                    break;
            }
        }
    }


}
