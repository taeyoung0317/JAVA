package java0918;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

public class ListMain {

	public static void main(String[] args) {
		//문자열을 저장하는 Stack을 생성
		Stack<String> stack = new Stack<>();
		//데이터를 삽입할 때는 push
		stack.push("색상 보정");
		stack.push("레이어 추가");
		
		//데이터를 삭제하면서 가져오기는 pop
		//pop 대신에 peek를 사용하면 2개의 결과가 동일
		String new_data=stack.pop();
		System.out.printf("%s\n", new_data);
		new_data = stack.pop();
		System.out.printf("%s\n", new_data);
		
		LinkedList<String> li = new LinkedList<>();
		li.add("133");
		li.add("11");
		li.add("364");
		//LinkedList는 순서대로 출력
		for(String temp : li) {
			System.out.printf("%s ", temp);
		}
		
		System.out.printf("\n---------------------\n");
		
		//우선순위를 가지고 데이터를 저장하는 큐
		PriorityQueue<String> pq = new PriorityQueue<>();
		pq.add("133");
		pq.add("11");
		pq.add("364");


		for(String temp : pq) {
			System.out.printf("%s ", temp);
		}
		
		//PriorityQueue는 크기 순서대로 정렬해서 출력
		System.out.printf("\n%s\n", pq.poll());
		System.out.printf("%s\n", pq.poll());
		System.out.printf("%s\n", pq.poll());
	}

}
