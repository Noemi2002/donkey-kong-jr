package org.kongjr.fruits;

public class Apple extends Fruit {
    public Apple(int liana, int height) {
        super(liana, height, 100); // La manzana otorga 10 puntos
    }

    @Override
    public void printInfo() {
        System.out.println("Manzana en liana " + getLiana() + ", altura " + getHeight());
    }

    @Override
    public int setPoint() {
        return 0;
    }
}
