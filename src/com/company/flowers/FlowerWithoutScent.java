package com.company.flowers;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class FlowerWithoutScent extends Flower {
    public FlowerWithoutScent(String flowerType, String colour) {
        super(flowerType, colour, Flower.WITHOUT_SCENT_MESSAGE);
    }
}
