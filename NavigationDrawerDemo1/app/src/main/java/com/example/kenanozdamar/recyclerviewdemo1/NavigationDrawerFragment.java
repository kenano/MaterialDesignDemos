package com.example.kenanozdamar.recyclerviewdemo1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kenanozdamar.recyclerviewdemo1.adapter.NavigationDrawerAdapter;
import com.example.kenanozdamar.recyclerviewdemo1.model.NavigationDrawerItem;

/**
 * Created by kenanozdamar on 7/15/17.
 */

public class NavigationDrawerFragment extends Fragment {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_navigation_drawer, container, false);

        setUpRecyclerView(view);

        return view;
    }

    private void setUpRecyclerView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.drawerList);

        NavigationDrawerAdapter navigationDrawerAdapter = new NavigationDrawerAdapter(getActivity(),
                NavigationDrawerItem.getData());

        //set the adapter for the recycler view.
        recyclerView.setAdapter(navigationDrawerAdapter);

        //set the LayoutManager for the recyclerView.
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public void setUpDrawer(int fragmentId, DrawerLayout drawerLayout, Toolbar toolbar) {

        this.drawerLayout = drawerLayout;

        //create an instance of ActionBarDrawerToggle. This is what displays/closes the Navigation bar.
        //since the button to open/close navigation bar is in the toolbar it should be passed into this
        //constructor.
        //we are interested in overriding the behavior of the toggle.
        actionBarDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar,
                R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);

                //do something when drawer is being opened | closed.
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                //do something when drawer is opened
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                //do something when drawer is closed
            }
        };

        //add the callbacks for drawer actions.
        //ActionBarDrawerToggle implements DrawerLayout.DrawerListener
        this.drawerLayout.addDrawerListener(actionBarDrawerToggle);


        //Synchronize the state of the drawer indicator/affordance with the linked DrawerLayout.
        //this needs to be invoked after DrawerLayout instance has been restored. therefore, add
        //it to the DrawerLayouts message queue.
        this.drawerLayout.post(new Runnable() {
            @Override
            public void run() {
                actionBarDrawerToggle.syncState();
            }
        });
    }
}
