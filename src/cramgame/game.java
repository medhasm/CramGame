package cramgame;

import java.util.ArrayList;
import java.util.Map;
import java.util.Vector;
import java.lang.Math;



public class game {
 Board b;
 int numRows;
 boolean RobotMode;
 Player play;
 int Stepcounter;
 Player Winner;
 boolean winnerflag=false;
 ArrayList<Integer> holder=new ArrayList<Integer>();
 ArrayList<Integer> hold=new ArrayList<Integer>();
 cram cram;
 
 public game(int Row,boolean Robotmode) {
	 this.RobotMode=Robotmode;
	 this.numRows=Row;
	 b=new Board(Row);
	 play=Player.PLAYERONE;
	 this.Stepcounter=3;
	 if(Robotmode == true) cram=new cram(Row);
	 
 }
 public Player getTurn() {
	 
	 return play;
 }
 public boolean move(Player player,int RowIndex,int ColIndex)  {
	 if(RowIndex<0 || RowIndex>=this.numRows || ColIndex< 0 || ColIndex > 1)
		 return false;
		  // Exception ("check number of rows and columns");
	 Stepcounter=Stepcounter - 1;
	boolean flag= b.setBoard(player, RowIndex, ColIndex);
	if(!flag) {
		Stepcounter=Stepcounter + 1;
	    return false;
		//Stepcounter=Stepcounter + 1;
	//	b.remove(RowIndex, ColIndex);
		
	}
	if(!checkMove(RowIndex,ColIndex)) {
		 b.remove(RowIndex, ColIndex);
		 Stepcounter=Stepcounter + 1;
		 return false;
		 
		
	}
	
	if(flag && Stepcounter == 0) {
		
		
	 switch (this.getTurn()) {
	 
	 case PLAYERONE:
	
		 this.play=Player.PLAYERTWO;
		 
		 Stepcounter=3;
		 break;
		 
	 case PLAYERTWO:
		 	
		this. play=Player.PLAYERONE;
		 
		 Stepcounter=3;
		 break;
		 
		 
	 case EMPTY:
		break; 
		 
		 
	 }
	 
	 if(checkend()) return flag;
	 
	 if(this.RobotMode) {
		 
		 if(this.getTurn()==Player.PLAYERONE) {
			
			 this.RobotMove(this.getTurn());
		 }
	 }
	}
	 return flag;
	 
	 
 }
 public boolean checkend() {
	 Vector<Vector<Player>> board=b.getBoard();
	 ArrayList<Integer> holder=new ArrayList<Integer>();
	 int counter=0;
	 if(this.winnerflag) return true;
	 
	 for(int i=0 ; i < board.size() - 1 ; i++) {
		 if(this.Stepcounter == 3) {
		 if(board.size() < 2) return false; //have to throw exception
		 if(board.get(i).get(0) == Player.EMPTY) counter++;
		 if(board.get(i).get(1) == Player.EMPTY) counter++;
		 if(board.get(i + 1).get(0) == Player.EMPTY) counter++;	
		
		 if(board.get(i + 1).get(1) == Player.EMPTY) counter++;
		 if(counter == 4 || counter == 3) return false;
		 counter = 0;
		 }else {
			 return false;
		 }
		 
	 }
	 
	 switch(getTurn()) {
	 case PLAYERONE:
		 this.winnerflag=true;
		 this.Winner=Player.PLAYERTWO;
		 break;
	 case PLAYERTWO:
		 this.winnerflag=true;
		 this.Winner=Player.PLAYERONE;
		 break;
	 case EMPTY:
     break;
	 
	 }
	 return true;
 }
 public void RobotMove(Player Player) {
	 if(this.winnerflag) return;
	 Algorithms alg=new Algorithms();
	 Line line=alg.XORBoard(this.b);
	 
	
	 
	 ArrayList<Integer> arr=new ArrayList<Integer>();
	 
	
	 Map<Integer,Map<Integer,ArrayList<Integer>>> kk=cram.getMap().get(line.getString());
	 
	 if(line.getString() == "A") {
		
	 arr=kk.get(line.getEnd() - line.getStart() + 1).get(line.getGrundy());}
	 if(line.getString() == "B" || line.getString() == "B2" ||
			 line.getString() == "B3" || line.getString() == "B4") {
		 
		// System.out.println(line.getString());
	arr=kk.get(line.getEnd() - line.getStart()).get(line.getGrundy());	 
	 }
	 
	 if(line.getString() == "D" || line.getString() == "D2" ) {
		
	 arr=(ArrayList<Integer>) cram.map.get(line.getString()).get(line.getEnd() - line.getStart() - 1).get(line.getGrundy());
	 
	 }
	 if(line.getString() == "C" || line.getString() == "C2" )
	 arr=kk.get(line.getEnd() - line.getStart() - 1).get(line.getGrundy());
	 
    System.out.println(arr);

	 for(int i : arr) {
		int c=(i+2*line.getStart());
		int row,col;
		int v=c%2;
		
		if(v == 1) {
		 row=(c/2) ;
		 col=v - 1;
		}else {
			row = (c/2) - 1;
			col = 1;
			
		}
	 if(b.setBoard(Player,row , col));
	 }
	 
	 switch (Player) {
	 case PLAYERONE:
		 play=Player.PLAYERTWO;
		 break;
	 case PLAYERTWO:
      break;
		 
	 case EMPTY:
		 break;
		 
	 }
	 
	 
 }
 
 public String startPlayer() {
	 
	 return "Player one";
 }
 public String getWinner() {
	 switch(Winner) {
	 case PLAYERONE:
		 return "first player";
	 case PLAYERTWO:
		 return "second player";
		 
	 case EMPTY:
     break;
	 
	 }
	 return null;
 }
 public boolean checkMove(int row,int col) {
	 int r=row + 1 ;
	 
	 
	 if(this.Stepcounter == 2) {//check while option
		 holder.add(r);
		 return true;
		 
	 }
	 else if(this.Stepcounter == 1){
		  holder.add(r);
		 if(Math.abs(holder.get(0) - holder.get(1))>1) {
			 holder.remove(1);
			 return false;
			 
		 }else return true;
		 
		 
		 
		 
		 
	 }else {
		 holder.add(r);
	
		 for(int i= 0 ;i < holder.size()  ; i++) {
			 
			 int k= Math.abs(holder.get(i) - holder.get((i+1)%3));
			 int s=Math.abs(holder.get(i)-holder.get((i+2)%3));
			 if(k  > 1|| s > 1) {
				 holder.remove(2);
				 return false;
			 }
		 }
		 holder=new ArrayList<Integer>();
		 return true;
		 }

		 
		 
	 
	 
	 
	
	 
	 
	 
 }
 
}
