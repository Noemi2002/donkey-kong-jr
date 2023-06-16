package org.kongjr.crocodiles;

public class RedCrocodile extends Crocodile{
    public RedCrocodile(String liana) {
        super(liana);
    }

    @Override
    public void movement() {
        System.out.println("Me muevo de forma vertical, sin caer");
    }

    @Override
    public int speed(){
        return 1;
    }

    public int speedLevel(int level){
        if (level == 1){
            return speed();
        }
        else{ return (level + 2);}
    }
}






