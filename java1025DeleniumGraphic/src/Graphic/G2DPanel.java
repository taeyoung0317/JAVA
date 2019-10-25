package Graphic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class G2DPanel extends JPanel {
	
	//화면에 보여질 때나 repaint 메소드를 호출하면 화면에 출력되는 메소드
	@Override //상위 클래스에 있는 메소드를 재정의 한다는 어노테이션
	//상위 클래스에 메소드가 존재하지 않으면 컴파일 에러 발생
	public void paint(Graphics g) {
		/*
		//그림 그리기
		g.fillRect(125, 125, 50, 50);
		//그래픽스 객체 변환
		Graphics2D g2 = (Graphics2D)g;
		//색상 설정 - fill은 채우기 효과
		g2.setColor(Color.green);
		g2.fill(new Rectangle2D.Double(200,200,80,80));
		//색상 설정 - draw는 테두리 효과(채우기 없음 선색만)
		
		g2.setColor(Color.blue);
		g2.draw(new Ellipse2D.Double(200,200,30,30));
		
		//그라이데이션 설정
		g2.setPaint(new GradientPaint(5,30,Color.RED,10,50,Color.black,true));
		g2.fill(new Rectangle2D.Double(300,300,80,80));
		//선두께 수정
		g2.setStroke(new BasicStroke(10));
		g2.draw(new Ellipse2D.Double(200,200,30,30));
		
		//색상 변경
		g2.setPaint(Color.black);
		float [] dashes = {5};
		g2.setStroke(new BasicStroke(3, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10,dashes,0));
		g2.draw(new Ellipse2D.Double(150,150,100,100));
		*/
		
		//Image 객체 만들기
		Image image = Toolkit.getDefaultToolkit().getImage("/Users/503main/Downloads/gclass.jpg");
		//그림 출력 - 좌표만 입력해서 출력 : 원본 크기 그대로
		//g.drawImage(image, 100, 100, this);
		
		//50,50 에 300,300 크기로 원본을 출력
		//g.drawImage(image,50,50,300,300,this);
		
		//50,50에서 100,100만큼을 분할해서
		//50,50부터 300,300까지에 출력
		//g.drawImage(image,50,50,300,300,50,50,100,100,this);
		
		
		//출력 영역을 수정
		g.setClip(0,0,100,200);
		g.drawImage(image,50,50,300,300,0,0,200,200,this);
		
		
	}

}
