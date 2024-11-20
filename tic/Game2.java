package tic;

import java.util.Random;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Game2 {
    private GameBoard board;
    private Players playerX;
    private Players playerO;
    private Scanner scanner;
    private boolean playAgainstComputer;

    public Game2(Players playerX, Players playerO, boolean playAgainstComputer) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.board = new GameBoard();
        this.scanner = new Scanner(System.in);
        this.playAgainstComputer = playAgainstComputer; // Whether Player O is a computer
    }

    public void resetGame() {
        board.resetBoard();
    }

    public void playGame() {
        Players currentPlayer = playerX;
        while (true) {
            board.displayBoard();

            if (currentPlayer == playerO && playAgainstComputer) {
                System.out.println("Computer's turn...");
                int position = getComputerMove(); // Get a move from the computer
                board.makeMove(position, currentPlayer.getSymbol());
            } else {
                System.out.println(currentPlayer.getName() + " (" + currentPlayer.getSymbol() + "), enter position (1-9):");
                int position = getPlayerMove();
                if (!board.makeMove(position, currentPlayer.getSymbol())) {
                    System.out.println("Position already taken, try again.");
                    continue; // Retry the move
                }
            }

            // Check for a win or draw
            if (board.checkWin(currentPlayer.getSymbol())) {
                board.displayBoard();
                System.out.println(currentPlayer.getName() + " wins!");
                currentPlayer.incrementScore();
                displayScores();
                break;
            } else if (board.isBoardFull()) {
                board.displayBoard();
                System.out.println("It's a draw!");
                break;
            }

            // Switch to the other player
            currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
        }
    }

    private int getPlayerMove() {
        int position = -1;
        while (position < 1 || position > 9) {
            try {
                position = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Enter a number between 1 and 9.");
                scanner.next();
            }
        }
        return position;
    }

    private int getComputerMove() {
        Random random = new Random();
        int position;
        do {
            position = random.nextInt(9) + 1; // Random position between 1 and 9
        } while (!board.makeMove(position, playerO.getSymbol())); // Ensure the position is valid
        return position;
    }

    private void displayScores() {
        System.out.println("Scores:");
        System.out.println(playerX.getName() + ": " + playerX.getScore());
        System.out.println(playerO.getName() + ": " + playerO.getScore());
    }
}