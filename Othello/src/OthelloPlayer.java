import java.util.ArrayList;

public abstract class OthelloPlayer 
{
	String name;
	String color;
	
	public OthelloPlayer(String inName, String inColor)
	{
		name=inName;
		color=inColor;
	}
	
	public abstract Location getMove(ArrayList<Location> legMoves);
}
