package com.company.flowers;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class Tulip extends FlowerWithoutScent {
    public final static String TULIP_FLOWER_TYPE = "Tulip";

    public Tulip(String colour) {
        super(TULIP_FLOWER_TYPE, colour);
    }
}
