package multithread;

import java.util.ArrayList;
import java.util.List;

public class Product {
	// 문자를 저장할 공유 변수
	List<Character> vec = new ArrayList<>();

	// 문자를 1개 받아서 vec 에 저장하는 메소드
	//생산하는 메소드 
	public synchronized void put(char ch) {
		//vec에 데이터가 5개 이상이면 대기
		if(vec.size()>=5) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		vec.add(ch);
		
		//공유 데이터를 생성하고 나면 notify()를 호출
		notify();
		
		System.out.printf("vec에 %c를 추가\n", ch);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.printf("현재 개수 : %d\n", vec.size());
	}

	// 첫번째 문자를 지우고 출력하는 메소드 : 소비하는 메소드
	public synchronized void get() {
		// 사용할 데이터가 없으면 대기
		if (vec.size() == 0) {
			try {
				//Object 클래스의 메소드
				//notify() 가 호출될 때까지 대기
				wait();
			} catch (Exception e) {
				System.out.printf("%s\n", e.getMessage());
			}
		}
		// 첫번째 데이터를 지우고 ch에 대입
		char ch = vec.remove(0);
		notify();
		System.out.printf("vec에서 %c를 제거\n", ch);
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.printf("현재 개수 : %d\n", vec.size());
	}
}
