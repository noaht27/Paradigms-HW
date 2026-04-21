// Noah Thompson
// 21 April 2026
// Main.java

package Tictactoe;

public class Main{
    public static void main(String[] args){
        // used game board file and player file to play actual game!
        System.out.println("Welcome to the Tic-Tac-Toe Game!\n");
        GameBoard.printBoard(); // initial empty board
        Player.game();
    }

}