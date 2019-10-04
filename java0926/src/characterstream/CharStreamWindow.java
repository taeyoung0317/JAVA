package characterstream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CharStreamWindow extends JFrame {
	//파일에 읽기와 쓰기를 수행할 버튼
	JButton btnWrite, btnRead, bufRead, bufWrite;
	//입력 내용과 출력을 담당할 텍스트 영역
	JTextArea display;
	
	public CharStreamWindow() {
		
		//버튼을 상단에 배치
		JPanel p = new JPanel();
		btnWrite = new JButton("문자 스트림 기록");
		btnRead = new JButton("문자 스트림 읽기");
		bufRead = new JButton("버퍼 문자 스트림 읽기");
		bufWrite = new JButton("버퍼 문자 스트림 기록");
		p.add(btnWrite);
		p.add(btnRead);
		p.add(bufWrite);
		p.add(bufRead);
		
		add("North",p);
		
		//출력영역을 중앙에 배치
		display = new JTextArea(30,30);
		add(display);
		
		//현재 클래스의 객체를 EventHandler에게 넘겨서 객체를 생성
		EventHandler handler = new EventHandler(this);
		//버튼들의 객체 이벤트 처리를 handler에게 위임
		btnWrite.addActionListener(handler);
		btnRead.addActionListener(handler);
		bufRead.addActionListener(handler);
		bufWrite.addActionListener(handler);
		
		
		setBounds(200,200,300,300);
		pack();
		setTitle("CharStream");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

}
