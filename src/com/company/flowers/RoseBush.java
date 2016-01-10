package com.company.flowers;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class RoseBush extends FlowerBush {
    private Boolean isThorn = false;

    public RoseBush(String colour, String scent, Boolean isThorn, int roseCount) {
        super(Rose.ROSE_FLOWER_TYPE, colour, scent, 0);

        // Remember whether the thorns are presented
        setThorn(isThorn);
        // Only after that form the rosebush!
        formFlowerBush(roseCount);
    }

    public Boolean getThorn() {
        return isThorn;
    }

    public void setThorn(Boolean thorn) {
        isThorn = thorn;
    }

    @Override
    public void addFlower () {
        super.addFlower(new Rose(getColour(), getScent(), getThorn()));
    }
}
