package org.kongjr.platforms;

public class Path {
    private int InitialPos;
    private int FinalPos;

    public Path(int InitialPos, int FinalPos) {
        this.InitialPos = InitialPos;
        this.FinalPos = FinalPos;
    }

    public int getInitialPos() {
        return InitialPos;
    }

    public int getFinalPos() {
        return FinalPos;
    }

    public boolean validPath(int position) {
        return position >= InitialPos && position <= FinalPos;
    }

    /*public void moverPersonaje(Personaje personaje, int nuevaPosicion) {
        if (estaEnCamino(nuevaPosicion)) {
            personaje.setPosicion(nuevaPosicion);
        } else {
            System.out.println("La posición especificada no está en el camino.");
        }*/
}


