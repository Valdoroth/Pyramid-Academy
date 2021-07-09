package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        int key = 1;
        Scanner input = new Scanner(System.in);
        String choice = "n";
        System.out.println("Please choose if you are encrypting or decrypting (e or d).");

            try {
                choice = input.next();
            } catch (Exception e) {
                System.out.println("You didn't enter a correct input. Exiting.");
            }
        System.out.println("Please enter the key-shift you want for the message.");
        while(key != 0) {
            try {
                key = input.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("You didn't enter a correct value input.");
                key = 0;
            }
        }

        if(choice.equals("e")) {
            Encrypt.setKeyCode(key);
            try {
                List<String> message = Files.readAllLines(FileAccess.getMessageDecryptedLocation());
                FileWriter fileE = new FileWriter(String.valueOf(FileAccess.getMessageEncryptedLocation()),true);
                for (String i : message)
                    fileE.write(String.valueOf(Collections.singleton(Encrypt.encryptMessage(i))));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        if(choice.equals("d")) {
            Decrypt.setKeyCode(key);
            try {
                List<String> message = Files.readAllLines(FileAccess.getMessageEncryptedLocation());
                FileWriter fileD = new FileWriter(String.valueOf(FileAccess.getMessageDecryptedLocation()),true);
                for (String i : message)
                    fileD.write(String.valueOf(Collections.singleton(Decrypt.encryptMessage(i))));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
