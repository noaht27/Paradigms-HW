// Noah Thompson
// 21 April 2026
// Player.java

package Tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random; // for random numbers
import java.util.Scanner; // for user input

public class Player{
    // actual game implementation
    public static void game(){
        // tracking game status
        boolean game = true;
        Random rand_num = new Random(); // creating random num object
        Scanner myObj = new Scanner(System.in); // creating scanner object

        // all available positions
        List<Integer> available = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        while (game == true){
            System.out.println("Player: Enter the position you want");
            int position = myObj.nextInt(); // reading user input
            
            while (!available.contains(position)){
                System.out.println("Position already taken! Try another: ");
                position = myObj.nextInt(); // reading user input
            }
            GameBoard.board[position-1] = 'X';

            // I had to look this up on how to remove by object
            available.remove(Integer.valueOf(position));

            GameBoard.printBoard(); // updated

            if (GameBoard.checkWinner() == true){
                System.out.println("Player 1 wins!");
                game = false;
                break;
            }

            // when no more positions are available, the game is a draw
            if (available.isEmpty()){
                System.out.println("Draw!");
                game = false;
                break;
            }

            int cpu = rand_num.nextInt(10); // random position for cpu
            while (!available.contains(cpu)){
                cpu = rand_num.nextInt(10);
            }
            GameBoard.board[cpu-1] = 'O';

            // I had to look this up on how to remove by object
            available.remove(Integer.valueOf(cpu));
            System.out.println("CPU Selects: " + cpu);

            GameBoard.printBoard(); // updated

            if (GameBoard.checkWinner() == true){
                System.out.println("Computer wins!");
                game = false;
                break;
            }
        }
    }
}