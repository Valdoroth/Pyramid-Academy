package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String redo = "y"; //set to play yes as default
        String name; // set name to none

        Scanner attempt = new Scanner(System.in); //setup scanner

            System.out.println("Welcome to Guess the Number! What's your name?");
            name = attempt.next(); //take inputted name
        while(redo.equals("y")) { //if player wants to play, runs the game.
            System.out.println("Do you want to play in easy (1), medium (2), hard(3) or hardest(4)? Choose 1, 2, 3, or 4. (Anything else gives 20 with 5 tries)");
            int limit = attempt.nextInt();
            int attemptCount = 4; //initializes attempts to 0

            switch(limit){
                case 1:
                    limit = 10;
                    attemptCount = 3;
                    break;
                case 2:
                    limit = 25;
                    break;
                case 3:
                    limit = 50;
                    attemptCount = 6;
                    break;
                case 4:
                    limit = 100;
                    attemptCount = 7;
                    break;
                default:
                    limit = 20;
                    break;
            }

            int gen = new Random().nextInt(limit); // generate an int between 0 and 20
            System.out.println("I have thought of a number between 0 and "+ limit + ". Try to guess what it is. You have "+ (attemptCount+1) +" tries.");
            int guess = attempt.nextInt(); //takes in guesses
            int attempted = 0;

            while (attemptCount > 0) { //loop for each guess attempt
                if (guess == gen) { //if guess correct, win!
                    System.out.println("Congratulations " + name + "! You got the correct answer in " + (attempted) + " tries.");
                    break;
                } else if (guess > gen) { //if guess wrong but too high, try again
                    System.out.println("Too high! Please try again. \n You have " + (attemptCount+1) + " remaining attempts");
                    guess = attempt.nextInt(); //reads in the next guess if applicable
                } else if (guess < gen) {//if guess wrong but too low, try again
                    System.out.println("Too low! Please try again. \n You have " + (attemptCount+1) + " remaining attempts");
                    guess = attempt.nextInt(); //reads in the next guess if applicable
                }
                --attemptCount; // decrement the guess attempts remaining.
                ++attempted; // increment attempt tries.
        }
            if (attemptCount == 0){
                System.out.println("Sorry " + name + ". The answer was " + gen + ".");
            }

            System.out.println("Do you want to play again? (y or n)");
            redo = attempt.next(); //read in to play again or not.
    }
        System.out.println("Thanks for playing " + name +  "!");
        attempt.close();
    }
}
