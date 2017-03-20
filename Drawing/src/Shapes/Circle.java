package Shapes;

import java.awt.Graphics;

public class Circle extends Shape {
	protected int radius;

	public Circle(Point m, int rad) {
		super(m);
		radius = rad;
	}
	
	public void erase(Graphics g) {
		g.clearRect(origin.get_x() - radius, origin.get_y() - radius, 2 * radius, 2 * radius);
    }

	public void draw(Graphics g) {
		g.drawOval(origin.get_x() - radius, origin.get_y() - radius, 2 * radius, 2 * radius);
    }

    public boolean contains(Point p) {
    	if(p.get_x() >= (origin.get_x() - radius) && p.get_x() <= (origin.get_x() + radius)
    		&& p.get_y() <= (origin.get_y() + radius) && p.get_y() >= (origin.get_y() - radius)) {
    		return true;
    	}
    	return false;
    }
    
	public void print() {
		System.out.print("this is a circle at ");
		origin.print();
		System.out.print (" with radius = " + radius);
		System.out.println();
	}
}
