package cramgame;

import java.util.ArrayList;
import java.util.Vector;

enum Player {
	PLAYERONE , PLAYERTWO , EMPTY}

public class Board {
	private Vector<Vector<Player>> Board ;
	
	public Board(int numRows){
		System.out.println(numRows);
		Board= new Vector<Vector<Player>>(numRows);
		System.out.println("Board size :" + Board.size());
		for(int i=0 ; i<numRows ; i++) {
			Board.add(i, new Vector<Player>(2));
			//Board.set(i, new Vector<Player>(2));
			Board.get(i).add(0, Player.EMPTY);
			Board.get(i).add(1, Player.EMPTY);
			}
		System.out.println(Board.size());
	}
		
		public void setBoard(Player Playerindex,int RowIndex,int ColIndex) {
			switch ( Playerindex) {
			
			case PLAYERONE:
				
			Board.get(RowIndex).set(ColIndex, Player.PLAYERONE);
			break;
 
			case PLAYERTWO:
				
				Board.get(RowIndex).set(ColIndex, Player.PLAYERTWO);
				break;
				
			case EMPTY:
				
				break;
 
			}			
		}
				
				
			public Vector<Vector<Player>> getBoard(){
				
			return Board;
		}
}
