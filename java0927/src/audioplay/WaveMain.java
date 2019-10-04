package audioplay;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class WaveMain {

	public static void main(String[] args) {
		/*
		try {
			//로컬 파일의 URL
			//인터넷에 있다면 인터넷주소를 적어도 됨
			//mp3파일 재생 불가
			URL url = new URL("file:////Users/503main/Documents/java-moon/java0927/pottery_workshop.wav");
			AudioClip audio = Applet.newAudioClip(url);
			audio.play();
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
		}
		
		*/
		Player player;
		
		try {
			player = new Player(new FileInputStream("/Users/503main/Documents/java-moon/java0927/Twinkle.mp3"));
			player.play();
			
			//mp3 재생은 javafx 패키지의 MediaPlayer 클래스로도 가능
			//자바 1.8에서는 실행 안됨 상위 버전에서 가능
			/*
			javafx.scene.media.Midia m = new javafx.scene.media.Midia("파일 경로");
			MediaPlayer p = new MediaPlayer(m);
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
