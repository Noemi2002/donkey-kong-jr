#include <stdio.h>

#define SDL_MAIN_HANDLED
#include <SDL2/SDL.h>
#include <SDL2/SDL_ttf.h>
#include "../include/utils.h"
#include "../include/client.h"


const int SCREEN_WIDTH = 640;
const int SCREEN_HEIGHT = 480;

int main(int argc, char* args[]) {
    struct WSAData data;
    struct sockaddr_in server_address;
    SOCKET client_socket;

    if (configure_client_socket(data, server_address, &client_socket) != 0) {
        return 1;
    }

    if (send_message_to_server(client_socket, "Hello from client!") != 0) {
        close_socket(client_socket);
        return 1;
    }

    char server_response[1024];
    if (get_server_response(client_socket, server_response) != 0) {
        close_socket(client_socket);
        return 1;
    }


    // Initialize SDL
    if (SDL_Init(SDL_INIT_VIDEO) < 0) {
        printf("SDL could not initialize! SDL_Error: %s\n", SDL_GetError());
        return 1;
    }

    // Create a window
    SDL_Window* window = SDL_CreateWindow("SDL Hello World", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED, SCREEN_WIDTH, SCREEN_HEIGHT, SDL_WINDOW_SHOWN);
    if (window == NULL) {
        printf("Window could not be created! SDL_Error: %s\n", SDL_GetError());
        return 1;
    }

    // Create a renderer
    SDL_Renderer* renderer = SDL_CreateRenderer(window, -1, SDL_RENDERER_ACCELERATED);
    if (renderer == NULL) {
        printf("Renderer could not be created! SDL_Error: %s\n", SDL_GetError());
        return 1;
    }

    // Initialize SDL_ttf for text rendering
    if (TTF_Init() < 0) {
        printf("SDL_ttf could not initialize! SDL_ttf Error: %s\n", TTF_GetError());
        return 1;
    }

    const char* filename = "../assets/fonts/Minecraft.ttf";
    char* file_path = search_file_in_current_path(filename);

    TTF_Font* font = TTF_OpenFont(file_path, 2000);
    if (font == NULL) {
        printf("Failed to load font! SDL_ttf Error: %s\n", TTF_GetError());
        return 1;
    }

    // Set up the text surface
    SDL_Color textColor = { 255, 255, 255 };
    SDL_Surface* textSurface = TTF_RenderText_Solid(font, "Hello, World!", textColor);
    if (textSurface == NULL) {
        printf("Failed to render text surface! SDL_ttf Error: %s\n", TTF_GetError());
        return 1;
    }

    // Create a texture from the text surface
    SDL_Texture* textTexture = SDL_CreateTextureFromSurface(renderer, textSurface);
    if (textTexture == NULL) {
        printf("Failed to create texture from surface! SDL_Error: %s\n", SDL_GetError());
        return 1;
    }

    // Clear the renderer
    SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
    SDL_RenderClear(renderer);

    // Render the text texture
    SDL_RenderCopy(renderer, textTexture, NULL, NULL);

    // Update the window
    SDL_RenderPresent(renderer);

    // Event loop
    SDL_Event event;
    int quit = 0;
    while (!quit) {
        while (SDL_PollEvent(&event) != 0) {
            if (event.type == SDL_QUIT) {
                quit = 1;
            }
        }
    }

    // Clean up resources
    SDL_DestroyTexture(textTexture);
    SDL_FreeSurface(textSurface);
    SDL_DestroyRenderer(renderer);
    SDL_DestroyWindow(window);
    SDL_Quit();

    return 0;
}