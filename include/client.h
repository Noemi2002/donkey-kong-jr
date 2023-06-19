#ifndef CLIENT_CLIENT_H
#define CLIENT_CLIENT_H
#include <stdio.h>
#include "winsock2.h"


int initialize_client_connection(void);
TCPsocket open_client_socket(void);


#endif //CLIENT_CLIENT_H
