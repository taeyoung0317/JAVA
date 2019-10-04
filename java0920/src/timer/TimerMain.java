package timer;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

//타이머 작업을 위한 클래스
class TimerTaskEx extends TimerTask{
	//타이머로 동작할 작업	
	public void run() {
		System.out.printf("TimerTask!\n");
	}
}

public class TimerMain {

	public static void main(String[] args) {
		//Date 만들기
		Calendar cal = new GregorianCalendar(2019,8,20,11,15,0);
		Date date = new Date(cal.getTimeInMillis());
		//Timer 만들기
		Timer timer = new Timer();
		//2019년 9월 20일 11시 15분에 동작하도록 설정
		//timer.schedule(new TimerTaskEx(), date);
		
		//5초 후부터 2초마다 작업을 수행
		timer.schedule(new TimerTaskEx(), 5000, 2000);
		
		
		//timer.cancel();

	}

}
