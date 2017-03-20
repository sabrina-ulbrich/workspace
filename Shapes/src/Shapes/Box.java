package Shapes;

// rectangle
public class Box extends Shape {
    protected Dist dxdy; 			// extension

    public Box (Point p1, Dist p2) {
    	super(p1);
    	dxdy = p2;
    }
    
    public void erase() { 
    	System.out.println("erasing a box"); 
    } 
    
    public void draw() { 
    	System.out.println("drawing a box"); 
    }
    
    public void print() { 
    	System.out.print ("this is a box at "); 
    	origin.print(); 
    	System.out.print (" with dxdy = "); 
    	dxdy.print(); 
    	System.out.println(); 
    } 
}
