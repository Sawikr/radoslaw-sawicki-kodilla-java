package com.kodilla.rps;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Game: Rock Paper Scissors
 * @author Radoslaw Sawicki
 * @version 0.0.2
 */

public class RpsRunner {

    private static Logger logger = Logger.getLogger(RpsRunner.class.getName());

    //Declare variables
    private static String userChoice;
    private static String computerChoice;
    private static String rock;
    private static String paper;
    private static String scissors;
    private static String gameOver;
    private static String newGame;
    private static String userName;
    private static String nameWinner;
    private static int numberRoundsWon;
    private static int counterUser;
    private static int counterComputer;
    private static boolean end;
    private static Random rnd;
    private static Scanner input;
    private static Scanner inputName;
    private static Scanner inputRoundsWon;


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
        rock = "1";
        paper = "2";
        scissors = "3";
        gameOver = "X";
        newGame = "N";
        end = false;
        numberRoundsWon = 0;
        counterUser = 0;
        counterComputer = 0;

        //Game
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
        System.out.println("\n>----------------------------<");
        System.out.println(">>>ROCK PAPER SCISSORS GAME<<<");
        System.out.println(">----------------------------<");
        System.out.println("What's your name?: ");
        userName = inputName.next();

        //Display the number of rounds won
        System.out.println("What's the number of rounds won?: ");
        numberRoundsWon = inputRoundsWon.nextInt();
        System.out.println("Game over after " + numberRoundsWon + " winning rounds!");

        //Introduction menu
        System.out.println("Start of the game!");
    }

    public static void displayGame() {
        //Game menu and next round
        System.out.println("\n" + userName + ", you have a choice: " +
                "\n1 = Rock \n2 = Paper \n3 = Scissors \nX = Game over \nN = New game\n" +
                "Enter your choice:");

        //User input
        userChoice = input.next();
        //Wrong choice
        while (!Objects.equals(userChoice, rock) && !Objects.equals(userChoice, paper) && !Objects.equals(userChoice, scissors)) {
            System.out.println("Give number between 1 and 3:");
            userChoice = input.next();
        }
        //logger.info("Variable 'userChoice' is: " + userChoice);
        choiceEndOrNewGame();
    }

    public static void userGameSelections(){
        //User selections
        if (Objects.equals(userChoice, rock)) {
            System.out.println("\n" + userName + " chose ROCK");
        }
        else {
            if (Objects.equals(userChoice, paper)) {
                System.out.println("\n" + userName + " chose PAPER");
            }
            else {
                System.out.println("\n" + userName + " chose SCISSORS");
            }
        }
    }

    public static void computerGameSelections(){
        //Computer input (random)
        String[] randomString = {"1","2","3","1","2","3"};
        computerChoice = randomString[rnd.nextInt(randomString.length)];
        //logger.info("Variable 'computerChoice' is: " + computerChoice);

        //Computer selection
        if (Objects.equals(computerChoice, rock)) {
            System.out.println("Computer chose ROCK");
        }
        else
        {
            if (Objects.equals(computerChoice, paper)) {
                System.out.println("Computer chose PAPER");
            }
            else {
                System.out.println("Computer chose SCISSORS");
            }
        }
    }

    public static void drawGameSelections(){
        //Draw
        while (Objects.equals(userChoice, computerChoice)) {
            System.out.println("Please try again:");

            //Wrong choice
            userChoice = input.next();
            while (!Objects.equals(userChoice, rock) && !Objects.equals(userChoice, paper) && !Objects.equals(userChoice, scissors)) {
                System.out.println("Give number between 1 and 3:");
                userChoice = input.next();
            }
            String[] randomString = {"1","2","3","1","2","3"};
            computerChoice = randomString[rnd.nextInt(randomString.length)];
            //logger.info("Variable 'computerChoice' is: " + computerChoice);

            //DRAW user selections
            if (Objects.equals(userChoice, rock)) {
                System.out.println("\n" + userName + " chose ROCK");
            }
            else {
                if (Objects.equals(userChoice, paper)) {
                    System.out.println("\n" + userName + " chose PAPER");
                }
                else {
                    System.out.println("\n" + userName + " chose SCISSORS");
                }
            }

            //DRAW computer selection
            if (Objects.equals(computerChoice, rock)) {
                System.out.println("Computer chose ROCK");
            }
            else {
                if (Objects.equals(computerChoice, paper)) {
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
        if (Objects.equals(computerChoice, rock)) {
            if (Objects.equals(userChoice, paper)) {
                if (!Objects.equals(userChoice, computerChoice))
                counterUser++;
                nameWinner = userName;
                System.out.println(userName + " wins: " + counterUser + "!");
                System.out.println("Computer wins: " + counterComputer + "!");
                if (counterUser == numberRoundsWon) {
                    endOrNewGame(nameWinner);
                    end = true;
                }
            }
            else {
                if (!Objects.equals(userChoice, computerChoice))
                counterComputer++;
                nameWinner = "Computer";
                System.out.println("Computer wins: " + counterComputer + "!");
                System.out.println(userName + " wins: " + counterUser + "!");
                if (counterComputer == numberRoundsWon) {
                    endOrNewGame(nameWinner);
                    end = true;
                }
            }
        }
        else if (Objects.equals(computerChoice, paper)) {
            if (Objects.equals(userChoice, rock)) {
                counterComputer++;
                nameWinner = "Computer";
                System.out.println("Computer wins: " + counterComputer + "!");
                System.out.println(userName + " wins: " + counterUser + "!");
                if (counterComputer == numberRoundsWon) {
                    endOrNewGame(nameWinner);
                    end = true;
                }
            }
            else {
                if (!Objects.equals(userChoice, computerChoice))
                counterUser++;
                nameWinner = userName;
                System.out.println(userName + " wins: " + counterUser + "!");
                System.out.println("Computer wins: " + counterComputer + "!");
                if (counterUser == numberRoundsWon) {
                    endOrNewGame(nameWinner);
                    end = true;
                }
            }
        }
        else if (Objects.equals(userChoice, rock)) {
            counterUser++;
            System.out.println(userName + " wins: " + counterUser + "!");
            System.out.println("Computer wins: " + counterComputer + "!");
            nameWinner = userName;
            if (counterUser == numberRoundsWon) {
                endOrNewGame(nameWinner);
                end = true;
            }
        }
        else {
            if (!Objects.equals(userChoice, computerChoice))
            counterComputer++;
            System.out.println("Computer wins: " + counterComputer + "!");
            System.out.println(userName + " wins: " + counterUser + "!");
            nameWinner = "Computer";
            if (counterComputer == numberRoundsWon) {
                endOrNewGame(nameWinner);
                end = true;
            }
        }
    }

    public static void endOrNewGame(String nameWinner){
        System.out.println("\n" + nameWinner + " wins the game!!! ");
        System.out.println("\n" + userName + ", you have a choice:" +
                "\nX = Game over \nN = New game" +
                "\nEnter your choice:");
        userChoice = input.next();
        choiceEndOrNewGameWinner();
    }

    private static void choiceEndOrNewGame() {
        if (userChoice.equals("X") || userChoice.equals("x")) {
            System.out.println("Are you sure you want to end the game?\nEnter T (yes) or N (nie):");
            String yes = "t";
            String yesT = "T";
            userChoice = input.next();
            if (Objects.equals(userChoice, yes) || Objects.equals(userChoice, yesT)){
                System.out.println("\nGAME OVER!");
                System.exit(0);
            }
            else
                displayGame();
        }
        else if (userChoice.equals("N") || userChoice.equals("n")){
            System.out.println("Are you sure you want to end the current game?\nEnter T (yes) or N (nie):");
            String yes = "t";
            String yesT = "T";
            userChoice = input.next();
            if (Objects.equals(userChoice, yes) || Objects.equals(userChoice, yesT)){
                counterUser = 0;
                counterComputer = 0;
                end = false;
                displayIntroduction();
                gameRunning();
            }
        }
    }

    private static void choiceEndOrNewGameWinner() {
        if (userChoice.equals("X") || userChoice.equals("x")) {
            System.out.println("Are you sure you want to end the game?\nEnter T (yes) or N (nie):");
            String yes = "t";
            String yesT = "T";
            userChoice = input.next();
            if (Objects.equals(userChoice, yes) || Objects.equals(userChoice, yesT)) {
                System.out.println("\nGAME OVER!");
                System.exit(0);
            } else
                endOrNewGame(nameWinner);
        } else if (userChoice.equals("N") || userChoice.equals("n")) {
            System.out.println("Are you sure you want to end the current game?\nEnter T (yes) or N (nie):");
            String yes = "t";
            String yesT = "T";
            userChoice = input.next();
            if (Objects.equals(userChoice, yes) || Objects.equals(userChoice, yesT)) {
                counterUser = 0;
                counterComputer = 0;
                end = false;
                displayIntroduction();
                gameRunning();
            } else
                endOrNewGame(nameWinner);
        }
    }
}