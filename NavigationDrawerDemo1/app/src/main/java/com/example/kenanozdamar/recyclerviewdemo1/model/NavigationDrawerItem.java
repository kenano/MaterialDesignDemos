package com.example.kenanozdamar.recyclerviewdemo1.model;

import com.example.kenanozdamar.recyclerviewdemo1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kenanozdamar on 7/14/17.
 */

public class NavigationDrawerItem {
    private String title;
    private int imageId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public static List<NavigationDrawerItem> getData() {
        List<NavigationDrawerItem> datalist = new ArrayList<>();

        int[] imageIds = getImages();
        String[] titles = getTitles();

        for (int i = 0; i < titles.length; i++) {
            NavigationDrawerItem navigationDrawerItem = new NavigationDrawerItem();

            navigationDrawerItem.setTitle(titles[i]);
            navigationDrawerItem.setImageId(imageIds[0]);

            datalist.add(navigationDrawerItem);
        }

        return datalist;
    }

    private static int[] getImages() {
        return new int[] {
                R.drawable.ic_birds,
                R.drawable.ic_animal,
                R.drawable.ic_forest,
                R.drawable.ic_ocean,
                R.drawable.ic_planet,
                R.drawable.ic_landscape
        };
    }

    private static String[] getTitles() {
        return new String[] {
                "Birds", "Animals", "Forest", "Ocean", "Planets", "Landscape"
        };
    }
}
