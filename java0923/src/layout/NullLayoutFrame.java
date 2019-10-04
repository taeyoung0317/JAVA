package layout;

import java.awt.Button;
import java.awt.Frame;
import java.util.Random;

public class NullLayoutFrame extends Frame {
	
	Button btn;
	int x = 10;
	int y = 20;
	public NullLayoutFrame() {
		//레이아웃을 null로 설정
		this.setLayout(null);
		
		btn=new Button("Button");
		//Layout이 null일 때는 위치와 크기를 직접 설정
		btn.setBounds(x, y, 50, 50);
		add(btn);
		
		this.setTitle("NullLayout!!");
		this.setBounds(200,200,600,600);
		this.setVisible(true);
		
		//스레드 만들고 실행
		Thread th = new Thread() {
			boolean flag = false;
			public void run() {
				while(true) {
					try {
						Thread.sleep(1000);
						Random r = new Random();
						x=r.nextInt(450);
						y=r.nextInt(450);
						btn.setLocation(x, y);
						btn.setVisible(flag);
						flag=!flag;
						
						
					}catch(Exception e) {
						
					}
				}
			}
		};
		th.start();
	}

}
