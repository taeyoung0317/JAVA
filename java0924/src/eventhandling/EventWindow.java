package eventhandling;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class EventWindow extends Frame {
	
	Button btn;
	
	public EventWindow() {
		/*
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				btn.setLocation(e.getX(),e.getY());
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		*/
		
		
		setLayout(null);
		
		btn=new Button("Hover");
		btn.setBounds(20, 20, 30, 30);
		add(btn);
		
		//현재 프레임의 키보드 이벤트를 처리
		this.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				//문자 키를 눌렀을  때만 동작
				//getKeyChar는 대소문자 구분을 합니다.
				System.out.printf("문자 : %c\n",e.getKeyChar());
				//키보드를 누르면 무조건 동작
				//대소문자 구분을 하지 않습니다.
				System.out.printf("숫자 : %d\n",e.getKeyCode());
				
				
				int x=20;
				int y=20;
				Random r = new Random();
				x=r.nextInt(350);
				y=r.nextInt(350);
				btn.setLocation(x,y);
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
	
		
		//AWT 나 SWING은 이벤트 처리를 Delegate 패턴으로 처리
		//Delegate 패턴 : 이벤트가 발생한 객체가 이벤트를 처리하지 않고
		//별도의 객체를 만들어서 처리하도록 하는 패턴 - 위임
		btn.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int x=20;
				int y=20;
				Random r = new Random();
				x=r.nextInt(350);
				y=r.nextInt(350);
				btn.setLocation(x,y);
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
								
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				btn.setForeground(Color.red);
				btn.setBackground(Color.blue);
				System.out.printf("x:%d,y:%d\n",e.getX(),e.getY());
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn.setBackground(Color.green);
				btn.setForeground(Color.black);
				
			}


			
		});
		
		
		setBounds(100,100,400,400);
		setTitle("EventWindow!");
		setVisible(true);
		
	}

}
