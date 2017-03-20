package Shapes;
import java.util.*;					// Vector and Enumeration

public class Figure {
    private Vector<Shape> v;		// where the Shapes go into

    public Figure() {
    	v = new Vector<Shape>();
    }

    public void addShape(Shape s) {
    	v.add(s); 
    }

    public void draw() {
    	for(Enumeration<Shape> e = v.elements(); e.hasMoreElements(); ) {
    		( e.nextElement() ).draw();
    	}
    }
    
    public void erase() {
    	for(Enumeration<Shape> e = v.elements(); e.hasMoreElements(); ) {
    		( e.nextElement() ).erase();
    	}
    }
    
    public void move(Dist delta) {
    	for(Enumeration<Shape> e = v.elements(); e.hasMoreElements(); ) {
    		( e.nextElement() ).move(delta);
    	}
    }
    
    public void print() {
    	for(Enumeration<Shape> e = v.elements(); e.hasMoreElements(); ) {
    		( e.nextElement() ).print();
    	}
    }
}
