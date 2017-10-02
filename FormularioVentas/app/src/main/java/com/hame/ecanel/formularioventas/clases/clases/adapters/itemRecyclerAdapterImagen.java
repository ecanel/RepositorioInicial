package com.hame.ecanel.formularioventas.clases.clases.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.ecanel.formularioventas.R;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvImagen;
import com.hame.ecanel.formularioventas.clases.clases.holders.itemHolder;
import com.hame.ecanel.formularioventas.clases.clases.holders.itemHolderImagen;

import java.util.List;

/**
 * Created by ecanel on 29/09/2017.
 */

public class itemRecyclerAdapterImagen extends RecyclerView.Adapter<itemHolderImagen> {

    private Context context;
    private List<FvImagen> lstImagen;

    public itemRecyclerAdapterImagen(Context context, List<FvImagen> lstImagen) {
        this.context = context;
        this.lstImagen = lstImagen;
    }

    @Override
    public itemHolderImagen onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.imagen,parent,false);

        return new itemHolderImagen(view);
    }

    @Override
    public void onBindViewHolder(itemHolderImagen holder, int position) {
        holder.obtenerImagen(lstImagen.get(position).getNombreImagen(),lstImagen.get(position).getPathImagen(),context );
    }

    @Override
    public int getItemCount() {
        return lstImagen.size();
    }
}
