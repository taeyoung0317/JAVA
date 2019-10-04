package java0918;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetMain {

	public static void main(String[] args) {
		//해시셋을 생성 - 저장은 해싱을 이용
		//중복된 데이터를 저장되지 않음
		//중복된 데이터를 저장하면 add 메소드가 false 리턴
		//해시 함수는 운영체제가 선택하기 때문에 저장 순서를 알지 못합니다.
		Set<Integer> hashSet = new HashSet<>();
		hashSet.add(33);
		hashSet.add(37);
		hashSet.add(27);
		hashSet.add(27);
		hashSet.add(99);
		
		for(Integer temp : hashSet) {
			System.out.printf("%d\t", temp);
		}
		
		System.out.printf("\n");
		
		//LinkedHashSet 은 저장된 순서를 기억해서
		//저장한 순서대로 데이터가 추출
		Set<Integer> linkedHashSet = new LinkedHashSet<>();
		linkedHashSet.add(33);
		linkedHashSet.add(37);
		linkedHashSet.add(27);
		linkedHashSet.add(27);
		linkedHashSet.add(99);
		//저장한 순서대로 출력
		for(Integer link : linkedHashSet) {
			System.out.printf("%d\t", link);
		}
		
		System.out.printf("\n");
		
		//TreeSet : 크기 순서대로 데이터를 추출할 수 있는 Set
		//자료구조엥서 Tree 라는 말이 나오면 데이터를 저장한 후
		//정렬하는 것이 아니고 데이터를 저장할 때 Tree구조를 이용해서 정렬하는 방식
		//Tree의 순회 방법을 이용해서 작은 것부터 큰 것(Pre Order)또는
		//저장된 순서(In Order)대로 출력
		//산술 연산은 Post Order
		
		Set <Integer> treeSet = new TreeSet<>();
		treeSet.add(33);
		treeSet.add(37);
		treeSet.add(27);
		treeSet.add(27);
		treeSet.add(99);
		//크기순서대로 출력
		for(Integer tree : treeSet) {
			System.out.printf("%d\t", tree);
		}
		
	}

}







