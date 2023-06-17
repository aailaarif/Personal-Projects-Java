import java.util.ArrayList;
public class BoundedGridTester
{
	public static void test_getOccupiedLocs()
	{
		/*****************************/
		/*  Testing with this board  */
		/*****************************/
		/*

				0   1   2   3

   			0   .   .   B   B

   			1   B   B   B   B

   			2   B   B   B   B

   			3   B   B   B   .

   		*/


		Grid board = new BoundedGrid(4);

		//Create answer KEY
		ArrayList<Location> origLocs = new ArrayList<Location>();
		origLocs.add(new Location(0, 2));
		origLocs.add(new Location(0, 3));

		origLocs.add(new Location(1, 0));
		origLocs.add(new Location(1, 1));
		origLocs.add(new Location(1, 2));
		origLocs.add(new Location(1, 3));

		origLocs.add(new Location(2, 0));
		origLocs.add(new Location(2, 1));
		origLocs.add(new Location(2, 2));
		origLocs.add(new Location(2, 3));

		origLocs.add(new Location(3, 0));
		origLocs.add(new Location(3, 1));
		origLocs.add(new Location(3, 2));

		for (int i = 0; i < origLocs.size(); i++)
		{
			board.put(origLocs.get(i), "B");
		}

		ArrayList<Location> occLocs = board.getOccupiedLocs();

		CompareListUtility.compareLocationLists(origLocs, occLocs, "getOccupiedLocs");
	}

	//----------------------------------------------------------------------
	public static void test_getOccupiedAdjacentLocs()
	{
		Grid board = new BoundedGrid(8);
		Location theLoc = null;

		/******************************************************/
		/*  Testing the corner #1  All filled around corner   */
		/******************************************************/
		theLoc = new Location(0,0);

		//Create answer KEY
		ArrayList<Location> cornerAdjLocs = new ArrayList<Location> ();
		cornerAdjLocs.add(new Location(0, 1));
		cornerAdjLocs.add(new Location(1, 1));
		cornerAdjLocs.add(new Location(1, 0));

		for (int i = 0; i < cornerAdjLocs.size(); i++)
		{
			board.put(cornerAdjLocs.get(i), "B");
		}

		ArrayList<Location> adjLocs = board.getOccupiedAdjacentLocs(theLoc);

		CompareListUtility.compareLocationLists(cornerAdjLocs, adjLocs, "getOccupiedAdjacentLocs-CORNER #1");

		/************************************************************/
		/*  Testing the corner #2 - partially filled around corner  */
		/************************************************************/
		//clear the board from previous test case
		board = new BoundedGrid(8);
		theLoc = new Location(0,0);

		//Create answer KEY
		cornerAdjLocs = new ArrayList<Location> ();
		cornerAdjLocs.add(new Location(0, 1));
		cornerAdjLocs.add(new Location(1, 1));
		
		for (int i = 0; i < cornerAdjLocs.size(); i++)
		{
			board.put(cornerAdjLocs.get(i), "B");
		}

		adjLocs = board.getOccupiedAdjacentLocs(theLoc);

		CompareListUtility.compareLocationLists(cornerAdjLocs, adjLocs, "getOccupiedAdjacentLocs-CORNER #2");



		/****************************************************************************/
		/*  Testing an edge that's not the corner #1  - all filled around edge      */
		/****************************************************************************/
		//clear the board from previous test case
		board = new BoundedGrid(8);
		theLoc = new Location(0,1);

		//Create answer KEY
		ArrayList<Location> edgeLocs = new ArrayList<Location> ();
		edgeLocs.add(new Location(0, 0));
		edgeLocs.add(new Location(0, 2));
		edgeLocs.add(new Location(1, 0));
		edgeLocs.add(new Location(1, 1));
		edgeLocs.add(new Location(1, 2));

		for (int i = 0; i < edgeLocs.size(); i++)
		{
			board.put(edgeLocs.get(i), "B");
		}

		adjLocs = board.getOccupiedAdjacentLocs(theLoc);

		CompareListUtility.compareLocationLists(edgeLocs, adjLocs, "getOccupiedAdjacentLocs-EDGE #1");

		/**********************************************************************************/
		/*  Testing an edge that's not the corner #2  - partially filled around edge      */
		/**********************************************************************************/
		//clear the board from previous test case
		board = new BoundedGrid(8);
		theLoc = new Location(0,1);

		//Create answer KEY
		edgeLocs = new ArrayList<Location> ();
		edgeLocs.add(new Location(0, 0));
		edgeLocs.add(new Location(1, 0));
		edgeLocs.add(new Location(1, 1));
		
		for (int i = 0; i < edgeLocs.size(); i++)
		{
			board.put(edgeLocs.get(i), "B");
		}

		adjLocs = board.getOccupiedAdjacentLocs(theLoc);

		CompareListUtility.compareLocationLists(edgeLocs, adjLocs, "getOccupiedAdjacentLocs-EDGE #2");

		/****************************************/
		/*  Testing the middle #1 - all filled  */
		/****************************************/
		//clear the board from previous test case
		board = new BoundedGrid(8);
		theLoc = new Location(1,1);

		//Create answer KEY
		ArrayList<Location> middleLocs = new ArrayList<Location> ();
		middleLocs.add(new Location(0, 0));
		middleLocs.add(new Location(0, 1));
		middleLocs.add(new Location(0, 2));
		middleLocs.add(new Location(1, 0));
		middleLocs.add(new Location(1, 2));
		middleLocs.add(new Location(2, 0));
		middleLocs.add(new Location(2, 1));
		middleLocs.add(new Location(2, 2));

		for (int i = 0; i < middleLocs.size(); i++)
		{
			board.put(middleLocs.get(i), "B");
		}

		adjLocs = board.getOccupiedAdjacentLocs(theLoc);

		CompareListUtility.compareLocationLists(middleLocs, adjLocs, "getOccupiedAdjacentLocs-MIDDLE #1");

		//System.out.println(middleLocs);
		//System.out.println(adjLocs);
		
		/*************************************************/
		/*  Testing the middle #2 - partially filled     */
		/*************************************************/
		//clear the board from previous test case
		board = new BoundedGrid(8);
		theLoc = new Location(1,1);

		//Create answer KEY
		middleLocs = new ArrayList<Location> ();
		middleLocs.add(new Location(0, 0));
		middleLocs.add(new Location(0, 1));
		middleLocs.add(new Location(2, 1));
		middleLocs.add(new Location(2, 2));

		for (int i = 0; i < middleLocs.size(); i++)
		{
			board.put(middleLocs.get(i), "B");
		}

		adjLocs = board.getOccupiedAdjacentLocs(theLoc);

		CompareListUtility.compareLocationLists(middleLocs, adjLocs, "getOccupiedAdjacentLocs-MIDDLE #2");
	}

//----------------------------------------------------------------------
	public static void test_isValid()
	{
		Grid board = new BoundedGrid(8);
		Location loc1 = new Location(0, 0);
		Location loc2 = new Location(8, 8);
		Location loc3 = new Location(7, 7);
		Location loc4 = new Location(-1, 0);

		System.out.print("The grid: Rows: " + board.getNumRows() );
		System.out.println(" Cols: " + board.getNumCols() );
		
		System.out.println("\t" + loc1 + " is in the grid:  " + board.isValid(loc1));
		System.out.println("\t" + loc2 + " is in the grid:  " + board.isValid(loc2));
		System.out.println("\t" + loc3 + " is in the grid:  " + board.isValid(loc3));
		System.out.println("\t" + loc4 + " is in the grid:  " + board.isValid(loc4));
	}

	//----------------------------------------------------------------------
	public static void test_getValidAdjacentLocations()
	{
		Grid board = new BoundedGrid(8);
		Location theLoc = null;

		/*************************/
		/*  Testing the corner   */
		/************************/
		theLoc = new Location(0,0);

		//Create answer KEY
		ArrayList<Location> cornerAdjLocs = new ArrayList<Location> ();
		cornerAdjLocs.add(new Location(0, 1));
		cornerAdjLocs.add(new Location(1, 1));
		cornerAdjLocs.add(new Location(1, 0));

		ArrayList<Location> adjLocs = board.getValidAdjacentLocations(theLoc);

		CompareListUtility.compareLocationLists(cornerAdjLocs, adjLocs, "test_getValidAdjacentLocations-CORNER");


				
		/************************************************/
		/*  Testing an edge that's not the corner       */
		/************************************************/
		board = new BoundedGrid(8);
		theLoc = new Location(0,1);

		//Create answer KEY
		ArrayList<Location> edgeLocs = new ArrayList<Location> ();
		edgeLocs.add(new Location(0, 0));
		edgeLocs.add(new Location(0, 2));
		edgeLocs.add(new Location(1, 0));
		edgeLocs.add(new Location(1, 1));
		edgeLocs.add(new Location(1, 2));

		adjLocs = board.getValidAdjacentLocations(theLoc);

		CompareListUtility.compareLocationLists(edgeLocs, adjLocs, "test_getValidAdjacentLocations-EDGE");


		/*****************************/
		/*  Testing the middle       */
		/*****************************/
		board = new BoundedGrid(8);
		theLoc = new Location(1,1);

		//Create answer KEY
		ArrayList<Location> middleLocs = new ArrayList<Location> ();
		middleLocs.add(new Location(0, 0));
		middleLocs.add(new Location(0, 1));
		middleLocs.add(new Location(0, 2));
		middleLocs.add(new Location(1, 0));
		middleLocs.add(new Location(1, 2));
		middleLocs.add(new Location(2, 0));
		middleLocs.add(new Location(2, 1));
		middleLocs.add(new Location(2, 2));

		adjLocs = board.getValidAdjacentLocations(theLoc);

		CompareListUtility.compareLocationLists(middleLocs, adjLocs, "test_getValidAdjacentLocations-MIDDLE");

	}
	//----------------------------------------------------------------------
	public static void test_getEmptyAdjacentLocations()
	{
		BoundedGrid board = new BoundedGrid(8);
		Location theLoc = null;

		/**********************************************************************/
		/*  Testing the corner #1 - 2 empty adjacent locations next to corner */
		/**********************************************************************/
		theLoc = new Location(0,0);
		board.put(new Location(0,1), "B");

		//Create answer KEY
		ArrayList<Location> cornerAdjLocs = new ArrayList<Location> ();
		cornerAdjLocs.add(new Location(1, 1));
		cornerAdjLocs.add(new Location(1, 0));

		ArrayList<Location> adjLocs = board.getEmptyAdjacentLocations(theLoc);

		CompareListUtility.compareLocationLists(cornerAdjLocs, adjLocs, "test_getEmptyAdjacentLocations-CORNER #1");
		
		
		/**********************************************************************/
		/*  Testing the corner #2 - 3 empty adjacent locations next to corner */
		/**********************************************************************/
		//clear the board from the previous test case
		board = new BoundedGrid(8);
		theLoc = new Location(0,0);
		
		//Create answer KEY
		cornerAdjLocs = new ArrayList<Location> ();
		cornerAdjLocs.add(new Location(1, 1));
		cornerAdjLocs.add(new Location(1, 0));
		cornerAdjLocs.add(new Location(0, 1));

		adjLocs = board.getEmptyAdjacentLocations(theLoc);

		CompareListUtility.compareLocationLists(cornerAdjLocs, adjLocs, "test_getEmptyAdjacentLocations-CORNER #2");
		
			
		

		/********************************************************************************************/
		/*  Testing an edge that's not the corner #1 - 2 empty adjacent locations next to edge      */
		/********************************************************************************************/
		//clear the board from the previous test case
		board = new BoundedGrid(8);
		
		theLoc = new Location(0,1);
		board.put(new Location(0,0), "B");
		board.put(new Location(0,2), "B");
		board.put(new Location(1,0), "B");

		//Create answer KEY
		ArrayList<Location> edgeLocs = new ArrayList<Location> ();
		edgeLocs.add(new Location(1, 1));
		edgeLocs.add(new Location(1, 2));

		adjLocs = board.getEmptyAdjacentLocations(theLoc);

		CompareListUtility.compareLocationLists(edgeLocs, adjLocs, "test_getEmptyAdjacentLocations-EDGE #1");
		
		
		/********************************************************************************************/
		/*  Testing an edge that's not the corner #2 - 4 empty adjacent locations next to edge      */
		/********************************************************************************************/
		//clear the board from the previous test case
		board = new BoundedGrid(8);
		
		theLoc = new Location(0,1);
		board.put(new Location(0,0), "B");

		//Create answer KEY
		edgeLocs = new ArrayList<Location> ();
		edgeLocs.add(new Location(0, 2));
		edgeLocs.add(new Location(1, 0));
		edgeLocs.add(new Location(1, 1));
		edgeLocs.add(new Location(1, 2));
			
		adjLocs = board.getEmptyAdjacentLocations(theLoc);

		CompareListUtility.compareLocationLists(edgeLocs, adjLocs, "test_getEmptyAdjacentLocations-EDGE #2");
		
		
		

		/*********************************************************************/
		/*  Testing the middle #1 - 6 empty adjacent locations to middle     */
		/*********************************************************************/
		//clear the board from the previous test case
		board = new BoundedGrid(8);
		
		theLoc = new Location(1,1);
		board.put(new Location(0,0), "B");
		board.put(new Location(0,1), "B");

		//Create answer KEY
		ArrayList<Location> middleLocs = new ArrayList<Location> ();
		middleLocs.add(new Location(0, 2));
		middleLocs.add(new Location(1, 0));
		middleLocs.add(new Location(1, 2));
		middleLocs.add(new Location(2, 0));
		middleLocs.add(new Location(2, 1));
		middleLocs.add(new Location(2, 2));

		adjLocs = board.getEmptyAdjacentLocations(theLoc);

		CompareListUtility.compareLocationLists(middleLocs, adjLocs, "test_getEmptyAdjacentLocations-MIDDLE #1");

		
		/*********************************************************************/
		/*  Testing the middle #2 - 2 empty adjacent locations to middle     */
		/*********************************************************************/
		//clear the board from the previous test case
		board = new BoundedGrid(8);
		
		theLoc = new Location(1,1);
		board.put(new Location(0,0), "B");
		board.put(new Location(0,1), "B");
		board.put(new Location(0,2), "B");
		board.put(new Location(1,0), "B");
		board.put(new Location(1,2), "B");
		board.put(new Location(2,0), "B");

		//Create answer KEY
		middleLocs = new ArrayList<Location> ();
		middleLocs.add(new Location(2, 1));
		middleLocs.add(new Location(2, 2));

		adjLocs = board.getEmptyAdjacentLocations(theLoc);

		CompareListUtility.compareLocationLists(middleLocs, adjLocs, "test_getEmptyAdjacentLocations-MIDDLE #2");
	}

	//----------------------------------------------------------------------

	public static void main(String[] args)
	{
		//Note....no parameters are included here.  They will be added in the 
		//tester methods that are called here.
		
		//Comment out the methods that are not being tested.

		System.out.println();
		test_getOccupiedLocs();
		System.out.println();
		test_getOccupiedAdjacentLocs();
		System.out.println();
		test_isValid();
		System.out.println();
		test_getValidAdjacentLocations();
		System.out.println();
		test_getEmptyAdjacentLocations();
		System.out.println();

	}
}