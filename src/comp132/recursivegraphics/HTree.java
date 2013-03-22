package comp132.recursivegraphics;

/** draw the H-tree fractal of a given order 
 * 
 * @author Robert Sedgewick
 * @author Tim Wahls
 * @author (YOUR NAME HERE)
 * @version (PUT DATE HERE)
 */

import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Color;

public class HTree extends JFrame {
	
	private static final int WIDTH = 810;
	private static final int HEIGHT = 830;
	
	/** initialize a frame to draw the H-tree on */
	public HTree() {
		super("H-tree");
		this.setBackground(Color.WHITE);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	
	/** draw an H on the screen
	 * 
	 * @param x the x coordinate of the upper left corner of the H
	 * @param y the y coordinate of the upper left corner of the H
	 * @param size the height and width of the H
	 * @param g the graphics object to draw the H on
	 */
	private void drawH(int x, int y, int size, Graphics g) {
		g.drawLine(x, y, x, y + size);
		g.drawLine(x + size, y, x + size, y + size);
		g.drawLine(x, y + size / 2, x + size, y + size / 2);		
	}
	
	
	/** redraw the screen
	 * 
	 * @param g the graphic object to draw on
	 */
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		hOrder(7, 205, 225, 400, g);
	}
	
	public void hOrder(int initOrder, int x, int y, int size, Graphics g){
		this.drawH(x, y, size, g);
		if (initOrder >1){
			this.hOrder(initOrder - 1, x-size/4, y-size/4, size/2, g);
			this.hOrder(initOrder - 1, x+size-size/4, y-size/4, size/2, g);
			this.hOrder(initOrder - 1, x-size/4, y+size-size/4, size/2, g);
			this.hOrder(initOrder - 1, x+size-size/4, y+size-size/4, size/2, g);
		}
	}
	public static void main(String [] args) {
		HTree st = new HTree();
		st.setVisible(true);
	}
}
