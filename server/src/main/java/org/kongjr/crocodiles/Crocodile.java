package org.kongjr.crocodiles;

public abstract class Crocodile {
    private String liana;

    public Crocodile(String liana) {
        this.liana = liana;
    }

    public abstract void movement();
    public abstract int speed();

}