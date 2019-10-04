package lang;

public class StringMain2 {

	public static void main(String[] args) {
		String string = "HelloWorld333";
		// 위의 문자열에서 소문자를 전부 대문자로 변환해서 출력하기 : HELLO WORLD!!333
		String result = "";
		// 각 문자를 순회
		int len = string.length();
		for (int i = 0; i < len; i = i + 1) {
			char ch = string.charAt(i);
			// 문자가 소문자인지 확인
			if (ch >= 'a' && ch <= 'z') {
				// 소문자인 경우는 32를 빼서 대문자로 변환
				ch = (char) (ch - 32);
			}
			result = result + ch;
		}
		System.out.printf("result : %s\n", result);

		// 위의 코드를 수정해서 대문자를 소문자로 변경
		String result2 = "";
		for (int i = 0; i < len; i = i + 1) {
			char ch = string.charAt(i);
			// 문자가 소문자인지 확인
			if (ch >= 'A' && ch <= 'Z') {
				// 소문자인 경우는 32를 빼서 대문자로 변환
				ch = (char) (ch + 32);
			}
			result2 = result2 + ch;
		}
		System.out.printf("result : %s\n", result2);

		// 비밀번호는 영문 대문자 1개 소문자 1개 그리고 숫자 1개 그 이외의 문자 1개
		// 이상으로 구성되어야 합니다.
		// 각각의 문자가 몇개인지 셀수 있어야 합니다.
		// string 에 저장된 문자열의 대문자개수, 소문자개수, 숫자개수, 그 이외의 문자 개수 세기
		int dae = 0;
		int so = 0;
		int su = 0;
		int etc = 0;
		// string 의 대소문자, 숫자 , 그 이외문자의 개수를 세서 저장하기
		// dae=2, so=8, su=3, etc=3으로 나오도록 작성
		for (int i = 0; i < len; i = i + 1) {
			char ch = string.charAt(i);
			if (ch >= 'A' && ch <= 'Z') {
				dae = dae + 1;
			} else if (ch >= 'a' && ch <= 'z') {
				so = so + 1;
			} else if (ch >= '0' && ch <= '9') {
				su = su + 1;
			} else {
				etc = etc + 1;
			}
		}
		System.out.printf("대문자 개수 : %d\n", dae);
		System.out.printf("소문자 개수 : %d\n", so);
		System.out.printf("숫자 개수 : %d\n", su);
		System.out.printf("그 외의 문자 개수 : %d\n", etc);

		// dae, so, su, etc가 모두 1보다 같다면 적합한 비밀번호
		// 그렇지 않다면 (4개 중에 하나라도 0이 있으면) 적합하지 않은 비밀번호라고 출력
		if (dae > 0 && so > 0 && su > 0 && etc > 0) {
			System.out.printf("적합한 비밀번호 입니다.");
		} else {
			System.out.printf("적합하지 않은 비밀번호입니다. 대소문자, 숫자, 그 외의 특수문자를 "
					+ "조합하여 다시 설정해 주십시오.\n");
		}
		//다른 방식
		if (dae * so * su * etc != 0) {
			System.out.printf("적합한 비밀번호 입니다.");
		} else {
			System.out.printf("적합하지 않은 비밀번호입니다. 대소문자, 숫자, 그 외의 특수문자를 "
					+ "조합하여 다시 설정해 주십시오.\n");
		}
	}

}
