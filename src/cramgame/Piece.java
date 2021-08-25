
package cramgame;

import java.awt.Color;
import java.awt.Point;

public class Piece {
    
    
    protected Color color;
    protected Point[] squares; // The locations of the squares within the piece
    protected int type;
    
    public Piece() {
        color = Color.black;
    }
    
    
    public Piece(Color clr) {
        color = clr;
    }
    
    
    public Color getColor() {
        return color;
    }
}
