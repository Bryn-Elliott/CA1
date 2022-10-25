package CS2020.assignment1.game;
import java.util.Random;

public class BattleShip extends AbstractBattleShip
{
    BattleShip(String shipName)
    {
        //Adding name to the object
        name = shipName;

        //generating a random direction for the object
        Random rnd = new Random();
        int shipOrientationINT = rnd.nextInt(2);
        //converting RNG number to direction
        if (shipOrientationINT == 0)
        {
            shipOrientation = "vertical";
        }
        else
        {
            shipOrientation = "horizontal";
        }
        

    }

	public boolean checkAttack (int row,int column)
    {
        if (shipCoordinates[0][0] == row && shipCoordinates[0][1] == column && hits < 3)
        { 
            hits++;
            return true;
        }
        else
        {
            return false;
        }
    }
	
	public String getName()
    {
        return name;
    }

	public int getHits()
    {
        return hits;
    }
	
	public String getShipOrientation()
    {
        return shipOrientation;
    }
	
	public void setHits(int numberOfHits)
    {
        hits = numberOfHits;
    }
	
	public int[][] getShipCoordinates()
    {
        return shipCoordinates;
    }
	
	public void setShipCoordinates(int [][] coordinates)
    {
        shipCoordinates = coordinates;
    }
}
