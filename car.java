// The car class
class car 
{
    int row;
	int col;
	char symbol;
	char dir;

	car(int row, int col, char symbol, char dir) 
	{
	    this.row = row;
	    this.col = col;
	    this.symbol = symbol;
	    this.dir = dir;
	}

	boolean canMoveLeft(char[][] board) 
	{
	    return col > 0 && board[row][col - 1] == '.'; 
	}

	boolean canMoveRight(char[][] board) 
	{
        return col < board.length - 2 && board[row][col + 2] == '.';
	}

	boolean canMoveUp(char[][] board) 
	{
	    return row > 0 && board[row - 1][col] == '.';
	}

	boolean canMoveDown(char[][] board) 
	{
	    return row < board.length - 2 && board[row + 2][col] == '.';
	}

	void moveLeft(char[][] board) 
	{
	    board[row][col + 1] = '.';
	    col--;
	    board[row][col] = symbol;
	}

	void moveRight(char[][] board) 
	{
	    board[row][col] = '.';
	    col++;
	    board[row][col + 1] = symbol;
	}

	void moveUp(char[][] board) 
	{
	    board[row + 1][col] = '.';
	    row--;
	    board[row][col] = symbol;
	}

	void moveDown(char[][] board) 
	{
	    board[row][col] = '.';
	    row++;
	    board[row + 1][col] = symbol;
	}
}

// The truck class
class truck extends car
{
    public truck(int row, int col, char symbol, char dir)
	{
		super(row, col, symbol, dir);
	}
	
	boolean canMoveLeft(char[][] board) 
	{
	    return col > 0 && board[row][col - 1] == '.'; 
	}

	boolean canMoveRight(char[][] board) 
	{
		return col < board.length - 3 && board[row][col + 3] == '.';
	}

	boolean canMoveUp(char[][] board) 
	{
	    return row > 0 && board[row - 1][col] == '.';
	}

	boolean canMoveDown(char[][] board) 
	{
	    return row < board.length - 3 && board[row + 3][col] == '.';
	}

	void moveLeft(char[][] board) 
	{
	    board[row][col + 2] = '.';
	    col--;
	    board[row][col] = symbol;
	}

	void moveRight(char[][] board) 
	{
	    board[row][col] = '.';
	    col++;
	    board[row][col + 2] = symbol;
	}

	void moveUp(char[][] board) 
	{
	    board[row + 2][col] = '.';
	    row--;
	    board[row][col] = symbol;
	}

	void moveDown(char[][] board) 
	{
	    board[row][col] = '.';
	    row++;
	    board[row + 2][col] = symbol;
	}
}