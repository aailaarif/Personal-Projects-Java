

public class LocationTester
{
	//---------------------------------------------------------------------
	public static void test_equals()
	{
		Location loc1 = new Location(2,3);
		Location loc2 = new Location(2,3);
		Location loc3 = new Location(1,3);

		//test equals
		boolean ans = loc1.equals(loc2);
		if (ans == true)
			System.out.println("1 .equals method.....WORKS");
		else
			System.out.println("1 .equals method.....FAILED");
		
		ans = loc1.equals(loc3);
		if (ans == false)
			System.out.println("2 .equals method.....WORKS");
		else
			System.out.println("2 .equals method.....FAILED");
		
		System.out.println();

	}
	//---------------------------------------------------------------------
	public static void test_getAdjacentLoc()
	{
		Location loc1 = new Location(2,2);
		Location loc2 = new Location(2,2);
		Location adjDir = null;

		//test getAdjacentLoc method
		//test NORTH
		adjDir = loc1.getAdjacentLoc(Location.NORTH);
		if (adjDir.equals(new Location(1, 2)))
			System.out.println("1 .getAdjacentLoc method.....WORKS");
		else
			System.out.println("2 .getAdjacentLoc method.....FAILED");

		//test NORTHEAST
		adjDir = loc1.getAdjacentLoc(Location.NORTHEAST);
		if (adjDir.equals(new Location(1, 3)))
			System.out.println("3 .getAdjacentLoc method.....WORKS");
		else
			System.out.println("4 .getAdjacentLoc method.....FAILED");


		//test EAST
		adjDir = loc1.getAdjacentLoc(Location.EAST);
		if (adjDir.equals(new Location(2, 3)))
			System.out.println("5 .getAdjacentLoc method.....WORKS");
		else
			System.out.println("6 .getAdjacentLoc method.....FAILED");


		//test SOUTHEAST
		adjDir = loc1.getAdjacentLoc(Location.SOUTHEAST);
		if (adjDir.equals(new Location(3, 3)))
			System.out.println("7 .getAdjacentLoc method.....WORKS");
		else
			System.out.println("8 .getAdjacentLoc method.....FAILED");


		//test SOUTH
		adjDir = loc1.getAdjacentLoc(Location.SOUTH);
		if (adjDir.equals(new Location(3, 2)))
			System.out.println("9 .getAdjacentLoc method.....WORKS");
		else
			System.out.println("10 .getAdjacentLoc method.....FAILED");

		//test SOUTHWEST
		adjDir = loc1.getAdjacentLoc(Location.SOUTHWEST);
		if (adjDir.equals(new Location(3, 1)))
			System.out.println("11 .getAdjacentLoc method.....WORKS");
		else
			System.out.println("12 .getAdjacentLoc method.....FAILED");


		//test WEST
		adjDir = loc1.getAdjacentLoc(Location.WEST);
		if (adjDir.equals(new Location(2, 1)))
			System.out.println("13 .getAdjacentLoc method.....WORKS");
		else

			System.out.println("14 .getAdjacentLoc method.....FAILED");


		//test NORTHWEST
		adjDir = loc1.getAdjacentLoc(Location.NORTHWEST);
		if (adjDir.equals(new Location(1, 1)))
			System.out.println("15 .getAdjacentLoc method.....WORKS");
		else
			System.out.println("16 .getAdjacentLoc method.....FAILED");

		System.out.println();
	}

	//---------------------------------------------------------------------
	public static void test_getDirectionToward()
	{
		//8 possible results
		Location curLoc = new Location(2,2);
		Location otherLoc = null;
		int dir = 99;

		//test NORTH
		dir = curLoc.getDirectionToward(new Location(1, 2));
		if (dir == Location.NORTH)
			System.out.println("1 .getDirectionToward method.....WORKS");
		else
			System.out.println("2 .getDirectionToward method.....FAILED");


		//test NORTHEAST
		dir = curLoc.getDirectionToward(new Location(1, 3));
		if (dir == Location.NORTHEAST)
			System.out.println("3 .getDirectionToward method.....WORKS");
		else
			System.out.println("4 .getDirectionToward method.....FAILED");


		//test EAST
		dir = curLoc.getDirectionToward(new Location(2, 3));
		if (dir == Location.EAST)
			System.out.println("5 .getDirectionToward method.....WORKS");
		else
			System.out.println("6 .getDirectionToward method.....FAILED");


		//test SOUTHEAST
		dir = curLoc.getDirectionToward(new Location(3, 3));
		if (dir == Location.SOUTHEAST)
			System.out.println("7 .getDirectionToward method.....WORKS");
		else
			System.out.println("8 .getDirectionToward method.....FAILED");

		//test SOUTH
		dir = curLoc.getDirectionToward(new Location(3, 2));
		if (dir == Location.SOUTH)
			System.out.println("9 .getDirectionToward method.....WORKS");
		else
			System.out.println("10 .getDirectionToward method.....FAILED");


		//test SOUTHWEST
		dir = curLoc.getDirectionToward(new Location(3, 1));
		if (dir == Location.SOUTHWEST)
			System.out.println("11 .getDirectionToward method.....WORKS");
		else
			System.out.println("12 .getDirectionToward method.....FAILED");

		//test WEST
		dir = curLoc.getDirectionToward(new Location(2, 1));
		if (dir == Location.WEST)
			System.out.println("13 .getDirectionToward method.....WORKS");
		else
			System.out.println("14 .getDirectionToward method.....FAILED");


		//test NORTHWEST
		dir = curLoc.getDirectionToward(new Location(1, 1));
		if (dir == Location.NORTHWEST)
			System.out.println("15 .getDirectionToward method.....WORKS");
		else
			System.out.println("16 .getDirectionToward method.....FAILED");

		System.out.println();
	}

	//---------------------------------------------------------------------
	public static void main(String args[])
	{

		//Note....no parameters are included here.  They will be added in the 
		//tester methods that are called from here.
		
		//Comment out the methods that are not being tested.
		
		test_equals();
		test_getAdjacentLoc();
		test_getDirectionToward();


	}
}