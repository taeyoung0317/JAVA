package format;

import java.text.ChoiceFormat;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateFormatMain {

	public static void main(String[] args) {
		//java 안에서 날짜를 만들 때는 Calendar 클래스를 이용해서
		//날짜를 만든 후 Date 클래스의 객체로 변환
		
		//1992년 3월 17일 Date 객체로 만들기
		Calendar cal = new GregorianCalendar(1992, 2, 17, 13 , 15, 3);
		Date date = new Date(cal.getTimeInMillis());
		//원하는 포맷의 문자열로 만들기
		//년도4자리 월2자리 일2자리 요일 오전오후 시간 분 초
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd EEE a hh mm ss");
		String result = sdf.format(date);
		System.out.printf("%s\n", result);
		
		DecimalFormat df = new DecimalFormat("\u00A4 0,000.00");
		double n =1898.99;
		String r =df.format(n);
		System.out.printf("%s\n", r);
		
		
		double [] scores = {0, 63, 75, 81, 97};
		String [] grades = {"F", "D", "C", "B", "A"};
		//if 나 switch를 이용해서 가능
		//if 나 switch의 코드 양을 줄일 수 있음
		ChoiceFormat cf = new ChoiceFormat(scores, grades);
		r=cf.format(81); // B
		System.out.printf("%s\n", r);
	
		r="이름:{0} 전화번호:{1}";
		Object [] person = {"문태영", "01049506450"};
		//result = String.format("이름:%s 전화번호:%s, "문태영", "01049506450");
		//라고 써도 동일한 결과 출력
		//String 클래스의 format 메소드를 이용해서도
		//동일한 결과를 만들어 낼 수 있음
		result = MessageFormat.format(r, person);
		System.out.printf("%s\n", result);
		
		
	}

}





