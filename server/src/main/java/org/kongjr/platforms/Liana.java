package org.kongjr.platforms;
import org.kongjr.crocodiles.*;
import org.kongjr.fruits.*;
import org.kongjr.lista.*;


//Se nombran las lianas como L1, L2, ...
//Inician del lado izquierdo al derecho

public class Liana {
    private String lianaName;
    private MyLinkedList<Fruit> food;
    private MyLinkedList<Crocodile> enemies;
    private int initialPos;
    private int finalPos;

    public Liana(String name, int posX, int posY) {
        this.lianaName = name;
        this.food = new MyLinkedList<>();
        this.enemies = new MyLinkedList<>();
        this.initialPos = posX;
        this.finalPos = posY;

    }

    public String getLianaName() {
        return lianaName;
    }

    public void addFruit(Fruit fruta) {
        food.insert(fruta);
    }

    public void removeFruit(Fruit fruta) {
        food.delete(fruta);
    }

    public void addCocodrilo(Crocodile cocodrilo) {
        enemies.insert(cocodrilo);
    }

    public void removeCocodrilo(Crocodile cocodrilo) {
        enemies.delete(cocodrilo);
    }

    public int getInitialPos() {
        return initialPos;
    }

    public int getFinalPos() {
        return finalPos;
    }

    public boolean validPosition(int position) {
        return position >= initialPos && position <= finalPos;
    }


}

