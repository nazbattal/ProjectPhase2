package game;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;




import Domain.Lokum;
import game.ChewyLokumLegend;

public class ChewyLokumLegendTest {
	private static Lokum lokum1,lokum2;

	ChewyLokumLegend chewyLokumLegend = new ChewyLokumLegend();
	

	@Before
	public void setUp() throws Exception {
		 lokum1 = new Lokum();
		 lokum2 = new Lokum();
		 chewyLokumLegend.boardState = new Lokum[9][9];
		 
	
	    for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) { chewyLokumLegend.boardState[i][j] = chewyLokumLegend.generateRandomLokum(i, j);}}
	   chewyLokumLegend.combinationType = null;
	   
		 
	}
			
			
	
	@Test 
	/** 
	 *
	 */
	public void testNull() {
		
		 assertTrue(chewyLokumLegend.boardState[8][8] != null);
	}
	

	@Test 
	/** 
	 * Test method for {@link Board#isAdjacent()}
	 */
	public void testIsAdjacent1() {
		lokum1 = chewyLokumLegend.boardState[2][3];
		 lokum2 = chewyLokumLegend.boardState[2][4];
		 assertTrue(chewyLokumLegend.isAdjacent(lokum1,lokum2) == true);
	}
	@Test 
	/** 
	 * Test method for {@link Board#isAdjacent()}
	 */
	public void testIsAdjacent2() {
		lokum1 = chewyLokumLegend.boardState[2][3];
		 lokum2 = chewyLokumLegend.boardState[2][2];
		 assertTrue(chewyLokumLegend.isAdjacent(lokum1,lokum2) == true);
	}
	
	@Test 
	/** 
	 * Test method for {@link Board#isAdjacent()}
	 */
	public void testIsAdjacent3() {
		lokum1 = chewyLokumLegend.boardState[1][2];
		 lokum2 = chewyLokumLegend.boardState[2][2];
		 assertTrue(chewyLokumLegend.isAdjacent(lokum1,lokum2) == true);
	}
	
	@Test 
	/** 
	 * Test method for {@link Board#isAdjacent()}
	 */
	public void testIsAdjacent4() {
		lokum1 = chewyLokumLegend.boardState[2][3];
		 lokum2 = chewyLokumLegend.boardState[2][5];
		 assertTrue(chewyLokumLegend.isAdjacent(lokum1,lokum2) == false);
	}
	
	@Test 
	/** 
	 * Test method for {@link Board#isAdjacent()}
	 */
	public void testIsAdjacent5() {
		lokum1 = chewyLokumLegend.boardState[2][2];
		 lokum2 = chewyLokumLegend.boardState[3][3];
		 assertTrue(chewyLokumLegend.isAdjacent(lokum1,lokum2) == false);
	}
	
	
	

	
	
	

	
	@Test 
	/** 
	 * Test method for {@link Board#destroyLokumAt(Lokum[][],int,int)}
	 */
	public void testDestroyLokumAt() {
		chewyLokumLegend.destroyLokumAt(chewyLokumLegend.boardState,1,1);
		assertTrue(chewyLokumLegend.boardState[2][2]==null);
		
	}
	



	
	@Test 
	/** 
	 * Test method for {@link Board#hasDownMoves(Lokum[][])}
	 */
	public void testHasDownMoves1() {
		chewyLokumLegend.boardState[1][1] = null;
		assertTrue(chewyLokumLegend.hasDownMoves(chewyLokumLegend.boardState)==true);
		
		}
	
	@Test 
	/** 
	 * Test method for {@link Board#hasDownMoves(Lokum[][])}
	 */
	public void testHasDownMoves2() {
		chewyLokumLegend.boardState[7][2] = null;
		assertTrue(chewyLokumLegend.hasDownMoves(chewyLokumLegend.boardState)==true);
		
			}
	
	
	@Test 
	/** 
	 * Test method for {@link Board#moveDown(Lokum[][])}
	 */
	public void testMoveDown1(){
		chewyLokumLegend.boardState[2][2] = null;
		chewyLokumLegend.moveDown(chewyLokumLegend.boardState);
		assertTrue(chewyLokumLegend.hasDownMoves(chewyLokumLegend.boardState)==false);
		
		

	}
	
	@Test 
	/** 
	 * Test method for {@link Board#moveDown(Lokum[][])}
	 */
	public void testMoveDown2(){
		chewyLokumLegend.boardState[1][2] = null;
		chewyLokumLegend.boardState[1][3] = null;
		chewyLokumLegend.boardState[1][4] = null;
		
		chewyLokumLegend.moveDown(chewyLokumLegend.boardState);
		assertTrue(chewyLokumLegend.hasDownMoves(chewyLokumLegend.boardState)==false);
			

	}
	
	@Test 
	/** 
	 * Test method for {@link Board#moveDown(Lokum[][])}
	 */
	public void testMoveDown3(){
		chewyLokumLegend.destroyLokumAt(chewyLokumLegend.boardState, 2,2);
		chewyLokumLegend.moveDown(chewyLokumLegend.boardState);
		assertTrue(chewyLokumLegend.boardState[2][2] != null);
		
		}
	
	
	@Test 
	/** 
	 * Test method for {@link Board#isCombinationGenerated(Lokum[][])}
	 */
	public void testIsCombinationGenerated() {
		
	lokum1 = chewyLokumLegend.boardState[0][3];
	lokum1.setLokumID(0);
	lokum2 = chewyLokumLegend.boardState[0][4];
	lokum2.setLokumID(0);
	Lokum lokum3 = new Lokum();
	lokum3= chewyLokumLegend.boardState[0][5];
	lokum3.setLokumID(0);
	
	assertTrue(chewyLokumLegend.isCombinationGenerated(chewyLokumLegend.boardState));
         
         
         
	}
	
	
	@Test 
	/** 
	 * Test method for {@link Board#loopForVert(Lokum[][])}
	 */
	public void testLoopForVert() {
		chewyLokumLegend.boardState[6][0].setLokumID(0);
		chewyLokumLegend.boardState[7][0].setLokumID(0);
		chewyLokumLegend.boardState[8][0].setLokumID(0);
		
		assertTrue(chewyLokumLegend.loopForVert(chewyLokumLegend.boardState));
		System.out.println("combination type :" + chewyLokumLegend.combinationType);
	}
	
	
	
	

	
	@Test 
	/** 
	 * Test method for {@link Board#swap(Lokum[][],Lokum,Lokum)}
	 */
	public void testSwap1() {
		 
		 lokum1 = chewyLokumLegend.boardState[6][0];
		 lokum2 = chewyLokumLegend.boardState[6][2];
		 Lokum lokum3 = new Lokum();
		 Lokum lokum4 = new Lokum();
		 lokum4 = chewyLokumLegend.boardState[6][1];
		 lokum3 = chewyLokumLegend.boardState[6][3];
		 lokum1.setLokumID(0);
		 lokum2.setLokumID(0);
		 lokum3.setLokumID(0);
		 
		 
		 chewyLokumLegend.swap(chewyLokumLegend.boardState,lokum1,lokum4);
		 assertTrue(chewyLokumLegend.boardState[6][0]==null && chewyLokumLegend.boardState[6][1]==null && chewyLokumLegend.boardState[6][2]==null );
		 
		
	}
	
	@Test 
	/** 
	 * Test method for {@link Board#swap(Lokum[][],Lokum,Lokum)}
	 */
	public void testSwap2() {
		lokum1 = chewyLokumLegend.boardState[2][3];
		lokum2 = chewyLokumLegend.boardState[3][5];
		
       	chewyLokumLegend.swap(chewyLokumLegend.boardState,lokum1,lokum2);
		assertTrue(lokum1.getCoordX()==2 && lokum1.getCoordY()==3);
		
		
	}
	
	
	@Test 
	/** 
	 * Test method for {@link Board#swap(Lokum[][],Lokum,Lokum)}
	 */
	public void testSwap3() {
		lokum1 = chewyLokumLegend.boardState[2][1];
		lokum2 = chewyLokumLegend.boardState[3][3];
		
		Lokum lokum3 = new Lokum();
		lokum3 = chewyLokumLegend.boardState[2][2];
		Lokum lokum4 = new Lokum();
		lokum4 = chewyLokumLegend.boardState[4][4];
		lokum1.setLokumID(1);
		lokum2.setLokumID(1);
		lokum4.setLokumID(1);
		chewyLokumLegend.swap(chewyLokumLegend.boardState,lokum1,lokum3);
		assertTrue(chewyLokumLegend.boardState[2][2]==null);
		
		
	}
	
	
	@Test 
	/** 
	 * Test method for {@link Board#updateState()}
	 */
	public void testUpdateBoard() {
		lokum1 = chewyLokumLegend.boardState[2][1];
		lokum2 = chewyLokumLegend.boardState[3][3];
		
		Lokum lokum3 = new Lokum();
		lokum3 = chewyLokumLegend.boardState[2][2];
		Lokum lokum4 = new Lokum();
		lokum4 =chewyLokumLegend.boardState[4][4];
		lokum1.setLokumID(1);
		lokum2.setLokumID(1);
		lokum4.setLokumID(1);
		chewyLokumLegend.swap(chewyLokumLegend.boardState,lokum1,lokum3);
		for (int i=0; i<9; i++) {
	       	 for (int j=0; j<9; j++) {
		chewyLokumLegend.updateBoard();
		assertTrue(chewyLokumLegend.boardState[2][2]!=null);
	       	 }}
		
	}
    


	

}
