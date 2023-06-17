
import java.util.ArrayList;

public class BoundedGrid implements Grid
{
	private String[][] board;

	//----------------------------------------------------------------------------
	public BoundedGrid(int size)
	{
		board = new String [size][size];
	}
	//----------------------------------------------------------------------------
	//Precondition:
	//Postcondition: Returns the number of rows in this grid.
	public int getNumRows()
	{
		return board.length;
	}

	//----------------------------------------------------------------------------
	//Precondition:
	//Postcondition: Returns the number of columns in this grid.
	public int getNumCols()
	{
		return board[0].length;
	}

	//----------------------------------------------------------------------------
	//Precondition:  loc is not null
	//Postcondition: Returns true if loc is valid in this grid, false otherwise
	public boolean isValid(Location loc)
	{
		if(loc.getRow()<0 || loc.getRow()>=board.length)
			return false;
		else if (loc.getCol()<0 || loc.getCol()>=board[0].length)
			return false;
		else 
			return true;
	}
	//----------------------------------------------------------------------------
	//Precondition:  (1) loc is valid in this grid
	//				 (2) theColor is not null
	//Postcondition:  Puts the String object at loc.
	//				  Returns the object previously at that location.
	public String put(Location loc, String theColor)
	{
		String previous;
		previous=board[loc.getRow()][loc.getCol()];
		board[loc.getRow()][loc.getCol()]=theColor;
		return previous;
	}
	//----------------------------------------------------------------------------
	//Precondition:  (1) loc is valid in this grid
    //Postcondition: Removes the object at loc.
    //				 returns the object that was removed or null if the location is unoccupied
    public String remove(Location loc)
    {
    	String previous;
    	previous=board[loc.getRow()][loc.getCol()];
    	board[loc.getRow()][loc.getCol()]=null;
    	return previous;
    }

	//----------------------------------------------------------------------------
	//Precondition:  loc is valid in this grid
	//Postcondition: Returns the String at loc or null if the location is unoccupied.
	public String get(Location loc)
	{
		String theValue=board[loc.getRow()][loc.getCol()];
		if(board[loc.getRow()][loc.getCol()]==null)
			return null;
		else
			return theValue;
	}
	//----------------------------------------------------------------------------
	//Precondition:
	//Postcondition:  returns an ArrayList of all occupied locations in this grid
    public ArrayList<Location> getOccupiedLocs()
	{
    	ArrayList<Location> occList = new ArrayList<Location>();
    	for(int i=0;i<board.length;i++)
    	{
    		for(int j=0;j<board[0].length;j++)
    		{
    			if(board[i][j]!=null)
    				occList.add(new Location(i,j));
    		}
    	}
    	return occList;
	}

	//----------------------------------------------------------------------------
	//Precondition:  loc is valid in this grid
	//Postcondition: returns an ArrayList of valid locations adjacent to loc in
	//				 all eight compass directions (north, northeast, east, southeast,
	//				 south, southwest,west, and northwest).
	public ArrayList<Location> getValidAdjacentLocations(Location loc)
    {
		ArrayList<Location> valList = new ArrayList<Location>();
		if(isValid(loc.getAdjacentLoc(Location.NORTH))==true)
			valList.add(loc.getAdjacentLoc(Location.NORTH));
		if(isValid(loc.getAdjacentLoc(Location.EAST))==true)
			valList.add(loc.getAdjacentLoc(Location.EAST));
		if(isValid(loc.getAdjacentLoc(Location.SOUTH))==true)
			valList.add(loc.getAdjacentLoc(Location.SOUTH));
		if(isValid(loc.getAdjacentLoc(Location.WEST))==true)
			valList.add(loc.getAdjacentLoc(Location.WEST));
		if(isValid(loc.getAdjacentLoc(Location.NORTHEAST))==true)
			valList.add(loc.getAdjacentLoc(Location.NORTHEAST));
		if(isValid(loc.getAdjacentLoc(Location.SOUTHEAST))==true)
			valList.add(loc.getAdjacentLoc(Location.SOUTHEAST));
		if(isValid(loc.getAdjacentLoc(Location.SOUTHWEST))==true)
			valList.add(loc.getAdjacentLoc(Location.SOUTHWEST));
		if(isValid(loc.getAdjacentLoc(Location.NORTHWEST))==true)
			valList.add(loc.getAdjacentLoc(Location.NORTHWEST));
		return valList;
    }

	//----------------------------------------------------------------------------

    //Precondition:  loc is valid in this grid
	//Postcondition: returns an ArrayList of valid empty locations adjacent to loc
	//				 in all eight compass directions (north, northeast, east,
	//				 southeast, south, southwest, west, and northwest).
    public ArrayList<Location> getEmptyAdjacentLocations(Location loc)
    {
    	ArrayList<Location> valEmpList = new ArrayList<Location>();
		if(isValid(loc.getAdjacentLoc(Location.NORTH))==true && (get(loc.getAdjacentLoc(Location.NORTH))==null))
			valEmpList.add(loc.getAdjacentLoc(Location.NORTH));
		if(isValid(loc.getAdjacentLoc(Location.EAST))==true && (get(loc.getAdjacentLoc(Location.EAST))==null))
			valEmpList.add(loc.getAdjacentLoc(Location.EAST));
		if(isValid(loc.getAdjacentLoc(Location.SOUTH))==true && (get(loc.getAdjacentLoc(Location.SOUTH))==null))
			valEmpList.add(loc.getAdjacentLoc(Location.SOUTH));
		if(isValid(loc.getAdjacentLoc(Location.WEST))==true && (get(loc.getAdjacentLoc(Location.WEST))==null))
			valEmpList.add(loc.getAdjacentLoc(Location.WEST));
		if(isValid(loc.getAdjacentLoc(Location.NORTHEAST))==true && (get(loc.getAdjacentLoc(Location.NORTHEAST))==null))
			valEmpList.add(loc.getAdjacentLoc(Location.NORTHEAST));
		if(isValid(loc.getAdjacentLoc(Location.SOUTHEAST))==true && (get(loc.getAdjacentLoc(Location.SOUTHEAST))==null))
			valEmpList.add(loc.getAdjacentLoc(Location.SOUTHEAST));
		if(isValid(loc.getAdjacentLoc(Location.SOUTHWEST))==true && (get(loc.getAdjacentLoc(Location.SOUTHWEST))==null))
			valEmpList.add(loc.getAdjacentLoc(Location.SOUTHWEST));
		if(isValid(loc.getAdjacentLoc(Location.NORTHWEST))==true && (get(loc.getAdjacentLoc(Location.NORTHWEST))==null))
			valEmpList.add(loc.getAdjacentLoc(Location.NORTHWEST));
		return valEmpList;
    }


	//----------------------------------------------------------------------------
	//Precondition:	  loc is valid in this grid
	//Postcondition:  returns an ArrayList of valid occupied locations adjacent to
	//				  loc in all eight compass directions (north, northeast, east,
	//				  southeast, south, southwest, west, and northwest).
   	public ArrayList<Location> getOccupiedAdjacentLocs(Location loc)
	{
   		ArrayList<Location> valOccList = new ArrayList<Location>();
		if(isValid(loc.getAdjacentLoc(Location.NORTH))==true && (get(loc.getAdjacentLoc(Location.NORTH))!=null))
			valOccList.add(loc.getAdjacentLoc(Location.NORTH));
		if(isValid(loc.getAdjacentLoc(Location.EAST))==true && (get(loc.getAdjacentLoc(Location.EAST))!=null))
			valOccList.add(loc.getAdjacentLoc(Location.EAST));
		if(isValid(loc.getAdjacentLoc(Location.SOUTH))==true && (get(loc.getAdjacentLoc(Location.SOUTH))!=null))
			valOccList.add(loc.getAdjacentLoc(Location.SOUTH));
		if(isValid(loc.getAdjacentLoc(Location.WEST))==true && (get(loc.getAdjacentLoc(Location.WEST))!=null))
			valOccList.add(loc.getAdjacentLoc(Location.WEST));
		if(isValid(loc.getAdjacentLoc(Location.NORTHEAST))==true && (get(loc.getAdjacentLoc(Location.NORTHEAST))!=null))
			valOccList.add(loc.getAdjacentLoc(Location.NORTHEAST));
		if(isValid(loc.getAdjacentLoc(Location.SOUTHEAST))==true && (get(loc.getAdjacentLoc(Location.SOUTHEAST))!=null))
			valOccList.add(loc.getAdjacentLoc(Location.SOUTHEAST));
		if(isValid(loc.getAdjacentLoc(Location.SOUTHWEST))==true && (get(loc.getAdjacentLoc(Location.SOUTHWEST))!=null))
			valOccList.add(loc.getAdjacentLoc(Location.SOUTHWEST));
		if(isValid(loc.getAdjacentLoc(Location.NORTHWEST))==true && (get(loc.getAdjacentLoc(Location.NORTHWEST))!=null))
			valOccList.add(loc.getAdjacentLoc(Location.NORTHWEST));
		return valOccList;
		
	}



	//----------------------------------------------------------------------------
	//Postcondition: displays the board and its values onto the screen.
	public void display()
	{
		System.out.println();
		System.out.print(String.format("%4s", " "));
		for (int i = 0; i < board[0].length; i++)
			System.out.print(String.format("%4d", i));

		System.out.println("\n");

		for (int i = 0; i < board.length; i++)
		{
			System.out.print(String.format("%4d", i));
			for (int j = 0; j < board[0].length; j++)
			{
				if (board[i][j] != null)
					System.out.print(String.format("%4s", board[i][j]));
				else
					System.out.print(String.format("%4s", "."));
			}
			System.out.println("\n");
		}

		System.out.println();
	}

	//----------------------------------------------------------------------------
}