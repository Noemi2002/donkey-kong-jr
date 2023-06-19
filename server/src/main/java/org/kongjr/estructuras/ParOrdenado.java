package org.kongjr.estructuras;

public class ParOrdenado {
    private int x;
    private int y;

    public ParOrdenado(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int value) {
        this.x = value ;
    }

    public void setY(int value) {
        this.y = value ;
    }

    public ParOrdenado add(int x, int y) {
        int newX = this.x + x;
        int newY = this.y + y;
        return new ParOrdenado(newX, newY);
    }
}
