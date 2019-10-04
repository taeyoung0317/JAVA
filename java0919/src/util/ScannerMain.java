package util;

import java.util.Scanner;

public class ScannerMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//번호와 이름을 입력받기 : 번호는 정수 이름은 문자열
		System.out.printf("번호:\n");
		int num = sc.nextInt();
		
		//앞에 정수를 입력받은 후에 문자열을 입력받으려고 하면
		//입력받는 문장이 실행이 안될 수 있습니다.
		sc.nextLine(); //엔터를 버퍼에서 지우기 위해서 사용
		System.out.printf("이름 :\n");
		String name = sc.nextLine();
		System.out.printf("이름 : %d ,번호 : %s\n", num, name);
		
		
		
		
		sc.close();

	}

}





