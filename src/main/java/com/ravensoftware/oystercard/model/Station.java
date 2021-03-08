package com.ravensoftware.oystercard.model;

/**
 * Created by bilga on 08-03-2021
 */
public enum Station {

    HOLBORN(Zone.ONE),
    EARLS_COURT(Zone.ONE, Zone.TWO),
    WIMBLEDON(Zone.THREE),
    HAMMERSMITH(Zone.TWO),
    CHELSEA(Zone.TWO);

    private Zone[] values;

    Station(Zone...values) {
        this.values = values;
    }

    public Zone[] getValues() {
        return values;
    }
}
