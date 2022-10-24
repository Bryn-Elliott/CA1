package CS2020.assignment1.game;
import java.util.Random;

public class BattleShip extends AbstractBattleShip
{
    BattleShip(String shipName)
    {
        name = shipName;
        Random rnd = new Random();
        int shipOrientationINT = rnd.nextInt(2);
        shipOrientation = String.valueOf(shipOrientationINT);
        //0 = vertical, 1 = horizontal.
        System.out.println(name);
    }

	public boolean checkAttack (int row,int column)
    {
        return false;
    }
	
	public String getName()
    {
        return name;
    }

	public int getHits()
    {
        return 0;
    }
	
	public String getShipOrientation()
    {
        return shipOrientation;
    }
	
	public void setHits(int numberOfHits)
    {
        
    }
	
	public int[][] getShipCoordinates()
    {
        return null;
    }
	
	public void setShipCoordinates(int [][] coordinates)
    {

    }
}
