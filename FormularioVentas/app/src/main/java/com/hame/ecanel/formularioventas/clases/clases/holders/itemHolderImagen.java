package com.hame.ecanel.formularioventas.clases.clases.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.hame.ecanel.formularioventas.R;

/**
 * Created by ecanel on 29/09/2017.
 */

public class itemHolderImagen extends RecyclerView.ViewHolder {
    public ImageView ivImagen;
    public TextView tvNombreImagen;
    public Context context;

    public itemHolderImagen(View itemView) {
        super(itemView);
        initComponents();
    }
    public void initComponents(){
        ivImagen = (ImageView) itemView.findViewById(R.id.ivImagen);
        tvNombreImagen = itemView.findViewById(R.id.tvImagen);

    }

    public void obtenerImagen(String pNombre, String pPath, Context pContext){

        tvNombreImagen.setText(pNombre);
        ivImagen.setTag(pPath);
        context = pContext;

    }
}
