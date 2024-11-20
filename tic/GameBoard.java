package tic;

public class GameBoard {
        private char[][] board;
        private static final int SIZE = 3;

        public GameBoard() {
            board = new char[SIZE][SIZE];
            resetBoard();
        }

        public void resetBoard() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    board[i][j] = ' ';
                }
            }
        }

        public boolean makeMove(int position, char symbol) {
            int row = (position - 1) / SIZE;
            int col = (position - 1) % SIZE;
            if (board[row][col] == ' ') {
                board[row][col] = symbol;
                return true;
            }
            return false;
        }

        public void displayBoard() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print(" " + board[i][j]);
                    if (j < SIZE - 1) System.out.print(" |");
                }
                System.out.println();
                if (i < SIZE - 1) System.out.println("---+---+---");
            }
        }

        public boolean checkWin(char symbol) {
            // Check rows, columns, and diagonals
            for (int i = 0; i < SIZE; i++) {
                if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
                if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol) return true;
            }
            return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                    (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
        }

        public boolean isBoardFull() {
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == ' ') return false;
                }
            }
            return true;
        }
    }
