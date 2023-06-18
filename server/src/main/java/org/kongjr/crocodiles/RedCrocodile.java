package org.kongjr.crocodiles;

public class RedCrocodile extends Crocodile{
    public RedCrocodile(String liana) {
        super(liana);
    }

    @Override
    public void movement() {
        System.out.println("Me muevo en forma vertical y no caigo, si no que subo y bajo");
    }

    @Override
    protected int getInitialSpeed() {
        return 5; //Velocidad origial del cocodrilo azul
    }

}







