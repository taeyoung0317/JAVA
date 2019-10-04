package java0917;

import java.util.Arrays;

public class FileNameMain {

	public static void main(String[] args) {
		//FileName의 배열을 생성
		FileName f1 = new FileName();
		f1.setName("Java");
		f1.setSize(33);
		f1.setType("PPT");
		
		FileName f2 = new FileName();
		f2.setName("Swift");
		f2.setSize(17);
		f2.setType("EXCEL");
		
		FileName f3 = new FileName();
		f3.setName("C");
		f3.setSize(43);
		f3.setType("WORD");
		
		//위에서 만든 FileName 객체 3개를 가지고 배열을 생성
		FileName [] ar = {f1,f2,f3};
		
		//배열의 데이터를 확인
		for(FileName temp : ar) {
			//객체 이름을 %s에 매핑 시켜서 출력하면 toString()의 결과가 출력
			System.out.printf("%s\n",temp);
		}

		//배열의 데이터 정렬
		//데이터를 정렬하려면 크기 비교하는 메소드가 구현되어 있어야 합니다.
		//Comparable 인터페이스의 compareTo 메소드입니다.
		//아니면 Comparator 인터페이스를 구현한 객체를 대입을 해주어야 합니다.
		Arrays.sort(ar);
		System.out.printf("==============\n");
		
		//배열의 데이터를 확인
		for(FileName temp : ar) {
			//객체 이름을 %s에 매핑 시켜서 출력하면 toString()의 결과가 출력
			System.out.printf("%s\n",temp);
		}
	}

}
