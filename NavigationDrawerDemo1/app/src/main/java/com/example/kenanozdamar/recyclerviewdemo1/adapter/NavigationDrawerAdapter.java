package com.example.kenanozdamar.recyclerviewdemo1.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kenanozdamar.recyclerviewdemo1.R;
import com.example.kenanozdamar.recyclerviewdemo1.model.NavigationDrawerItem;

import java.util.List;

/**
 * Created by kenanozdamar on 7/14/17.
 */

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.MyViewHolder>{

    private List<NavigationDrawerItem> dataList;
    private LayoutInflater inflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavigationDrawerItem> dataList) {
        this.dataList = dataList;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.navigation_drawer_list_list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        NavigationDrawerItem currentNavigationDrawerItem = dataList.get(position);

        holder.imgIcon.setImageResource(currentNavigationDrawerItem.getImageId());
        holder.title.setText(currentNavigationDrawerItem.getTitle());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, holder.title.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView imgIcon;

        public MyViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.title);
            imgIcon = (ImageView) itemView.findViewById(R.id.imgIcon);
        }
    }
}
