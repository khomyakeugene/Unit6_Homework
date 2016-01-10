package com.company.tests;

import com.company.music.Guitar;
import com.company.music.MusicShop;
import com.company.music.Piano;
import com.company.music.Trumpet;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class TestMusicShop {
    public final static String MUSIC_SHOP_NAME = "My Music Shop";

    private MusicShop musicShop = null;

    private void initMusicShopData() {
        musicShop = new MusicShop(MUSIC_SHOP_NAME);

        musicShop.addInstrument(new Guitar());
        musicShop.addInstrument(new Guitar());
        musicShop.addInstrument(new Piano());
        musicShop.addInstrument(new Trumpet());
    }

    private void showMusicShop() {
        musicShop.showMusicShop();
    }

    public void demonstrateData() {
        initMusicShopData();
        showMusicShop();
    }
}
