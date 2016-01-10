package com.company.flowers;

import java.text.MessageFormat;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class Rose extends Flower {
    public final static String ROSE_FLOWER_TYPE = "Rose";
    public final static String TYPICAL_ROSE_SCENT = "Typical rose scent";
    public final static String ROSE_DESCRIPTION_MESSAGE = "{0}, thorns present: {1}";

    private Boolean isThorn = false;

    public Rose(String colour, String scent, Boolean isThorn) {
        super(ROSE_FLOWER_TYPE, colour, scent);

        setThorn(isThorn);
    }

    public Rose(String colour, String scent) {
        this(colour, scent, false);
    }

    public Rose(String colour) {
        this(colour, TYPICAL_ROSE_SCENT);
    }

    public Boolean getThorn() {
        return isThorn;
    }

    public void setThorn(Boolean thorn) {
        isThorn = thorn;
    }

    @Override
    public String toString() {
        return MessageFormat.format(ROSE_DESCRIPTION_MESSAGE , super.toString(), getThorn());
    }
}
