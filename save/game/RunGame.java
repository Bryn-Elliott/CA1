package CS2020.assignment1.game;
import java.util.Scanner;

public class RunGame
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter grid width: ");
        String widthSTR = input.nextLine();
        System.out.println("");
        System.out.print("Enter grid height: ");
        String heightSTR = input.nextLine();
        System.out.println("");
        System.out.print("Enter number of ships per team: ");
        String noOfShipsSTR = input.nextLine();
        int width = Integer.parseInt(widthSTR);
        int height = Integer.parseInt(heightSTR);
        int noOfShips = Integer.parseInt(noOfShipsSTR);
        Game myGame = new Game(width, height, noOfShips);
        myGame.playersGrid.printGrid();
        myGame.opponentsGrid.printGrid();
        while (true)
        {
            boolean exit = myGame.checkVictory();
            if (exit)
            {
                myGame.exitGame("exit");
            }
                System.out.println("");
                System.out.print("Enter coordinate(in form [x,y]): ");
                String coords = input.nextLine();
                myGame.exitGame(coords);
                myGame.playRound(coords);
        }

    }
}