package org.kongjr;
import org.kongjr.fruits.Fruit;
import java.util.ArrayList;
import java.util.List;

//Revisar doc por si no se pueden usar las listas de java
// -----------CAMBIAR LO DE LAS LISTAS-----------

public class Liana {
    private int lianaNumber;
    private List<Fruit> fruits;

    public Liana(int lianaNumber) {
        this.lianaNumber = lianaNumber;
        this.fruits = new ArrayList<>();
    }

    public int getLianaNumber() {
        return lianaNumber;
    }

    public List<Fruit> getFrutas() {
        return fruits;
    }

    public void addFruit(Fruit fruta) {
        fruits.add(fruta);
    }

    public void removeFruit(Fruit fruta) {
        fruits.remove(fruta);
    }

}

