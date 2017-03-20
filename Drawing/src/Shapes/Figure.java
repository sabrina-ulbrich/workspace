// Figure.java ------------------------------------------
package Shapes;

//import java.lang.annotation.Target;
import java.util.*; // Vector & Enumeration
import java.awt.*;

public class Figure {
	private Vector<Shape> v; // where the Shapes go into

	public Figure() {
		v = new Vector<Shape>();
	}

	public void addShape(Shape s) {
		v.addElement(s); // ein Shape IST EIN Object !!!
	}

	public void draw(Graphics g) {
		for (Enumeration<Shape> e = v.elements(); e.hasMoreElements(); ) {
			( e.nextElement() ).draw(g);
		}
	}

	public void erase(Graphics g) {
		for (Enumeration<Shape> e = v.elements(); e.hasMoreElements(); ) {
			( e.nextElement() ).erase(g);
		}
	}

	public void move(Graphics g, Dist d) {
		try {
			Thread.sleep( 10 );
		} catch ( InterruptedException e) {}
		this.erase(g);
		for (Enumeration<Shape> e = v.elements(); e.hasMoreElements(); ) {
			( e.nextElement() ).move(g, d);
		}
	}
	
	public static int ggT(int a, int b) {
		if (a == b) return a;                   
		else if (a > b) return ggT(a - b, b);      
		else return ggT(a, b - a);
	}
	
	// 3 unfertige Versuche geradlinige und sichtbare Bewegung zu implementieren
	public void calculateMove(Graphics g, Dist d) {
		int dx = d.get_dx();
		int dy = d.get_dy();
		int x = d.get_dx();
		int y = d.get_dy();	
		int offset, steps = 0;
		float mF = dy / dx;
		int m = Math.round(mF);

		if(dx < 0) x *= -1;
		//if(dy < 0) y *= -1;

		if(dx == 0) offset = 0;
		else if(dx < 0) offset = -1;
		else offset = 1;

		for(int i = 0; i != dx; i = i + (1 * offset)) {
			mF = (float) y / x;
			System.out.println("mF: " + mF);
			m = Math.round(mF);
			//if(dy < 0) m *= (-1);
			System.out.println("i: " + i + ", x: " + x + ", y: " + y + ", Steigung: " + m);
			this.move(g, new Dist(offset, m));
			//if(dy < 0) m *= (-1);
			y = y - m;
			x = x - offset;
		}

/*
		if(dx < 0) x *= -1;
		if(dy < 0) y *= -1;
		
		if(x > 0 && y > 0) {
			steps = ggT(x, y);
			x = dx / steps;
			y = dy / steps;
		}
		
		else if(x == 0 && y > 0) {
			steps = y;
			if(dy < 0) y = -1;
			else y = 1;
		}
		
		else if(x > 0 && y == 0) {
			steps = x;
			if(dx < 0) x = -1;
			else x = 1;
		}
		
		System.out.println("steps: " + steps + ", x: " + x + ", y: " + y);
		for(int i = 1; i <= steps; i++) {
			this.move(g, new Dist(x, y));
		}
*/	
/*		
		if(dx >= 0) {
			if(dy >= 0) {
				for(int i = 0, j = 0; i <= dx && j <= dy; i++, j++) {
					if(i == dx && j < dy) {
						for(int k = j; k <= dy; k++) {
							this.move(g, new Dist(0, 1));
						}
					}
					else if(i < dx && j == dy) {
						for(int l = i; l <= dx; l++) {
							this.move(g, new Dist(1, 0));
						}
					} else {
						this.move(g, new Dist(1, 1));
					}
				}
			}
			if(dy < 0) {
				for(int i = 0, j = 0; i <= dx && j >= dy; i++, j--) {
					if(i == dx && j > dy) {
						for(int k = j; k >= dy; k--) {
							this.move(g, new Dist(0, -1));
						}
					}
					else if(i < dx && j == dy) {
						for(int l = i; l <= dx; l++) {
							this.move(g, new Dist(1, 0));
						}
					} else {
						this.move(g, new Dist(1, -1));
					}
				}
			}
		}
		if(dx < 0) {
			if(dy >= 0) {
				for(int i = 0, j = 0; i >= dx && j <= dy; i--, j++) {
					if(i == dx && j < dy) {
						for(int k = j; k <= dy; k++) {
							this.move(g, new Dist(0, 1));
						}
					}
					else if(i > dx && j == dy) {
						for(int l = i; l >= dx; l--) {
							this.move(g, new Dist(-1, 0));
						}
					} else {
						this.move(g, new Dist(-1, 1));
					}
				}
			}
			if(dy < 0) {
				for(int i = 0, j = 0; i >= dx && j >= dy; i--, j--) {
					if(i == dx && j > dy) {
						for(int k = j; k >= dy; k--) {
							this.move(g, new Dist(0, -1));
						}
					}
					else if(i > dx && j == dy) {
						for(int l = i; l >= dx; l--) {
							this.move(g, new Dist(-1, 0));
						}
					} else {
						this.move(g, new Dist(-1, -1));
					}
				}
			}
		}*/
	}

	public boolean contains(Point p) {
		// wahr, wenn p in einer der Teilfiguren liegt
		boolean pointInFigure = false;
		for (Enumeration<Shape> e = v.elements(); e.hasMoreElements(); ) {
			if(e.nextElement().contains(p)) {
				pointInFigure = true;
			}
		}
		return pointInFigure;
	}
	
	public void print(Point start, Point target) {
		System.out.println("faehrt von [" + start.get_x() + ", " + start.get_y() + "] nach [" + target.get_x() + ", " + target.get_y() + "]");
	}
}
// Figure.java ------------------------------------------
