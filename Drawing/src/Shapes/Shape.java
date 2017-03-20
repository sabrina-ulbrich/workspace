// Shape.java ----------------------------------------------
package Shapes;

import java.awt.*;

public abstract class Shape {
	protected Point origin;
	
	public Shape(Point o) {
		origin = o;
	}
	
	public final void move(Graphics g, Dist delta) {
		//erase(g);
		origin.add(delta);
		draw(g);
	}

	abstract public void draw(Graphics g);
	abstract public void erase(Graphics g);
	abstract public boolean contains(Point p);
	abstract public void print();
}
// Shape.java ----------------------------------------------
