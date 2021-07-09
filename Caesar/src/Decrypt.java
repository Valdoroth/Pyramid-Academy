package com.company;

import java.util.ArrayList;
import java.util.List;

public class Decrypt {
    private static int keyCode;
    private static char[] codeBase = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz .!?%{}[]()*&^$@~`".toCharArray();;

    public static void setKeyCode(int key) {
        keyCode = key;
    }

    public static String encryptMessage(String message){
        List<Character> letterList = new ArrayList<>();
        StringBuilder messageEnC = new StringBuilder();
        char[] code = new char[70];
        int slide;

        // This sets the shifting of letters based on the formula for simple Caesar ciphers.
        if(1-keyCode <= 0) slide = (1-keyCode+71)%70 ;
        else slide = (1-keyCode)%70;

        // This creates the array of letters shifted.
        for(int i = 0; i < 70; i++) {
            if(i - slide < 0) code[i] = codeBase[i-slide+70];
            else if(i - slide > 70) code[i] = codeBase[i+slide-(1+keyCode)];
            else code[i] = codeBase[i-slide-(1-keyCode)];
        }

        for(char i: codeBase) letterList.add(i);

        // This decrypts the message and returns that string value of.
        ArrayList<Character> tempList = new ArrayList<>();
        for(char k : message.toCharArray()) tempList.add(k);
        for(int j = 0; j < tempList.size(); j++){
            messageEnC.append(code[letterList.indexOf(tempList.get(j))]);
        }
        System.out.println(messageEnC);
        return String.valueOf(messageEnC);
    }
}
