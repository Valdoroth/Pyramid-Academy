import java.util.ArrayList;
import java.util.Scanner;

public class Player {
    private static ArrayList<MapLocation> playerBoard;
    public ArrayList<MapLocation> playerShots;

    public Player(){
        playerBoard = Grid.createGrid();
        playerShots = Grid.createGrid();
    }

    public void printGrid(){
        ArrayList<MapLocation> map = playerBoard;
        StringBuilder grid = new StringBuilder();

        for(int i = 0; i< 121; i++){
            if(i%11==0){
                grid.append("\n");
            }
            grid.append(" ").append(map.get(i).getItem()).append(" ");
        }

        System.out.print(grid + "\n");
    }

/*
    public boolean checkLocation(MapLocation spot){
        ArrayList<MapLocation> currentMap = playerBoard;
        ArrayList<MapLocation> classOfShip = switch (spot.getItem()) {
            case "C" -> Ship.getPosition();
            case "B" -> Ship.getPosition();
            case "R" -> Ship.getPosition();
            case "D" -> Ship.getPosition();
            case "S" -> Ship.getPosition();
            default -> new ArrayList<>();
        };

        boolean isGood = false;
        int x;
        int y;
        String tempC;
        for(MapLocation j: classOfShip) {
            x = j.getC().getX();
            y = j.getC().getY();
            for (MapLocation i : currentMap) {
                int tempX = i.getC().getX();
                int tempY = i.getC().getY();
                if (tempX == x && tempY == y) {
                    tempC = i.getItem();
                    if (tempC.equals("C") || tempC.equals("B") || tempC.equals("D") || tempC.equals("R") || tempC.equals("S") && x < 10 && y < 10) {
                        isGood = false;
                        giveFeedback(tempC);
                        break;
                    } else {
                        isGood = true;
                    }
                    break;
                }
            }
            if(!isGood) break;
        }
        return !isGood;
    }

                         */

    public static ArrayList<MapLocation> getPlayerBoard(){
        return playerBoard;
    }
    public boolean checkShotLocation(int xIn, int yIn, ArrayList<MapLocation> otherBoard){

        boolean hit = false;
        int x = xIn;
        int y = yIn;
        String tempC;
            for (MapLocation i : otherBoard) {
                int tempX = i.getC().getX();
                int tempY = i.getC().getY();
                if (tempX == x && tempY == y) {
                    tempC = i.getItem();
                    if(!Coordinate.locationCheck(i))
                    {
                        hit = true;
                        giveFeedback(tempC);
                        i.setItem("X");
                    } else {
                        hit = false;
                        i.setItem("O");
                        playerShots.set(playerShots.indexOf(i),i);
                    }
                    break;
                }
                break;
            }
        return hit;
    }

    private void giveFeedback(String tempC) {
        String shotStatus = "miss";
        String shipClass = switch (tempC){
            case "C" -> "a carrier ";
            case "B" -> "a battleship ";
            case "R" -> "a cruiser ";
            case "D" -> "a destroyer ";
            case "S" -> "a submarine ";
            default -> "nothing ";
        };
        if(!tempC.equals("X") || !tempC.equals("0")) {
            System.out.println("There is " + shipClass + "here.");
        }
        else {
            if( tempC.equals("X")) shotStatus = ("*hit a " + shipClass);
            System.out.println("You " + shotStatus + ".");
        }
    }

    public void guessShot(ArrayList<MapLocation> otherBoard) {
        System.out.println("Take a shot at the enemy. You get two shots per turn. \n What is your first shot?");
        MapLocation<Coordinate,String> spotHere = new MapLocation<>();

        Scanner guess = new Scanner(System.in);
        int y = guess.nextInt();
        int x = guess.nextInt();
        int tempX;
        int tempY;

        for (MapLocation i : otherBoard) {
            tempX = i.getC().getX();
            tempY = i.getC().getY();
            if (tempX == x && tempY == y) spotHere = i;
        }
        if(!checkShotLocation(spotHere.getC().getX(), spotHere.getC().getY(), otherBoard)){
            spotHere.setItem("X");
            //playerShots
        }

    }
}
