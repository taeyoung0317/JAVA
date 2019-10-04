package java0918;

import java.util.HashMap;

public class MapMain3 {

	public static void main(String[] args) {
		//국가별 축구 선수 이름을 하나의 배열 만들기 - 2차원 배열
		String [] korea = {"차범근", "손흥민","이주성"};
		String [] holland = {"크루이프", "베르캄프","굴리트"};
		String [] england = {"리네커","시어러","베컴"};
		String [] brazil = {"기린샤","호나우지뉴","ㅇㅇ"};

		String [][] soccer = {korea, holland, england, brazil};
		
		
		//이차원 배열의 데이터 출력하기
		//국가이름 - 선수명단 형태로 출력
		for(int i=0;i<soccer.length;i=i+1) {
			//국가 이름 출력
			if(i==0) 
				System.out.printf("한국 :");
			else if(i==1) 
				System.out.printf("네덜란드 :");
			else if(i==2)
				System.out.printf("영국 :");
			else
				System.out.printf("브라질 :");
			//선수 명단 출력
			String [] temp = soccer[i];
			for(String imsi : temp) {
				System.out.printf("%10s",imsi);
			}
			System.out.printf("\n");
		}
		
		System.out.printf("---------------------\n");
		
		//배열들을 가지고 배열을 만들 때는 분류를 위해서
		//각 배열들을 Map으로 만들고 그 Map들의 배열을 만들어야 합니다.
		HashMap<String, Object> map1 = new HashMap<>();
		//데이터들의 특징을 저장
		map1.put("국가", "한국");
		//실제 데이터를 저장
		map1.put("선수", korea);
		
		HashMap<String, Object> map2 = new HashMap<>();
		map2.put("국가", "화란");
		map2.put("선수", holland);
		
		HashMap<String, Object> map3 = new HashMap<>();
		map3.put("국가", "영국");
		map3.put("선수", england);
		
		HashMap <String, Object> map4 = new HashMap<>();
		map4.put("국가", "브라질");
		map4.put("선수", brazil);
		
		//Map들의 배열을 생성
		//실제 프로그램에서는 배열이 아니고 List를 만듭니다.
		//그래야 나중에 동적으로 데이터를 추가
		HashMap [] football = {map1,map2,map3,map4};
		
		for(int i=0;i<football.length;i=i+1) {
			HashMap map = football[i];
			System.out.printf("%s : ", map.get("국가"));
			//출력을 제외하고 사용을 할  때는
			//원래의 자료형을 변환해서 사용해야 합니다.
			String [] ar =(String [])map.get("선수");
			for(String player : ar) {
				System.out.printf("%10s", player);
			}
			System.out.printf("\n");
			
		}
		
		
	}

}






