package java1021stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class ReduceMain1 {

	public static void main(String[] args) {
		String [] ar = {"김씨","이씨","박씨","최씨","정씨","문씨","유씨","박씨"};
		//배열을 이용해서 Stream을 생성
		Stream<String>stream = Arrays.stream(ar);
		//중복 제거
		//stream.distinct().forEach(firstName->System.out.printf("%s\n", firstName));
		
		//stream.skip(2).limit(2).forEach(firstName->System.out.printf("%s\n", firstName));
		
		int len = ar.length/4 + 1;
		for(int i=0;i<len;i=i+1) {
			Stream <String> imsi = Arrays.stream(ar);
			imsi.skip(i*4).limit(4).forEach(firstName->System.out.printf("%s\n",firstName));
			try {
				Thread.sleep(3000);
			}catch(Exception e) {}
		}
		
		
	}

}
