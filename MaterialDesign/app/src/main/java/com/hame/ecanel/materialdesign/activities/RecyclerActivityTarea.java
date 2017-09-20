package com.hame.ecanel.materialdesign.activities;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;

import com.hame.ecanel.materialdesign.R;
import com.hame.ecanel.materialdesign.activities.adapters.itemRecyclerAdapter;
import com.hame.ecanel.materialdesign.activities.adapters.itemRecyclerAdapterTarea;
import com.hame.ecanel.materialdesign.activities.clases.Imagen;

import java.util.ArrayList;

public class RecyclerActivityTarea extends AppCompatActivity {
    private RecyclerView recyclerView;
    private itemRecyclerAdapterTarea itemAdapter;
    public ArrayList<Imagen> lstImagen;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_tarea);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;
        initComponents();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lstImagen.add(new Imagen(getResources().getString(R.string.cbx_calculator),R.drawable.thumbnail_calculator));

                itemAdapter = new itemRecyclerAdapterTarea(lstImagen,context);
                recyclerView.setAdapter(itemAdapter);
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void initComponents(){
        recyclerView = findViewById(R.id.rv_item_list_tarea);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        lstImagen = new ArrayList<>();
        lstImagen.add(new Imagen(getResources().getString(R.string.cbx_bag),R.drawable.thumbnail_bag));
        lstImagen.add(new Imagen(getResources().getString(R.string.chx_atm),R.drawable.thumbnail_atm));
        lstImagen.add(new Imagen(getResources().getString(R.string.cbx_box),R.drawable.thumbnail_box));
        lstImagen.add(new Imagen(getResources().getString(R.string.cbx_basket),R.drawable.thumbnail_basket));
        lstImagen.add(new Imagen(getResources().getString(R.string.cbx_briefcase),R.drawable.thumbnail_briefcase));
        lstImagen.add(new Imagen(getResources().getString(R.string.cbx_calculator),R.drawable.thumbnail_calculator));

        itemAdapter = new itemRecyclerAdapterTarea(lstImagen,context);
        recyclerView.setAdapter(itemAdapter);
    }

}
