package tic;

import java.util.Scanner;

public class game {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            // Keep asking until valid input is given
            boolean playAgainstComputer = false; // Default value
            while (true) {
                System.out.println("Do you want to play against the computer? (y/n): ");
                String input = scanner.nextLine().trim().toLowerCase(); // Normalize input to lowercase
                if (input.equals("y")) {
                    playAgainstComputer = true;
                    break; // Exit loop for valid input
                } else if (input.equals("n")) {
                    playAgainstComputer = false;
                    break; // Exit loop for valid input
                } else {
                    System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
                }
            }

            // Get player names
            System.out.print("Enter Player X's name: ");
            String playerXName = scanner.nextLine();

            Players playerX = new Players('X', playerXName);
            Players playerO;

            if (playAgainstComputer) {
                // Create a computer player
                playerO = new Players('O', "Computer");
            } else {
                // Get Player O's name if it's not a computer
                System.out.print("Enter Player O's name: ");
                String playerOName = scanner.nextLine();
                playerO = new Players('O', playerOName);
            }

            // Initialize the tic.game
            Game2 game = new Game2(playerX, playerO, playAgainstComputer);

            // Play the tic.game in a loop
            while (true) {
                game.playGame();
                System.out.println("Play again? (y/n): ");
                if (!scanner.nextLine().equalsIgnoreCase("y")) break;
                game.resetGame();
            }
        }
    }
