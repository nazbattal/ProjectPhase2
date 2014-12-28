package game;



import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Set;
import java.util.Timer;



import Domain.Lokum;




public class Board  {
	
	
	public int BoardWidth;
	public int BoardHeight;
	public Lokum[][] boardState;
	public Domain.Lokum firstPressedLokum;
	public Domain.Lokum secondPressedLokum;
	public String combinationType;
	public String combinationCode;
	public int remainingMoves;
	public int currentScore;
	public int NumOfMoves;
	
	
	
	
	public Lokum[][] getBoardState() {
		return boardState;
	}

	public void setBoardState(Lokum[][] boardState) {
		this.boardState = boardState;
	}

	public void setRemainingMoves(int remainingMoves) {
		this.remainingMoves = remainingMoves;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}

	public int getCurrentScore() {
		
		return currentScore;
	}
	
	public int getRemainingMoves() {
		
		return remainingMoves;
	}

	public int getNumOfMoves() {
		// TODO Auto-generated method stub
		return NumOfMoves;
	}

	public void start() {
		// TODO Auto-generated method stub
		
	}



	


	
	
	

}
		
	
	
	
	
	
	

	
	
	
