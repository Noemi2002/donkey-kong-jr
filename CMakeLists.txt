cmake_minimum_required(VERSION 3.25)
project(client C)

set(CMAKE_C_STANDARD 23)

# Find the SDL2 package
find_package(SDL2 CONFIG REQUIRED)
find_package(SDL2_ttf CONFIG REQUIRED)
find_package(SDL2_image CONFIG REQUIRED)

# Define the source files
set(SOURCES src/main.c src/client.c include/client.h include/client.h include/utils.h include/utils.h)


# Create the executable
add_executable(Client ${SOURCES})
# Link with the required libraries
target_link_libraries(Client PRIVATE
        ws2_32
        SDL2::SDL2main
        SDL2::SDL2
        $<IF:$<TARGET_EXISTS:SDL2_ttf::SDL2_ttf>,
        SDL2_ttf::SDL2_ttf,
        SDL2_ttf::SDL2_ttf-static>
        $<IF:$<TARGET_EXISTS:SDL2_image::SDL2_image>,
        SDL2_image::SDL2_image,
        SDL2_image::SDL2_image-static>)
