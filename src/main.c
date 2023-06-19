#include <stdio.h>
#include <stdbool.h>

#define SDL_MAIN_HANDLED
#include <SDL2/SDL.h>
#include <SDL2/SDL_net.h>
#include "../include/utils.h"
#include "../include/globals.h"
#include "../include/client.h"
#include "../include/game_map.h"


int main(int argc, char* args[]) {

    // Initialize SDL2
    if (SDL_Init(SDL_INIT_EVERYTHING) < 0) {
        printf("SDL2 initialization error: %s\n", SDL_GetError());
        return 1;
    }

    // Initialize SDL_net
    if (SDLNet_Init() < 0) {
        printf("SDL_net initialization error: %s\n", SDLNet_GetError());
        SDL_Quit();
        return 1;
    }

    initialize_client_connection();
    TCPsocket clientSocket = open_client_socket();


    // Create a window
    SDL_Window* window = SDL_CreateWindow("DonkeyKong Jr",
                                          SDL_WINDOWPOS_UNDEFINED,
                                          SDL_WINDOWPOS_UNDEFINED,
                                          SCREEN_WIDTH,
                                          SCREEN_HEIGHT,
                                          SDL_WINDOW_SHOWN);

    // Create a renderer
    SDL_Renderer* renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);
    if (renderer == NULL || window == NULL) {
        printf("Renderer or Window could not be created! SDL_Error: %s\n", SDL_GetError());
        return 1;
    }

    SDL_Surface* window_surface = NULL;
    window_surface = SDL_GetWindowSurface(window);

    GameMap gameMap;
    initGameMap(&gameMap, 20, 20);

    // Clear the renderer
    SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
    SDL_RenderClear(renderer);


    // Update the window
    SDL_RenderPresent(renderer);

    // Event loop
    SDL_Event event;
    int gameOver = false;

    // Game loop
    while (!gameOver) {
        // Event handling

        // Game logic

        // Rendering
        while (SDL_PollEvent(&event) != 0) {

            drawGrid(renderer);
            //renderGameMap(&gameMap, renderer);

            if (event.type == SDL_QUIT) {
                gameOver = true;
            }

            if (event.type == SDL_KEYDOWN) {
                switch (event.key.keysym.sym) {
                    case SDLK_ESCAPE:
                        gameOver = true;
                        break;
                    default:
                        break;
                }
            }


        }
    }

    // Clean up resources
    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return 0;
}
