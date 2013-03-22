package comp132.recursivegraphics;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class PlusTree extends JFrame{
	private static final int WIDTH = 810;
	private static final int HEIGHT = 830;
	
	public PlusTree (){
		super("Plus Tree");
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(WIDTH, HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void drawPlus(int x, int y, int size, Graphics g){
		g.drawLine(x+size/2, y, x+size/2, y+size);
		g.drawLine(x, y+size/2, x+size, y+size/2);
		
	}
	public void paint(Graphics g) {
		g.setColor(Color.RED);
		plusOrder(8, 205, 225, 400, g);
	}
	public void plusOrder(int initOrder, int x, int y, int size, Graphics g){
		this.drawPlus(x, y, size, g);
		if (initOrder > 1){
			this.plusOrder(initOrder-1, x+size/4, y-size/2, size/2, g);
			this.plusOrder(initOrder-1, x-size/2, y+size/4, size/2, g);
			this.plusOrder(initOrder-1, x+size/4, y+size, size/2, g);
			this.plusOrder(initOrder-1, x+size, y+size/4, size/2, g);
		}
	}
	public static void main(String[] args){
		PlusTree pt = new PlusTree();
		pt.setVisible(true);
	}
}
