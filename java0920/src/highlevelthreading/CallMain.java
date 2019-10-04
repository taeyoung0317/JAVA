package highlevelthreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallMain {

	public static void main(String[] args) {
		//스레드 풀을 생성
		//스레드 풀 : 스레드를 미리 만들어 놓고 스레드를 실행하는 개념
		//한 번에 실행할 개수를 설정해서 객체를 생성
		//연산하는 작업이 주가 되는 스레드르르 만들 때는
		//동시에 수행되는 개수르 코어의 개수로 설정하는 것이 좋습니다.
		//쿼드 코어 : 제어장치는 하나인데 연산장치는 4개
		Runtime.getRuntime().availableProcessors();
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		//스레드를 생성해서 풀에 추가
		Future<Integer> f1 = service.submit(new ThreadEx(10));
		Future<Integer> f2 = service.submit(new ThreadEx(1000));
		Future<Integer> f3 = service.submit(new ThreadEx(10000));
		Future<Integer> f4 = service.submit(new ThreadEx(100000));
		
		try {
			//스레드를 실행하고 결과를 가져오기
			//결과가 순서대로 안나올 수도 있습니다.
			//먼저 완료된 작업이 먼저 출력
			System.out.printf("f1:%d\n", f1.get());
			System.out.printf("f2:%d\n", f2.get());
			System.out.printf("f3:%d\n", f3.get());
			System.out.printf("f4:%d\n", f4.get());
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
		}

	}

}
