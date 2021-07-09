import java.util.ArrayList;
import java.util.Scanner;

public class Ship extends Player{
    private static int remainingCarrier;
    private static int remainingBattleship;
    private static int remainingCruiser;
    private static int remainingDestroyer;
    private static int remainingSubmarine;

    public static void addShip(String shipType){
        ArrayList<MapLocation> board = Player.getPlayerBoard();

        Scanner input = new Scanner(System.in);
        String direction = "h";
        int shipSize = switch (shipType) {
            case "cv" -> 5;
            case "bb" -> 4;
            case "cl" -> 3;
            case "dd" -> 2;
            case "ss" -> 1;
            default -> 0;
        };

        System.out.println("Please choose where to place your " + shipType + " starting spot from 1-10. (x then y) \nNOTE: It will place from the front of the ship to the right or down");
        Coordinate boatStart = new Coordinate();

        if (input.hasNextInt()) {
            boatStart.setY(input.nextInt());
        } else {
            System.out.println("Please input a valid coordinate value.");
        }

        if (input.hasNextInt()) {
            boatStart.setX(input.nextInt());
        } else {
            System.out.println("Please input a valid coordinate value.");
        }

        for(MapLocation k : board){
            if(k.getC().getX() == boatStart.getX() && k.getC().getY() == boatStart.getY()) k.setC(boatStart);
            boatStart = k.getC();
        }

        boolean validate = false;
        System.out.println("What direction do you want to place the " + shipType + "? horizontally (h) or vertically (v)?");
        while(!validate) {
            direction = input.next();
            if(direction.equals("h")){
                validate = true;
            } else {
                validate = direction.equals("v");
                if (!validate) System.out.println("Please type a valid input.");
            }
        }
   
        //Verify boat starting values are within the play area and set to closest edge if not.
        if(boatStart.getY() <= 0)
        {
            boatStart.setY(1);
            System.out.println("Boat position has been shifted slightly to ensure it does not go off the map.");
        }

        if(boatStart.getX() <= 0)
        {
            boatStart.setX(1);
            System.out.println("Boat position has been shifted slightly to ensure it does not go off the map.");
        }

        //Verify that boat right/bottom edge will not extend past the map and set to minimum distance to fit inside the map.
        if(boatStart.getY() >= 7 && direction.equals("h"))
        {
            boatStart.setY(11-shipSize);
            System.out.println("Boat position has been shifted slightly to ensure it does not go off the map.");
        }
        else if(boatStart.getX() >= 7 && direction.equals("v"))
        {
            boatStart.setX(11-shipSize);
            System.out.println("Boat position has been shifted slightly to ensure it does not go off the map.");
        }
        else {
            switch (shipType) {
                case "cv" -> Ship.setCarrier(boatStart, direction);
                case "bb" -> Ship.setBattleship(boatStart, direction);
                case "cl" -> Ship.setCruiser(boatStart, direction);
                case "dd" -> Ship.setDestroyer(boatStart, direction);
                case "ss" -> Ship.setSubmarine(boatStart, direction);
            }
        }
    }

    public static void setCarrier(Coordinate start, String direction) {

        if (direction.equals("v")) {
            for (int i = 0; i < 5; i++) {
                Coordinate boatPart = new Coordinate();
                MapLocation<Coordinate, String> shipAddedLocation = new MapLocation<>();
                boatPart.setX(start.getX() + i);
                boatPart.setY(start.getY());
                shipAddedLocation.setC(boatPart);
                shipAddedLocation.setItem("C");
            }
        } else {
            for (int i = 0; i < 5; i++) {
                Coordinate boatPart = new Coordinate();
                MapLocation<Coordinate, String> shipAddedLocation = new MapLocation<>();
                boatPart.setX(start.getX());
                boatPart.setY(start.getY() + i);
                shipAddedLocation.setC(boatPart);
                shipAddedLocation.setItem("C");
            }
        }
        setShipRemaining(5, "cv");

    }

    public static void setBattleship(Coordinate start, String direction) {
        if (direction.equals("v")) {
            for (int i = 0; i < 4; i++) {
                Coordinate boatPart = new Coordinate();
                MapLocation<Coordinate, String> shipAddedLocation = new MapLocation<>();
                boatPart.setX(start.getX() + i);
                boatPart.setY(start.getY());
                shipAddedLocation.setC(boatPart);
                shipAddedLocation.setItem("B");
            }
        } else {
            for (int i = 0; i < 4; i++) {
                Coordinate boatPart = new Coordinate();
                MapLocation<Coordinate, String> shipAddedLocation = new MapLocation<>();
                boatPart.setX(start.getX());
                boatPart.setY(start.getY() + i);
                shipAddedLocation.setC(boatPart);
                shipAddedLocation.setItem("B");
            }
        }
        setShipRemaining(4, "bb");
    }

    public static void setCruiser(Coordinate start, String direction) {
        if (direction.equals("v")) {
            for (int i = 0; i < 3; i++) {
                Coordinate boatPart = new Coordinate();
                MapLocation<Coordinate, String> shipAddedLocation = new MapLocation<>();
                boatPart.setX(start.getX() + i);
                boatPart.setY(start.getY());
                shipAddedLocation.setC(boatPart);
                shipAddedLocation.setItem("R");
            }
        } else {
            for (int i = 0; i < 3; i++) {
                Coordinate boatPart = new Coordinate();
                MapLocation<Coordinate, String> shipAddedLocation = new MapLocation<>();
                boatPart.setX(start.getX());
                boatPart.setY(start.getY() + i);
                shipAddedLocation.setC(boatPart);
                shipAddedLocation.setItem("R");
            }
        }
        setShipRemaining(3,"cl");
    }

    public static void setDestroyer(Coordinate start, String direction) {
        if (direction.equals("v")) {
            for (int i = 0; i < 2; i++) {
                Coordinate boatPart = new Coordinate();
                MapLocation<Coordinate, String> shipAddedLocation = new MapLocation<>();
                boatPart.setX(start.getX() + i);
                boatPart.setY(start.getY());
                shipAddedLocation.setC(boatPart);
                shipAddedLocation.setItem("D");
            }
        } else {
            for (int i = 0; i < 2; i++) {
                Coordinate boatPart = new Coordinate();
                MapLocation<Coordinate, String> shipAddedLocation = new MapLocation<>();
                boatPart.setX(start.getX());
                boatPart.setY(start.getY() + i);
                shipAddedLocation.setC(boatPart);
                shipAddedLocation.setItem("D");
            }
        }
        setShipRemaining(2, "dd");
    }

    public static void setSubmarine(Coordinate start, String direction) {
        if (direction.equals("v")) {
            for (int i = 0; i < 1; i++) {
                Coordinate boatPart = new Coordinate();
                MapLocation<Coordinate, String> shipAddedLocation = new MapLocation<>();
                boatPart.setX(start.getX() + i);
                boatPart.setY(start.getY());
                shipAddedLocation.setC(boatPart);
                shipAddedLocation.setItem("S");
            }
        } else {
            for (int i = 0; i < 1; i++) {
                Coordinate boatPart = new Coordinate();
                MapLocation<Coordinate, String> shipAddedLocation = new MapLocation<>();
                boatPart.setX(start.getX());
                boatPart.setY(start.getY() + i);
                shipAddedLocation.setC(boatPart);
                shipAddedLocation.setItem("S");
            }
        }
        setShipRemaining(1,"ss");
    }

    private static void setShipRemaining(int i, String type) {
        int shipChangeRemaining = switch (type) {
            case "cv" -> remainingCarrier -= i;
            case "bb" -> remainingBattleship -= i;
            case "cl" -> remainingCruiser -= i;
            case "dd" -> remainingDestroyer -= i;
            case "ss" -> remainingSubmarine -= i;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }
}
