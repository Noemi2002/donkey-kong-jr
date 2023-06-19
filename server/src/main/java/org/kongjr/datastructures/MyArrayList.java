package org.kongjr.datastructures;

public class MyArrayList<T> {
    private Object[] elementos;
    private int tamano;
    private static final int CAPACIDAD_INICIAL = 10;

    public MyArrayList() {
        elementos = new Object[CAPACIDAD_INICIAL];
        tamano = 0;
    }

    public void agregar(T elemento) {
        if (tamano == elementos.length) {
            aumentarCapacidad();
        }
        elementos[tamano] = elemento;
        tamano++;
    }

    public T obtener(int indice) {
        if (indice < 0 || indice >= tamano) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        return (T) elementos[indice];
    }

    public int tamano() {
        return tamano;
    }

    private void aumentarCapacidad() {
        int nuevaCapacidad = elementos.length * 2;
        Object[] nuevoArreglo = new Object[nuevaCapacidad];
        System.arraycopy(elementos, 0, nuevoArreglo, 0, tamano);
        elementos = nuevoArreglo;
    }
}

