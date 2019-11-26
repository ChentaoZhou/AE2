//Yirong Li 2458304l

public class Column {
	private int numRows;
	private Counter[] counts;
	//Constructor
	public Column(int numRows){
		this.numRows = numRows;
		counts = new Counter[numRows];	//Number of rows decides the size of the array.(How many counters can a row take.)
	}

	//Getter for the Counter array.(Used in Board.checkWinner)
	public Counter[] getCounts(){
		return counts;
	}
	
	
/*	Method isFull:
	returns true if the column is full;
	else returns false.
*/
	public boolean isFull(){
		if(counts[0] != null) return true;
		else return false;
	}
	
/*	Method add:
	Input a Counter object;
	If the column is not full, the Counter will be added to the correct position and return true;
	If the column is full, return false.
 */
	public boolean add(Counter counter){
		if(this.isFull())return false;
		else{
			for(int i = numRows-1; i >= 0; i--){
				if(counts[i] == null){
					counts[i] = counter;
					break;
				}
			}
			return true;
		}
	}
/*	Method displayRow:
 	Input a row number; 
	assume that the row number is always within an acceptable range;
	return a String consisting of the counter’s character if there is a counter at that position;
 	return a String including a space character if there is no counter in that position.
 */
	public String displayRow(int rowNum){
		if(counts[rowNum] != null) return counts[rowNum].toString();
		else return " ";
	}
/*	Method display:
	Display the rows on different lines.
 */
	public void display(){
		for(int i = 0; i < numRows; i++){
			System.out.println(displayRow(i));
		}
	}
	

}
