package com.hame.ecanel.materialdesign.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hame.ecanel.materialdesign.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openResult(View view){
        Intent intent = new Intent(this,TextActivity.class);
        startActivity(intent);
    }

    public void openImageOpt(View view){
        Intent intent = new Intent(this,ImageOptActivity.class);
        startActivity(intent);
    }

    public void openSelectedOpt(View view){
        startActivity(new Intent(this,SelectedOptActivity.class));
    }

    public void openListView(View view){
        startActivity(new Intent(this,ListViewActivity.class));
    }
}
