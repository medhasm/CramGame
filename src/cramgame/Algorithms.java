package cramgame;

import java.util.ArrayList;
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
				 firstcond=(upEBlock == Player.EMPTY)&&(lowEBlock == Player.EMPTY);
				 
				 if(firstcond) countempty=countempty+2;
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
				 firstcond=(upEBlock == Player.EMPTY)&&(lowEBlock == Player.EMPTY);
				 if(firstcond) countempty+=2;
				 
			}
			
			if(countempty == ((endRow - beginRow)*2)) return true;
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
				 firstcond=(upEBlock == Player.EMPTY)&&(lowEBlock == Player.EMPTY);
				 if(firstcond) countempty+=2;;
				 
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
				 firstcond=(upEBlock == Player.EMPTY)&&(lowEBlock == Player.EMPTY);
				 if(firstcond) countempty+=2;;
				 
			}
			if(countempty == (endRow - beginRow - 1)*2) return true;
			else return false;
			
		}else return false;		
	}
	
	public Map<Integer,Map<Integer,Set<Integer>>> calculator(Board board) {
		cram cram=new cram(board.getBoard().size());
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
				if(mapr.get(i)==null) {
					mapr.putIfAbsent(i, mk);
				}else mapr.get(i).put(c, cram.calculateA(c-i+1));
				
			}
			
		}
		if(map.get("B")!=null) {
			Map<Integer,Integer> mp=map.get("B");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateB(c-i));
				if(mapr.get(i)==null) {
				mapr.putIfAbsent(i, mk);
			}	else mapr.get(i).put(c, cram.calculateB(c-i));
			
		}
		}
		if(map.get("B2")!=null) {
			Map<Integer,Integer> mp=map.get("B2");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateB2(c-i));
				if(mapr.get(i)==null) {
				mapr.putIfAbsent(i, mk);
			}	else mapr.get(i).put(c, cram.calculateB(c-i));
				
			}	
			
		}
		if(map.get("B3")!=null) {
			Map<Integer,Integer> mp=map.get("B3");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateB3(c-i));
				if(mapr.get(i)==null) {
				mapr.putIfAbsent(i, mk);
			}	else mapr.get(i).put(c, cram.calculateB(c-i));
				
			}	
			
		}
		if(map.get("B4")!=null) {
			Map<Integer,Integer> mp=map.get("B4");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateB4(c-i));
				if(mapr.get(i)==null) {
				mapr.putIfAbsent(i, mk);
			}	else mapr.get(i).put(c, cram.calculateB(c-i));
				
			}	
			
		}
		if(map.get("C")!=null) {
			Map<Integer,Integer> mp=map.get("C");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateC(c-i-1));
				if(mapr.get(i)==null) {
				mapr.putIfAbsent(i, mk);
			}	else mapr.get(i).put(c, cram.calculateC(c-i-1));
				
			}	
			
		}
		if(map.get("C2")!=null) {
			Map<Integer,Integer> mp=map.get("C2");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateC2(c-i-1));
				if(mapr.get(i)==null) {
				mapr.putIfAbsent(i, mk);
			}	else mapr.get(i).put(c, cram.calculateC(c-i-1));
				
			}	
			
		}
		if(map.get("D")!=null) {
			Map<Integer,Integer> mp=map.get("D");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateD(c-i-1));
				if(mapr.get(i)==null) {
				mapr.putIfAbsent(i, mk);
			}	else mapr.get(i).put(c, cram.calculateD(c-i-1));
				
			}	
			
		}
		if(map.get("D2")!=null) {
			Map<Integer,Integer> mp=map.get("D2");
			
			Map<Integer,Set<Integer>> mk=new HashMap<Integer,Set<Integer>>();
			
			for(int i : mp.keySet()) {
				int c=mp.get(i);
				mk.put(c, cram.calculateD2(c-i-1));
				if(mapr.get(i)==null) {
				mapr.putIfAbsent(i, mk);
			}	else mapr.get(i).put(c, cram.calculateD(c-i-1));
				
			}	
			
		}
		
		
		//}
	
	
		return mapr;
		
		
		
	}
	
	
	public Map<String,Map<Integer,Integer>> findsubCrams(Board board) {
		Map<String,Map<Integer,Integer>> map=new HashMap<String,Map<Integer,Integer>>();
		Map<Integer,Integer> iimp;
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
			 if(startInd == -1 ) return map;
		
			 endInd=findendsub(board,startInd);
	
			 if(endInd-startInd == 0) {
				 if(i==(stack.size()-1)) { 
					
					 return map; 
				 
				 
				 }
				 i=i+1;
				 continue;
			 }
			  
			 if(checkifA(startInd,endInd,board)) {
				
				// map.p
				 if(map.get("A") == null) {
					 Map key=new HashMap<Integer,Integer>();
					 key.put(startInd,endInd);
					map.putIfAbsent("A",key );
				 }else
				 map.get("A").put(startInd,endInd);
				 i=endInd+1;
				
			 }
			
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
				  
				    if(firstcond&&fifthcond) {
						 if(map.get("B") == null) {
							 Map key=new HashMap<Integer,Integer>();
							 key.put(startInd,endInd);
							map.putIfAbsent("B",key );
						 }else map.get("B").put(startInd,endInd);}
					if(thirdcond&&fourcond) {
					
						 if(map.get("B2") == null) {
							 
							 Map key=new HashMap<Integer,Integer>();
							 key.put(startInd,endInd);
							map.putIfAbsent("B2",key );
						 }else
						 map.get("B2").put(startInd,endInd);}				
			    	if(secondcond&&fourcond) { 
						 if(map.get("B3") == null) {
							 Map key=new HashMap<Integer,Integer>();
							 key.put(startInd,endInd);
							map.putIfAbsent("B3",key );
						 }
						 else map.get("B3").put(startInd,endInd);}
					if(firstcond&&sixcond) {
						 if(map.get("B4") == null) {
							 Map key=new HashMap<Integer,Integer>();
							 key.put(startInd,endInd);
							
							 map.putIfAbsent("B4",key );
							 
						 }else 	map.get("B4").put(startInd,endInd);}
				 i=endInd + 1;
				 continue;
				 
			 }
			 if(checkifC(startInd,endInd,board))
			 {
				 if(endInd - startInd == 1) {
					 i=endInd+1;
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
				 if(firstcond&&secondcond) {				
					 if(map.get("C") == null) {
					 Map key=new HashMap<Integer,Integer>();
					 key.put(startInd,endInd);
					map.putIfAbsent("C",key );
				 }else map.get("C").put(startInd,endInd);
					 }
					 
				 if(thirdcond&&fourcond)	{	
					 if(map.get("C2") == null) {
					 Map key=new HashMap<Integer,Integer>();
				     key.put(startInd,endInd);
				   map.putIfAbsent("C2",key );
			 }else map.get("C2").put(startInd,endInd);
				 }
					
				 i=endInd+1;
				 continue;
				 
			 }
			 if(checkifD(startInd,endInd,board)) {
				 
				 if(endInd - startInd == 1) {
					 i=endInd+1;
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
				 if(firstcond&&fourcond)
					 {		
					 if(map.get("D") == null) {
					 
					 Map key=new HashMap<Integer,Integer>();
					 key.put(startInd,endInd);
					map.putIfAbsent("D",key );
				 }else map.get("D").put(startInd,endInd);
					 }
				 if(secondcond&&thirdcond) {
					 
					 if(map.get("D2") == null) {
						 
					 Map key=new HashMap<Integer,Integer>();
					 key.put(startInd,endInd);
					map.putIfAbsent("D2",key );
				 }else map.get("D2").put(startInd,endInd);
				 }
				 
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
		if(row==(stack.size()- 1)) return -1;
		for(int i=row; i<stack.size() ; i++) {
			
			 upBBlock=stack.get(i).get(0);
			 lowBBlock=stack.get(i).get(1);	
			 cond = ((upBBlock != Player.EMPTY)&&(lowBBlock != Player.EMPTY));
			 if(cond) continue;
			
			 return i;
			 
		}
		return -1;
	}
	
	public int findendsub(Board board,int row) {
		Vector<Vector<Player>> stack=board.getBoard();
		Player upBBlock;
		Player lowBBlock;
		boolean cond,cond2;
		if(row == (stack.size()-1)) return row;
		for(int i=row+1; i<stack.size() ; i++) {
			if(i == (stack.size()-1)) return i;
			 upBBlock=stack.get(i).get(0);
			 lowBBlock=stack.get(i).get(1);	
			 cond = ((upBBlock == Player.EMPTY)&&(lowBBlock == Player.EMPTY));
			 cond2 = ((upBBlock != Player.EMPTY)&&(lowBBlock != Player.EMPTY));
			 if(cond2) return i-1;
			 if(!cond) return i;
			 
			 
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

	
		for(String s: map.keySet()) {	
			
		

        for(int i : map.get(s).keySet()){
             calc2=0;
        	end=map.get(s).get(i);	
        	Set<Integer> set=mapr.get(i).get(end);
     
        	if(counter == 0) {RandomLine=new Line(s,i,end,(int)set.toArray()[0],false);
        	counter++;
        	}
        	
        	    for(String k : map.keySet()) {	
        	    	for(int z : map.get(k).keySet()){
        	    		if(z != i ) {
        	    
        	    	   ends=map.get(k).get(z);
        	    	 
if( k == "A") calc2=calc2^cram.A.get( ends-z +1);
if( k == "B" ||  k == "B2" ||  k =="B3" ||  k =="B4") calc2=calc2^cram.B.get( ends-z );
if( k == "C" ||  k == "C2") calc2=calc2^cram.C.get( ends-z -1);
if( k == "D" ||  k == "D2") calc2=calc2^cram.D.get( ends-z -1);  
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
	
	
	public ArrayList<Integer> getOpMoves(Line line){
		
		
		 Line lin=line;
		 
			
			
		 ArrayList<Integer> arr=new ArrayList<Integer>();
		 cram cram =new cram(15);
		
		 Map<Integer,Map<Integer,ArrayList<Integer>>> kk=cram.getMap().get(line.getString());
		 
		 if(line.getString() == "A") {
			
		 arr=kk.get(line.getEnd() - line.getStart() + 1).get(line.getGrundy());}
		 if(line.getString() == "B" || line.getString() == "B2" ||
				 line.getString() == "B3" || line.getString() == "B4") {
			 
			 
		arr=kk.get(line.getEnd() - line.getStart()).get(line.getGrundy());	 
		 }
		 
		 if(line.getString() == "D" || line.getString() == "D2" ) {
			
		 arr=(ArrayList<Integer>) cram.map.get(line.getString()).get(line.getEnd() - line.getStart() - 1).get(line.getGrundy());
		 
		 }
		 if(line.getString() == "C" || line.getString() == "C2" )
		 arr=kk.get(line.getEnd() - line.getStart() - 1).get(line.getGrundy());
	return arr;	
		
	}
	
	
	
	
}
