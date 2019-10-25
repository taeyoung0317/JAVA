package Graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class MyPanel extends JPanel {
	
	public Color color = new Color(100,100,100);
	public void paint(Graphics g) {
		// g.setColor(Color.BLUE);
		g.setColor(color);
		g.drawString("색상변경", 130, 130);
	}
	
}
