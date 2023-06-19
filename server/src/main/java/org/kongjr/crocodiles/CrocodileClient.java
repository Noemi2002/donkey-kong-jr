package org.kongjr.crocodiles;

public class CrocodileClient {
    private CrocodileFactory factory;

    public CrocodileClient(CrocodileFactory factory) {
        this.factory = factory;
    }

    public void createCrocodile(String color, String liana, int x, int y) {
        Crocodile crocodile = factory.createCrocodile(color, liana, x, y);
        // Lógica adicional, enviar información al servidor, etc.
        System.out.println("Creating a new crocodile: " + crocodile.getColor() + ", " + crocodile.getLiana() + ", " + crocodile.getCurrentPosition());
    }
}
