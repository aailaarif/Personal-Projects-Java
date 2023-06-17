import java.util.ArrayList;
public class CompareListUtility
{
	public static void compareLocationLists(ArrayList<Location>origLocs, 
											ArrayList<Location> testingLocs,
							                String methodName)
	{
		boolean found = false;

		if (origLocs.size() == 0 && testingLocs.size() == 0)
		{
			System.out.println("." + methodName + " method (lists are empty).....WORKED");
			return;
		}


		if (origLocs.size() != testingLocs.size())
		{
			System.out.println("." + methodName + " method (size).....FAILED");
			return;
		}
		else
		{
			for (int i = 0; i < origLocs.size(); i++)
			{
				found = false;
				Location targetLoc = origLocs.get(i);
				
				//Loop through testingLocs and look for targetLoc because
				//it may be in a different slot in both ArrayLists.
				for (int j = 0; j < testingLocs.size() && found == false; j++)
				{
					if (targetLoc.equals(testingLocs.get(j)))
						found = true;
				}
				if (found == false)
				{
					System.out.println("." + methodName + " method (match).....FAILED");
					return;
				}
			}
		}
		
		System.out.println("." + methodName + " method (end match).....WORKED");
		
	}

	//------------------------------------------------------------------------------------------
	public static void compareMatrix(Grid board, String[][] key, String methodName)
	{
		for (int row = 0; row < board.getNumRows(); row++)
		{
			for (int col = 0; col < board.getNumRows(); col++)
			{
				String boardValue = board.get(new Location(row, col));
				String keyValue = key[row][col];
				if (boardValue != null && keyValue != null )
				{
					if (! boardValue.equals(keyValue))
					{
						System.out.println("." + methodName + " method....FAILED (not null) at row: " + row + " col: " + col);
						System.out.println("Updated Board Value: " + boardValue);
						System.out.println("Key Value:           " + keyValue);
						return;
					}
				}
				else if ( (boardValue != null && keyValue == null) || (boardValue == null && keyValue != null) )
				{
					System.out.println("." + methodName + " method....FAILED at row: " + row + " col: " + col);
					System.out.println("Updated Board Value: " + boardValue);
					System.out.println("Key Value:           " + keyValue);
					return;
				}

			}
		}
		System.out.println("." + methodName + " method .....WORKED");
	}

	//------------------------------------------------------------------------------------------
	public static void display(String[][] theMatrix)
	{
		for (int i = 0;i < theMatrix.length; i++)
		{
			for (int j = 0; j < theMatrix[0].length; j++)
				System.out.print(theMatrix[i][j]);

			System.out.println();
		}
		System.out.println();
	}


}