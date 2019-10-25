package Graphic;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	
	public MyFrame() {
		
		
		setBounds(200,200,300,300);
		setTitle("Graphic!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	//화면에 출력될 때 호출되는 메소드
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.orange);
		g.drawString("안녕하세요", 100, 50);
		g.setColor(Color.green);
		g.drawRect(125, 125, 50, 50);
	}

}
