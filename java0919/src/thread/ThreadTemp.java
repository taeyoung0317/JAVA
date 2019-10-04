package thread;

public class ThreadTemp extends Thread {
	//스레드로 수행할 내용을 가지는 메소드
	@Override
	public void run() {
		for(int i=0;i<5;i=i+1) {
			//1초마다 쉬면서 Hello Java를 5번 출력
			System.out.printf("Hello Java!\n");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.printf("%s\n", e.getMessage());
			}
			
		}
	}
}
