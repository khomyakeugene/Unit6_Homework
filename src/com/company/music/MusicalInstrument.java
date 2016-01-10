package com.company.music;

import java.text.MessageFormat;

/**
 * Created by Yevgen on 21.12.2015.
 */
public class MusicalInstrument {
    public final static String INSTRUMENT_DESCRIPTION_MESSAGE = "Instrument: {0}";

    private String instrumentType = null;

    public MusicalInstrument(String instrumentType) {
        super();

        setInstrumentType(instrumentType);
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    @Override
    public String toString() {
        return MessageFormat.format(INSTRUMENT_DESCRIPTION_MESSAGE, getInstrumentType());
    }
}
