package com.hame.ecanel.materialdesign.activities.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hame.ecanel.materialdesign.R;

/**
 * Created by ecanel on 19/09/2017.
 */

public class itemHolderTarea extends RecyclerView.ViewHolder {
    public ImageView imV;
    public TextView txV;

    public itemHolderTarea(View itemView)
    {
        super(itemView);
        imV = itemView.findViewById(R.id.imageViewTarea);
        txV = itemView.findViewById(R.id.textViewTarea);


    }

    public void setData(String pNombre, int pImagen){
        imV.setImageResource(pImagen);
        txV.setText(pNombre);
    }


}
