package CS2020.assignment1.game;

public class PlayerGameGrid extends GameGrid
{
    PlayerGameGrid(int width, int height, int NoOfShips)
    {
        super(width, height, NoOfShips);
    }

    public void printGrid()
    {
        int width = gameGrid.length;
        int height = gameGrid[0].length;
        System.out.println("Player's Grid");
        for (int i = 0; i < width; i++)
        {
            for (int l = 0; l < height; l++)
            {
                System.out.print(gameGrid[i][l]);
            }
            System.out.println("");
        }
    }
}