package Graphic;

import javax.swing.JFrame;

public class MouseFrame extends JFrame {
	
	public MouseFrame() {
		
		MousePanel panel = new MousePanel();
		add(panel);
		
		setBounds(100,100,1000,1000);
		setTitle("MouseAction");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

}
