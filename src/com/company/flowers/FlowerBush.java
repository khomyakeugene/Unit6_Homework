package com.company.flowers;

/**
 * Created by Yevgen on 21.12.2015.
 */

public class FlowerBush extends FlowerSet {
    private String flowerType = null;
    private String colour = null;
    private String scent = Flower.WITHOUT_SCENT_MESSAGE;

    protected FlowerBush(String flowerType, String colour, String scent, int flowerCount) {
        super();

        setFlowerType(flowerType);
        setColour(colour);
        setScent(scent);

        formFlowerBush(flowerCount);
    }

    public String getFlowerType() {
        return flowerType;
    }

    public void setFlowerType(String flowerType) {
        this.flowerType = flowerType;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getScent() {
        return scent;
    }

    public void setScent(String scent) {
        this.scent = scent;
    }

    public void addFlower (){
        super.addFlower(new Flower(getFlowerType(), getColour(), getScent()));
    }

    public void formFlowerBush(int flowerCount) {
        for (int i = getFlowerCount(); i < flowerCount; i++) {
            addFlower();
        }
    }
}
