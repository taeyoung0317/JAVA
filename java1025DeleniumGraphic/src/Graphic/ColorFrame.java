package Graphic;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorFrame extends JFrame {
	
	public ColorFrame() {
		
		JButton btn1 = new JButton("빨강");
		JButton btn2 = new JButton("노랑");
		JButton btn3 = new JButton("파랑");
		
		final MyPanel myPanel = new MyPanel();
		add("Center",myPanel);
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				myPanel.color = Color.red;
				//화면을 다시 그려주는 메소드
				myPanel.repaint();				
			}
			
		});
		
		JPanel northPanel = new JPanel();
		northPanel.add(btn1);
		northPanel.add(btn2);
		northPanel.add(btn3);
		
		add("North",northPanel);
		

		
		setBounds(200,200,300,300);
		setTitle("Color!");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
