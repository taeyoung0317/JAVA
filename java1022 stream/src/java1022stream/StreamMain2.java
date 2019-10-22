package java1022stream;

import java.util.LinkedList;

public  class StreamMain2 {
	
	public static void working(Student student) {
		try {
			Thread.sleep(10000);
			System.out.println(student);
		}catch(Exception e) {
			
		}
	}

	public static void main(String[] args) {
		
		LinkedList<Student>list=new LinkedList<>();
		list.add(new Student(1,"영희","여자",86));
		list.add(new Student(2,"철수","남자",92));
		list.add(new Student(3,"훈이","남자",58));
		list.add(new Student(4,"이슬","여자",95));
		list.add(new Student(5,"맹구","남자",78));
		
		long start = System.currentTimeMillis();
		//빠른 열거를 이용해서 작업
		/*
		for(Student student : list) {
			working(student);
		}
		*/
		
		//일반 스트림을 이용한 처리
		//list.stream().forEach(student->working(student));
		
		//병렬 스트림을 이용해서 처리
		list.parallelStream().forEach(student->working(student));
		
		long end = System.currentTimeMillis();
		System.out.printf("걸린시간:%d\n", end-start);
		
	}

}
