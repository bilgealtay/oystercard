package com.ravensoftware.oystercard.model;

/**
 * Created by bilga on 08-03-2021
 */
public enum Zone {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);


    private int value;

    Zone(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
