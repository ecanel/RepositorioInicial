package com.hame.ecanel.formularioventas.clases.clases.holders;

import android.content.Context;
import android.support.annotation.VisibleForTesting;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hame.ecanel.formularioventas.R;
import com.hame.ecanel.formularioventas.clases.clases.ClienteConsultaActivity;

import org.w3c.dom.Text;

/**
 * Created by ecanel on 29/09/2017.
 */


public class itemHolder extends RecyclerView.ViewHolder {
    public ImageView ivFotoCliente;
    public TextView tvCliente;
    public TextView tvDireccion;
    public TextView tvNit;
    public Context context;
    public RelativeLayout rlMostrar;
    public int IdCliente;

    public itemHolder(View itemView) {
        super(itemView);
        initComponents();
    }


    public void initComponents(){
        ivFotoCliente =  itemView.findViewById(R.id.ivCliente);
        tvCliente = itemView.findViewById(R.id.tvCliente);
        tvDireccion = itemView.findViewById(R.id.tvDireccion);
        tvNit = itemView.findViewById(R.id.tvNit);
        rlMostrar = itemView.findViewById(R.id.mostrar);
        rlMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ClienteConsultaActivity)context).editarDatos(IdCliente);
            }
        });
    }

    public void obtenerDatosCliente(int pCodCliente, String pCliente, String pDireccion, String pNit, String pFoto, Context pContext){

        IdCliente = pCodCliente;
        tvCliente.setText(pCliente);
        tvDireccion.setText(pDireccion);
        tvNit.setText(pNit);
        ivFotoCliente.setTag(pFoto);
        context = pContext;
    }
}
