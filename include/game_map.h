#ifndef CLIENT_GAME_MAP_H
#define CLIENT_GAME_MAP_H

#include <SDL.h>

// GameMap struct
typedef struct {
    int** tiles;
    int mapWidth;
    int mapHeight;
    SDL_Texture* tileTexture;
} GameMap;

void drawGrid(SDL_Renderer* renderer);
SDL_Texture* loadTexture(SDL_Renderer* renderer, const char* path);
void initGameMap(GameMap* gameMap, int width, int height);

#endif //CLIENT_GAME_MAP_H
