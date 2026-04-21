// Noah Thompson
// 21 April 2026
// GameBoard.java

package Tictactoe;

public class GameBoard{
    // tracking current board status
    public static char[] board = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    // here is current gameboard
    public static void printBoard() {
        System.out.println("|---|---|---|");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
        System.out.println("|-----------|");
        System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
        System.out.println("|---|---|---|\n");
    }

    public static boolean checkWinner() {
        for (int a = 0; a < 8; a++) {
            String line = null;

            // going through each individual possible case for a winner to occur
            switch (a) {
                case 0:
                    line = "" + board[0] + board[1] + board[2];
                    break;
                case 1:
                    line = "" + board[3] + board[4] + board[5];
                    break;
                case 2:
                        line = "" + board[0] + board[3] + board[6];
                        break;
                case 3:
                    line = "" + board[6] + board[7] + board[8];
                    break;
                case 4:
                    line = "" + board[0] + board[4] + board[8];
                    break;
                case 5:
                    line = "" + board[2] + board[5] + board[8];
                    break;
                case 6:
                        line = "" + board[1] + board[4] + board[7];
                        break;
                case 7:
                    line = "" + board[2] + board[4] + board[6];
                    break;
            }

            // for X winner
            if (line.equals("XXX")) {
                return true;
            }

            // for O winner
            else if (line.equals("OOO")) {
                return true;
            }
        }
        return false; // no winner found
    }
}