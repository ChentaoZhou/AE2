//Yirong Li 2458304l

import java.util.*;
public class ConnectFour {

	public static void main(String[] args) {

		/* Demo 1: Player and Counter toString */
		
//		Player p1 = new Player( "Clive" , 'x' );
//		Counter c = new Counter(p1);
//		System.out.println(c.getPlayer().toString() + ", " +c.toString());
//		
//		Column col = new Column( 4 );
//		for ( int i= 0 ;i< 5 ;i++) {
//		Boolean result = col.add( new Counter(p1));
//		System.out.println(result);
//		}
		
		/* Demo 2: Operation of a column */
		
//		Column col = new Column( 6 );
//		Player p1 = new Player( "Clive" , 'o' );
//		Player p2 = new Player( "Sharon" , 'x' );
//		for ( int i= 0 ;i< 3 ;i++) {
//		col.add( new Counter(p1));
//		col.add( new Counter(p2));
//		}
//		col.display();
		
		/* Demo 3: Playing in a board */
		
//		Board board = new Board( 6 , 7 );
//		Player p1 = new Player( "Clive" , 'o' );
//		Player p2 = new Player( "Sharon" , 'x' );
//		board.add( new Counter(p2), 6 );
//		board.add( new Counter(p1), 3 );
//		board.add( new Counter(p2), 4 );
//		board.add( new Counter(p1), 4 );
//		board.add( new Counter(p2), 5 );
//		board.add( new Counter(p1), 5 );
//		board.add( new Counter(p2), 6 );
//		board.add( new Counter(p1), 5 );
//		board.add( new Counter(p2), 6 );
//		board.add( new Counter(p1), 6 );
//		board.winnerCheck(4);
		
		/* Demo 4: Random playing */
		
//		randomPlay( 6, 7);
		
		/* Demo 5: Random playing and check the winner*/
		
		randomWinner( 6, 7);



	}
/*	Static method randomPlay:
 	Two virtual players play randomly until the board is full.
 	Input the size of the board(rows, columns).
 */
	public static void randomPlay(int rows, int columns){
		Board board = new Board( rows , columns );
		Player p1 = new Player( "Clive" , 'o' );
		Player p2 = new Player( "Sharon" , 'x' );
		while(!board.isFull()){//Game goes on if the board is not full.	
			Random rand = new Random();
			/*	There are loops to make sure players have successfully dropped a counter in an available column.
			 * 	When the add operation failed, the loops continues.
			 * 	When the method returns true, the loops ends.
			 */	
			boolean p1Move = false;
			while(!p1Move){
				p1Move = board.add( new Counter(p1), rand.nextInt(columns));
			}
			
			boolean p2Move = board.isFull();//p2 will not drop a counter if the board is full after p1's dropping.
			while(!p2Move){
				p2Move = board.add( new Counter(p2), rand.nextInt(columns));
			}	
		}
	}
	
	
	/*	Static method randomWinner:
 	Same as the Random play method, but can recognize a winner. 
	 */
	public static void randomWinner(int rows, int columns){
		Board board = new Board( rows , columns );
		Player p1 = new Player( "Clive" , 'o' );
		Player p2 = new Player( "Sharon" , 'x' );
		
		while(!board.isFull()){//Game goes on if the board is not full.	]
			Random rand = new Random();
			/*	There are loops to make sure players have successfully dropped a counter in an available column.
			 * 	When the add operation failed, the loops continues.
			 * 	When the method returns true, the loops ends.
			 */	
			boolean p1Move = false;
			while(!p1Move){
				p1Move = board.add( new Counter(p1), rand.nextInt(columns));
			}			
			if(board.winnerCheck(4))break;		
			boolean p2Move = board.isFull();//p2 will not drop a counter if the board is full after p1's dropping.
			while(!p2Move){
				p2Move = board.add( new Counter(p2), rand.nextInt(columns));
			}			
			if(board.winnerCheck(4))break;		
		}
	}

}
