package org.kongjr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a server socket
            ServerSocket serverSocket = new ServerSocket(1234);

            System.out.println("Server started. Waiting for connections...");

            // Accept client connections
            Socket clientSocket = serverSocket.accept();

            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Create input and output streams for the client socket
            BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive data from the client
            String clientMessage = input.readLine();
            System.out.println("Received from client: " + clientMessage);

            // Send response to the client
            String responseMessage = "Hello, client!";
            output.println(responseMessage);
            System.out.println("Sent to client: " + responseMessage);

            // Close the streams and sockets
            output.close();
            input.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}