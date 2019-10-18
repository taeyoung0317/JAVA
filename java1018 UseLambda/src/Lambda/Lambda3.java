package Lambda;

import java.util.ArrayList;
import java.util.List;

public class Lambda3 {

	public static void main(String[] args) {
		//문자열을 저장하는 List를 생성하고 데이터를 저장
		List<String>list=new ArrayList<String>();
		list.add("조각사");
		list.add("궁수");
		list.add("검사");
		list.add("성1기사");
		list.add("마법사");
		
		//위의 데이터를 순서대로 하나씩 출력
		//List에 함수를 매개변수로 대입해서
		//List의 모든 데이터를 함수의 매개변수로
		//대입해서 실행
		//이 기능은 C언어를 제외한 거의 모든 프로그래밍 언어에
		//존재하는 기능인데 대부분은 map이라고 합니다.
		list.forEach(System.out::println);

	}

}
