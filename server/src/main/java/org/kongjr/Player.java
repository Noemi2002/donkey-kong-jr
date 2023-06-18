package org.kongjr;

public class Player {
    private int hearts; //vidas
    private int points;

    public Player() {
        this.hearts = 3;
        this.points = 0;
    }

    public int getHearts() {
        return hearts;
    }

    public void setHearts(int vidas) {
        this.hearts = vidas;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int puntos) {
        this.points = puntos;
    }

    public void increasePoints(int puntos) {
        this.points += puntos;
    }

    public void decreaseHearts() {
        if (hearts > 0) {
            hearts--;
        }
    }
}
