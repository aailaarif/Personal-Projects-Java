import java.util.ArrayList;
import java.util.Scanner;

public class HumanOthelloPlayer extends OthelloPlayer
{

	public HumanOthelloPlayer(String inName, String inColor) 
	{
		super(inName, inColor);
	}

	public Location getMove(ArrayList<Location> legMoves) 
	{
		boolean valMove=false;
		int row=0;
		int col=0;
		Scanner inputReader = new Scanner(System.in);
		
		if(legMoves.size()==0)
		{
			System.out.println("legalMoves: []");
			return null;
		}
		
		System.out.print("legalMoves: [" + legMoves.get(0));
		for(int i=1; i<legMoves.size(); i++)
		{
			System.out.print(", " + legMoves.get(i));
		}
		System.out.print("]");
		
		while(valMove==false)
		{
			System.out.println();
			System.out.println("Enter row: ");
			row = inputReader.nextInt();
			System.out.println("Enter col: ");
			col= inputReader.nextInt();
			
			for(int a=0; a<legMoves.size(); a++)
			{
				if(row == legMoves.get(a).getRow() && col == legMoves.get(a).getCol())
					valMove=true;
			}
			if(valMove==false)
				System.out.println("Invalid move. Please reenter ");	
		}
		return new Location(row, col); 
	}
}
