#include <stdio.h>
#include <winsock2.h>
#include "client.h"


int main() {
    struct WSAData wsaData;
    struct sockaddr_in serverAddress;
    SOCKET clientSocket;
    char message[1024];
    char serverResponse[1024];

    // Configure the client socket
    if (configure_client_socket(wsaData, serverAddress, &clientSocket) != 0) {
        printf("Failed to configure client socket.\n");
        return 1;
    }

    // Send a message to the server
    strcpy(message, "Hello, server!");
    if (send_message_to_server(clientSocket, message) != 0) {
        printf("Failed to send message to the server.\n");
        close_socket(clientSocket);
        return 1;
    }

    // Receive the server's response
    if (get_server_response(clientSocket, serverResponse) != 0) {
        printf("Failed to receive server response.\n");
        close_socket(clientSocket);
        return 1;
    }

    // Close the socket and cleanup
    if (close_socket(clientSocket) != 0) {
        printf("Failed to close socket.\n");
        return 1;
    }

    return 0;
}
