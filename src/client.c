#include <stdio.h>
#include <winsock2.h>


int configure_client_socket(struct WSAData data, struct sockaddr_in server_address) {
    if (WSAStartup(MAKEWORD(2, 2), &data) != 0) {
        printf("Failed to initialize Winsock.\n");
        return 1;
    }

    if (socket == INVALID_SOCKET) {
        printf("Failed to create socket.\n");
        WSACleanup();
        return 1;
    }

    client_socket = socket(AF_INET, SOCK_STREAM, 0);

    server_address.sin_family = AF_INET;
    server_address.sin_port = htons(1234); // Set the server port number
    server_address.sin_addr.s_addr = inet_addr("127.0.0.1"); // Set the server IP address

    printf("Successfully initialized client.\n");

    // Connect to the server
    if (connect(client_socket, (struct sockaddr*)&server_address, sizeof(server_address)) < 0) {
        printf("Failed to connect to the server.\n");
        closesocket(client_socket);
        WSACleanup();
        return 1;
    }
}

int send_message_to_server(SOCKET client_socket, const char* message) {
    if (send(client_socket, message, strlen(message), 0) < 0) {
        printf("Failed to send data to the server.\n");
        closesocket(client_socket);
        WSACleanup();
        return 1;
    }

    printf("Successfully sent message to server.\n");
}

int get_server_response(SOCKET client_socket, char server_response[1024]) {
    if (recv(client_socket, server_response, sizeof(server_response), 0) < 0) {
        printf("Failed to receive data from the server.\n");
        closesocket(client_socket);
        WSACleanup();
        return 1;
    }

    printf("Server response: %s\n", server_response);
}