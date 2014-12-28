package game;


import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.Random;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.JPanel;



import Domain.Lokum;






public class ChewyLokumLegend  {


	public Lokum firstPressedLokum;
	public Lokum secondPressedLokum;
	String combinationType;
	public int combinationCode;
	private int currentScore;
	private int goalScore;
	public int numOfMoves;
	public int remainingMoves = 20;
	private int count = 0;
	public Lokum[][] boardState;
	public static JPanel board;
	Timer timer;
	
	
	
	public ChewyLokumLegend() {
		startGame();
		moveDown(boardState);
		
	}
	
	
	public void startGame()
	{
		
		numOfMoves = 0;
	    boardState = new Lokum[9][9];
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				boardState[i][j] = generateRandomLokum(i,j);
				
			}}
		
	  }
	
	
	
	

	
	/**
	 * 
	 * @param bs
	 * @param lokum1: the first pressed lokum
	 * @param lokum2: the second pressed lokum
	 * @requires the lokums should be adjacent to each other the numOfMoves should be greater than 0
	 * @postcondition: wanted to change the places of the first pressed and the second pressed lokum
	 */
	
	
	
	
protected void swap(Lokum[][] bs,Lokum lokum1, Lokum lokum2){
		
		
		if (isAdjacent(lokum1, lokum2)) {
			Lokum tempLokum;
			
			tempLokum= lokum1;
			lokum1 = lokum2;
			lokum2 = tempLokum;
			

		
		
			if (isCombinationGenerated(bs)) {
				count=0;
				numOfMoves++;
				
			 if (combinationType == "horiz") {
				 if (combinationCode == 3) {
					 destroyLokumAt(bs,lokum1.getCoordX(),lokum1.getCoordY());
						destroyLokumAt(bs,lokum2.getCoordX(),lokum2.getCoordY());
						destroyLokumAt(bs,lokum2.getCoordX(), (Math.max(lokum1.getCoordY(), lokum2.getCoordY())+1));
					 
				 }
				 else if (combinationCode == 4) {
					 destroyLokumAt(bs,lokum1.getCoordX(),lokum1.getCoordY());
						destroyLokumAt(bs,lokum2.getCoordX(),lokum2.getCoordY());
						destroyLokumAt(bs,lokum2.getCoordX(), (Math.max(lokum1.getCoordY(), lokum2.getCoordY())+1));
						destroyLokumAt(bs,lokum2.getCoordX(), (Math.max(lokum1.getCoordY(), lokum2.getCoordY())+2));
						   
				 }
				 else {
					 destroyLokumAt(bs,lokum1.getCoordX(),lokum1.getCoordY());
						destroyLokumAt(bs,lokum2.getCoordX(),lokum2.getCoordY());
						destroyLokumAt(bs,lokum2.getCoordX(), (Math.max(lokum1.getCoordY(), lokum2.getCoordY())+1));
						destroyLokumAt(bs,lokum2.getCoordX(), (Math.max(lokum1.getCoordY(), lokum2.getCoordY())+2));
						destroyLokumAt(bs,lokum2.getCoordX(), (Math.max(lokum1.getCoordY(), lokum2.getCoordY())+3));
						      
				 }
			 }
			 
				 
			 
			 else if (combinationType == "vertical") {
				 if (combinationCode == 3) {
					 destroyLokumAt(bs,lokum1.getCoordX(),lokum1.getCoordY());
						destroyLokumAt(bs,lokum2.getCoordX(),lokum2.getCoordY());
						destroyLokumAt(bs,(Math.max(lokum1.getCoordX(), lokum2.getCoordX())+1), lokum1.getCoordY());
					 
				 }
				 else if (combinationCode == 4) {
					 destroyLokumAt(bs,lokum1.getCoordX(),lokum1.getCoordY());
						destroyLokumAt(bs,lokum2.getCoordX(),lokum2.getCoordY());
						destroyLokumAt(bs,lokum2.getCoordX(), (Math.max(lokum1.getCoordY(), lokum2.getCoordY())+1));
						destroyLokumAt(bs,(Math.max(lokum1.getCoordX(), lokum2.getCoordX())+1), lokum1.getCoordY());
						destroyLokumAt(bs,(Math.max(lokum1.getCoordX(), lokum2.getCoordX())+2), lokum1.getCoordY());
						     
				 }
				 else {
					 destroyLokumAt(bs,lokum1.getCoordX(),lokum1.getCoordY());
						destroyLokumAt(bs,lokum2.getCoordX(),lokum2.getCoordY());
						destroyLokumAt(bs,(Math.max(lokum1.getCoordX(), lokum2.getCoordX())+1), lokum1.getCoordY());
						destroyLokumAt(bs,(Math.max(lokum1.getCoordX(), lokum2.getCoordX())+2), lokum1.getCoordY());
						destroyLokumAt(bs,(Math.max(lokum1.getCoordX(), lokum2.getCoordX())+3), lokum1.getCoordY());
						      
				 }
				 
			 }
			
		 }}else if (count == 1) {count=0; System.out.println("no combination or not adjacent, either way no swap!!");}
		
		 else {count++; swap(bs,lokum1,lokum2); 
		}}
	
	
	

	
	
	protected boolean hasDownMoves(Lokum[][] bs){
		
		for (int i=0; i<9; i++) { 
			for (int j=0; j<9; j++) { 
		       if (boardState[i][j]== null )
		    	   return true;  	   
		       }}
		
		 return false;
		}
	
	protected void moveDown(Lokum[][] bs){
		
		while (hasDownMoves(bs)) {
			for (int i=0; i<9; i++) {
				for (int j=0; j<9; j++) {
					if (bs[i][j]==null) 
						{if (i==0) {bs[0][j] = generateRandomLokum(i , j);}
						else {bs[i][j] = bs[i-1][j];}}
				}}}}
	
	
	/**
	 * 
	 * @param x : the x coordinate where the random lokum will place at
	 * @param y : the y coordinate where the random lokum will place at
	 * @requires empty places which the lokums are destroyed 
	 * @postcondition a randomly chosen lokum get into that places
	 */
	public Lokum generateRandomLokum(int x, int y) {
		int id;
		Lokum lok = new Lokum();
		Random rn = new Random();
		id = rn.nextInt(4) + 0;
		lok.setLokum(id,x, y);
		
		return lok;
		
	}
	
 
	/**
	 * 
	 * @param lok1: the first pressed lokum
	 * @param lok2: the second pressed lokum
	 * @postcondition  it looks if the pressed lokums are next to each other 
	 * @effects if it is true the lokums can swap so it affects swap 
	 */
	protected boolean isAdjacent(Lokum lok1, Lokum lok2) {
		
	int x1 = lok1.getCoordX();
	int y1 = lok1.getCoordY();
	int x2 = lok2.getCoordX();
	int y2 = lok2.getCoordY();
		
		if (x1 == x2  &&  (y1 == (y2 + 1) || y1 == (y2- 1))) {
			return true;
		}else if (y1 == y2  && (x1 == (x2 + 1) || x1 == (x2 - 1))){
			return true;
		}else if (x1 == (x2 + 1) && y1 == (y2 - 1)) {
			return true;
		}else if (x1 == (x2 + 1) && y1 == (y2 + 1)) {
			return true;
		}else if (x1 == (x2 - 1) && y1 == (y2 + 1)) {
			return true;
		}else if (x1 == (x2 - 1) && y1 == (y2 - 1)) {
			return true;
		}else {return false;}
		
		
	}
	
	
	/**
	 * 
	 * @requires 3 or more lokums are combined, next to each other.
	 * @postcondition if isCombinationGenerated occurs, destroyLokumAt occurs, the lokums are deleted from that places, numOfMoves 
	 * decreases by one. Score increases.  generateRandomLokum occurs for that places.
	 */
	boolean isCombinationGenerated(Lokum[][] bs) {

		
		if (loopForHoriz(bs)) return true;
		else if (loopForVert(bs)) return true;
		else return false;}

	
	boolean loopForHoriz(Lokum[][] bs) {
		int c=0;
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (j==8 && c>1) {combinationType = "horiz"; return true;}
				else if(j==8) continue;
				if(bs[i][j].getLokumID() == bs[i][j + 1].getLokumID()) {
					c++;}
				else if(c>1) {combinationCode=c+1; combinationType = "horiz"; c=0;  return true;}
				else {c=0;}}}return false;}
		
	boolean loopForVert(Lokum[][] bs) {
		int c=0;
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (j==8 && c>1) {combinationType = "vertical"; return true;}
				else if(j==8) continue;
				if(bs[j][i].getLokumID() == bs[j+1][i].getLokumID()) {
					c++;}
				else if(c>1) {combinationCode=c+1; combinationType = "vertical"; c=0;  return true;}
				else {c=0;}}}return false;}
	
	
		
	
	
		
	/**
	 * @param x   the place where the destroyed lokum at x coordinate
	 * @param y    the place where the destroyed lokum at y coordinate
	 * @requires   isCombinationGenerated occurs.
	 * @postcondition    The lokums are deleted from that places, numOfMoves decreases by one. Score increases. 
	 *              generateRandomLokum for that places.
	 */
		
	
	
	void destroyLokumAt (Lokum[][] bs, int x, int y) {
		bs[x][y] = null;
		
	}
	
	
	
	/**
	 * @requires destroyed time lokum
	 * @postcondition adding time to the remaining time if a time lokum is destroyed. the additional time increases by the number of destroyed
	 * time lokum
	 */
	
	
	public void addAdditionalTime(){
		
		
		
	}
	
	
	public void updateBoard() {
		while (hasDownMoves(boardState)) {
			moveDown(boardState);
		}
	}
		
		
	




public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	
}
	
public int getNumOfMoves() {
	return numOfMoves;
}




	
	
	
	
	public boolean repOk() {
		
		if (remainingMoves < 0)
			return false;

	if (board == null)
			return false;

		return true;
	}


	

	



	@Override
	public String toString() {
		return "ChewyLokumLegend [firstPressedLokum=" + firstPressedLokum
				+ ", secondPressedLokum=" + secondPressedLokum
				+ ", combinationType=" + combinationType + ", combinationCode="
				+ combinationCode + ", currentScore=" + currentScore
				+ ", goalScore=" + goalScore + ", numOfMoves=" + numOfMoves
				+ ", remainingMoves=" + remainingMoves + ", count=" + count
				+ ", boardState=" + Arrays.toString(boardState) + "]";
	}
}
