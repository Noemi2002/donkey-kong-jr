#include <stdio.h>
#include <winsock2.h>

#pragma comment(lib, "ws2_32.lib")

int configure_client_socket(struct WSAData data, struct sockaddr_in server_address, SOCKET* client_socket) {
    if (WSAStartup(MAKEWORD(2, 2), &data) != 0) {
        printf("Failed to initialize Winsock.\n");
        return 1;
    }

    *client_socket = socket(AF_INET, SOCK_STREAM, 0);
    if (*client_socket == INVALID_SOCKET) {
        printf("Failed to create socket.\n");
        WSACleanup();
        return 1;
    }

    server_address.sin_family = AF_INET;
    server_address.sin_port = htons(1234); // Set the server port number
    server_address.sin_addr.s_addr = inet_addr("127.0.0.1"); // Set the server IP address

    printf("Successfully initialized client.\n");

    // Connect to the server
    if (connect(*client_socket, (struct sockaddr*)&server_address, sizeof(server_address)) == SOCKET_ERROR) {
        printf("Failed to connect to the server.\n");
        closesocket(*client_socket);
        WSACleanup();
        return 1;
    }

    return 0;
}

int send_message_to_server(SOCKET client_socket, const char* message) {
    char message_with_newline[1024];
    snprintf(message_with_newline, sizeof(message_with_newline), "%s\n", message);

    int result = send(client_socket, message_with_newline, strlen(message_with_newline), 0);
    if (result == SOCKET_ERROR) {
        printf("Failed to send data to the server.\n");
        return 1;
    }

    printf("Successfully sent message to server.\n");
    return 0;
}


int close_socket(SOCKET client_socket) {
    closesocket(client_socket);
    WSACleanup();
    return 0;
}


int get_server_response(SOCKET client_socket, char server_response[1024]) {
    int result = recv(client_socket, server_response, 1024, 0);
    if (result == SOCKET_ERROR) {
        printf("Failed to receive data from the server.\n");
        return 1;
    }

    server_response[result] = '\0'; // Null-terminate the received data
    printf("Server response: %s\n", server_response);

    if (get_server_response(client_socket, server_response) != 0) {
        close_socket(client_socket);
        return 1;
    }

    // Close the connection after receiving the response
    close_socket(client_socket);

    return 0;
}


