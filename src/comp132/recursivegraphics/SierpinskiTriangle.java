package comp132.recursivegraphics;

/** draw the Sierpinski Triangle of a given order
 * 
 * @author Robert Sedgewick
 * @author Tim Wahls
 * @author (YOUR NAME HERE)
 * @version (PUT DATE HERE)
 */

import javax.swing.JFrame;
import java.awt.Polygon;
import java.awt.Graphics;
import java.awt.Color;

public class SierpinskiTriangle  extends JFrame {
	
	private static final int WIDTH = 810;
	private static final int HEIGHT = 830;
	
	/** initialize a frame to draw the Sierpinski triangle on */
	public SierpinskiTriangle() {
		super("Sierpinski Triangle");
		this.setBackground(Color.WHITE);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	/** draw an inverted triangle on the screen
	 * 
	 * @param x the x coordinate of the upper left corner of the triangle
	 * @param y the y coordinate of the upper left corner of the triangle
	 * @param size the width and height of the triangle
	 * @param g the graphics object to draw the triangle on
	 */
	public void drawTriangle(int x, int y, int size, Graphics g) {
		Polygon triangle = new Polygon();
		triangle.addPoint(x, y);
		triangle.addPoint(x + size / 2, y + size);
		triangle.addPoint(x + size, y);
		g.fillPolygon(triangle);		
	}
	
	/** redraw the screen
	 * 
	 * @param g the graphic object to draw on
	 */	
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		triangleOrder(5, 205, 425, 400, g);
	}
	public void triangleOrder(int initOrder, int x, int y, int size, Graphics g){
		this.drawTriangle(x, y, size, g);
		if (initOrder > 1){
			this.triangleOrder(initOrder-1, x-size/4, y+size/2, size/2, g);
			this.triangleOrder(initOrder-1, x+size/4, y-size/2, size/2, g);
			this.triangleOrder(initOrder-1, x+size-size/4, y+size/2, size/2, g);
		}
	}

	public static void main(String [] args) {
		SierpinskiTriangle st = new SierpinskiTriangle();
		st.setVisible(true);
	}
}
