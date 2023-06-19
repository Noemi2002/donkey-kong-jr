package org.kongjr.crocodiles;

public abstract class Crocodile {
    private String color;
    private String liana;
    private int currentPosition;

    public Crocodile(String color, String liana, int initialPosY) {
        this.color = color;
        this.liana = liana;
        this.currentPosition = initialPosY;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getLiana() {
        return liana;
    }

    public String getColor() {
        return color;
    }
}
