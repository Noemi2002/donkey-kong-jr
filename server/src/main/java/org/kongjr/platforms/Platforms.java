package org.kongjr.platforms;


import org.kongjr.estructuras.ParOrdenado;

public abstract class Platforms {
    private String name;
    private int initialPosX;
    private int initialPosY;
    private int finalPosX;
    private int finalPosY;


    public Platforms(String name, int initialPosX, int initialPosY){//, int finalPosX, int finalPosY) {
        this.name = name;
        this.initialPosX = initialPosX;
        this.finalPosY = finalPosY;
        this.initialPosY = initialPosY;
        this.finalPosX = finalPosX;
    }

    public String getName() {
        return name;
    }

    public ParOrdenado getInitialPos() {

        return new ParOrdenado(initialPosX, initialPosY);
    }

    public ParOrdenado getFinalPos() {

        return new ParOrdenado(finalPosX, finalPosY);
    }

    /*public boolean isValidPosition(int position) {
        return position >= initialPos && position <= finalPos;
    }*/
}

