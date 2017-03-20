package Shapes;

public class App0 {

	public static void main(String[] args) {
		Box b = new Box (new Point (0, 0), new Dist (10, 20)); 
        b.draw(); 
        b.print(); 
        b.move(new Dist (20,-20)); 
        b.print();
        
        Shape s = new Box (new Point (0, 0), new Dist (10, 20)); 
        s.draw(); 
        s.print(); 
        s.move(new Dist (20,-20)); 
        s.print();
	}
}
