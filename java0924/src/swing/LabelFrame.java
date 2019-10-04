package swing;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LabelFrame extends JFrame {
	
	JLabel lbl;
	ImageIcon [] images;
	
	public LabelFrame() {
		setLayout(new FlowLayout());
		
		//ImageIcon 배열 만들기
		images = new ImageIcon[3];
		images[0] = new ImageIcon("./h1.png");
		images[1] = new ImageIcon("./h2.png");
		images[2] = new ImageIcon("./h3.png");
		
		
		//닫기 버튼을 눌렀을 때 종료 기능을 수행하도록 설정
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//현재 디렉토리 경로를 화인
		String curDir = System.getProperty("user.dir");
		System.out.printf("%s\n",curDir);
		
		//절대 경로를 이용하여 ImageIcon을 생성
		//Windows의 절대경로는 디렉토리기호가 \\
		//ImageIcon imageicon = new ImageIcon("/Users/503main/Downloads/h1.png");
		
		//상대 경로 이용
		///Users/503main/Documents/java-moon/java0924 안에 존재할경우
		//ImageIcon imageicon = new ImageIcon("./h1.png");
		
		///Users/503main/Documents/java-moon 안에 존재할경우
		//ImageIcon imageicon = new ImageIcon("../h1.png");
		
		//이미지 아이콘을 이용해서 레이블을 생성
		lbl = new JLabel(images[0]);
		add(lbl);
		
		Thread th = new Thread() {
			public void run() {
				int idx = 0;
				while(true) {
					try {
						idx = idx + 1;
						Thread.sleep(50);
						lbl.setIcon(images[idx%images.length]);
					}catch(Exception e) {}
				}
			}
		};
		
		th.start();
		
		setBounds(200,200,400,400);
		setTitle("레이블 애니메이션");
		setVisible(true);
	}

}
