package com.kodilla.rps;

import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Game: Rock Paper Scissors
 * @author Radoslaw Sawicki
 * @version 0.0.1
 */

public class RpsRunner {

    private static Logger logger = Logger.getLogger(RpsRunner.class.getName());

    //Declare variables
    private static int userChoice, computerChoice, rock, paper, scissors;
    private static int numberRoundsWon, counterUser, counterComputer;
    private static boolean end;
    private static Character gameOver, newGame;
    private static Scanner input, inputName, inputRoundsWon;
    private static Random rnd;
    private static String userName, nameWinner, userEndOrNew;

    public static void main(String[] args){

        //Create input object for the user
        input = new Scanner (System.in);

        //Create input object for the name of user
        inputName = new Scanner (System.in);

        //Create input object for the number of rounds won
        inputRoundsWon = new Scanner (System.in);

        //Create random input for the computer
        rnd = new Random();

        //Assigning values to the following variables
        rock = 1;
        paper = 2;
        scissors = 3;
        gameOver = 'X';
        newGame = 'N';
        end = false;
        numberRoundsWon = 0;
        counterUser = 0;
        counterComputer = 0;

        //Game introduction
        displayIntroduction();
        gameRunning();

    }

    public static void gameRunning(){
        //Proper game
        while(!end) {
            displayGame();
            userGameSelections();
            computerGameSelections();
            drawGameSelections();
            resultGame();
        }
    }

    public static void displayIntroduction(){
        //Display the game name
        System.out.println("\n>>>ROCK PAPER SCISSORS GAME<<<\n");
        System.out.println("What's your name?: ");
        userName = inputName.next();

        //Display the number of rounds won
        System.out.println("What's the number of rounds won?: ");
        numberRoundsWon = inputRoundsWon.nextInt();
        System.out.println("Game over after " + numberRoundsWon + " winning rounds!");

        //Game menu
        System.out.println("\nStart of the game!" +
                "\nYou have a choice: " +
                "\n1 = Rock \n2 = Paper \n3 = Scissors \nX = Game over \nN = New game");

    }

    public static void displayGame(){
        //Next round
        System.out.println("\n" + userName + " you have a choice: " +
                "\n1 = Rock \n2 = Paper \n3 = Scissors\n" +
                "Enter your choice:");

        //User input
        userChoice = input.nextInt();
        //If user chooses above 3
        while (userChoice > 3) {
            System.out.println("Give number between 1 and 3");
            userChoice = input.nextInt();
        }
    }

    public static void userGameSelections(){
        //User selections
        if (userChoice == rock) {
            System.out.println("\n" + userName + " chose ROCK");
        }
        else {
            if(userChoice== paper) {
                System.out.println("\n" + userName + " chose PAPER");
            }
            else {
                System.out.println("\n" + userName + " chose SCISSORS");
            }
        }
    }

    public static void computerGameSelections(){
        //Computer input (random)
        computerChoice = rnd.nextInt(1,4);
        logger.info("Variable 'computerChoice' is: " + computerChoice);

        //Computer selection
        if(computerChoice == rock) {
            System.out.println("Computer chose ROCK");
        }
        else
        {
            if(computerChoice == paper) {
                System.out.println("Computer chose PAPER");
            }
            else {
                System.out.println("Computer chose SCISSORS");
            }
        }
    }

    public static void drawGameSelections(){
        //Draw
        while (userChoice == computerChoice) {
            System.out.println("Please try again:");

            //If user chooses above 3
            userChoice = input.nextInt();
            while (userChoice > 3) {
                System.out.println("Give number between 1 and 3");
                userChoice = input.nextInt();
            }
            computerChoice = rnd.nextInt(1, 4);
            logger.info("Variable 'computerChoice' is: " + computerChoice);
            //DRAW user selections
            if (userChoice == rock) {
                System.out.println("\n" + userName + " chose ROCK");
            }
            else {
                if(userChoice== paper) {
                    System.out.println("\n" + userName + " chose PAPER");
                }
                else {
                    System.out.println("\n" + userName + " chose SCISSORS");
                }
            }

            //DRAW computer selection
            if(computerChoice == rock) {
                System.out.println("Computer chose ROCK");
            }
            else {
                if(computerChoice == paper) {
                    System.out.println("Computer chose PAPER");
                }
                else {
                    System.out.println("Computer chose SCISSORS");
                }
            }
        }

    }

    public static void resultGame(){
        //Results section
        if (computerChoice==rock) {
            if (userChoice==paper) {
                if(userChoice != computerChoice)
                counterUser++;
                nameWinner = userName;
                System.out.println(userName + " wins: " + counterUser + "!");
                if(counterUser == numberRoundsWon) {
                    endOrNewGame(nameWinner);
                    end = true;
                }
            }
            else {
                if(userChoice != computerChoice)
                counterComputer++;
                nameWinner = "Computer";
                System.out.println("Computer wins: " + counterComputer + "!");
                if(counterComputer == numberRoundsWon) {
                    endOrNewGame(nameWinner);
                    end = true;
                }
            }
        }
        else if (computerChoice==paper) {
            if (userChoice==rock) {
                counterComputer++;
                nameWinner = "Computer";
                System.out.println("Computer wins: " + counterComputer + "!");
                if(counterComputer == numberRoundsWon) {
                    endOrNewGame(nameWinner);
                    end = true;
                }
            }
            else {
                if(userChoice != computerChoice)
                counterUser++;
                nameWinner = userName;
                System.out.println(userName + " wins: " + counterUser + "!");
                if(counterUser == numberRoundsWon) {
                    endOrNewGame(nameWinner);
                    end = true;
                }
            }
        }
        else if (userChoice==rock) {
            counterUser++;
            System.out.println(userName + " wins: " + counterUser + "!");
            nameWinner = userName;
            if(counterUser == numberRoundsWon) {
                endOrNewGame(nameWinner);
                end = true;
            }
        }
        else {
            if(userChoice != computerChoice)
            counterComputer++;
            System.out.println("Computer wins: " + counterComputer + "!");
            nameWinner = "Computer";
            if(counterComputer == numberRoundsWon) {
                endOrNewGame(nameWinner);
                end = true;
            }
        }
    }

    public static void endOrNewGame(String nameWinner){

        System.out.println("\n" + nameWinner + " wins the game!!! ");
        System.out.println("\nYou have a choice:" +
                "\nX = Game over \nN = New game" +
                "\nEnter your choice:");
        endOrNewChoice();
    }

    public static void endOrNewChoice(){
        userEndOrNew = input.next();
        logger.info("UserEndOrNewInt is: " + userEndOrNew);

        if(userEndOrNew.equals("X") || userEndOrNew.equals("x")){
            System.out.println("\nGAME OVER!");
        }
        else{
            counterUser = 0;
            counterComputer = 0;
            gameRunning();
        }
    }
}
