//Yirong Li 2458304l

public class Player {
	private String name;
	private char symbol;
	
	//Constructor
	public Player(String name, char symbol){
		this.name = name;
		this.symbol = symbol;
	}
	
	//Getters
	public String getName() {
		return name;
	}
	public char getSymbol() {
		return symbol;
	}

/*	Method toString:
	returns the name of this player as a String.
 */
	public String toString(){
		return name;
	}
	
	

}
