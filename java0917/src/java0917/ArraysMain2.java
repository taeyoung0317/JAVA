package java0917;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ArraysMain2 {

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
		
		//키보드로부터 입력받기 위한 객체를 생성
		Scanner sc = new Scanner(System.in);
		
		System.out.printf("정렬 기준을 선택하세요.(1.이름, 2.크기, 3.종류)");
		int manual=sc.nextInt();
		
		//Comparator는 제너릭이 적용된 인터페이스라서 객체를 생성할 때
		//자료형을 결졍해 주어야 합니다.
		if(manual==1) {
			Arrays.sort(ar, new Comparator<FileName>(){

				@Override
				public int compare(FileName o1, FileName o2) {
					//o1과 o2 의 name을 비교
					return o1.getName().compareTo(o2.getName());
				}
				
			});
		}else if(manual==2) {
			Arrays.sort(ar, new Comparator<FileName>() {

				@Override
				public int compare(FileName o1, FileName o2) {
					return o1.getSize() - o2.getSize();
				}
				
			});
		}else if(manual==3) {
			Arrays.sort(ar, new Comparator<FileName>() {

				@Override
				public int compare(FileName o1, FileName o2) {
					return o1.getType().compareTo(o2.getType());
				}
				
			});
		}else {
			System.out.printf("잘못된 명령어를 입력하셨습니다.");
			//프로그램 종료
			System.exit(0);
		}
		
		for(FileName temp : ar) {
			System.out.printf("%s\n", temp);
		}
		
		//입력받는 객체 닫기
		sc.close();

	}

}
