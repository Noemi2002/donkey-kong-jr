
#ifndef CLIENT_PLAYER_H
#define CLIENT_PLAYER_H


typedef struct {
    int x;
    int y;
} Position;

typedef struct {
    int score;
    int lives;
    Position position;
} Player;



// Methods
void move_player();
void update_player_position_on_server();


#endif //CLIENT_PLAYER_H
