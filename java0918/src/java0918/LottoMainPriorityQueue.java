
package java0918;

import java.util.PriorityQueue;
import java.util.Scanner;

public class LottoMainPriorityQueue {

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

		// 배열을 사용하는 경우
		// 정수 6개를 저장하는 배열
		PriorityQueue<Integer> lottoQueue = new PriorityQueue<>();

		Scanner sc = new Scanner(System.in);
		// 결과가 변하지 않는 자주 접근하는 속성이나 메소드의 결과는
		// 지역변수에 저장하고 사용
		for (int i = 0; i < 6; i = i + 1) {
			// input에 정수 입력받기
			System.out.printf("1-45 사이의 숫자를 입력해 주십시오.\n");
			int input = sc.nextInt();

			// 1부터 45사이가 아니라면 다시 입력
			if (input < 1 || input > 45) {
				System.out.printf("1-45사이의 숫자를 다시 입력해 주시기 바랍니다.\n");
				i = i - 1;
				continue;
			}
			// 중복검사를 해서 통과하지 못하면 다시 입력
			// 처음에는 할 필요가 없어서 i>0 보다 클 때
			int j = 0;
			//큐를 순회하면서 동일한 데이터가 있으면 j=1로 변경
			for(Integer temp : lottoQueue) {
				if(input==temp) {
					j=1;
					break;
				}
			}
			//중복된 데이터가 있으면 다시 입력받기
			if(j==1) {
				System.out.printf("중복된 숫자를 입력하셨습니다.다시 입력해 주십시오.\n");
				i=i-1;
				continue;
			}
			
			// 유효성 검사를 통과하면 데이터를 배열에 저장
			lottoQueue.add(input);

		}

		// 우선순위 큐는 poll을 출력하면 순서대로 출력
		for(int i=0;i<6;i=i+1) {
			System.out.printf("%d\t", lottoQueue.poll());
		}

		sc.close();
	}

}
