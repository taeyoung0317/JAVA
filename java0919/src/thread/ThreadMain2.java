package thread;

public class ThreadMain2 {

	public static void main(String[] args) {
		//Thread 클래스로 부터 상속받은 클래스의 객체를 생성
		ThreadTemp th1 = new ThreadTemp();
		//스레드 시작
		th1.start();
		
		//anonymous class 를 이용하는 방법
		Thread th2 = new Thread() {
			public void run() {
				for(int i=0;i<5;i=i+1) {
					System.out.printf("Thread\n");
					try {
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.printf("%s\n", e.getMessage());
					}
				}
			}
		};
		th2.start();
		
		//Runnable 인터페이스를 이용하는 방법
		Runnable r =new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<5;i=i+1) {
					try {
						System.out.printf("Runnable\n");
						Thread.sleep(1000);
					}
					//스레드를 강제로 종료할 수 있도록 만들고자 할 때
					//InterruptedException이 발생하면
					//return 하도록 코드를 작성
					catch(InterruptedException e) {
						return;
					}
				}
				
			}
			
		};
		//Runnable 인터페이스를 이용하는 경우에는 
		//Thread 클래스의 객체를 만들고 그 객체를 가지고 start
		Thread th3 =new Thread(r);
		th3.start();
		
		
		Thread th4 = new Thread() {
			//10초 동안 1초씩 쉬면서 Daemon이라는 문자열을 출력
			@Override
			public void run() {
				for(int i=0;i<10;i=i+1) {
					try {
						System.out.printf("Daemon\n");
						Thread.sleep(1000);
					}catch(Exception e) {
						System.out.printf("%s\n", e.getMessage());
					}
				}
				
			}
		};
		//데몬 스레드로 설정 - 다른 스레드들이 작업을 하는 동안만 이 스레드는 동작합니다.
		//데몬설정이 시작하는 것보다 먼저 나와야 합니다.
		th4.setDaemon(true);
		th4.start();
		
		//스레드의 우선 순위 설정
		//긴 시간동안 동작하는 스레드일 때 우선순위의 영향을 받음
		th1.setPriority(Thread.MIN_PRIORITY);
		th2.setPriority(Thread.MAX_PRIORITY);
		th3.setPriority(Thread.MAX_PRIORITY);
		
	}

}
