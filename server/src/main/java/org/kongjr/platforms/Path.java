package org.kongjr.platforms;
import org.kongjr.crocodiles.Crocodile;
import org.kongjr.datastructures.*;

public class Path extends Platforms {

    private MyLinkedList<Crocodile> enemies;

    public Path(String name, int initialPos, int finalPos) {
        super(name, initialPos, finalPos);
        this.enemies = new MyLinkedList<>();
    }

    public void addCrocodile(Crocodile crocodile) {
        enemies.insert(crocodile);
    }

    public void removeCrocodile(Crocodile crocodile) {
        enemies.delete(crocodile);
    }

    /*public void moverPersonaje(Personaje personaje, int nuevaPosicion) {
        if (estaEnCamino(nuevaPosicion)) {
            personaje.setPosicion(nuevaPosicion);
        } else {
            System.out.println("La posición especificada no está en el camino.");
        }*/
}


