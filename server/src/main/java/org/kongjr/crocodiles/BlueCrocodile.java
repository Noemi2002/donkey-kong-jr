package org.kongjr.crocodiles;

public class BlueCrocodile extends Crocodile{
    public BlueCrocodile(String liana) {
            super(liana);
        }

    @Override
    public void movement() {
        System.out.println("Me muevo en forma vertical y caigo");
    }

    @Override
    protected int getInitialSpeed() {
        return 10; //Velocidad origial del cocodrilo azul
    }

}


