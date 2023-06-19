package org.kongjr.crocodiles;

public class RedCrocodileFactory implements CrocodileFactory {
    @Override
    public Crocodile createCrocodile(String color, String liana, int x, int y) {
        return new RedCrocodile(color, liana, x, y);
    }
}
