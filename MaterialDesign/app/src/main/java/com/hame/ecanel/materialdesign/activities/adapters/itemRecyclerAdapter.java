package com.hame.ecanel.materialdesign.activities.adapters;

import android.content.Context;
import android.support.v4.view.LayoutInflaterFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hame.ecanel.materialdesign.R;
import com.hame.ecanel.materialdesign.activities.holders.itemHolder;

/**
 * Created by ecanel on 18/09/2017.
 */

public class itemRecyclerAdapter extends RecyclerView.Adapter <itemHolder> {

    private int[] imagesResource;
    private String[] labels;
    private Context context;

    public itemRecyclerAdapter(int[] imagesResource
                                        , String[] labels
                                        , Context context){
        this.imagesResource = imagesResource;
        this.labels = labels;
        this.context = context;
    }

    @Override
    public itemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View view = li.inflate(R.layout.item_recycler,parent,false);

        return new itemHolder(view);
    }

    @Override
    public void onBindViewHolder(itemHolder holder, int position) {
        holder.setData(imagesResource[position],labels[position]);
    }

    @Override
    public int getItemCount() {

        return imagesResource.length;
    }
}

