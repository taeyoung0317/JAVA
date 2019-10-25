package Graphic;

import javax.swing.JFrame;

public class G2DFrame extends JFrame {
	
	public G2DFrame() {
		
		G2DPanel panel = new G2DPanel();
		add("Center",panel);
		
		setBounds(200,200,500,500);
		setTitle("Graphics2D");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

}
