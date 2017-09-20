package com.hame.ecanel.materialdesign.activities;

import android.content.pm.LauncherApps;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.hame.ecanel.materialdesign.R;
import com.hame.ecanel.materialdesign.activities.adapters.itemRecyclerAdapter;

public class RecyclerActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private itemRecyclerAdapter itemAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initComponents();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //agregar un elemento al Recy
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });


    }
    private void initComponents(){
        recyclerView = findViewById(R.id.rv_item_list);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(gridLayoutManager);

        int[] drawables = new int[]{
                R.drawable.thumbnail_atm,
                R.drawable.thumbnail_bag,
                R.drawable.thumbnail_basket,
                R.drawable.thumbnail_box,
                R.drawable.thumbnail_briefcase,
                R.drawable.thumbnail_calculator
        };

        String[] labels = getResources().getStringArray(R.array.selected_options);

        itemAdapter = new itemRecyclerAdapter(drawables,labels,this);
        recyclerView.setAdapter(itemAdapter);
    }

}
