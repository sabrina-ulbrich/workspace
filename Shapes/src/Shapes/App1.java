package Shapes;

public class App1 {

	public static void main(String[] args) {
		
		Colored_Box cb = new Colored_Box (new Point (0, 0), new Dist (10, 20), 1);

        Colored_Quadrat cq = new Colored_Quadrat (new Point (20, 30), 10, 2);

        Colored_Circle cc = new Colored_Circle (new Point (40, 40), 30, 3);

        Figure f = new Figure();

        f.addShape(cb); 
        f.addShape(cq); 
        f.addShape(cc);

        f.draw(); 
        f.print(); 
        f.move(new Dist (20, -20)); 
        f.print();
	}
}
