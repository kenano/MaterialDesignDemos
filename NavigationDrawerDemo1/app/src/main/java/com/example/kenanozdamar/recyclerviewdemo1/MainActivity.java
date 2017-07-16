package com.example.kenanozdamar.recyclerviewdemo1;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.kenanozdamar.recyclerviewdemo1.adapter.RecyclerAdapter;
import com.example.kenanozdamar.recyclerviewdemo1.model.NatureVista;

public class MainActivity extends AppCompatActivity
        implements Toolbar.OnMenuItemClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpToolbar();

        setUpNavigationDrawer();

        setupRecyclerView();

    }

    private void setUpToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Navigation Drawer Demo");
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(this);
    }

    private void setUpNavigationDrawer() {

        //create an instance of the navigation drawer fragment.
        NavigationDrawerFragment navigationDrawerFragment = new NavigationDrawerFragment();

        //get a reference to the drawer layout (inside DrawerLayout element in activity_main layout.
        DrawerLayout drawerLayout = (DrawerLayout) this.findViewById(R.id.drawer_layout);

        //invoke method from NavigationDrawerFragment which will setup the navigation drawer.
        navigationDrawerFragment.setUpDrawer(R.id.nav_drwr_fragment, drawerLayout, toolbar);
    }

    private void setupRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, NatureVista.getData());

        recyclerView.setAdapter(recyclerAdapter);

        //recycler view is implemented in a more specific type (linear, grid, staggered,..
        //the layout must be specified for recycler view to work.
        LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
        mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayoutManagerVertical);

        //animates changes to items in the recycler view. DefaultItemAnimator is used even if the
        //line below isnt explicitly called.
        recyclerView.setItemAnimator(new DefaultItemAnimator());


    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
//        int id = item.getItemId();
//
//        switch (id) {
//            case R.id.linearViewHorizontal:
//                LinearLayoutManager mLinearLayoutManagerHorizontal = new LinearLayoutManager(this);
//                mLinearLayoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
//                recyclerView.setLayoutManager(mLinearLayoutManagerHorizontal);
//                break;
//
//            case R.id.linearViewVertical:
//                LinearLayoutManager mLinearLayoutManagerVertical = new LinearLayoutManager(this);
//                mLinearLayoutManagerVertical.setOrientation(LinearLayoutManager.VERTICAL);
//                recyclerView.setLayoutManager(mLinearLayoutManagerVertical);
//                break;
//            case R.id.gridView:
//                GridLayoutManager mGridLayoutManager = new GridLayoutManager(this, 2); // (Context context, int spanCount)
//                recyclerView.setLayoutManager(mGridLayoutManager);
//                break;
//            case R.id.staggeredViewHorizontal:
//                StaggeredGridLayoutManager mStaggeredHorizontalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL); // (int spanCount, int orientation)
//                recyclerView.setLayoutManager(mStaggeredHorizontalLayoutManager);
//                break;
//            case R.id.staggeredViewVertical:
//                StaggeredGridLayoutManager mStaggeredVerticalLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL); // (int spanCount, int orientation)
//                recyclerView.setLayoutManager(mStaggeredVerticalLayoutManager);
//                break;
//        }
        return true;
    }
}
