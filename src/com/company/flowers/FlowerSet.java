package com.company.flowers;

import com.company.utils.Utils;

import java.util.Vector;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class FlowerSet {
    private Vector<Flower> flowers = null;

    public FlowerSet() {
        super();

        // Init "bouquet space"
        flowers = new Vector<Flower>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public void removeFlower(Flower flower) {
        flowers.remove(flower);
    }

    public Flower getFlowerByIndex (int index) {
        return flowers.elementAt(index);
    }

    public Integer getFlowerCount() {
        return flowers.size();
    }

    public void showFlowerSet() {
        Utils.writeMessage(getClass().getName());

        for (int i=0; i < getFlowerCount(); i++) {
            Utils.writeMessage(getFlowerByIndex(i).toString());
        }
    }
}
