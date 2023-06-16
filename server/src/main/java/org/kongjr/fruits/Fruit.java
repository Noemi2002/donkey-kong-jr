package org.kongjr.fruits;

//Van a haber diferentes tipos de frutas?
//En ese caso cada fruta requiere su clase y esta que es general debería ser abstract
//Cada fruta tiene su puntaje

public class Fruit {
    private String liana;
    private int height;
    private int points;

    public Fruit(String liana, int height, int points) {
        this.liana = liana;
        this.height = height;
        this.points = points;
    }

    public void createFruit(String liana, int height){
        System.out.println("A new fruit is created");
    }

    public void deleteFruit(String liana, int height) {
        //pass
    }

    public int getPoints() {
        return this.points;
    }


}

