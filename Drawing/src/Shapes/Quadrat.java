// Quadrat.java ------------------------------------------------
package Shapes;

import java.awt.Graphics;

public class Quadrat extends Box {
	
	public Quadrat(Point p1, int a) {
		super(p1, new Dist(a,a));
	}

	public void erase(Graphics g) {
		g.clearRect(origin.get_x(), origin.get_y(), dxdy.get_dx(), dxdy.get_dy());
	}
	
	public void draw(Graphics g) {
		g.drawRect(origin.get_x(), origin.get_y(), dxdy.get_dx(), dxdy.get_dy());
	}
        
	public void print() {
		System.out.print ("this is a quadrat at ");
		origin.print(); 
		System.out.print (" with side length = ");
		System.out.print(dxdy.get_dx());
		System.out.println();
	}
}
// Quadrat.java ------------------------------------------------
