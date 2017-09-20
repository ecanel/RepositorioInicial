package com.hame.ecanel.materialdesign.activities.holders;

import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.hame.ecanel.materialdesign.R;

/**
 * Created by ecanel on 18/09/2017.
 */

public class itemHolder extends RecyclerView.ViewHolder {

    private CardView cvBackground;
    private ImageView ivImage;
    private TextView tvLabel;


    public itemHolder(View itemView) {
        super(itemView);

        cvBackground = itemView.findViewById(R.id.cv_item_recycler);
        ivImage =  itemView.findViewById(R.id.iv_item_image);
        tvLabel = itemView.findViewById(R.id.tv_item_label);


        cvBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //agregar un elemento al Recy
                Snackbar.make(view, tvLabel.getText().toString(), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }

    public void setData(int imageResource, String label){
        ivImage.setImageResource(imageResource);
        tvLabel.setText(label);
    }
}
