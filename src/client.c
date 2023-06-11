#include <stdio.h>
#include <winsock2.h>

// Initialize Winsock
WSADATA wsaData;

// Set up the server address
struct sockaddr_in serverAddress;

// Create a socket for connecting to the server
SOCKET clientSocket = INVALID_SOCKET;

int configure_client_socket(struct WSAData wsaData, struct sockaddr_in serverAddress, SOCKET clientSocket) {
    if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0) {
        printf("Failed to initialize Winsock.\n");
        return 1;
    }

    if (clientSocket == INVALID_SOCKET) {
        printf("Failed to create socket.\n");
        WSACleanup();
        return 1;
    }

    clientSocket = socket(AF_INET, SOCK_STREAM, 0);

    serverAddress.sin_family = AF_INET;
    serverAddress.sin_port = htons(1234); // Set the server port number
    serverAddress.sin_addr.s_addr = inet_addr("127.0.0.1"); // Set the server IP address

    printf("Successfully initialized client.\n");

    // Connect to the server
    if (connect(clientSocket, (struct sockaddr*)&serverAddress, sizeof(serverAddress)) < 0) {
        printf("Failed to connect to the server.\n");
        closesocket(clientSocket);
        WSACleanup();
        return 1;
    }
}

int send_message_to_server(SOCKET clientSocket, const char* message) {
    if (send(clientSocket, message, strlen(message), 0) < 0) {
        printf("Failed to send data to the server.\n");
        closesocket(clientSocket);
        WSACleanup();
        return 1;
    }

    printf("Successfully sent message to server.\n");
}

int get_server_response(SOCKET client_socket, char serverResponse[1024]) {
    if (recv(client_socket, serverResponse, sizeof(serverResponse), 0) < 0) {
        printf("Failed to receive data from the server.\n");
        closesocket(client_socket);
        WSACleanup();
        return 1;
    }

    printf("Server response: %s\n", serverResponse);
}