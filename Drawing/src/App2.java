import java.awt.*;
import java.awt.event.*;

import Shapes.*; 
import Shapes.Point;

public class App2 extends Frame { 
   private Point p1, p2; 			// Start und Ziel der Bewegung
   private boolean pointInFigure;	// Mauszeiger in der Figur?

   private Colored_Box cb = new Colored_Box(new Point(40, 78), new Dist(90, 40), Color.blue);
   private Colored_Box cbtop = new Colored_Box(new Point(61, 48), new Dist(50, 30), Color.blue);
   private Colored_Circle cc1 = new Colored_Circle(new Point(61, 118), 15, Color.red);
   private Colored_Circle cc2 = new Colored_Circle(new Point(111, 118), 15, Color.red);
   private Colored_Circle cc3 = new Colored_Circle(new Point(61, 118), 7, Color.green);
   private Colored_Circle cc4 = new Colored_Circle(new Point(111, 118), 7, Color.green);
   private Figure f = new Figure();

   public static void main(String[] args) { 
       App2 wnd = new App2(); 	// das Fenster 
   }

   public App2() { 
      super("App2");
      f.addShape(cb); 
      f.addShape(cbtop);
      f.addShape(cc1);
      f.addShape(cc2);
      f.addShape(cc3);
      f.addShape(cc4);

      // 'Fenster-Horcher', der das Programm beendet, wenn man das Fenster schliesst
      addWindowListener( 
         new WindowAdapter() { 
            public void windowClosing(WindowEvent event) { 
            	System.out.println("Auf Wiedersehen!");
            	System.exit(0); 
            } 
         } 
      ); 

      // 'Maus-Horcher', der die Ereignisse Klick und Loslassen der linken Maustaste behandelt
      // jedes Maus-Ereignis kann nach seinem 'Ereignisort' befragt werden 
      addMouseListener( 
         new MouseAdapter() {     	 
        	 public void mousePressed(MouseEvent e) {
        		 p1 = new Point(e.getX(),e.getY()); // start
        		 pointInFigure = false;
        		 if(f.contains(p1)) {
        			 pointInFigure = true;
        		 }
        	 }
        	 
        	 public void mouseReleased(MouseEvent e) { 
        		 if(pointInFigure) {
        			 p2 = new Point(e.getX(),e.getY()); // ziel 
        			 Dist d = p1.distance(p2);
        			 //f.calculateMove(getGraphics(), d);
        			 f.move(getGraphics(), d);
        			 f.print(p1, p2);
        		 }
        	 } 
         } 
      );
      
      setBackground(Color.yellow); 
      setSize(500,600); 
      setVisible(true); 
   }

   public void paint(Graphics g) { 
	   f.draw(g);
   } 
}