package highlevelthreading;

import java.util.concurrent.Callable;

//생성자가 정수 한개를 대입받고 1부터 그 정수까지의 합을
//계산한 후 리턴하는 스레드

public class ThreadEx implements Callable<Integer> {
	
	private int n;
	
	
	public ThreadEx(Integer n) {
		//기본형과 Wrapper는 바로 대입 가능
		//Boxing & Unboxing 이라고 합니다.
		//this.n = n.intValue()가 수행됩니다.
		this.n = n;
	}


	@Override
	public Integer call() throws Exception {
		int total = 0;
		for(int i=1;i<n+1;i=i+1) {
			total=total+i;
		}
		return total;
	}

}
