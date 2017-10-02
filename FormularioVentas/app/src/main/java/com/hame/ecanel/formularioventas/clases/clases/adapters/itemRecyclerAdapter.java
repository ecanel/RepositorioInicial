package com.hame.ecanel.formularioventas.clases.clases.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.ecanel.formularioventas.R;
import com.hame.ecanel.formularioventas.clases.clases.clases.FvCliente;
import com.hame.ecanel.formularioventas.clases.clases.holders.itemHolder;

import java.util.List;

/**
 * Created by ecanel on 29/09/2017.
 */

public  class itemRecyclerAdapter extends RecyclerView.Adapter<itemHolder> {

    private Context context;
    private Cursor lstCliente;

    public itemRecyclerAdapter(Context context, Cursor lstCliente) {
        this.context = context;
        this.lstCliente = lstCliente;
    }


    @Override
    public itemHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.consultaclientes,parent,false);

        return new itemHolder(view);
    }

    @Override
    public void onBindViewHolder(itemHolder holder, int position) {
        //holder.obtenerDatosCliente(lstCliente.get(position).getNombre(),lstCliente.get(position).getDireccion(),lstCliente.get(position).getNit(),lstCliente.get(position).getImagen(),context );
        lstCliente.move(position);
        holder.obtenerDatosCliente(lstCliente.getInt(0),lstCliente.getString(1), lstCliente.getString(2), lstCliente.getString(3), lstCliente.getString(4), context);
    }

    @Override
    public int getItemCount() {
        return lstCliente.getCount();
    }
}
