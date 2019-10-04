package eventhandling;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EventRouting extends Frame {
	
	Button blueBtn, greenBtn;
	
	public EventRouting() {
		
		setLayout(new FlowLayout());
		
		blueBtn=new Button("청색");
		greenBtn=new Button("녹색");
		
		add(blueBtn);
		add(greenBtn);
		
		/*
		 //	버튼 2개의 이벤트 처리를 개의 객체를 생성해서 처리
		blueBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.blue);
				
			}
			
		});
		
		greenBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setBackground(Color.green);
				
			}
			
		});
		*/
		
		//이벤트처리객체를 먼저 생성
		ActionListener al= new ActionListener() {

			@Override
			//이벤트가 발생한 객체 -e.getSource()
			public void actionPerformed(ActionEvent e) {
				if(e.getSource()==blueBtn) {
					setBackground(Color.blue);
				}else if(e.getSource()==greenBtn) {
					setBackground(Color.green);
				}
				
			}
			
		};
		//2개 버튼의 액션 이벤트 처리를 동일한 객체에게 위임 - 이벤트 라우팅
		
		EH eh = new EH();
		eh.setFrame(this);
		
		
		blueBtn.addActionListener(al);
		greenBtn.addActionListener(al);
		
		
		setBounds(100,100,300,300);
		setTitle("EventRouting");
		setVisible(true);
	}

}
