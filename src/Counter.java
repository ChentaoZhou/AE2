//Yirong Li 2458304l

public class Counter {
	private Player player;
	//Constructor
	public Counter(Player player){
			this.player = (Player) player;
	}
	//Getter
	public Player getPlayer() {
		return player;
	}

/*	Method toString:
	returns the symbol of the player as a String.
 */
	public String toString(){
		//Get the symbol from the player and cast the character into String.
		String thisSymbol = Character.toString(player.getSymbol());
		return thisSymbol;
	}
	
/*	Method equals:
 	Input an object;
 	returns true when the input object is a counter and has the same player as this counter;
 	returns false otherwise.
 */
	public boolean equals(Object c){
		if(c instanceof Counter){
			Counter otherC = (Counter)c;
			if(this.player == otherC.getPlayer())return true;
			else return false;
		}else {
			System.out.println("Wrong type.");
			return false;
		}
	}
	

}
