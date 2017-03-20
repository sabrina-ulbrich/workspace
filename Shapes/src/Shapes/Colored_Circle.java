package Shapes;

public class Colored_Circle extends Circle {
	private int color;
	
	public Colored_Circle(Point p1, int r, int col) {
    	super(p1, r);
    	color = col;
	}
	
    public void erase() { 
    	System.out.println("erasing a colored circle"); 
    } 
    
    public void draw() { 
    	System.out.println("drawing a colored circle"); 
    }
    
    public void print() { 
    	System.out.print("this is a colored circle at "); 
    	origin.print(); 
    	System.out.print(" with radius = "); 
    	System.out.print(radius);
    	System.out.print(" and color ");
    	System.out.print(color);
    	System.out.println(); 
    } 
}
