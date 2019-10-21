package java1021stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReduceMain2 {

	public static void main(String[] args) {
		//Game 객체 4개를 저장할 수 있는 배열이 생성
		Game [] ar = new Game[4];
		ar[0] = new Game(132,"전사",9304, "근거리 탱커");
		ar[1] = new Game(97,"법사",6855, "원거리 보조형");
		ar[2] = new Game(178,"궁수",13750, "원거리 공격형");
		ar[3] = new Game(151,"도적",12534,"근거리 보조형");
		
		//배열을 가지고 스트림 생성
		Stream<Game>stream=Arrays.stream(ar);
		
		stream.filter((game)->{
			String [] ad = game.getPosition().split(" ");
				for(String imsi : ad) {
					if(imsi.equals("탱커")) {
						return true;
					}
				}return false;}).forEach(game->System.out.printf("%s\n",game));
	}

}
