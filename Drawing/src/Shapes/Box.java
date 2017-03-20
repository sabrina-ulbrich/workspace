// Box.java ------------------------------------------------
package Shapes;

import java.awt.Graphics;

public class Box extends Shape {
	protected Dist dxdy; // Ausdehnung

	public Box(Point p1, Dist p2) {
		super(p1);
		dxdy = p2;
	}
	
	public void erase(Graphics g) {
		// Parameter: x- und y-Koordinate (Point), Breite und Hoehe (Distance)
		g.clearRect(origin.get_x(), origin.get_y(), dxdy.get_dx(), dxdy.get_dy());
	}
	
	public void draw(Graphics g) {
		g.drawRect(origin.get_x(), origin.get_y(), dxdy.get_dx(), dxdy.get_dy());
	}
	
	public int right() {
		return origin.get_x() + dxdy.get_dx();
	}
	
	public int bottom() {
		return origin.get_y() + dxdy.get_dy();
	}
	
    public boolean contains(Point p) {
    	if(p.get_x() >= origin.get_x() && p.get_x() <= right()
    		&& p.get_y() >= origin.get_y() && p.get_y() <= bottom()) {
    		return true;
    	}
    	return false;
    }
	
	public void print() {
		System.out.print ("this is a box at ");
		origin.print(); // origin muss in Shape protected sein
		System.out.print (" with dxdy = ");
		dxdy.print();
		System.out.println();
	}
}
// Box.java ------------------------------------------------
