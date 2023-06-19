package org.kongjr.fruits;

public abstract class Fruit {
    private int liana;
    private int height;
    private int points;

    public Fruit(int liana, int height, int points) {
        this.liana = liana;
        this.height = height;
        this.points = points;
    }

    public int getLiana() {
        return liana;
    }

    public int getHeight() {
        return height;
    }

    public int getPoints() {
        return points;
    }

    public abstract void printInfo();
    public abstract int setPoint();
}
