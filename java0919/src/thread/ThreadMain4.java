package thread;

public class ThreadMain4 {

	public static void main(String[] args) {
		//ShareData 객체 생성
		ShareData sd = new ShareData();
		//스레드르르 생성해서 시작
		Thread th1 = new Thread(sd);
		th1.start();
		Thread th2 = new Thread(sd);
		th2.start();
		
		
		
		try {
			Thread.sleep(20000);
		}catch(Exception e) {}

		//결과 출력
		System.out.printf("%d\n", sd.getResult());
		
		
	}

}
