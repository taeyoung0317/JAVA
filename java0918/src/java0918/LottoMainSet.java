package java0918;

import java.util.Scanner;
import java.util.TreeSet;

public class LottoMainSet {

	public static void main(String[] args) {
		// 1-45까지의 숫자 6개를 중복없이 저장
		// 어떤 자료구조를 이용해서 저장하는 것이 가장
		// 코드를 줄일 수 있는지 생각
		// 동일한 자료형의 데이터를 여러 개 저장하는 자료구조

		// 최근에는 배열도 List로 취급
		// 배열
		// ArrayList, LinkedList, Stack
		// PriorityQueue, ArrayDeque
		// HashSet, LinkedHashSet, TreeSet


		//중복된 데이터를 저장하지 않고 데이터의 크기 순서대로
		//저장하는 자료구조 객체 만들기
		TreeSet <Integer> lotto = new TreeSet<>();

		Scanner sc = new Scanner(System.in);
		// 결과가 변하지 않는 자주 접근하는 속성이나 메소드의 결과는
		// 지역변수에 저장하고 사용
		for (; lotto.size() < 6;) {
			// input에 정수 입력받기
			System.out.printf("1-45 사이의 숫자를 입력해 주십시오.\n");
			int input = sc.nextInt();

			// 1부터 45사이가 아니라면 다시 입력
			if (input < 1 || input > 45) {
				System.out.printf("1-45사이의 숫자를 다시 입력해 주시기 바랍니다.\n");
				continue;
			}
			
			//데이터 삽입 여부를 r에 저장하면서 삽입
			boolean r = lotto.add(input);
			
			//삽입에 실패했다면 - 데이터 중복
			if(r==false) {
				System.out.printf("중복된 숫자를 입력하셨습니다.다시 입력해 주십시오.\n");
			}
		}

		// TreeSet은 데이터를 크기 순서대로 접근할 수 있는 방법을 가지고 있기 때문에
		//정렬을 할 필요가 없음
		for(Integer temp : lotto) {
			System.out.printf("%d\t", temp);
		}

		sc.close();
	}

}
