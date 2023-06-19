package org.kongjr.estructuras;

public class Matriz {
    private MyArrayList<ParOrdenado> paresOrdenados;

    public Matriz() {
        paresOrdenados = new MyArrayList<>();
    }

    public void agregarParOrdenado(int posX, int posY) {
        ParOrdenado parOrdenado = new ParOrdenado(posX, posY);
        paresOrdenados.agregar(parOrdenado);
    }

}