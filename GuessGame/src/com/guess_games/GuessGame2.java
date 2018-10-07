package com.guess_games;

import java.util.Scanner;

public class GuessGame2 {


    private static Scanner myScanner = new Scanner(System.in);


    public static void main(String[] args) {

        int[] storeNumOfGuesses = {};


        int firstRun = runTheGame();
        System.out.println(firstRun);
        storeNumOfGuesses = store(storeNumOfGuesses, firstRun);
        while(wannaPlayAgain()) {
            int repeated = runTheGame();
            System.out.println(repeated);
            storeNumOfGuesses = store(storeNumOfGuesses, repeated);
        }

        System.out.println("Number of Guesses:\n");
        for (int element: storeNumOfGuesses) {
            System.out.println(element);
        }


    }

    private static int runTheGame() {
        GuessGame2 gg2 = new GuessGame2();
        int levelChosen = gg2.readInDiffLevel();
        int maxForDiffLevel = gg2.getMaxForDiffLevel(levelChosen);
        System.out.println(maxForDiffLevel);
        int randomNum = gg2.getRandomNum(maxForDiffLevel);
        return gg2.guessingGame(randomNum, maxForDiffLevel, 0);
    }


    private static boolean wannaPlayAgain() {
        System.out.println("Do you wanna play again? (true or false)");
        return myScanner.nextBoolean();
    }


    public static int[] store(int[] initial, int res) {
        int[] newStore = new int[initial.length + 1];

        for (int i = 0; i < initial.length; i++) {
            newStore[i] = initial[i];
        }
        newStore[newStore.length - 1] = res;
        return newStore;

    }



    public int validateDiffLevel(int choice) {
        if (choice >= 1 && choice <= 4) {
            return choice;
        } else {
            return -1;
        }
    }

    private int readInDiffLevel() {

        int choice = -1;
        boolean isFirstTime = true;

        do {
            if (isFirstTime) {
                System.out.println("Welcome to the Guessing Game, Enter your desired level of difficulty here. Say '1' for beginner , '2' for intermediate, '3' for advanced and '4' for expert.\n");
                isFirstTime = false;
            } else {
                System.out.println("Type a number between 1 and 4 this time:");
            }
            choice = this.validateDiffLevel(myScanner.nextInt());
            if (choice == -1) {
                System.out.println("Type a number between 1 and 4 this time:");
                choice = this.validateDiffLevel(myScanner.nextInt());
            } else {
                System.out.println("Good choice");
            }

        } while (choice == -1);

        return choice;
    }


    private int getMaxForDiffLevel(int levelDiff) {
        int max;
        switch (levelDiff) {
            case 1:
                max = 10;
                break;
            case 2:
                max = 100;
                break;
            case 3:
                max = 1000;
                break;
            case 4:
                max = 10000;
                break;
            default:
                max = 0;
        }
        return max;
    }

    public int getRandomNum(int max) {
        return (int) (Math.random() * max) + 1;
    }



    public int guessingGame(int randomNum, int maxRange, int prevAttempts) {
        int numOfGuesses = ++prevAttempts;

        System.out.println("Type in your guess:\n");
        int userGuess = myScanner.nextInt();
        // validate if in range
        if (ifInRange(maxRange, userGuess)) {
            // continue validating until matches the random number
            if (userGuess == randomNum) {
                System.out.println("Congrats, you got it!");
                return numOfGuesses;
            } else {
                this.belowOrAbove(randomNum, userGuess);
                return this.guessingGame(randomNum, maxRange, numOfGuesses);
            }
        } else {
            return this.guessingGame(randomNum, maxRange, numOfGuesses);
        }

    }

    public boolean ifInRange(int maxRange, int readInNumber) {
        if (readInNumber >= 1 && readInNumber <= maxRange) {
            return true;
        } else {
            System.out.println("Please choose a number from 1 - " + maxRange + " this time.");
            return false;

        }
    }

    public void belowOrAbove(int randomNum, int userGuess) {
        if (userGuess > randomNum) {
            System.out.println("Your number is ABOVE, Guess again...");
        } else {
            System.out.println("your number is BELOW, Guess again...");
        }
    }

}
