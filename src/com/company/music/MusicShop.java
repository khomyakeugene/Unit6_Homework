package com.company.music;

import com.company.utils.Utils;

import java.util.Vector;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class MusicShop {
    private String shopName = null;
    private Vector<MusicalInstrument> instruments = null;

    public MusicShop(String shopName) {
        super();

        setShopName(shopName);

        // Init "instruments space"
        instruments = new Vector<>();
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void addInstrument(MusicalInstrument instrument) {
        instruments.add(instrument);
    }

    public MusicalInstrument getInstrumentByIndex(int index) {
        return instruments.elementAt(index);
    }

    public int getInstrumentCount() {
        return instruments.size();
    }

    public void showMusicShop() {
        Utils.writeMessage(getShopName());

        showAllInstruments();
    }

    public void showAllInstruments() {
        for (int i = 0; i < getInstrumentCount(); i++) {
            Utils.writeMessage(getInstrumentByIndex(i).toString());
        }
    }
}
