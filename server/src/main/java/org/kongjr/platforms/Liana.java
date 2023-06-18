package org.kongjr.platforms;
import org.kongjr.crocodiles.*;
import org.kongjr.fruits.*;
import org.kongjr.estructuras.*;


//Se nombran las lianas como L1, L2, ...
//Inician del lado izquierdo al derecho

public class Liana extends Platforms {
    private MyLinkedList<Fruit> food;
    private MyLinkedList<Crocodile> enemies;

    public Liana(String name, int initialPos, int finalPos) {
        super(name, initialPos, finalPos);
        this.food = new MyLinkedList<>();
        this.enemies = new MyLinkedList<>();

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

}

