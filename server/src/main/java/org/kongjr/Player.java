package org.kongjr;

public class Player {
    private static int changingID = 1000;
    private int id; // ID único para cada instancia de jugador
    private int hearts;
    private int points;


    public Player() {
        this.id = changingID++;
        this.hearts = 3;
        this.points = 100;

    }


    public int getId() {
        return id;
    }
}


