package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Welcome to Hangman. You have 3 attempts to guess the right word.");
        String play = "y";

        while(play.equals("y")) {

            int missedLettersCount = 0;
            String missedLettersActual = "";
            String guessedLetter;

            NooseProgress hung = new NooseProgress(missedLettersCount, missedLettersActual);
            System.out.println(hung.nooseDisplay(missedLettersCount, missedLettersActual));

            WordForGuess wordToGuess = new WordForGuess();

            List<String> word1 = new ArrayList<>(Arrays.asList((wordToGuess.wordforguess().split(""))));
            List<String> blanks = new ArrayList<>();

            for (int i = 0; i < word1.size(); i++) {
                blanks.add("_ ");
            }

            System.out.println("");

            for (String b : blanks) {
                System.out.print(b);
            }
            Scanner scan = new Scanner(System.in);

            while (missedLettersCount < 6) {
                System.out.println("\nWhat is your guess?");
                guessedLetter = scan.next();

                /*if (guessedLetter.matches("[a-zA-Z_]+")) {
                    System.out.println("Invalid input type. Please use letters only.");
                    break;
                } else */ if(word1.equals(blanks)){
                    System.out.println("Congratulations you guessed it correctly!");
                    break;
                } else if (word1.contains(guessedLetter.toLowerCase(Locale.ROOT))) {
                    for (int i = 0; i < blanks.size(); i++) {
                        if (word1.get(i).equals(guessedLetter)) {
                            blanks.set(i, guessedLetter);
                        }
                    }
                    for (String b : blanks) {
                        System.out.print(b);
                    }
                    if(word1.equals(blanks)){
                        System.out.println("\nCongratulations you guessed it correctly!");
                        break;
                    }
                } else if (!word1.contains(guessedLetter.toLowerCase(Locale.ROOT))) {
                    missedLettersCount += 1;
                    missedLettersActual += guessedLetter + " ";
                    System.out.println(hung.nooseDisplay(missedLettersCount, missedLettersActual));
                    for (String b : blanks) {
                        System.out.print(b);
                    }
                }
            }
            if(missedLettersCount == 6) {
                System.out.print("\nThe word was ");
                for (String s : word1) {
                    System.out.print(s);
                }
                System.out.println("\nBetter luck next time.\n");
            }
            System.out.println("\nDo you want to play again? (y or n)");
            play = scan.next();
        }
    }
}
