package org.kongjr.crocodiles;

public class BlueCrocodile extends Crocodile{
    public BlueCrocodile(String liana) {
            super(liana);
        }

        @Override
        public void movement() {
            System.out.println("Me muevo de forma vertical, yo sí caigo");
        }

    @Override
    public int speed(){
        return 1;
    }

    //Dependiendo del nivel,
    public int speedLevel(int level){
        if (level == 1){
            return speed();
        }
        else{ return (level + 2);}
    }

}


