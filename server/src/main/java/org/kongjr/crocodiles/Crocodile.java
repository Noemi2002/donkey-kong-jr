package org.kongjr.crocodiles;

import org.kongjr.estructuras.ParOrdenado;

public abstract class Crocodile {
    private String color;
    private String liana;
    private ParOrdenado currentPosition;

    public Crocodile(String color, String liana, int initialPosX, int initialPosY) {
        this.color = color;
        this.liana = liana;
        this.currentPosition = new ParOrdenado(initialPosX, initialPosY);
    }

    public ParOrdenado getCurrentPosition() {
        return currentPosition;
    }

    public String getLiana() {
        return liana;
    }

    public String getColor() {
        return color;
    }
}
