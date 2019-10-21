package java1021stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class ReduceMain3 {

	public static void main(String[] args) {
		String [] ar = {"C#","Java","C++","Swift","Kotlin","R","Python","Closure","SQL","JavaScript","Ruby","Scala"};
		//배열을 가지고 스트림을 생성
		Stream <String>	stream = Arrays.stream(ar);
		//String 클래스는 Comparable 인터페이스를 implements 해서 정렬이 가능
		//오름차순 정렬
		//stream.sorted().forEach(lang->System.out.printf("%s\n", lang));
		
		//내림차순 정렬
		//stream.sorted(Comparator.reverseOrder()).forEach(lang->System.out.printf("%s\n", lang));
		
		//Student의 배열을 생성
		Student [] students = {
				new Student(1,"빨강","여자",86), 
				new Student(2,"초록","남자",77), 
				new Student(3,"파랑","남자",98), 
				new Student(4,"노랑","여자",98),
				new Student(5,"보라","여자",68)
		};
		Stream<Student>st = Arrays.stream(students);
		//이 형태를 예외없이 사용하고자 하면
		//Student 클래스에 Comparable 인터페이스
		//st.sorted().forEach(list->System.out.printf("%s\n", list));
		
		//Comparator 인터페이스를 이용한 정렬
		//score의 내림차순 정렬, score가 같으면 name 오름차순 정렬
		//.reversed()를 생략하면 오름차순
		//st.sorted(Comparator.comparing(Student::getScore).reversed().thenComparing(Student::getName)).forEach(list->System.out.printf("%s\n", list));
		
		//Comparator 객체 직접 생성
		Comparator<Student>comp = new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				if(o1.getScore()>o2.getScore()) {
					return 1;
				}else if(o1.getScore()==o2.getScore()) {
					return o2.getName().compareTo(o1.getName());
				}else {
					return -1;
				}
			}
			
		};
		st.sorted(comp).forEach(student->System.out.printf("%s\n",student));
	}

}
