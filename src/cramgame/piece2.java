package cramgame;

import java.awt.Color;
import java.awt.Point;

public class piece2  extends Piece{
    
	
	
	// [X][ ]
	// [ ]
	public piece2() {
        super(Color.cyan);
        type=2;

        squares = new Point[3];
        squares[0] = new Point(0, 0);
        squares[1] = new Point(0, 1);
        squares[2] = new Point(1, 0);
    }
}

