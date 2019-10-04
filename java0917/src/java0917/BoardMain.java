package java0917;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class BoardMain {
	
	public static void main(String[] args) {
		//Board 클래스의 객체 여러개를 저장할 수 있는 자료구조를 생성
		//배열 (크기 변경 안됨), ArrayList(읽기는 빠름), LinkedList(삽입삭제가 빠름)
		
		List<Board> list = new LinkedList<>();
		
		//Board 클래스의 객체를 만들어서 데이터를 설정한 후 list에 삽입하기
		//이 부분은 데이터베이스에 읽어오던가 파일에서 읽어오는 형태로 변경
		Board b = new Board();
		b.setNumber(3);
		b.setTitle("신고합니다.");
		b.setName("불주먹");
		b.setDate("2019.03.15");
		
		list.add(b);
		
		b = new Board();
		b.setNumber(75);
		b.setTitle("아이템팝니다.");
		b.setName("철산");
		b.setDate("2019.01.05");
		
		list.add(b);
		
		b = new Board();
		b.setNumber(54);
		b.setTitle("레이드참여.");
		b.setName("근육마법사");
		b.setDate("2016.12.29");
		
		list.add(b);

		list.sort(new Comparator<Board>() {

			@Override
			public int compare(Board o1, Board o2) {
				return o1.getDate().compareTo(o2.getDate());
			}
			
		});
		
		System.out.printf("%-5s%-20s%-15s%-20s\n","글번호", "글제목", "글작성자", "글쓴날짜");
		
		for(Board board : list) {
			System.out.printf("%-5s%-20s%-15s%-20s\n",
					board.getNumber(), board.getTitle(), 
					board.getName(), board.getDate());
		}
		
		
	}

}
