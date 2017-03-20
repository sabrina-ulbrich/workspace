package Shapes;

public class Circle extends Shape {
	protected int radius;

    public Circle(Point p1, int r) {
    	super(p1);
    	radius = r;
    }
    
    public void erase() { 
    	System.out.println("erasing a circle"); 
    } 
    
    public void draw() { 
    	System.out.println("drawing a circle"); 
    }
    
    public void print() { 
    	System.out.print("this is a circle at "); 
    	origin.print(); 
    	System.out.print(" with radius = "); 
    	System.out.print(radius);
    	System.out.println(); 
    } 
}
