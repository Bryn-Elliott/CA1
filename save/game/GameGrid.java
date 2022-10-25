package CS2020.assignment1.game;
import java.util.Random;

public class GameGrid extends AbstractGameGrid
{
    protected int[] gridSize = new int[2];
    GameGrid(int width, int height, int noOfShips)
    {
        gridSize[0] = width;
        gridSize[1] = height;
        initializeGrid();
        generateShips(noOfShips);
        for(int i = 0; i < noOfShips; i++)
        {
            placeShip(ships[i]);
        }
    }

    public void initializeGrid()
    {
        gameGrid = new String[gridSize[0]][gridSize[1]];
        for(int i = 0; i < gridSize[0]; i++)
        {
            for(int l = 0; l < gridSize[1]; l++)
            {
                gameGrid[i][l] = ".";
            }
        }

    }
	public void placeShip(AbstractBattleShip ship)
    {
        Random rnd = new Random();
        int x = gridSize[0] - 2;
        int y = gridSize[1] - 2;
        int row = rnd.nextInt(x) + 1;
        int column = rnd.nextInt(y) + 1;
        String shipOrientation = ship.getShipOrientation();
        int[][] coordinates = new int[2][3];
        coordinates[0][1] = row;
        coordinates[1][1] = column;
        if (shipOrientation == "vertical")
        {
            coordinates[0][0] = row - 1;
            coordinates[0][2] = row + 1;
            coordinates[1][0] = column;
            coordinates[1][2] = column;
        }
        else
        {
            coordinates[0][0] = row;
            coordinates[0][2] = row;
            coordinates[1][0] = column - 1;
            coordinates[1][2] = column + 1;
        }
        ship.setShipCoordinates(coordinates);
        for (int i = 0; i < 3; i++)
        {
            gameGrid[coordinates[0][i]][coordinates[1][i]] = "*";
        }
    }
	
	//this should generate ships for both player and the opponent 
	public void generateShips (int numberOfShips)
    {
        ships = new AbstractBattleShip[numberOfShips];
        for (int i = 0; i < numberOfShips; i++)
        {
            String shipName = "Ship " + String.valueOf(i + 1);
            ships[i] = new BattleShip(shipName);
        }
    }
}
