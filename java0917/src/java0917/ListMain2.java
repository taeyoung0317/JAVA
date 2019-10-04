package java0917;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListMain2 {

	public static void main(String[] args) {
		//테이블 구조 만들기
		List<Person> list = new ArrayList<>();
		
		//테이블에 삽입할 데이터를 생성
		Person p = new Person();
		p.setName("문태영");
		p.setPhone("01049506450");
		p.setAddress("인천연수구선학동");
		p.setAge(28);
		
		//테이블에 데이터를 삽입하기
		list.add(p);
		
		//테이블에 삽입할 데이터를 생성
		p = new Person();
		p.setName("김지영");
		p.setPhone("01054483484");
		p.setAddress("경기도남양주오남읍");
		p.setAge(27);
		
		//테이블에 데이터를 삽입하기
		list.add(p);
		
		//데이터를 정렬(sort) - 나이로 정
		list.sort(new Comparator<Person>() {
			//나이를 가지고 비교
			@Override
			public int compare(Person o1, Person o2) {
				return o1.getAge()-o2.getAge();
			}
			
		});
		
		//타이틀을 출력
		System.out.printf("%-10s%-15s%-20s%-3s\n", "이름", "전화번호", "주소", "나이");
		//Fast Enumeration을 이용한 List 접근
		for(Person person : list) {
			System.out.printf("%-10s%-15s%-20s%-3d\n", 
					person.getName(), person.getPhone(), 
					person.getAddress(), person.getAge());
		}
	}

}
