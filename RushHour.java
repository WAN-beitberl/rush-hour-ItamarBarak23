import java.util.*;

// Rush hour game
public class RushHour {
	  static final int ROWS = 6;
	  static final int COLUMNS = 6;

	  static char[][] board = new char[ROWS][COLUMNS];
	  static car[] cars = new car[4];
	  static truck[] trucks = new truck[4];
	  
	  public static Scanner in = new Scanner(System.in);
	  public static void main(String[] args) 
	  {
	    initializeGrid();
	    System.out.println("Welcome to Rush Hour!");
	    System.out.println("Move the 'x' car to the right most column to win the game");
	    printBoard();
	    
	    // The game loop
	    while (cars[0].col != COLUMNS - 2) 
	    {
	        if (makeMove()) 
	        {
	            System.out.println("Move successful!");
	            printBoard();
	        } 
	        else 
	        {
	            System.out.println("Invalid move. Try again.");
	        }
	    }
	    System.out.println("Congratulations! You won the game!");
	  }

	  static void initializeGrid() 
	  {
	    // Initialize the board
	    board[0] = new char[]{'.', '.', 'P', 'R', 'R', 'R'};
	    board[1] = new char[]{'.', '.', 'P', 'Q', '.', '.'};
	    board[2] = new char[]{'X', 'X', 'P', 'Q', '.', '.'};
	    board[3] = new char[]{'B', '.', '.', 'Q', '.', 'T'};
	    board[4] = new char[]{'B', 'C', 'C', '.', '.', 'T'};
	    board[5] = new char[]{'.', '.', 'A', 'A', '.', 'T'};
	    cars[0] = new car(2, 0, 'X', 'C');
	    cars[1] = new car(5, 2, 'A', 'C');
	    cars[2] = new car(3, 0, 'B', 'R');
	    cars[3] = new car(4, 1, 'C', 'C');
	    trucks[0] = new truck(1, 3, 'Q', 'R');
	    trucks[1] = new truck(0, 3, 'R', 'C');
	    trucks[2] = new truck(3, 5, 'T', 'R');
	    trucks[3] = new truck(0, 2, 'P', 'R');
	    }

	  static boolean makeMove()
	  // Makes moves of each car
	  {
          System.out.println("Enter car to move");
		  char c = in.next().charAt(0);
		  int carIndex = 100, truckIndex = 100;
		  switch(c)
		  {
		  case 'X':
		      carIndex = 0;
		      break;
		  case 'A':
		      carIndex = 1;
		      break;
		  case 'B':
		      carIndex = 2;
		      break;
		  case 'C':
		      carIndex = 3;
		      break;
		  case 'Q':
		      truckIndex = 0;
		      break;
		  case 'R':
		      truckIndex = 1;
		      break;
		  case 'T':
		      truckIndex = 2;
		      break;
		  case 'P':
		      truckIndex = 3;
		      break;
		  default:
			  return false;
		  }
		  car car;
		  truck truck;
		  if(carIndex != 100)
		  {
		      car = cars[carIndex];
		      if(car.dir == 'C')
		      {
		          System.out.println("Enter the direction to move the car (L, R):");
		          char direction = in.next().charAt(0);
		           if (direction == 'L' && car.canMoveLeft(board)) 
		               car.moveLeft(board); 
		           else if (direction == 'R' && car.canMoveRight(board)) 
		               car.moveRight(board); 
		           else
		               return false;
		      }
		      else
		      {
		          System.out.println("Enter the direction to move the car (U, D):");
			      char direction = in.next().charAt(0);
		          if (direction == 'U' && car.canMoveUp(board)) 
		              car.moveUp(board);  
		          else if (direction == 'D' && car.canMoveDown(board)) 
		              car.moveDown(board); 
		          else 
		              return false;
		      }
		   }
		   else
		   {
		       truck = trucks[truckIndex];
		       if(truck.dir == 'C')
		       {
		           System.out.println("Enter the direction to move the car (L, R):");
		           char direction = in.next().charAt(0);
		           if (direction == 'L' && truck.canMoveLeft(board)) 
		               truck.moveLeft(board); 
		           else if (direction == 'R' && truck.canMoveRight(board)) 
		               truck.moveRight(board); 
		           else
		               return false;
		    	}
		    	else
		    	{
		    	    System.out.println("Enter the direction to move the car (U, D):");
		            char direction = in.next().charAt(0);
		            if (direction == 'U' && truck.canMoveUp(board)) 
		        	    truck.moveUp(board);  
		            else if (direction == 'D' && truck.canMoveDown(board)) 
		                truck.moveDown(board); 
		            else 
		                return false;
		    	}
		    }
		    return true;
		  }


	static void printBoard()
	// Print the board
	{
	    for (int row = 0; row < ROWS; row++) 
	    {
	        for (int col = 0; col < COLUMNS; col++) 
	        {
	            System.out.print(board[row][col] + " ");
	        }
	        System.out.println();
	    }
	}
}