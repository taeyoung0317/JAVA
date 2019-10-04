package thread;

//Thread 클래스를 상속받은 클래스
public class ThreadEx extends Thread {
	//1초씩 쉬면서 0-9까지 출력
	public void run() {
		for(int i=0;i<10;i=i+1) {
			System.out.printf("%d\n", i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.printf("%s\n", e.getMessage());
			}
			
		}
	}
}
