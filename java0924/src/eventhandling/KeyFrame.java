package eventhandling;

import java.awt.Frame;
import java.awt.Label;

public class KeyFrame extends Frame {
	
	Label lbl;
	
	public KeyFrame() {
		setLayout(null);
		
		
		//레이블을 생성해서 배치
		lbl = new Label("@");
		lbl.setBounds(30, 30, 50, 50);
		add(lbl);
		
		//Frame에 윈도우 이벤트가 발생하면
		//KeyEvent 객체에게 처리해달라고 요청
		KeyEventHandler keyevent = new KeyEventHandler(lbl);
		this.addWindowListener(keyevent);
		this.addKeyListener(keyevent);
		
		
		
		setBounds(200,200,600,600);
		setTitle("KeyEvent!");
		setVisible(true);
	}


}
