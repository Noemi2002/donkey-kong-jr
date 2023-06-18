package org.kongjr.crocodiles;
import org.kongjr.estructuras.ParOrdenado;
import org.kongjr.platforms.Liana;
import org.kongjr.platforms.Path;

public class RedCrocodile extends Crocodile{
    private Liana liana;
    private ParOrdenado currentPosition;
    private Path path;
    public RedCrocodile(Liana liana, int x, int y) {

        super(liana.getName(), x, y);
        this.liana = liana;
        this.path = null;

    }

    public RedCrocodile(Path path, int x, int y) {

        super(path.getName(), x, y);
        this.liana = null;
        this.path = path;
    }

    @Override
    public void movement() {
        /*if (liana != null && liana.isValidPosition(updatePos())) {
            moveVertically();
        } else if (path != null && path.isValidPosition(updatePos())) {
            moveHorizontally();
        } else {
            //manejar errores
        }*/
    }


    @Override
    protected int getInitialSpeed() {
        return 5; //Velocidad origial del cocodrilo azul
    }

    @Override
    protected int updatePos() {
        return 0;
    }

    //@Override
    /*protected ParOrdenado updatePos() {
        ParOrdenado currentPosition = getCurrentPosition();
        int speed = speed();

        if (liana != null) {
            // Actualizar posición verticalmente en la liana
            if (liana.getInitialPos().getY() < currentPosition.getY()) {
                currentPosition.setY(currentPosition.getY() + 1);
            } else if (liana.getFinalPos().getY() > currentPosition.getY()) {
                currentPosition.setY(currentPosition.getY() - 1);
            }
        } else if (path != null) {
            // Actualizar posición horizontalmente en el camino
            currentPosition.setX(currentPosition.getX() + 1);
        }
    }*/

    private void moveVertically() {
        updatePos();
        }


    private void moveHorizontally() {
        updatePos();}

    public ParOrdenado getCurrentPosition() {
        return currentPosition;
    }

}







