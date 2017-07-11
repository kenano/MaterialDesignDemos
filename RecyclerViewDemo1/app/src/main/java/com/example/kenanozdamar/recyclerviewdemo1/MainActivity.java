package com.example.kenanozdamar.recyclerviewdemo1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements Toolbar.OnMenuItemClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Home Page");
        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(this);

        setupRecyclerView();
    }

    private void setupRecyclerView() {

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
