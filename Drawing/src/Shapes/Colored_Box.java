package Shapes;

import java.awt.Color;
import java.awt.Graphics;

public class Colored_Box extends Box {
	private Color col;

	public Colored_Box(Point m, Dist d, Color c ) {
		super(m, d);
		col = c;
	}
	
	public void erase(Graphics g) {
		Color c = g.getColor(); 
		g.setColor(Color.yellow); 				// Hintergrundfarbe 
		g.fillRect(origin.get_x(), origin.get_y(), dxdy.get_dx(), dxdy.get_dy());
		g.setColor(c);
	}

	public void draw(Graphics g) { 
		Color c = g.getColor(); 
		g.setColor(col); 
		g.fillRect(origin.get_x(), origin.get_y(), dxdy.get_dx(), dxdy.get_dy()); 
		g.setColor(c);
	}

	public void print()
	{
		System.out.print ("this is a colored box at ");
		origin.print();
	        System.out.print (" with dxdy = ");
                dxdy.print();
		System.out.print(" and color " + col );
                System.out.println();
	}
}

