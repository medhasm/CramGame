package cramgame;

import java.util.ArrayList;
import java.util.Vector;

import com.sun.org.apache.xerces.internal.util.ShadowedSymbolTable;

enum Player {
	PLAYERONE , PLAYERTWO , EMPTY}

public class Board {
	private Vector<Vector<Player>> Board ;
	
	public Board(int numRows){
		
		Board= new Vector<Vector<Player>>(numRows);
	
		for(int i=0 ; i<numRows ; i++) {
			Board.add(i, new Vector<Player>(2));
			//Board.set(i, new Vector<Player>(2));
			Board.get(i).add(0, Player.EMPTY);
			Board.get(i).add(1, Player.EMPTY);
			}
		
	}
		
		public boolean setBoard(Player Playerindex,int RowIndex,int ColIndex) {
		//    System.out.println("ROW:"+RowIndex+" COL:"+ColIndex);
			 if( Board.get(RowIndex).get(ColIndex) != Player.EMPTY) return false; 
			switch ( Playerindex) {
			
			case PLAYERONE:
			Board.get(RowIndex).set(ColIndex, Player.PLAYERONE);
			return true;
			
 
			case PLAYERTWO:
				
				Board.get(RowIndex).set(ColIndex, Player.PLAYERTWO);
				return true;
				
			case EMPTY:
				
				return false;
 
			}	
			return false;
		}
				
			public void remove(int row,int col) {
				
				Board.get(row).set(col, Player.EMPTY);
				
				
				
				
			}
			public Vector<Vector<Player>> getBoard(){
				
			return Board;
		}
}
