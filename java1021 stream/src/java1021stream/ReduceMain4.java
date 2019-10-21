package java1021stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReduceMain4 {

	public static void main(String[] args) {
		//Student의 배열을 생성
		Student [] students = {
				new Student(1,"빨강","여자",86), 
				new Student(2,"초록","남자",77), 
				new Student(3,"파랑","남자",98), 
				new Student(4,"노랑","여자",98),
				new Student(5,"보라","여자",68)
		};
		Stream<Student>st = Arrays.stream(students);
		st.mapToInt(Student::getScore).sorted().forEach(student->System.out.printf("%s\n",student));
	}

}
