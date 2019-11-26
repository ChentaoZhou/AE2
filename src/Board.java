//Yirong Li 2458304l

public class Board {
	int rows;
	int columns;
	Column[] cols;	//This is the array of the columns in this board.
//Constructor	
	public Board(int rows, int columns){
		this.rows = rows;
		this.columns = columns;
		
		cols = new Column[columns];
		for(int i = 0; i < columns; i++){
			cols[i] = new Column(rows);	//Form the empty board with empty columns.
		}
	}
/*	Method add:
 	Input a Counter object and the number of column where the counter is dropped.
  	return true when the operation success;
  	return false otherwise.
 */	
	public boolean add(Counter c, int colNum){
		boolean result = cols[colNum].add(c);	//Calls the add method of the specific column, add the counter into it. 
		if(result)System.out.println(this.toString());	//Print the board if the add operation succeed.
		return result;
	}
/*	Method toString:
	Print the board.
 */
	public String toString(){
		String board = "|";
		for(int i = 0; i < columns; i++){
			board += (i + "|");	//Add the first line of the board(column numbers).
		}
		board += "\n";
		for(int i = 0; i < columns; i++){
			board += "--";//Add the ---- line.
		}
		board += "\n";
		for(int i = 0; i < rows; i++){
			board += "|";
			for(int j = 0; j < columns; j++){	//Print the counter of each column in each row.
				board += cols[j].displayRow(i) + "|";
			}
			board += "\n";
		}
		return board;
	}
	
/*	Method isFull:
 	Returns true if the board is full;
 	returns false otherwise.
 */
	public boolean isFull(){
		boolean result = true;
		for(int i = 0; i < columns; i++){
			if (cols[i].isFull() != true) result = false;
		}
		return result;
	}
	
/*	Method winnerCheck:
 	Input the number of continuous counters that requires to win;
 	return true and print the player who wins the game if someone wins;
 	return null if no one wins yet. 
 */	
	public boolean winnerCheck(int z){ 
		
		/* 1. Vertical check */		
		
		if(verticalCheck(z))
			{return true;}
			
			
		/* 2. Horizontal check */
		
		if(horizontalCheck(z))
		{return true;}

		
		/* 3. Diagonal check */
		
		if(diagonalCheck(z))
		{return true;}
		
		return false;	
	}
	
	
	
	
	/* 1. Vertical check
	 * Check whether there is a winner wins vertically.
	 * Return true and print the message if their is a winner. */
	
	public boolean verticalCheck(int z){	
		for(int i = 0; i < columns; i++){		//Check every columns.
			Counter[] counts = cols[i].getCounts();		//Get the Counters in this column.
			Player winner = checkLine(counts, z);
			/*	This checkLine method returns the player that wins if 
			there are Z counters belongs to the same person in the line, 
			otherwise return null. */
			if(winner!=null){
				System.out.println("Game over!\nVertical check: " + winner.getName() + " wins the game.");
				return true;
			}
		}
		return false;	
	}
	
	/* 2. Horizontal check
	 * Check whether there is a winner wins horizontally.
	 * Return true and print the message if their is a winner. */
	
	public boolean horizontalCheck(int z){	
		for(int i = rows-1; i >= 0; i--){		//Check every rows.
			Counter[] counts = new Counter[columns];
			for(int j = 0; j < columns; j++){
				counts[j] = cols[j].getCounts()[i];	//Get the Counters in this row. Start from the bottom row. 
			}
			Player winner = checkLine(counts, z);	//Pass the row into the checkLine method. 	
			if(winner!=null){		
				System.out.println("Game over!\nHorizontal check: " + winner.getName() + " wins the game.");
				return true;
			}
			
		}
		return false;	
	}
	
	/* 3. Diagonal check
	 * Check whether there is a winner wins diagonally.
	 * Return true and print the message if their is a winner. */
	
	public boolean diagonalCheck(int z){	
		/* For the diagonal check, I have to put the diagonal lines
		   which are longer than Z into the checkLine method.(Those possibly contains a winning line)
		   The lines can be divided  into two categories: gradient=-1 and gradient=1.
		   */
		
			/* (1) In the direction that gradient = 1 */
		
				/* i. Check the lines above the longest diagonal line of the board */
		int maxLength;
		if(rows>=columns) maxLength = rows;
		else maxLength = columns;
		for(int i = z-1; i < rows; i++){
			Counter[] counts = new Counter[maxLength];
			for(int j = 0; j <= i; j++){
				counts[j] = cols[j].getCounts()[i-j];
	//			System.out.println(counts[j]);
				Player winner = checkLine(counts, z);	
				if(winner!=null){		
					System.out.println("Game over!\nDiagonal check: " + winner.getName() + " wins the game.");
					return true;
				}
			}
		}
				/* ii. Check the lines under the longest diagonal line of the board */
		for(int i = 1; i <= columns-z; i++){	
			Counter[] counts = new Counter[maxLength];
			for(int j = 0; j < rows-(i-1); j++){
				counts[j] = cols[i+j].getCounts()[rows-1-j];
		//		System.out.print(counts[j]+",");
				Player winner = checkLine(counts, z);	 	
				if(winner!=null){		
					System.out.println("Game over!\nDiagonal check: " + winner.getName() + " wins the game.");
					return true;
				}			
			}//System.out.println();
		}

			/* (1) In the direction that gradient = -1 */
		
				/* i. Check the lines above the longest diagonal line of the board */

		for(int i = z-1; i < rows; i++){
			Counter[] counts = new Counter[maxLength];
			for(int j = 0; j <= i; j++){
				counts[j] = cols[columns-1-j].getCounts()[i-j];
	//			System.out.println(counts[j]);
				Player winner = checkLine(counts, z);	
				if(winner!=null){		
					System.out.println("Game over!\nDiagonal check: " + winner.getName() + " wins the game.");
					return true;
				}
			}
		}
				/* ii. Check the lines under the longest diagonal line of the board */
		for(int i = 1; i <= columns-z; i++){	
			Counter[] counts = new Counter[maxLength];
			for(int j = 0; j < rows-(i-1); j++){
				counts[j] = cols[columns-i-j].getCounts()[rows-1-j];
//				System.out.print(counts[j]+",");
				Player winner = checkLine(counts, z);	 	
				if(winner!=null){		
					System.out.println("Game over!\nDiagonal check: " + winner.getName() + " wins the game.");
					return true;
				}			
			}//System.out.println();
		}		
		return false;	
	}
	
	
	
	/* Method checkLine: 
	   This is called in the winnerCheck method for several times.
	   Take a Counter array, the length of it and Z as inputs.
	   To check every z continuous counters in a line, 
	   start from the first counter, which is counts[length-1].
	   In total have to check length-z-1 times to cover the whole line.
	 */
	public Player checkLine(Counter[] counts, int z){
		for(int j = counts.length-1; j >= z-1; j--){	 
			boolean b = true;	//A checking flag.
			for(int k = 1; k < z; k++){	//For one counter counts[j], check those (z-1) counters after it in the line.
				int compareIndex = j-k;
				if(counts[j]!=null && counts[compareIndex]!=null){	//Check only when there is a counter at this position, instead of null.
					b = counts[j].equals(counts[compareIndex]);	
				}
				else {b = false;}
				if(!b) break;	//Stop checking once b changes to false. Which means there is a counter belongs to another player in this n counters.   
			}
			if(b){	//If b is still true after the loop, that means those n checked counters belongs to the same player, the winner.
				return counts[j].getPlayer();	
			}
		}
		return null;	
	}

}



