package org.kongjr.crocodiles;

import org.kongjr.estructuras.ParOrdenado;

public abstract class Crocodile {
    private String liana;
    private int initialPosX;
    private int initialPosY;
    private int currentPosition;;

    public Crocodile(String liana, int initialPosX, int initialPosY) {
        this.liana = liana;
        this.initialPosX = initialPosX;
        this.initialPosY = initialPosY;
    }

    public abstract void movement();
    public final int speed() {
        int pos = 5; //Valor que se cambia por la posición del jugador cuando se da el cambio de nivel
        int level = currentLevel(pos);
        int baseSpeed = getInitialSpeed();
        return newSpeed(level, baseSpeed);
    }

    public ParOrdenado getInitialPos(){
        return new ParOrdenado(initialPosX, initialPosY);
    }



    protected abstract int getInitialSpeed();
    protected abstract int updatePos();

    protected int newSpeed(int level, int baseSpeed) {
        return baseSpeed + (level * 2);
    }

    protected int currentLevel(int playerPosition) {
        // Nivel del jugador
        return 1; // Nivel por defecto
    }

}