package org.kongjr.crocodiles;

public abstract class Crocodile {
    private String liana;

    public Crocodile(String liana) {
        this.liana = liana;
    }

    public abstract void movement();
    public final int speed() {
        int pos = 5; //Valor que se cambia por la posición del jugador cuando se da el cambio de nivel
        int level = currentLevel(pos);
        int baseSpeed = getInitialSpeed();
        return newSpeed(level, baseSpeed);
    }



    protected abstract int getInitialSpeed();

    protected int newSpeed(int level, int baseSpeed) {
        return baseSpeed + (level * 2);
    }

    protected int currentLevel(int playerPosition) {
        // Nivel del jugador
        return 1; // Nivel por defecto
    }

}