package cramgame;

public class Line {

	String s;
	int startInd;
	int endInd;
	int grundy;
	boolean flag;
	 public Line(String ks,int i ,int e ,int grund,boolean fl) {
			 s=ks;
			 startInd=i;
			 endInd=e;
			 grundy=grund;
			 flag=fl;
 
	 }
	 public String getString() {
		 return this.s;
	 }
	 
	 
	 public int getStart() {
		 
		 return startInd;
	 }
	 
	 public int getEnd() {
		 
		 return endInd;
	 }
	 public int getGrundy() {
		 
		 return grundy;
	 }
	 public boolean getWin() {
		 return flag;
	 }
}
