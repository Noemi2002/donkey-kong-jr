package org.kongjr.crocodiles;

public class BlueCrocodile extends Crocodile{
    public BlueCrocodile(String liana, int x, int y) {
        super(liana, x, y);
        }

    @Override
    public void movement() {
        System.out.println("Me muevo en forma vertical y caigo");
    }

    @Override
    protected int getInitialSpeed() {
        return 10; //Velocidad origial del cocodrilo azul
    }

    @Override
    protected int updatePos() {
        return 0;
    }

}


