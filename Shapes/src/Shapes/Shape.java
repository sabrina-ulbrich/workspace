package Shapes;

public abstract class Shape {
	protected Point origin;		// should be visible for extended classes

	public Shape(Point o) {
		origin = o;
	}

	public final void move(Dist delta) { 
		erase(); 
		origin.add(delta); 
		draw(); 
	}

	abstract public void draw(); 
	abstract public void erase(); 
	abstract public void print();
}
