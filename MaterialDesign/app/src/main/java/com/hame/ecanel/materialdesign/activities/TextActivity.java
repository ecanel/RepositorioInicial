package com.hame.ecanel.materialdesign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hame.ecanel.materialdesign.R;

public class TextActivity extends AppCompatActivity {

    private EditText etIngresado;
    private TextView tvMostrado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text);
        initComponents();
    }

    private  void initComponents(){
        etIngresado = (EditText) findViewById(R.id.ed_insert_text);
        tvMostrado = (TextView) findViewById(R.id.txt_view);

    }

    public void readText(View view){
        String text = etIngresado.getText().toString();
        if ((text != null) && (!text.trim().isEmpty())){
            tvMostrado.setText(text);
        }else {
            tvMostrado.setText("");
            Toast.makeText(this,getString(R.string.msj_empty_text),Toast.LENGTH_LONG).show();
        }
    }
}
