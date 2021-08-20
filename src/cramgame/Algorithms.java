package cramgame;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javafx.util.Pair;

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
		boolean firstcond=((upBBlock != Player.EMPTY)&&(lowBBlock == Player.EMPTY));
		boolean secondcond=((upEBlock != Player.EMPTY)&&(lowEBlock == Player.EMPTY));
		

		boolean thirdcond=((upBBlock == Player.EMPTY)&&(lowBBlock != Player.EMPTY));
		boolean fourcond=((upEBlock == Player.EMPTY)&&(lowEBlock != Player.EMPTY));
		
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
		boolean fourcond=((upEBlock != Player.EMPTY)&&(lowEBlock == Player.EMPTY));
		
		boolean secondcond=((upBBlock != Player.EMPTY)&&(lowBBlock == Player.EMPTY));
		boolean thirdcond=((upEBlock == Player.EMPTY)&&(lowEBlock != Player.EMPTY));
		
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
	
	public Map<Integer,Map<Integer,Set<Integer>>> calculator(Board board) {
		
		Map<String,Map<Integer,Integer>> map=findsubCrams(board);
		Map<Integer,Map<Integer,Set<Integer>>> mapr=
				new HashMap<Integer,Map<Integer,Set<Integer>>>();

		//for(String s : map.keySet()) {
			
		if(map.get("A")!= null) {
			
			Map<Integer,Integer> mp=map.get("A");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateA(c-i+1));
				mapr.put(i, mk);
				
			}
			
		}
		if(map.get("B")!=null) {
			Map<Integer,Integer> mp=map.get("B");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateB(c-i+1));
				mapr.put(i, mk);
				
			}	
			
		}
		if(map.get("B2")!=null) {
			Map<Integer,Integer> mp=map.get("B2");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateB2(c-i+1));
				mapr.put(i, mk);
				
			}	
			
		}
		if(map.get("B3")!=null) {
			Map<Integer,Integer> mp=map.get("B3");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateB3(c-i+1));
				mapr.put(i, mk);
				
			}	
			
		}
		if(map.get("B4")!=null) {
			Map<Integer,Integer> mp=map.get("B4");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateB4(c-i+1));
				mapr.put(i, mk);
				
			}	
			
		}
		if(map.get("C")!=null) {
			Map<Integer,Integer> mp=map.get("C");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateC(c-i+1));
				mapr.put(i, mk);
				
			}	
			
		}
		if(map.get("C2")!=null) {
			Map<Integer,Integer> mp=map.get("C2");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateC2(c-i+1));
				mapr.put(i, mk);
				
			}	
			
		}
		if(map.get("D")!=null) {
			Map<Integer,Integer> mp=map.get("D");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateD(c-i+1));
				mapr.put(i, mk);
				
			}	
			
		}
		if(map.get("D2")!=null) {
			Map<Integer,Integer> mp=map.get("D2");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateD2(c-i+1));
				mapr.put(i, mk);
				
			}	
			
		}
		
		
		//}
		
		return mapr;
		
		
		
	}
	
	
	public Map<String,Map<Integer,Integer>> findsubCrams(Board board) {
		Map<String,Map<Integer,Integer>> map=new HashMap<String,Map<Integer,Integer>>();
		Vector<Vector<Player>> stack=board.getBoard();
		Player upBBlock;
		Player lowBBlock;
		Player upEBlock ;
		Player lowEBlock ;
        int startInd,endInd;
				
		for(int i=0;i<stack.size();) {
			 upBBlock=stack.get(i).get(0);
			 lowBBlock=stack.get(i).get(1);
			 startInd=findstrsub(board,i);
			 endInd=findendsub(board,startInd);
			 if(endInd-startInd == 0) {
				 
				 i=i+1;
				 continue;
			 }
			 if(checkifA(startInd,endInd,board)) map.get("A").put(startInd,endInd);
			 
			 if(checkifB(startInd,endInd,board)) {
				 
				 upBBlock=stack.get(startInd).get(0);
				 lowBBlock=stack.get(startInd).get(1);
				 upEBlock =stack.get(endInd).get(0);
				 lowEBlock =stack.get(endInd).get(1);
				 
					boolean firstcond=((upBBlock == Player.EMPTY)&&(lowBBlock == Player.EMPTY));
				    boolean fifthcond=((upEBlock != Player.EMPTY)&&(lowEBlock == Player.EMPTY));				  
				    boolean secondcond=((upBBlock != Player.EMPTY)&&(lowBBlock == Player.EMPTY));					
					boolean thirdcond=((upBBlock == Player.EMPTY)&&(lowBBlock != Player.EMPTY));					
				    boolean fourcond=(upEBlock == Player.EMPTY)&&(lowEBlock == Player.EMPTY);	  
				    boolean sixcond=((upEBlock == Player.EMPTY)&&(lowEBlock != Player.EMPTY));
				  
				    if(firstcond&&fifthcond) map.get("B").put(startInd,endInd);
					if(thirdcond&&fourcond) map.get("B2").put(startInd,endInd);				
			    	if(secondcond&&fourcond) map.get("B3").put(startInd,endInd);
					if(firstcond&&sixcond) map.get("B4").put(startInd,endInd);
				 i=endInd + 1;
				 continue;
				 
			 }
			 if(checkifC(startInd,endInd,board))
			 {
				 if(endInd - startInd == 1) {
					 i=endInd;
					 continue; 
				 }
					 upBBlock=stack.get(startInd).get(0);
					 lowBBlock=stack.get(startInd).get(1);
					 upEBlock =stack.get(endInd).get(0);
					 lowEBlock =stack.get(endInd).get(1);
						boolean firstcond=((upBBlock != Player.EMPTY)&&(lowBBlock == Player.EMPTY));
						boolean secondcond=((upEBlock != Player.EMPTY)&&(lowEBlock == Player.EMPTY));
                        boolean thirdcond=((upBBlock == Player.EMPTY)&&(lowBBlock != Player.EMPTY));
						boolean fourcond=((upEBlock == Player.EMPTY)&&(lowEBlock != Player.EMPTY));
				 if(firstcond&&secondcond) 
					 map.get("C").put(startInd,endInd);
				 if(thirdcond&&fourcond)
					 map.get("C2").put(startInd,endInd);
					 	 
				 
			 }
			 if(checkifD(startInd,endInd,board)) {
				 
				 if(endInd - startInd == 1) {
					 i=endInd;
					 continue; 
				 }
				 upBBlock=stack.get(startInd).get(0);
				 lowBBlock=stack.get(startInd).get(1);
				 upEBlock = stack.get(endInd).get(0);
				 lowEBlock = stack.get(endInd).get(1);
					boolean firstcond=((upBBlock == Player.EMPTY)&&(lowBBlock != Player.EMPTY));
					boolean fourcond=((upEBlock != Player.EMPTY)&&(lowEBlock == Player.EMPTY));
					
					boolean secondcond=((upBBlock != Player.EMPTY)&&(lowBBlock == Player.EMPTY));
					boolean thirdcond=((upEBlock == Player.EMPTY)&&(lowEBlock != Player.EMPTY));
				 if(firstcond&&fourcond) map.get("D").put(startInd,endInd);
				 if(secondcond&&thirdcond) map.get("D2").put(startInd,endInd);
				 i=endInd + 1;
				 continue;
				 
			 }
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
	
	
	public Line XORBoard(Board board) {
		Map<String,Map<Integer,Integer>> map=findsubCrams(board);
		Map<Integer,Map<Integer,Set<Integer>>> mapr=this.calculator(board);
		Line RandomLine = null;
		int counter=0;
		int end;
		int ends;
		int calc=0;
		int calc2=0;
		boolean A=false;
		boolean B=false;
		boolean C=false;
		boolean D=false;
		
		for(String s: map.keySet()) {	
			if( s == "A") A=true;
			if( s == "B" ||  s == "B2" ||  s =="B3" ||  s =="B4") B=true;
			if( s == "C" ||  s == "C2") C=true;
			if( s == "D" ||  s == "D2") D=true;
        for(int i : map.get(s).keySet()){
        	
        	end=map.get(s).get(i);	
        	Set<Integer> set=mapr.get(i).get(end);
        	if(counter == 0) RandomLine=new Line(s,i,end,(int)set.toArray()[0],false);
        	    for(String k : map.keySet()) {	
        	    	for(int z : map.get(s).keySet()){
        	    		  if(z != i ) {
        	    			  ends=map.get(k).get(z);
        	    				if( k == "A") calc2=calc2^cram.A.get( ends-z +1);
        	    				if( k == "B" ||  k == "B2" ||  k =="B3" ||  k =="B4") calc2=calc2^cram.B.get( ends-z +1);
        	    				if( k == "C" ||  k == "C2") calc2=calc2^cram.C.get( ends-z +1);
        	    				if( k == "D" ||  k == "D2") calc2=calc2^cram.D.get( ends-z +1);  
        	    		  }	} }
        	    for (int cc : set) {
        	    calc=cc;    
        	    if( (calc^calc2) == 0) {
        	    Line line=new Line(s,i,end,cc,true);
        	    return line;
        	    }}}  			
		}
		
		
		return RandomLine;
	}
	
	
	
	
	
}
