package multithread;

public class Producer extends Thread {
	//Consumer 와 공유할 객체
	Product product;
	
	//생성자에서 product를 대입받아서 인스턴스 변수에 대입
	public Producer(Product product) {
		//this가 붙으면 메소드 외부에서 속성이나 메소드를 찾습니다.
		this.product = product;
	}

	@Override
	//java에서는 int 보다 작은 자료형을 가지고 산술 연산을 하면 int 로 변환해서 처리합니다.
	//산술연산의 결과는 최소가 int
	//산술연산 결과를 int보다 작은 자료형에 저장할 때는
	//강제 형 변환을 해주어야 합니다.
	public void run() {
		for(char ch='A';ch<='Z';ch=(char)(ch+1)) {
			product.put(ch);
		}
	}
}
