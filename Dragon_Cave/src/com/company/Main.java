package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        String intro = "\n\nYou are in a land full of dragons." +
                "\nYou are on a mission to find treasure which lies in the caves that the dragons sleep in." +
                "\nYou approach the nearby cave; it is dark and spooky...";

        String firstIntersection = "As you enter the cave, you come across an intersection with three choices: left, middle and right." +
                "\n\n" +
                "Choose 1 for left, 2 for middle, or 3 for right.";

        String secondIntersection = "The new intersection only has two routes. Both reek of dragon breath, but which will lead to doom?" +
                "\nChoose 1 for left or 2 for right.";

        String proceed = "You walk forward through the dark and come across an intersection";

        String death = "\nYou enter the hall and the room opens up. A pair of eyes stares you down and you see a sudden flame erupt."+
                "\n\nYou have died a crispy death.";

        String success = "\nYou enter the hall and the room opens up. A large pile of riches is in front of you." +
                "\nYou quickly fill your bags as quiet as able and manager to backtrace your steps." +
                "\nA successful excursion!.";

        System.out.println(intro);
        Scanner scan = new Scanner(System.in);
        System.out.println(firstIntersection);
        int a = scan.nextInt();
        CaveOptions intersection = new CaveOptions(a);
        while (intersection.choiceMade(a) != 3){
            intersection = new CaveOptions(a);
            a = scan.nextInt();
        }
        if(intersection.choiceMade(a) == 3){
            System.out.println("You enter the route to the right...");
            System.out.println(proceed);
        }
        System.out.println(secondIntersection);
        int b = scan.nextInt()*10;
        CaveOptions intersection2 = new CaveOptions(b);
        if(intersection2.choiceMade(b) == 10){
            System.out.println(death);
        } else{
            System.out.println(success);
        }
        scan.close();
    }
}
