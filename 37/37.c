#include <stdio.h>
#include <stdlib.h>
#define N 9

void solveSudoku(char **board, int boardSize, int *boardColSize);
int fillCell(char **board, int boardSize);
int isValidNum(char **board, int boardSize, int y, int x, int num);

int main() {
    char **board = malloc(sizeof(char *) * N);
    for (int k = 0; k < N; ++k) {
        board[k] = malloc(sizeof(char) * N);
        for (int j = 0; j < N; ++j)
            scanf(" %c", &board[k][j]);
    }

    int colSize[N] = {N, N, N, N, N, N, N, N, N};
    solveSudoku(board, N, colSize);
    
    for (int k = 0; k < N; ++k) {
        for (int j = 0; j < N; ++j)
            printf("%c ", board[k][j]);
        if (k < N - 1)
            putchar('\n');
    }
    
    return 0;
}

void solveSudoku(char **board, int boardSize, int *boardColSize) {
    fillCell(board, boardSize);
}

int fillCell(char **board, int boardSize) {
    for (int k = 0; k < boardSize; ++k) {
        for (int j = 0; j < boardSize; ++j) {

            if (board[k][j] == '.') {
                for (int num = 1; num <= boardSize; ++num) {

                    if (isValidNum(board, boardSize, k, j, num)) {
                        board[k][j] = num + 48;
                        if (!fillCell(board, boardSize))
                            board[k][j] = '.';
                        else
                            // break;
                            return 1;
                    }
                }
                if (board[k][j] == '.')
                    return 0;
            }
        }
    }
    return 1;
}

int isValidNum(char **board, int boardSize, int y, int x, int num) {
    for (int k = 0; k < boardSize; ++k) {
        if (board[k][x] - 48 == num)
            return 0;
    }
    for (int j = 0; j < boardSize; ++j) {
        if (board[y][j] - 48 == num)
            return 0;
    }
    int areaSz = boardSize / 3;
    int areaY = y / areaSz * areaSz;
    int areaX = x / areaSz * areaSz;
    for (int k = 0; k < areaSz; ++k) {
        for (int j = 0; j < areaSz; ++j) {
            if (board[k + areaY][j + areaX] - 48 == num)
                return 0;
        }
    }
    return 1;
}