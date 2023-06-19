#include "../include/game_map.h"
#include "../include/globals.h"
#include <SDL2/SDL.h>
#include <SDL2/SDL_image.h>


// Function to load textures from a PNG file
SDL_Texture* loadTexture(SDL_Renderer* renderer, const char* path) {
    // Load image using SDL_image
    SDL_Surface* surface = IMG_Load(path);
    if (!surface) {
        printf("Failed to load image: %s\n", IMG_GetError());
        return NULL;
    }

    // Create texture from surface
    SDL_Texture* texture = SDL_CreateTextureFromSurface(renderer, surface);
    if (!texture) {
        printf("Failed to create texture: %s\n", SDL_GetError());
        SDL_FreeSurface(surface);
        return NULL;
    }

    // Free the surface since we have the texture now
    SDL_FreeSurface(surface);

    return texture;
}

// Function to initialize the game map
void initGameMap(GameMap* gameMap, int width, int height) {
    gameMap->mapWidth = width;
    gameMap->mapHeight = height;

    // Allocate memory for the tile array
    gameMap->tiles = (int**)malloc(gameMap->mapHeight * sizeof(int*));
    for (int i = 0; i < gameMap->mapHeight; i++) {
        gameMap->tiles[i] = (int*)malloc(gameMap->mapWidth * sizeof(int));
    }

    // Initialize the tile array with sample data
    for (int y = 0; y < gameMap->mapHeight; y++) {
        for (int x = 0; x < gameMap->mapWidth; x++) {
            gameMap->tiles[y][x] = 0; // Replace with your own tile data
        }
    }
}


// Function to render the game map onto the screen
void renderGameMap(GameMap* gameMap, SDL_Renderer* renderer) {
    // Clear the screen
    SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
    SDL_RenderClear(renderer);

    // Load the textures
    SDL_Texture* grassTexture = loadTexture(renderer, "../assets/textures/grass.png");\
    SDL_Texture* platformTexture = loadTexture(renderer, "../assets/textures/platform.png");
    SDL_Texture* waterTexture = loadTexture(renderer, "../assets/textures/water.png");

    // Render the tiles
    for (int y = 0; y < gameMap->mapHeight; y++) {
        for (int x = 0; x < gameMap->mapWidth; x++) {
            int tile = gameMap->tiles[y][x];

            // Set the rendering position and dimensions of the tile
            SDL_Rect tileRect;
            tileRect.x = x * TILE_SIZE;     // Replace TILE_WIDTH with your own tile width
            tileRect.y = y * TILE_SIZE;    // Replace TILE_HEIGHT with your own tile height
            tileRect.w = TILE_SIZE;
            tileRect.h = TILE_SIZE;

            // Render the tile texture onto the screen

            if (tile == 9)
            {
                SDL_RenderCopy(renderer, waterTexture, NULL, &tileRect);
            } else if (tile == 1) {
                SDL_RenderCopy(renderer, grassTexture, NULL, &tileRect);
            } else if (tile == 3) {
                SDL_RenderCopy(renderer, platformTexture, NULL, &tileRect);
            }
        }
    }

    // Update the screen
    SDL_RenderPresent(renderer);
}


static int grid[20][30] = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1},
        {0, 0, 0, 1,1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3, 3},
        {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 3, 3,  0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        {9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9},
};



void drawGrid(SDL_Renderer* renderer)
{
    SDL_SetRenderDrawColor(renderer, 0, 0, 255, SDL_ALPHA_OPAQUE);
    SDL_Rect rect;
    rect.w = GRID_SIZE;
    rect.h = GRID_SIZE;

    SDL_Texture* waterTexture = loadTexture(renderer, "../assets/textures/water.png");


    for (int row = 0; row < 20; row++) {
        for (int col = 0; col < 30; col++) {
            rect.x = col * GRID_SIZE;
            rect.y = row * GRID_SIZE;

            if (grid[row][col] == 9) {
                SDL_RenderCopy(renderer, waterTexture, NULL, &rect);
                SDL_SetRenderDrawColor(renderer, 0, 0, 255, SDL_ALPHA_OPAQUE);
                SDL_RenderFillRect(renderer, &rect);
            } else if (grid[row][col] == 1) {
                SDL_SetRenderDrawColor(renderer, 255, 255, 0, SDL_ALPHA_OPAQUE);
                SDL_RenderFillRect(renderer, &rect);
            } else if (grid[row][col] == 3) {
                SDL_SetRenderDrawColor(renderer, 0, 255, 0, SDL_ALPHA_OPAQUE);
                SDL_RenderFillRect(renderer, &rect);
            } else {
                SDL_SetRenderDrawColor(renderer, 255, 0, 5, SDL_ALPHA_OPAQUE);
                SDL_RenderDrawRect(renderer, &rect);
            }
        }
    }

    SDL_RenderPresent(renderer);
}


