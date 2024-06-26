package org.kongjr.ui;

//Imports necesarios
import org.kongjr.crocodiles.BlueCrocodile;
import org.kongjr.crocodiles.Crocodile;
import org.kongjr.crocodiles.RedCrocodile;
import org.kongjr.fruits.Apple;
import org.kongjr.fruits.Banana;
import org.kongjr.fruits.Fruit;
import org.kongjr.fruits.Watermelon;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz {

    //ventana
    public static void main(String[] args) {
        JFrame frame = new JFrame("Crocodiles and Fruits");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setBounds(40, 70, 200, 200);


        //Botones para crear cocodrilos
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

        //Botones para crear frutas
        JButton apple = new JButton("New Apple");
        apple.setBounds(30, 120, 150, 40);
        apple.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showFruitDialog("Apple");
            }
        });

        JButton banana = new JButton("New Banana");
        banana.setBounds(30, 170, 150, 40);
        banana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showFruitDialog("Banana");
            }
        });

        JButton watermelon = new JButton("New Watermelon");
        watermelon.setBounds(30, 220, 150, 40);
        watermelon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showFruitDialog("Watermelon");
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

    //Para definir la liana y la posición de los cocodrilos
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

                if (isValidLiana(liana) && isValidHeight(height)) {
                    createCrocodile(color, liana, height);
                    dialog.dispose();
                } else {
                    String errorMessage = "Invalid input:";
                    if (!isValidLiana(liana)) {
                        errorMessage += "\n- Liana must be between L1 and L6.";
                    }
                    if (!isValidHeight(height)) {
                        errorMessage += "\n- Height must be a positive integer.";
                    }
                    JOptionPane.showMessageDialog(dialog, errorMessage);
                }
            }
        });
        panel.add(createButton);

        dialog.getContentPane().add(panel);
        dialog.setSize(200, 200);
        dialog.setVisible(true);
    }

    //Crea la instancia de los cocodrilos
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



        System.out.println("Creating a new " + color + " crocodile...");
        System.out.println("Liana: " + liana);
        System.out.println("Height: " + height);
    }

    //Para definir la liana y la posición de las frutas
    private static void showFruitDialog(String fruitName) {
        JFrame dialog = new JFrame("Create Fruit");
        dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel fruitLabel = new JLabel("Fruit: " + fruitName);
        panel.add(fruitLabel);

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

                if (isValidLiana(liana) && isValidHeight(height)) {
                    createFruit(fruitName, liana, height);
                    dialog.dispose();
                } else {
                    String errorMessage = "Invalid input:";
                    if (!isValidLiana(liana)) {
                        errorMessage += "\n- Liana must be between L1 and L6.";
                    }
                    if (!isValidHeight(height)) {
                        errorMessage += "\n- Height must be a positive integer.";
                    }
                    JOptionPane.showMessageDialog(dialog, errorMessage);
                }
            }
        });
        panel.add(createButton);

        dialog.getContentPane().add(panel);
        dialog.setSize(200, 200);
        dialog.setVisible(true);
    }

    //Crea las instancias de las frutas
    private static void createFruit(String fruitName, String liana, int height) {
        // Código para crear una nueva fruta
        Fruit fruit;

        if (fruitName.equals("Apple")) {
            fruit = new Apple(liana, height);
        } else if (fruitName.equals("Watermelon")) {
            fruit = new Watermelon(liana, height);
        } else if (fruitName.equals("Banana")){
            fruit = new Banana(liana, height);
        } else {
            // Nombre de fruta inválido
            return;
        }


        System.out.println("Creating a new " + fruitName + "...");
        System.out.println("Liana: " + liana);
        System.out.println("Height: " + height);
    }


    //Validas las lianas
    private static boolean isValidLiana(String liana) {
        return liana.matches("L[1-6]");
    }

    //Valida la altura
    private static boolean isValidHeight(int height) {
        return height > 0;
    }

}