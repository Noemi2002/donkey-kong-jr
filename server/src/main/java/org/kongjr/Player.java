package org.kongjr;

public class Player {
    private int hearts; //vidas
    private int points;
    private int posX;
    private int posY;

    public Player() {
        this.hearts = 3;
        this.points = 100;
        this.posX = 0;
        this.posY = 0;
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


    public int decreaseHearts() {
        if (hearts > 0) {
            hearts--;
        }
        return hearts;
    }

    public int getPositionX() {
            return posX;
        }
    public void setPositionX(int positionX) {
            posX = positionX;
        }

    public int getPositionY() {
            return posY;
        }

    public void setPositionY(int positionY) {
            posY = positionY;
        }

    public void moveUp() {
            posY--;
        }

    public void moveDown() {
            posY++;
        }

    public void moveLeft() {
            posX--;
        }

    public void moveRight() {
            posX++;
        }
}

