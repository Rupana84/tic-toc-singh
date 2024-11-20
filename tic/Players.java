package tic;

public class Players {
        private char symbol;
        private String name;
        private int score;

        public Players(char symbol, String name) {
            this.symbol = symbol;
            this.name = name;
            this.score = 0;
        }

        public String getName() {
            return name;
        }

        public char getSymbol() {
            return symbol;
        }

        public int getScore() {
            return score;
        }

        public void incrementScore() {
            score++;
        }
    }

