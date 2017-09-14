package com.hame.ecanel.materialdesign.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.hame.ecanel.materialdesign.R;

public class ListViewActivity extends AppCompatActivity implements  AdapterView.OnItemClickListener {

    private ListView listView;
    private ImageView ivSelected;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        iniComponets();
    }

    private  void iniComponets(){
        ivSelected = (ImageView) findViewById(R.id.iv_listView);
        listView = (ListView) findViewById(R.id.lv_options);

        String[] options = getResources().getStringArray(R.array.selected_options);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                options);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        switch (position) {
            case 0:
                ivSelected.setImageResource(R.drawable.thumbnail_atm);
                break;
            case 1:
                ivSelected.setImageResource(R.drawable.thumbnail_bag);
                break;
            case 2:
                ivSelected.setImageResource(R.drawable.thumbnail_basket);
                break;
            case 3:
                ivSelected.setImageResource(R.drawable.thumbnail_box);
                break;
            case 4:
                ivSelected.setImageResource(R.drawable.thumbnail_briefcase);
                break;
            case 5:
                ivSelected.setImageResource(R.drawable.thumbnail_calculator);
                break;
        }
    }
}
