package org.kongjr.fruits;

public class Banana extends Fruit {
    public Banana(int liana, int height) {
        super(liana, height, 50); // La manzana otorga 10 puntos
    }

    @Override
    public void printInfo() {
        System.out.println("Banana en liana " + getLiana() + ", altura " + getHeight());
    }
}
