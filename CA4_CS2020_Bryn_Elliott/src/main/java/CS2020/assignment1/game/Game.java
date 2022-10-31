package CS2020.assignment1.game;
import java.util.Random;

public class Game implements GameControls
{
    protected PlayerGameGrid playersGrid;
    protected OpponentGameGrid opponentsGrid;
    Game(int width, int height, int noOfShips)
    {
        playersGrid = new PlayerGameGrid(width, height, noOfShips);
        opponentsGrid = new OpponentGameGrid(width, height, noOfShips);
    }

    public PlayerGameGrid getPlayersGrid()
    {
        return playersGrid;
    }

    public OpponentGameGrid getOpponentssGrid()
    {
        return opponentsGrid;
    }

    public void playRound (String input)
    {
        String[] values = input.split(",");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        if (opponentsGrid.gameGrid[x][y] == "*")
        {
            opponentsGrid.gameGrid[x][y] = "X";
            System.out.print("HIT ");
            int [][] coords = new int[2][3];
            for(int i = 0; i < opponentsGrid.ships.length; i++)
            {
                coords = opponentsGrid.ships[i].getShipCoordinates();
                for(int l = 0; l < 3; l++)
                {
                    if (x == coords[0][l])
                    {
                        if (y == coords[1][l])
                        {
                            opponentsGrid.ships[i].setHits(opponentsGrid.ships[i].getHits() + 1);
                            String shipName = opponentsGrid.ships[i].getName();
                            System.out.print(shipName);
                        }
                    }
                }
                System.out.println("!!!");
            }
        }
        else
        {
            opponentsGrid.gameGrid[x][y] = "%";
            System.out.println("MISS!!!");
        }
        opponentsGrid.printGrid();
        Random rnd = new Random();
        x = rnd.nextInt(playersGrid.gameGrid.length - 1);
        y = rnd.nextInt(playersGrid.gameGrid[0].length - 1);
        if (playersGrid.gameGrid[x][y] == "*")
        {
            playersGrid.gameGrid[x][y] = "X";
            System.out.print("HIT ");
            int [][] coords = new int[2][3];
            for(int i = 0; i < playersGrid.ships.length; i++)
            {
                coords = playersGrid.ships[i].getShipCoordinates();
                for(int l = 0; l < 3; l++)
                {
                    if (x == coords[0][l])
                    {
                        if (y == coords[1][l])
                        {
                            playersGrid.ships[i].setHits(playersGrid.ships[i].getHits() + 1);
                            String shipName = playersGrid.ships[i].getName();
                            System.out.print(shipName);
                        }
                    }
                }
                System.out.println("!!!");
            }
        }
        else
        {
            playersGrid.gameGrid[x][y] = "%";
            System.out.println("MISS!!!");
        }
        playersGrid.printGrid();
    }
	
	public boolean checkVictory ()
    {
        int noOfShips = playersGrid.ships.length;
        int noOfHits;
        boolean win = true;
        boolean lose = true;
        for (int i = 0; i < noOfShips; i++)
        {
            if (playersGrid.ships[i].getHits() < 3)
            {
                lose = false;
            }
        }
        for (int i = 0; i < noOfShips; i++)
        {
            if (opponentsGrid.ships[i].getHits() < 3)
            {
                win = false;
            }
        }
        if (win)
        {
            System.out.println("You have won!");
            return true;
        }
        else if (lose)
        {
            System.out.println("You have lost!");
            return true;
        }
        else
        {
            return false;
        }
    }
	
	public void exitGame (String input)
    {
        if (input == "exit")
        {
            System.out.println("Exiting game - thank you for playing");
            System.exit(0);
        }
    }
}