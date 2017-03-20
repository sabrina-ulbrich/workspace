// Point.java ----------------------------------------------
package Shapes;

public class Point {
	private int x;
	private int y;

	public Point(int px, int py) {
		x = px;
		y = py;
	}
	
	public int get_x() {
		return x;
	}

	public int get_y() {
		return y;
	}
	
	public void add (Dist d) {
		x += d.get_dx();
		y += d.get_dy();
	}

	static final Point zero = new Point (0,0);

	public void print() {
		System.out.print("[" + x + ", " + y + "]");
	}

	public Dist distance(Point p) {
		return new Dist(p.get_x() - x, p.get_y() - y);
	}
}
// Point.java ----------------------------------------------
