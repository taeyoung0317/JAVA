package java1021stream;

import java.util.Arrays;
import java.util.stream.Stream;

//컬렉션의 다양한 접근
public class StreamMain1 {

	public static void main(String[] args) {
		/*
		List<String>list = new ArrayList<String>();
		list.add("김씨");
		list.add("이씨");
		list.add("박씨");
		*/
		
		String [] list = {"김씨","이씨","박씨","최씨","정씨"};
		
		//일반 반복문을 이용해서 접근
		int i = 0;
		int len = list.length;
		while(i<len) {
			//데이터를 가져오기
			String item = list[i];
			//가져온 데이터를 가지고 작업 - 출력
			System.out.printf("%s\n", item);
			//인덱스 변수 증감
			i = i+1;
			
			}
		

		System.out.printf("-----------------------------\n");
		
		//Iterator(cursor - 반복자)
		//데이터를 가져온 위치에 대기하고 있다가 
		//다음 데이터를 찾아가는 방법
		//배열은 사용 못함
		/*
		Iterator<String> iterator = list.iterator();
		while(iterator.hasNext()) {
			String next = iterator.next();
			System.out.printf("%s\n", next);
		}
		*/
		
		System.out.printf("-----------------------------\n");
		
		//위의 방법은 전에 사용하던 방식
		//최근에는 위의 방식을 개선해서 Fast Enumeration 제공
		//언어에 따라서 Map도 이 방식이 가능
		for(String imsi : list) {
			System.out.printf("%s\n", imsi);
		}
		
		System.out.printf("-----------------------------\n");
		
		//위의 문장은 조금 더 간결하게 작성
		Stream<String>stream=Arrays.stream(list);
		stream.forEach(name->System.out.printf("%s\n", name));
		
	}

}
