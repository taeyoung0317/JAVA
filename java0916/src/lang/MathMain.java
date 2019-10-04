package lang;

public class MathMain {

	public static void main(String[] args) {
		int [] ar = {1, 2, 3, 4, 5, 6};
		//0.0 - 1.0 사이의 랜덤한 실수를 만들어서 저장
		double r = Math.random();
		//ar 배열의 인덱스 범위 내의 숫자로 변경하기
		int idx = (int)(r*100) % ar.length;
		System.out.printf("랜덤한 주사위 숫자 :%d\n", ar[idx]);
		
	}

}
