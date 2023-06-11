#ifndef CLIENT_CLIENT_H
#define CLIENT_CLIENT_H
#include <stdio.h>
#include "winsock2.h"

int configure_client_socket(struct WSAData data, struct sockaddr_in server_address, SOCKET* client_socket);
int send_message_to_server(SOCKET client_socket, const char* message);
int get_server_response(SOCKET client_socket, char server_response[1024]);
int close_socket(SOCKET client_socket);



#endif //CLIENT_CLIENT_H
