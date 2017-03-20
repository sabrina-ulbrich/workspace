// Dist.java ----------------------------------------------
package Shapes;

public class Dist {
	private int dx;
	private int dy;

	public Dist(int px, int py) {
		dx = px;
		dy = py;
	}

	public int get_dx() {
		return dx;
	}

	public int get_dy() {
		return dy;
	}
	
	public void print() {
		System.out.print("[" + dx + ", " + dy + "]");
	}
}
// Dist.java ----------------------------------------------

