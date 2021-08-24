package cramgame;

import java.awt.Color;
import java.awt.Point;

public class piece3  extends Piece{
    
	
	// [ ][X]
	// 	  [ ]
	public piece3() {
        super(Color.cyan);
        type=3;
        squares = new Point[3];
        squares[0] = new Point(0, 0);
        squares[1] = new Point(0, -1);
        squares[2] = new Point(1, 0);
    }
}
