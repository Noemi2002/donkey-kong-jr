package org.kongjr.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import static java.lang.System.out;

public class Server {

    public ServerSocket serverSocket;
    public Socket clientSocket;
    private final int port;

    public Server(int port) throws IOException {
        this.port = port;
        this.serverSocket = new ServerSocket(this.port);
        out.println("Server started, waiting for connections...");

        acceptClientConnections();
    }

    public void acceptClientConnections() throws IOException {
        while (true) {
            clientSocket = this.serverSocket.accept();

            System.out.println("Client connected: " + clientSocket.getInetAddress());

            // Create input and output streams for the client socket
            var input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            var output = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read messages from the client
            String clientMessage;
            while ((clientMessage = input.readLine()) != null) {
                System.out.println("Received from client: " + clientMessage);

                // Process the client message
                // ...

                // Send response to the client
                String responseMessage = "Hello, client!";
                output.println(responseMessage);
                System.out.println("Sent to client: " + responseMessage);
            }

            // Close the resources for this client
            input.close();
            output.close();
            closeSocket();
        }
    }

    public void closeSocket() throws IOException {
        clientSocket.close();
        serverSocket.close();
    }

    public int getPort() {
        return port;
    }
}