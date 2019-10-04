package util;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateMain {

	public static void main(String[] args) {
		//1992년 3월 17일을 Date 객체로 만들기
		//바로 객체를 생성하면 Deprecated 메세지 - 경고가 발생		
		Date date = new Date(92, 2, 17);
		System.out.printf("%s\n", date);
		
		
		//GregorianCalendar 를 이용해서 객체를 생성하고
		//이 정보를 가지고 Date 객체를 만들어서 사용
		//월은 -1 해서 설정
		GregorianCalendar cal = new GregorianCalendar(1992, 2, 17);
		date = new Date(cal.getTimeInMillis());
		System.out.printf("%s\n", date);
		
		
		//java.sql.Date 사용
		//서로 다른 패키지에 있는 동일한 클래스를 같이 사용할 때는
		//나중에 사용되는 클래스에 패키지 이름을 붙여서 작성
		//toString 을 호출하면 년월일만 출력됩니다.
		java.sql.Date d = new java.sql.Date(cal.getTimeInMillis());
		System.out.printf("%s\n", d);

	}

}















