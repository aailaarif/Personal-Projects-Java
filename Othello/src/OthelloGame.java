import java.util.ArrayList;

public class OthelloGame
{
	private OthelloPlayer humanPlayer;		//human Othello player
	private OthelloPlayer compPlayer;		//computer Othello player
	private Grid board;						//board

	//----------------------------------------------------------------------------------
	public OthelloGame()
	{
	
		//testing entire game with a 4 x 4
		board = new BoundedGrid(4);

		//testing entire game with an 8 x8 instead of 4 x 4. Try this after 4 x 4 works.
		//board = new BoundedGrid(8);

		//initialize the humanPlayer object
		humanPlayer=new HumanOthelloPlayer("Human", "B");
		
		//initialize the compPlayer object
		compPlayer=new StupidComputerPlayer("Computer", "W");
		
		initializeBoard();
	}
	//----------------------------------------------------------------------------------
	//Description:  This method places the "B"'s and "W"'s in the appropriate 
	// 				place on the game board. Pretend you don't know the size of 
	// 				the board - i.e. write generically.

	//Postcondition: "B"'s and "W"'s are placed in the appropriate place on the
	//				 board.

	private void initializeBoard()
	{
		int midRow=board.getNumRows()/2;
		int midCol=board.getNumCols()/2;
		board.put(new Location(midRow,midCol), "B");
		board.put(new Location(midRow-1,midCol-1), "B");
		board.put(new Location(midRow,midCol-1), "W");
		board.put(new Location(midRow-1,midCol), "W");	
	}
	//----------------------------------------------------------------------------------
	/*
	The playGame method (below) has the players alternate moves until the board is filled or both
	players have no legal moves.  A winner is then declared.

	When it's the human's turn, all legal moves are displayed on the screen.  If there are legal
	moves, the human is asked for a move (in another method).  The move is made and the board is
	reconfigured according to the rules of the game.  If there are no legal moves, display a message
	stating there are no legal moves. Switch the player.

	When it's the computer's turn, all legal moves are displayed on the screen.  If there are legal
	moves, a random move is selected (not in this method).   The move is made and the board is
	reconfigured according to the rules of the game.  If there are no legal moves display a message
	stating there are no legal moves. Switch the player.

	This method calls other methods to help do its job.
	*/

	public void playGame()
	{
		//your local variables that are needed go here.
		OthelloPlayer currPlayer=humanPlayer;
		OthelloPlayer theWinner=null;
		boolean contGame=true;

		while (contGame==true)	//keep playing while the game is not over
		{
			//display the board
			board.display();
			
			//display who is taking a turn
			System.out.println(currPlayer.name + " - your turn.");
			//Get the legal moves.
			ArrayList <Location> legMoves= getLegalMoves(currPlayer.color);
			//display the legal moves to the user or display no moves are left.

			//Get a VALID move from the list of legal moves just generated (or
			//no move if none exist)
			Location theMove=currPlayer.getMove(legMoves);
			if(theMove!=null)
			{
				System.out.println("MOVING TO: " + theMove.toString());
				updateBoard(theMove, currPlayer.color);
			}
			else
			{
				System.out.println("There are no moves possible for " + currPlayer.name);
			}
		
			if((getLegalMoves(humanPlayer.color).size()==0) && (getLegalMoves(compPlayer.color).size()==0))
			{
				board.display();
				int bCount=0;
				int wCount=0;
				for(int a=0; a<board.getNumRows(); a++)
				{
					for(int b=0; b<board.getNumCols(); b++)
					{
						if(board.get(new Location(a,b))!=null)
						{
							String returned=board.remove(new Location(a,b));
							if(returned.equals(humanPlayer.color))
								bCount++;
							else
								wCount++;
						}
					}
				}
				if(bCount>wCount)
					theWinner=humanPlayer;
				else if(wCount>bCount)
					theWinner=compPlayer;
				else
					theWinner=null;
				contGame=false;
			}
			//Check for a winner and provide code if a winner exists.
			//switch the current player
			if(currPlayer.equals(humanPlayer))
				currPlayer=compPlayer;
			else
				currPlayer=humanPlayer;
		}
		if(theWinner!=null)
			System.out.println(theWinner.name + " wins!");
		else
			System.out.println("It's a tie!");
	}

	
	//----------------------------------------------------------------------------------
	//Precondition:  The player's current color is received.
	//Postcondition: Returns an ArrayList of non-duplicate Locations that
	//				 contain the legal moves for that color.
	public ArrayList<Location> getLegalMoves(String curColor)
	{
		ArrayList<Location> legalMoves= new ArrayList<Location>(); //hold legal moves
		ArrayList<Location> occLocs= new ArrayList<Location>(); //hold occupied locations
		occLocs=board.getOccupiedLocs();
		for (int i = 0; i < occLocs.size(); i++)
		{
			boolean isVal;
			isVal=board.isValid(occLocs.get(i));
			if ((isVal!=false) && board.get(occLocs.get(i)) != null && !(board.get(occLocs.get(i)).equals(curColor))) 
			{
				ArrayList <Location> emptyAdj = new ArrayList<Location>(); 
				emptyAdj=board.getEmptyAdjacentLocations(occLocs.get(i));
				for (int a = 0; a < emptyAdj.size(); a++)
				{
					if ((validMove(emptyAdj.get(a), occLocs.get(i), curColor)==true))
				 		legalMoves.add(emptyAdj.get(a)); 
				}
			}
		}
		//to remove duplicates
		isDuplicate(legalMoves);
		return legalMoves;	
	}
	
	//pre condition: receives an arraylist of Location objects
	//post: returns an arraylist of non duplicate location objects
	public ArrayList<Location> isDuplicate(ArrayList<Location> noDupes)
	{
		for (int i = 0; i < noDupes.size(); i++)
		{
			for (int j = i + 1; j < noDupes.size(); j++)
			{
				if (noDupes.get(i).equals(noDupes.get(j)))
				{
					noDupes.remove(j);
					j--;
				}
			}
		}
		return noDupes;
	}
	//pre condition: receives two valid locations with a color labeled either "B" or "W"
	//post condition: returns true if the location is valid and the player can play there, false if not
	public boolean validMove(Location targetLoc, Location occLoc, String currColor)
	{
		int direction = targetLoc.getDirectionToward(occLoc);
		Location nextSpot = occLoc.getAdjacentLoc(direction);
		boolean isVal=true;
		while (board.isValid(nextSpot)==true && board.get(nextSpot) != null) 
		{
			isVal=board.isValid(nextSpot);
			if (board.get(nextSpot).equals(currColor))
				return true;
			else
				nextSpot = nextSpot.getAdjacentLoc(direction); 
		}
		
		return false;
	}
	
	//----------------------------------------------------------------------------------
		//Precondition:   receives a valid Location representing where player has 
		//				  chosen to move.
		//				  receives the String value to place in the Location
		//Postcondition:  updates the Location with the String given.  All other locations are 
		//				  updated (flipped)according to the game rules.
		public void updateBoard(Location nextMove, String targetString)
		{
			Location nextLoc;
			int dirTowards;
			ArrayList <Location> adjLoc= board.getOccupiedAdjacentLocs(nextMove);
			
			for (int i=0; i<adjLoc.size(); i++)
			{
				dirTowards= nextMove.getDirectionToward(adjLoc.get(i));
				nextLoc=nextMove.getAdjacentLoc(dirTowards);
				if(validMove(nextMove,nextLoc,targetString)==true)
				{
					board.put(nextMove, targetString);
					
					while(board.isValid(nextLoc) && board.get(nextLoc) != null && !(board.get(nextLoc).equals(targetString)))//check if valid location and that it isn't equal to targetString
					{
						board.put(nextLoc, targetString);
						nextLoc=nextLoc.getAdjacentLoc(dirTowards);
					}
				}
			}
		}
}