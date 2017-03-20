package Shapes;

import java.awt.Graphics; 
import java.awt.Color;

public class Colored_Circle extends Circle {
	private Color col;
	
	public Colored_Circle(Point m, int rad, Color c) {
		super(m, rad);
		col = c; 								// 'echte' Farbe
	}

    // die Funktion fillOval zeichnet i.allg. Ellipsen durch Angabe des umgebenden Rechtecks 
	public void erase(Graphics g) {
		Color c = g.getColor(); 
		g.setColor(Color.yellow); 				// Hintergrundfarbe 
		g.fillOval(origin.get_x()-radius, origin.get_y()-radius, 2*radius, 2*radius); 
		g.setColor(c);
	}

	public void draw(Graphics g) { 
		Color c = g.getColor(); 
		g.setColor(col); 
		g.fillOval(origin.get_x()-radius, origin.get_y()-radius, 2*radius, 2*radius); 
		g.setColor(c);
	}

	public void print() {
		System.out.print ("this is a colored circle at ");
		origin.print();
		System.out.print (" with radius = " + radius + " and color " + col );
		System.out.println();
	} 
} 
