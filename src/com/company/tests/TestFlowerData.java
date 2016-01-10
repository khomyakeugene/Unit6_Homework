package com.company.tests;

import com.company.flowers.Bouquet;
import com.company.flowers.Aster;
import com.company.flowers.Chamomile;
import com.company.flowers.Rose;
import com.company.flowers.RoseBush;
import com.company.flowers.Tulip;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class TestFlowerData {
    public final static String RED_COLOUR = "Red";
    public final static String WHITE_COLOUR = "White";
    public final static String ROSE_COLOUR = "Rose";
    public final static String YELLOW_COLOUR = "Yellow";

    public static final int ROSE_COUNT_IN_ROSEBUSH = 7;

    private Bouquet bouquet = null;
    private RoseBush roseBush = null;

    private void collectBouguet() {
        bouquet = new Bouquet(new Aster(RED_COLOUR));

        bouquet.addFlower(new Aster(WHITE_COLOUR));
        bouquet.addFlower(new Tulip(RED_COLOUR));
        bouquet.addFlower(new Tulip(ROSE_COLOUR));
        bouquet.addFlower(new Chamomile(WHITE_COLOUR));
        bouquet.addFlower(new Chamomile(WHITE_COLOUR));
        bouquet.addFlower(new Chamomile(YELLOW_COLOUR));
        bouquet.addFlower(new Rose(ROSE_COLOUR));
        bouquet.addFlower(new Rose(RED_COLOUR, Rose.TYPICAL_ROSE_SCENT, true));
    }

    private void showBouquet() {
        bouquet.showFlowerSet();
    }

    private void showRoseBush() {
        roseBush.showFlowerSet();
    }

    public void demonstrateBouquet() {
        collectBouguet();
        showBouquet();
    }

    private void collectRosebush() {
        roseBush = new RoseBush(ROSE_COLOUR, Rose.TYPICAL_ROSE_SCENT, true, ROSE_COUNT_IN_ROSEBUSH);
    }

    public void demonstrateRoseBush() {
        collectRosebush();
        showRoseBush();
    }

    public void demonstrateData() {
        demonstrateBouquet();
        demonstrateRoseBush();
    }
}
