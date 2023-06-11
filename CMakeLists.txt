cmake_minimum_required(VERSION 3.25)
project(client C)

set(CMAKE_C_STANDARD 23)

set(SOURCES src/main.c src/client.c include/client.h src/client.h)

add_executable(Client ${SOURCES})

# Link with the Winsock library (ws2_32)
target_link_libraries(Client ws2_32)