package com.kodilla.testing.tictactoe;

import java.util.Random;
import java.util.Scanner;

/**
 * Game Tic Tac Toe. Enjoy!
 * @author Radoslaw Sawicki
 * @version 0.0.1
 */

public class TicTacToe {

    public static void main(String[] args){

        System.out.println("\nEnter the size of the game board [3-10]: ");
        int dim = new Scanner(System.in).nextInt();
        while(dim < 3 || dim > 10){
            System.out.println("Choice invalid, please try again!" +
                    "\nEnter the size of the game board [3-10]: ");
            dim = new Scanner(System.in).nextInt();
        }
        char[][] board = new char[dim][dim];

        int dimMinusOne = dim - 1;
        System.out.println("The size of the game board is: " + dim + " x " + dim + "!\n" +
                "The size of the game board is from 0 to " + dimMinusOne + " rows and columns!" +
                "\n\nDrawing the first player!");
        //Drawing the first player
        char activePlayer = TicTacToe.firstPlayerDraw();
        System.out.println("The game begins with player: '" + activePlayer + "'!");

        int movesCounter = 0;
        char winner = 0;
        boolean won = false;

        while(movesCounter < dim * dim && !won ){
            System.out.println("\nPlayer '" + activePlayer + "' look at the board:");
            printBoard(board);//Prints a board

            boolean moveWasCorrect = performPlayerMove(board, activePlayer);
            if(moveWasCorrect){
                //Counter movies
                movesCounter++;
                //Checking if player won
                won = checkWinner(board, activePlayer);
                winner = activePlayer;
                //Changing of player
                activePlayer = activePlayer == 'X' ? 'O' : 'X';
            }else {
                System.out.println("Move invalid, please try again!");
            }
        }

        printBoard(board);
        //Displaying of the winning player
        System.out.println("\nEnd Game! Player '" + winner + "' won!");

    }

    private static char firstPlayerDraw() {
        Random random = new Random();
        Character[] playerNames = {'X', 'O', 'X', 'O', 'X', 'O', 'X', 'O'};
        char playerName = 0;
        for(int i = 0; i < playerNames.length; i++) {
            int indexPlayers = random.nextInt(playerNames.length);
            playerName = playerNames[indexPlayers];
        }
        return playerName;
    }

    private static boolean checkOneDiagonal(char[][] board, char activePlayer){
        //Retrieving the length of the board
        int dim = board.length;
        for(int i = 0; i < dim; i++){
            if(board[i][i] != activePlayer){
                return false;
            }
        }
        return true;
    }

    private static boolean checkTwoDiagonal(char[][] board, char activePlayer){
        int dim = board.length;
        for(int i = 0; i < dim; i++){
            if(board[i][dim - i - 1] != activePlayer){
                return false;
            }
        }
        return true;
    }

    private static boolean checkWinInRows(char[][] board, char activePlayer){
        int dim = board.length;
        //Checking rows from 0 to dim
        for(int row = 0; row < dim; row++){
            //Founding: activePlayer won!
            boolean win = true;
            //Checking columns
            for(int col = 0; col < dim; col++){
                //No activePlayer when win = false
                if (board[row][col] != activePlayer){
                    win = false;
                    //Leaving loop!
                    break;
                }
            }
            //activePlayer won!
            if(win){
                return true;
            }
        }
        return false;
    }

    private static boolean checkWinInColumns(char[][] board, char activePlayer){
        int dim = board.length;
        //Checking column from 0 to dim
        for(int col = 0; col < dim; col++){
            //Founding: activePlayer won!
            boolean win = true;
            //Checking rows
            for(int row = 0; row < dim; row++){
                //No activePlayer when win = false
                if (board[row][col] != activePlayer){
                    win = false;
                    //Leaving loop!
                    break;
                }
            }
            //activePlayer won!
            if(win){
                return true;
            }
        }
        return false;
    }

    private static boolean checkWinner(char[][] board, char activePlayer){
        return checkOneDiagonal(board, activePlayer) || checkTwoDiagonal(board, activePlayer) ||
                checkWinInColumns(board, activePlayer) || checkWinInRows(board, activePlayer);
    }

    private static boolean performPlayerMove(char[][] board, char activePlayer){
        int dim = board.length;
        System.out.println("\nPlayer '" + activePlayer + "', enter a row number: ");
        int row = new Scanner(System.in).nextInt();
        while(row < 0 || row >= dim){
            System.out.println("Player '" + activePlayer + "', enter a row number: ");
            row = new Scanner(System.in).nextInt();
        }

        System.out.println("Player '" + activePlayer + "', enter a column number: ");
        int col = new Scanner(System.in).nextInt();
        while(col < 0 || col >= dim){
            System.out.println("Player '" + activePlayer + "', enter a column number: ");
            row = new Scanner(System.in).nextInt();
        }
        if(board[row][col] == 0){//If a field is free
            board[row][col] = activePlayer;
            //Move correct
            return true;
        }else {
            //Move incorrect, the field is not free
            return false;
        }
    }

    private static void printBoard(char[][] board){
        int dim = board.length;
        //Columns headers
        System.out.print("\t");
        for(int i = 0; i < dim; i++){
            System.out.print(i + ".\t");
        }
        System.out.println();
        for(int row = 0; row < dim; row++){
            System.out.print(row + ".\t");
            for(int column = 0; column < dim; column++){
                System.out.print(board[row][column] + "\t");
            }
            System.out.println();
        }
    }
}