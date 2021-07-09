package com.company;

public class CaveOptions {

    public CaveOptions(int a) {
    }

    public int choiceMade(int a){
        int result = 1;

        switch (a){
            case 1: System.out.println("You enter the route to the left and it loops back to the same intersection from the middle");
                result = 1;
                break;
            case 2: System.out.println("You enter the route in the middle and it loops back to the same intersection from the left");
                result = 2;
                break;
            case 3:
                result = 3;
                break;
            case 10: System.out.println("You enter the route to the left...");
                result = 10;
                break;
            case 20:
                System.out.println("You enter the route to the right...");
                result = 20;
                break;
            default:
                System.out.println("You cannot chicken out now!");
        }

        return result;
    }
}
