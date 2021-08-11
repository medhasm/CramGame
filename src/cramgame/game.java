package cramgame;

public class game {
 Board b;
 int numRows;
 boolean RobotMode;
 Player play;
 int Stepcounter;
 
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
	 
	boolean flag= b.setBoard(player, RowIndex, ColIndex);
	if(flag) Stepcounter=Stepcounter - 1;
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
 
 public void RobotMove() {
	 
 }
 
 public String startPlayer() {
	 
	 return "Player one";
 }
}
