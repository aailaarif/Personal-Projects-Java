import java.util.ArrayList;
import java.lang.Math; 

public class StupidComputerPlayer extends OthelloPlayer
{

	public StupidComputerPlayer(String inName, String inColor) 
	{
		super(inName, inColor);
	}

	public Location getMove(ArrayList<Location> legMoves) 
	{
		if(legMoves.size()==0)
		{
			System.out.println("legalMoves: []");
			return null;
		}
		
		int theChoice=(int)(Math.random() * legMoves.size());
		
		int row=legMoves.get(theChoice).getRow();
		int col=legMoves.get(theChoice).getCol();
		
		return new Location(row, col);
	}

}
