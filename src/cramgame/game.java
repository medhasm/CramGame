package cramgame;

import java.util.ArrayList;
import java.util.Vector;
import java.lang.Math;



public class game {
 Board b;
 int numRows;
 boolean RobotMode;
 Player play;
 int Stepcounter;
 Player Winner;
 ArrayList<Integer> holder=new ArrayList<Integer>();
 
 public game(int Row,boolean Robotmode) {
	 this.RobotMode=Robotmode;
	 this.numRows=Row;
	 b=new Board(Row);
	 play=Player.PLAYERONE;
	 this.Stepcounter=3;
	 
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
	 switch (player) {
	 case PLAYERONE:
		 play=Player.PLAYERTWO;
		 Stepcounter=3;
		 return flag;
	 case PLAYERTWO:
		 play=Player.PLAYERONE;
		 Stepcounter=3;
		 return flag;
		 
	 case EMPTY:
		 break;
		 
	 }
	}
	 return flag;
	 
	 
 }
 public boolean checkend() {
	 Vector<Vector<Player>> board=b.getBoard();
	 ArrayList<Integer> holder=new ArrayList<Integer>();
	 int counter=0;
	 for(int i=0 ; i < board.size() - 1 ; i++) {
		 if(this.Stepcounter == 3) {
		 if(board.size() < 2) return false; //have to throw exception
		 if(board.get(i).get(0) == Player.EMPTY) counter++;
		 if(board.get(i).get(1) == Player.EMPTY) counter++;
		 if(board.get(i + 1).get(0) == Player.EMPTY) counter++;	
		 System.out.println(i + 1);
		 if(board.get(i + 1).get(1) == Player.EMPTY) counter++;
		 if(counter == 4 || counter == 3) return false;
		 counter = 0;
		 }else {
			 return false;
		 }
		 
	 }
	 
	 switch(getTurn()) {
	 case PLAYERONE:
		 this.Winner=Player.PLAYERTWO;
		 break;
	 case PLAYERTWO:
		 this.Winner=Player.PLAYERONE;
		 break;
	 case EMPTY:
     break;
	 
	 }
	 return true;
 }
 public void RobotMove() {
	 
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
		 System.out.println("Size"+ holder.size()) ;
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
