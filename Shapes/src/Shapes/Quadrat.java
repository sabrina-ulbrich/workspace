package Shapes;

public class Quadrat extends Box{
	protected int sideLength;
	
	public Quadrat(Point p1, int length) {
    	super(p1, new Dist (length, length));
    	sideLength = length;
    }
    
    public void erase() { 
    	System.out.println("erasing a quadrat"); 
    } 
    
    public void draw() { 
    	System.out.println("drawing a quadrat"); 
    }
    
    public void print() { 
    	System.out.print ("this is a quadrat at "); 
    	origin.print(); 
    	System.out.print (" with dxdy = "); 
    	dxdy.print(); 
    	System.out.println();
    }
}
