package com.hame.ecanel.materialdesign.activities.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.ecanel.materialdesign.R;
import com.hame.ecanel.materialdesign.activities.clases.Imagen;
import com.hame.ecanel.materialdesign.activities.holders.itemHolderTarea;

import java.util.ArrayList;

/**
 * Created by ecanel on 19/09/2017.
 */

public class itemRecyclerAdapterTarea extends RecyclerView.Adapter<itemHolderTarea> {
    public ArrayList<Imagen> lstImagen;
    public Context context;

    public itemRecyclerAdapterTarea(ArrayList<Imagen> pLstImagen, Context pContext){
        lstImagen = pLstImagen;
        context = pContext;
    }
    @Override
    public itemHolderTarea onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater fl = LayoutInflater.from(context);
        View view = fl.inflate(R.layout.item_recycler_tarea,parent,false);


        return new itemHolderTarea(view);
    }

    @Override
    public void onBindViewHolder(itemHolderTarea holder, int position) {
        holder.setData(lstImagen.get(position).getNombreImagen(),lstImagen.get(position).getImagen());

    }

    @Override
    public int getItemCount()
    {
        return lstImagen.size();
    }
}
