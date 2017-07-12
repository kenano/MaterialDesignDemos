package com.example.kenanozdamar.recyclerviewdemo2.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kenanozdamar.recyclerviewdemo2.R;
import com.example.kenanozdamar.recyclerviewdemo2.model.Animal;

import java.util.List;

/**
 * Created by kenanozdamar on 7/11/17.
 */

public class RecycleAdapter  extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {

    private List<Animal> data;
    private LayoutInflater layoutInflater;

    public RecycleAdapter(Context context, List<Animal> data) {
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view  = layoutInflater.inflate(R.layout.list_item, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder ;
    }

    @Override
    public int getItemCount() {
        return data.size() ;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Animal currentViewObject = this.data.get(position);
        holder.setData(currentViewObject, position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imgThumb;
        int position;
        Animal current;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView)  itemView.findViewById(R.id.txv_row );
            imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
        }

        public void setData(Animal currentViewObject, int position) {
            this.title.setText(currentViewObject.getTitle());
            this.imgThumb.setImageResource(currentViewObject.getImgId());
            this.position = position;
            this.current = currentViewObject;
        }
    }
}
