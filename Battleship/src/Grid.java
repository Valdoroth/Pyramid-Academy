import java.util.ArrayList;

public class Grid {

    public static ArrayList<MapLocation> createGrid(){
        ArrayList<MapLocation> gridMap = new ArrayList<>();
        String water = "~";
        StringBuilder coordinateItem = new StringBuilder();

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                Coordinate here = new Coordinate();
                MapLocation<Coordinate, String> gridLocation = new MapLocation<>();
                if(i == 0 && j > 0) coordinateItem.append(j);
                if(j == 0 && i > 0 && i != 10) coordinateItem.append(i + " ");
                if(i == 10 && j == 0) coordinateItem.append(10);
                if(j == 0 && i == 0) coordinateItem = new StringBuilder("  ");
                if(j > 0 && i > 0) coordinateItem = new StringBuilder(water);
                here.setX(i);
                here.setY(j);
                gridLocation.setC(here);
                gridLocation.setItem(coordinateItem.toString());
                coordinateItem = new StringBuilder();
                gridMap.add(gridLocation);
            }
        }
        return gridMap;
    }
}
