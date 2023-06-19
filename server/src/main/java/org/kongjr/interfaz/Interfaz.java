package org.kongjr.interfaz;

import org.kongjr.crocodiles.BlueCrocodile;
import org.kongjr.crocodiles.Crocodile;
import org.kongjr.crocodiles.RedCrocodile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Crocodiles and Fruits");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(40, 70, 200, 200);

        JButton blue = new JButton("New Blue Crocodile");
        blue.setBounds(30, 20, 150, 40);
        blue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCrocodileDialog("blue");
            }
        });

        JButton red = new JButton("New Red Crocodile");
        red.setBounds(30, 70, 150, 40);
        red.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showCrocodileDialog("red");
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

    private static void showCrocodileDialog(String color) {
        JFrame dialog = new JFrame("Create Crocodile");
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel colorLabel = new JLabel("Color: " + color);
        panel.add(colorLabel);

        JLabel lianaLabel = new JLabel("Liana:");
        JTextField lianaField = new JTextField(10);
        panel.add(lianaLabel);
        panel.add(lianaField);

        JLabel heightLabel = new JLabel("Height:");
        JTextField heightField = new JTextField(10);
        panel.add(heightLabel);
        panel.add(heightField);

        JButton createButton = new JButton("Create");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String liana = lianaField.getText();
                int height = Integer.parseInt(heightField.getText());

                createCrocodile(color, liana, height);

                dialog.dispose();
            }
        });
        panel.add(createButton);

        dialog.getContentPane().add(panel);
        dialog.setSize(200, 200);
        dialog.setVisible(true);
    }

    //Usar esta función para enviar la información al cliente
    private static void createCrocodile(String color, String liana, int height) {
        // Código para crear un nuevo cocodrilo
        Crocodile crocodile;

        if (color.equals("blue")) {
            crocodile = new BlueCrocodile("blue",liana, height);
        } else if (color.equals("red")) {
            crocodile = new RedCrocodile( "red",liana, height);
        } else {
            // Color inválido
            return;
        }

        // Enviar el cocodrilo al servidor
        // Aquí debes agregar el código para enviar el objeto 'crocodile' al servidor

        System.out.println("Creating a new " + color + " crocodile...");
        System.out.println("Liana: " + liana);
        System.out.println("Height: " + height);
    }
}
