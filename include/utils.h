#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#ifdef _WIN32
#include <direct.h>
#define GetCurrentDir _getcwd
#define DIR_SEPARATOR "\\"
#else
#include <unistd.h>
    #define GetCurrentDir getcwd
    #define DIR_SEPARATOR "/"
#endif

char* search_file_in_current_path(const char* filename) {
    char* current_path = (char*)malloc(1024);  // Assuming a maximum path length of 1024 characters
    if (current_path == NULL) {
        printf("Memory allocation failed.\n");
        return NULL;
    }

    // Retrieve the current path
    if (GetCurrentDir(current_path, 1024) == NULL) {
        printf("Failed to get the current path.\n");
        free(current_path);
        return NULL;
    }

    const size_t current_path_length = strlen(current_path);
    const size_t filename_length = strlen(filename);
    const size_t total_length = current_path_length + filename_length + 2;  // +2 for directory separator and null-terminator

    char* file_path = (char*)malloc(total_length);
    if (file_path == NULL) {
        printf("Memory allocation failed.\n");
        free(current_path);
        return NULL;
    }

    strcpy(file_path, current_path);

    // Append directory separator if necessary
    if (file_path[current_path_length - 1] != DIR_SEPARATOR[0]) {
        strcat(file_path, DIR_SEPARATOR);
    }

    strcat(file_path, filename);

    free(current_path);

    return file_path;
}