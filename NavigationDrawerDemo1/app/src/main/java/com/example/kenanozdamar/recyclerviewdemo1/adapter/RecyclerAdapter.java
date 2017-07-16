package com.example.kenanozdamar.recyclerviewdemo1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kenanozdamar.recyclerviewdemo1.R;
import com.example.kenanozdamar.recyclerviewdemo1.model.NatureVista;

import java.util.List;

/**
 * Created by kenanozdamar on 7/10/17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private static final String TAG = RecyclerAdapter.class.getSimpleName();

    private List<NatureVista> data;
    private LayoutInflater layoutInflater;

    public RecyclerAdapter(Context context, List<NatureVista> data) {
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

        NatureVista currentViewObject = this.data.get(position);
        holder.setData(currentViewObject, position);
        holder.setListener();
    }

    public void addItem(int position, NatureVista natureVista) {
        this.data.add(position, natureVista);
        this.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        this.data.remove(position);
        this.notifyItemRemoved(position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView title;
        ImageView imgThumb, imgDelete, imgAdd;
        int position;
        NatureVista current;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView)  itemView.findViewById(R.id.tvTitle);
            imgThumb = (ImageView) itemView.findViewById(R.id.img_row);
            imgDelete = (ImageView) itemView.findViewById(R.id.img_row_delete);
            imgAdd = (ImageView) itemView.findViewById(R.id.img_row_add);
        }

        public void setData(NatureVista currentViewObject, int position) {
            this.title.setText(currentViewObject.getTitle());
            this.imgThumb.setImageResource(currentViewObject.getImageID());
            this.position = position;
            this.current = currentViewObject;
        }

        public void setListener() {
            this.imgAdd.setOnClickListener(MyViewHolder.this);
            this.imgDelete.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Log.i(TAG, position + " " + data.size());

            switch (view.getId()) {
                case R.id.img_row_add:
                    addItem(position, current);
                    break;
                case R.id.img_row_delete:
                    removeItem(position);
                    break;
            }
        }
    }
}
