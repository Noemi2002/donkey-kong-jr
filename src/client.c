#include <SDL2/SDL.h>
#include <SDL2/SDL_net.h>

IPaddress ip;
TCPsocket clientSocket;

int initialize_client_connection(){
    // Resolve the server IP address and port
    if (SDLNet_ResolveHost(&ip, "127.0.0.1", 1234) == -1) {
        printf("SDLNet_ResolveHost: %s\n", SDLNet_GetError());
        SDLNet_Quit();
        SDL_Quit();
        return 1;
    }
}

TCPsocket open_client_socket() {
    // Open a connection to the server
    clientSocket = SDLNet_TCP_Open(&ip);
    if (!clientSocket) {
        printf("SDLNet_TCP_Open: %s\n", SDLNet_GetError());
        SDLNet_Quit();
        SDL_Quit();
    }

    return clientSocket;
}