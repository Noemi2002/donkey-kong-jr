package org.kongjr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;

import static java.lang.System.*;


public class Main {
    public static void main(String[] args) throws IOException {
        try {
            // Create a server socket
            var serverSocket = new ServerSocket(1234);

            out.println("Server started. Waiting for connections...");

            // Accept client connections
            var clientSocket = serverSocket.accept();

            out.println("Client connected: " + clientSocket.getInetAddress());

            // Create input and output streams for the client socket
            var input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            var output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive data from the client
            var clientMessage = input.readLine();
            out.println("Received from client: " + clientMessage);

            // Send response to the client
            var responseMessage = "Hello, client!";
            output.println(responseMessage);
            out.println("Sent to client: " + responseMessage);

            // Close the streams and sockets
            output.close();
            input.close();
            clientSocket.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new IOException("All clients have been terminated." + e.getMessage());
        }
    }
}