package org.kongjr.interfaz;

import org.kongjr.crocodiles.BlueCrocodile;
import org.kongjr.crocodiles.Crocodile;
import org.kongjr.crocodiles.CrocodileFactory;
import org.kongjr.crocodiles.RedCrocodile;
import org.kongjr.estructuras.ParOrdenado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {
    private static CrocodileFactory crocodileFactory = new CrocodileFactory() {
    };

    public static void main(String[] args) {
        JFrame frame = new JFrame("Crocodiles and Fruits");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(40, 70, 200, 200);

        JButton blue = new JButton("New Blue Crocodile");
        blue.setBounds(30, 20, 150, 40);
        blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDialogAndCreateCrocodile("blue");
            }
        });

        JButton red = new JButton("New Red Crocodile");
        red.setBounds(30, 70, 150, 40);
        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showDialogAndCreateCrocodile("red");
            }
        });

        JButton apple = new JButton("New Apple");
        apple.setBounds(30, 120, 150, 40);
        apple.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para crear una nueva manzana
                System.out.println("Creating a new apple...");
            }
        });

        JButton banana = new JButton("New Banana");
        banana.setBounds(30, 170, 150, 40);
        banana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para crear un nuevo plátano
                System.out.println("Creating a new banana...");
            }
        });

        JButton watermelon = new JButton("New Watermelon");
        watermelon.setBounds(30, 220, 150, 40);
        watermelon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Código para crear una nueva sandía
                System.out.println("Creating a new watermelon...");
            }
        });

        frame.setLayout(null);
        frame.getContentPane().add(blue);
        frame.getContentPane().add(red);
        frame.getContentPane().add(apple);
        frame.getContentPane().add(banana);
        frame.getContentPane().add(watermelon);
        frame.getContentPane().add(panel);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private static void showDialogAndCreateCrocodile(String color) {
        String liana = JOptionPane.showInputDialog("Enter the liana name:");
        int height = Integer.parseInt(JOptionPane.showInputDialog("Enter the height:"));

        // Crear el cocodrilo utilizando el CrocodileFactory
        Crocodile crocodile = crocodileFactory.createCrocodile(color, liana, height);

        // Enviar el cocodrilo al servidor
        // Aquí debes agregar el código para enviar el objeto 'crocodile' al servidor

        System.out.println("Creating a new " + color + " crocodile...");
        System.out.println("Liana: " + liana);
        System.out.println("Height: " + height);
    }
}
