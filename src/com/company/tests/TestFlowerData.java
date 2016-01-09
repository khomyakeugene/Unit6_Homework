package com.company.tests;

import com.company.flowers.Bouquet;
import com.company.utils.Const;
import com.company.flowers.Aster;
import com.company.flowers.Camomile;
import com.company.flowers.Rose;
import com.company.flowers.RoseBush;
import com.company.flowers.Tulip;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class TestFlowerData {
    public static final int ROSE_COUNT_IN_ROSEBUSH = 7;

    private Bouquet bouquet = null;
    private RoseBush roseBush = null;

    private void collectBouguet() {
        bouquet = new Bouquet(new Aster(Const.RED_COLOUR));

        bouquet.addFlower(new Aster(Const.WHITE_COLOUR));
        bouquet.addFlower(new Tulip(Const.RED_COLOUR));
        bouquet.addFlower(new Tulip(Const.ROSE_COLOUR));
        bouquet.addFlower(new Camomile(Const.WHITE_COLOUR));
        bouquet.addFlower(new Camomile(Const.WHITE_COLOUR));
        bouquet.addFlower(new Camomile(Const.YELLOW_COLOUR));
        bouquet.addFlower(new Rose(Const.ROSE_COLOUR));
        bouquet.addFlower(new Rose(Const.RED_COLOUR, Const.TYPICAL_ROSE_SCENT, true));
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
        roseBush = new RoseBush(Const.ROSE_COLOUR, Const.TYPICAL_ROSE_SCENT, true, ROSE_COUNT_IN_ROSEBUSH);
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
