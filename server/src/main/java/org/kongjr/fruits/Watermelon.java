package org.kongjr.fruits;

public class Watermelon extends Fruit {
    public Watermelon(String liana, int height) {
        super(liana, height, 100); // La manzana otorga 10 puntos
    }

    @Override
    public void printInfo() {
        System.out.println("Sandía en liana " + getLiana() + ", altura " + getHeight());
    }

    @Override
    public int setPoint() {
        return 0;
    }
}
