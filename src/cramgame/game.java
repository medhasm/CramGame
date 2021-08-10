package cramgame;

public class game {
 Board b;
 int numRows;
 boolean RobotMode;
 
 public game(int Row,boolean Robotmode) {
	 this.RobotMode=Robotmode;
	 this.numRows=Row;
	 b=new Board(Row);	 
 }
 
 public void move(Player player,int RowIndex,int ColIndex) throws Exception {
	 if(RowIndex<0 || RowIndex>=this.numRows || ColIndex< 0 || ColIndex > 1)
		  throw new Exception ("check number of rows and columns");
	 
	 b.setBoard(player, RowIndex, ColIndex);
 }
 
 public void RobotMove() {
	 
 }
 
 public String startPlayer() {
	 
	 return "Player one";
 }
}
