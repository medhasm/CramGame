package cramgame;

import java.awt.Color;
import java.awt.Point;

public class piece4  extends Piece{
    
	
	//    [ ]
	// [ ][X]
	public piece4() {
        super(Color.cyan);
        type=4;
        squares = new Point[3];
        squares[0] = new Point(0, 0);
        squares[1] = new Point(0, -1);
        squares[2] = new Point(-1, 0);
    }
}
