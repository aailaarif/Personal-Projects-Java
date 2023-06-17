import java.util.ArrayList;
public class UpdateBoardTestCases
{
	//Each method depicts different test cases for a 4 x 4 matrix.
	//It is recommended that you create test cases for an 8 x 8 matrix.

	//-----------------------------------------------------------------------------------------
	public static void testCase1(Grid board, String[][] key)
	{

		/*
       			0   1   2   3

   			0   .   .   .   .

   			1   W   B   B   .

  			2   .   .   .   .

   			3   .   .   .   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #1");

		board.put(new Location(1, 0), "W");
		board.put(new Location(1, 1), "B");
		board.put(new Location(1, 2), "B");


		key[1][0] = "W";
		key[1][1] = "W";
		key[1][2] = "W";
		key[1][3] = "W";

	}

	//-----------------------------------------------------------------------------------------
	public static void testCase2(Grid board, String[][] key)
	{
	/*
       			0   1   2   3

   			0   .   .   .   .

   			1   B   W   B   .

  			2   .   .   .   .

   			3   .   .   .   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #2");

		board.put(new Location(1, 0), "B");
		board.put(new Location(1, 1), "W");
		board.put(new Location(1, 2), "B");


		key[1][0] = "B";
		key[1][1] = "W";
		key[1][2] = "W";
		key[1][3] = "W";

	}


	//-----------------------------------------------------------------------------------------
	public static void testCase3(Grid board, String[][] key)
	{
		/*
       			0   1   2   3

   			0   W   .   .   .

   			1   .   B   .   .

  			2   .   .   B   .

   			3   .   .   .   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #3");

		board.put(new Location(0, 0), "W");
		board.put(new Location(1, 1), "B");
		board.put(new Location(2, 2), "B");


		key[0][0] = "W";
		key[1][1] = "W";
		key[2][2] = "W";
		key[3][3] = "W";


	}

	//-----------------------------------------------------------------------------------------
	public static void testCase4(Grid board, String[][] key)
	{

		/*
       			0   1   2   3

   			0   W   B   B   .

   			1   B   B   .   .

  			2   B   .   B   .

   			3   .   .   .   .
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #4");

		board.put(new Location(0, 0), "W");
		board.put(new Location(0, 1), "B");
		board.put(new Location(0, 2), "B");

		board.put(new Location(1, 0), "B");
		board.put(new Location(1, 1), "B");

		board.put(new Location(2, 0), "B");
		board.put(new Location(2, 2), "B");

		key[0][0] = "W";
		key[0][1] = "B";
		key[0][2] = "B";

		key[1][0] = "B";
		key[1][1] = "W";

		key[2][0] = "B";
		key[2][2] = "W";

		key[3][3] = "W";

	}

	//-----------------------------------------------------------------------------------------
	public static void testCase5(Grid board, String[][] key)
	{

		/*
       			0   1   2   3

   			0   .   B   B   W

   			1   B   B   .   .

  			2   B   .   B   .

   			3   W   .   .   W
		*/

		System.out.println("-----------------------------------------------");
		System.out.println("Test Case #5");

		board.put(new Location(0, 1), "B");
		board.put(new Location(0, 2), "B");
		board.put(new Location(0, 3), "W");

		board.put(new Location(1, 0), "B");
		board.put(new Location(1, 1), "B");

		board.put(new Location(2, 0), "B");
		board.put(new Location(2, 2), "B");

		board.put(new Location(3, 0), "W");
		board.put(new Location(3, 3), "W");


		key[0][0] = "W";
		key[0][1] = "W";
		key[0][2] = "W";
		key[0][3] = "W";

		key[1][0] = "W";
		key[1][1] = "W";

		key[2][0] = "W";
		key[2][2] = "W";

		key[3][0] = "W";
		key[3][3] = "W";
	}
}