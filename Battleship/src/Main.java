import java.util.concurrent.TimeUnit;

public class Main {
    private static Player player1;
    private static Player player2;

    public static void main(String[] args) throws InterruptedException {
        player1 = new Player();
        player2 = new Player();

        System.out.println("Player 1's turn to place their ships.");
        player1.printGrid();
        Ship.addShip("cv");
        player1.printGrid();
        Ship.addShip("bb");
        player1.printGrid();
        Ship.addShip("cl");
        player1.printGrid();
        Ship.addShip("dd");
        player1.printGrid();
        Ship.addShip("ss");
        player1.printGrid();

        // Player 2's turn to setup
        TimeUnit.MILLISECONDS.sleep(500);
        System.out.println("\nPlayer 2's turn to place their ships.");
        TimeUnit.MILLISECONDS.sleep(500);

        /*
        player2.printGrid(player1.getBoard());
        player2.carrier = new Ship();
        while(player2.shipSetupCount > 4) {
            Ship.addShip("cv");
            player2.updateMap();
            player2.shipSetupCount--;
        }
        player2.printGrid(player1.getBoard());


        while(player2.shipSetupCount > 3) {
            player2.battleship = new Ship();
            Ship.addShip("bb");
            if (player2.checkLocation("bb")) {
                Battleship.position.clear();
            } else {
                player2.updateMap();
                player2.shipSetupCount--;
            }
        }
        player2.printGrid(player2.getBoard());

        while(player2.shipSetupCount > 2) {
            player2.cruiser = new Ship();
            Ship.addShip("cl");
            if (player2.checkLocation("cl")) {
                Cruiser.position.clear();
            } else {
                player2.updateMap();
                player2.shipSetupCount--;
            }
        }
        player2.printGrid(player2.getBoard());

        while(player2.shipSetupCount > 1) {
            player2.destroyer = new Ship();
            Ship.addShip("dd");
            if(player2.checkLocation("dd")) {
                Destroyer.position.clear();
            } else {
                player2.updateMap();
                player2.shipSetupCount--;
            }
        }
        player2.printGrid(player2.getBoard());
        while(player2.shipSetupCount > 0) {
            player2.submarine = new Ship();
            Ship.addShip("ss");
            if (player2.checkLocation("ss")) {
                Submarine.position.clear();
            } else {
                player2.updateMap();
                player2.shipSetupCount--;
            }
        }

        player2.printGrid(player2.getBoard());

        while(!player1.status().equals("lost")) {

            player1.guessShot(player2.getBoard());
        }
        */
    }
}
