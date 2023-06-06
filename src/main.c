#include <stdio.h>
#include <winsock2.h>

int main() {
    // Initialize Winsock
    WSADATA wsaData;

    if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0) {
        printf("Failed to initialize Winsock.\n");
        return 1;
    }

    // Create a socket
    SOCKET clientSocket = socket(AF_INET, SOCK_STREAM, 0);
    if (clientSocket == INVALID_SOCKET) {
        printf("Failed to create socket.\n");
        WSACleanup();
        return 1;
    }

    // Set up the server address
    struct sockaddr_in serverAddress;
    serverAddress.sin_family = AF_INET;
    serverAddress.sin_port = htons(1234); // Set the server port number
    serverAddress.sin_addr.s_addr = inet_addr("127.0.0.1"); // Set the server IP address

    // Connect to the server
    if (connect(clientSocket, (struct sockaddr*)&serverAddress, sizeof(serverAddress)) < 0) {
        printf("Failed to connect to the server.\n");
        closesocket(clientSocket);
        WSACleanup();
        return 1;
    }

    // Send data to the server
    const char* message = "Hello, server!";
    if (send(clientSocket, message, strlen(message), 0) < 0) {
        printf("Failed to send data to the server.\n");
        closesocket(clientSocket);
        WSACleanup();
        return 1;
    }

    // Receive data from the server
    char serverResponse[1024];
    if (recv(clientSocket, serverResponse, sizeof(serverResponse), 0) < 0) {
        printf("Failed to receive data from the server.\n");
        closesocket(clientSocket);
        WSACleanup();
        return 1;
    }

    printf("Server response: %s\n", serverResponse);

    // Close the socket and cleanup Winsock
    closesocket(clientSocket);
    WSACleanup();

    return 0;
}
