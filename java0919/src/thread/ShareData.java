package thread;

public class ShareData implements Runnable {
	//합계를 저장할 변수
	private int result;
	//인덱스 변수
	private int idx;
	
	//idx를 1000번 정도 증가시키면서 result에 더하는 메소드
	//synchronized 가 붙은 메소드는 자신의 작업이 완료되기 전에는
	//다른 작업할 수 없도록 합니다.
	private void sum() {
		for(int i=0;i<3333;i=i+1) {
			try {
				//이 영역에서 사용중인 데이터는 다른 곳에서 수정할 수 없도록 합니다.
				synchronized(this) {
					idx=idx+1;
					Thread.sleep(1);
					result=result+idx;
				}
			}catch(Exception e) {}
		}
	}
	
	//스레드로 동작할 내용을 가진 메소드
	@Override
	public void run() {
		sum();
	}
	
	//result를 리턴하는 메소드
	public int getResult() {
		return result;
	}
}
