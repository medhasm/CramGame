package cramgame;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Algorithms {

	
	
	boolean checkifA(int beginRow,int endRow,Board board) {
		
		Vector<Vector<Player>> stack=board.getBoard();
		Player upBBlock=stack.get(beginRow).get(0);
		Player lowBBlock=stack.get(beginRow).get(1);
		Player upEBlock =stack.get(endRow).get(0);
		Player lowEBlock =stack.get(endRow).get(1);
		boolean firstcond=(upBBlock == Player.EMPTY)&&(lowBBlock == Player.EMPTY);
		boolean secondcond=(upEBlock == Player.EMPTY)&&(lowEBlock == Player.EMPTY);
		if(firstcond && secondcond) {
			int countempty=0;
			for(int i=beginRow ; i<=endRow && endRow<stack.size();i++ ) {
				 upEBlock =stack.get(i).get(0);
				 lowEBlock =stack.get(i).get(1);	
				 firstcond=(upBBlock == Player.EMPTY)&&(lowBBlock == Player.EMPTY);
				 countempty++;
			}
			if(countempty == (endRow - beginRow+1)*2) return true;
			else return false;
			
		}else return false;
		
		//return false;
	}
	boolean checkifB(int beginRow,int endRow,Board board) {
		 
		Vector<Vector<Player>> stack=board.getBoard();
		Player upBBlock=stack.get(beginRow).get(0);
		Player lowBBlock=stack.get(beginRow).get(1);
		Player upEBlock =stack.get(endRow).get(0);
		Player lowEBlock =stack.get(endRow).get(1);
		boolean firstcond=((upBBlock == Player.EMPTY)&&(lowBBlock == Player.EMPTY));
		boolean secondcond=((upBBlock != Player.EMPTY)&&(lowBBlock == Player.EMPTY));
		boolean thirdcond=((upBBlock == Player.EMPTY)&&(lowBBlock != Player.EMPTY));
		boolean fourcond=(upEBlock == Player.EMPTY)&&(lowEBlock == Player.EMPTY);
	    boolean fifthcond=((upEBlock != Player.EMPTY)&&(lowEBlock == Player.EMPTY));
		boolean sixthcond=((upEBlock == Player.EMPTY)&&(lowEBlock != Player.EMPTY));
		boolean flag=(firstcond  &&  (fifthcond || sixthcond))
				                 ||
				      (fourcond  &&  (secondcond || thirdcond));
		
		if( flag ) {
			
			int countempty=0;
			for(int i=beginRow ; i<=endRow && endRow<stack.size();i++ ) {
				 upEBlock =stack.get(i).get(0); //upper begining block
				 lowEBlock =stack.get(i).get(1);	//lowwer begining block
				 firstcond=(upBBlock == Player.EMPTY)&&(lowBBlock == Player.EMPTY);
				 if(firstcond) countempty++;
				 
			}
			if(countempty == (endRow - beginRow)*2) return true;
			else return false;
			
		}else return false;
		
		
	}
	boolean checkifC(int beginRow,int endRow,Board board) {
		 
		Vector<Vector<Player>> stack=board.getBoard();
		Player upBBlock=stack.get(beginRow).get(0);
		Player lowBBlock=stack.get(beginRow).get(1);
		Player upEBlock =stack.get(endRow).get(0);
		Player lowEBlock =stack.get(endRow).get(1);
		boolean firstcond=((upBBlock == Player.EMPTY)&&(lowEBlock == Player.EMPTY));
		boolean secondcond=((upBBlock != Player.EMPTY)&&(lowEBlock != Player.EMPTY));
		boolean thirdcond=((upBBlock != Player.EMPTY)&&(lowEBlock != Player.EMPTY));
		boolean fourcond=((upBBlock == Player.EMPTY)&&(lowEBlock == Player.EMPTY));
		boolean flag=(firstcond&&secondcond) || (thirdcond&&fourcond);
		
		if( flag ) {
			
			int countempty=0;
			for(int i=beginRow ; i<=endRow && endRow<stack.size();i++ ) {
				 upEBlock =stack.get(i).get(0); //upper begining block
				 lowEBlock =stack.get(i).get(1);	//lowwer begining block
				 firstcond=(upBBlock == Player.EMPTY)&&(lowBBlock == Player.EMPTY);
				 if(firstcond) countempty++;
				 
			}
			if(countempty == (endRow - beginRow - 1)*2) return true;
			else return false;
			
		}else return false;		
	}
	boolean checkifD(int beginRow,int endRow,Board board) {
		 
		Vector<Vector<Player>> stack=board.getBoard();
		Player upBBlock=stack.get(beginRow).get(0);
		Player lowBBlock=stack.get(beginRow).get(1);
		Player upEBlock =stack.get(endRow).get(0);
		Player lowEBlock =stack.get(endRow).get(1);
		boolean firstcond=((upBBlock == Player.EMPTY)&&(lowBBlock != Player.EMPTY));
		boolean secondcond=((upBBlock != Player.EMPTY)&&(lowBBlock == Player.EMPTY));
		boolean thirdcond=((upEBlock == Player.EMPTY)&&(lowEBlock != Player.EMPTY));
		boolean fourcond=((upEBlock != Player.EMPTY)&&(lowEBlock == Player.EMPTY));
		boolean flag=(firstcond&&fourcond) || (thirdcond&&secondcond);
		
		if( flag ) {
			
			int countempty=0;
			for(int i=beginRow ; i<=endRow && endRow<stack.size();i++ ) {
				 upEBlock =stack.get(i).get(0); //upper begining block
				 lowEBlock =stack.get(i).get(1);	//lowwer begining block
				 firstcond=(upBBlock == Player.EMPTY)&&(lowBBlock == Player.EMPTY);
				 if(firstcond) countempty++;
				 
			}
			if(countempty == (endRow - beginRow - 1)*2) return true;
			else return false;
			
		}else return false;		
	}
	public void calculator() {
		
		
	}
	public Map<Character,Map<Integer,Integer>> findsubCrams(Board board) {
		Map<Character,Map<Integer,Integer>> map=new HashMap<Character,Map<Integer,Integer>>();
		Vector<Vector<Player>> stack=board.getBoard();
		Player upBBlock;
		Player lowBBlock;
        int startInd,endInd;
				
		for(int i=0;i<stack.size();i++) {
			 upBBlock=stack.get(i).get(0);
			 lowBBlock=stack.get(i).get(1);
			 startInd=findstrsub(board,i);
			 endInd=findendsub(board,startInd);
			 if(checkifA(startInd,endInd,board)) map.get('A').put(startInd,endInd);
			 if(checkifB(startInd,endInd,board)) map.get('B').put(startInd,endInd);
			 if(checkifC(startInd,endInd,board)) map.get('C').put(startInd,endInd);
			 if(checkifD(startInd,endInd,board)) map.get('D').put(startInd,endInd);
			 i=endInd +1 ;
		}
		
		return map;
	}
	public int findstrsub(Board board,int row) {
		Vector<Vector<Player>> stack=board.getBoard();
		Player upBBlock;
		Player lowBBlock;
		boolean cond;
		
		for(int i=row; i<stack.size() ; i++) {
			
			 upBBlock=stack.get(i).get(0);
			 lowBBlock=stack.get(i).get(1);	
			 cond = ((upBBlock != Player.EMPTY)&&(lowBBlock != Player.EMPTY));
			 if(cond) continue;
			 return i;
		}
		return 0;
	}
	public int findendsub(Board board,int row) {
		Vector<Vector<Player>> stack=board.getBoard();
		Player upBBlock;
		Player lowBBlock;
		boolean cond;
		if(row == (stack.size()-1)) return row;
		for(int i=row+1; i<stack.size() ; i++) {
			if(i == (stack.size()-1)) return i;
			 upBBlock=stack.get(i).get(0);
			 lowBBlock=stack.get(i).get(1);	
			 cond = ((upBBlock != Player.EMPTY)&&(lowBBlock != Player.EMPTY));
			 if(cond)return i-1;
			 
		}
		return 0;
	}
	
	
	
}
