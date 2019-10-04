package awt;

import java.awt.Color;
import java.awt.Frame;

public class MyFrame extends Frame {
	// 배경색이 될 배열
	Color[] colors = { Color.blue, Color.orange, Color.gray,
			Color.green, Color.darkGray, Color.magenta };
	
	String [] titles = {"JAVA","AVAJ","VAJA","AJAV"};

	// 인덱스 변수 설정
	int i = 0;

	public MyFrame() {
		// 옵션 설정
		this.setTitle("JAVA");
		this.setBackground(Color.white);
		setSize(200, 200);
		setLocation(100, 100);
		setVisible(true);

		// 색상을 변경하는 스레드
		Thread th = new Thread() {
			public void run() {
				while (true) {
					i = i + 1;
					try {
						Thread.sleep(500);
						setBackground(colors[i % colors.length]);
						setTitle(titles[i%titles.length]);
					} catch (Exception e) {
						System.out.printf("%s\n", e.getMessage());
					}
				}
			}
		};
		th.start();
	}

}
