package characterstream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BufferWindow extends JFrame {
	
	JButton logRead;
	JTextArea display;
	
	public BufferWindow() {
		
		JPanel p = new JPanel();
		logRead = new JButton("로그파일 읽기");
		p.add(logRead);
		add("North", logRead);
		
		
		
		
		setBounds(100,100,300,300);
		pack();
		setTitle("로그파일 트래픽의 합계구하기");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
	}

}
