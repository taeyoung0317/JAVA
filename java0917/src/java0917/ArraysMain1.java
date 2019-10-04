package java0917;

import java.util.Arrays;

public class ArraysMain1 {

	public static void main(String[] args) {
		String [] first = {"김씨", "정씨", "하씨", "이씨", "문씨"};
		//배열의 데이터를 정렬해주는 메소드
		//Arrays.sort - String 클래스는 Comparable을 implements 했으므로 가능
		Arrays.sort(first);
		//정렬이 되었는지 확인
		for(String temp : first) {
			System.out.printf("%s\n", temp);
		}
		
		//정수 배열도 정렬이 가능
		//정수는 int 이지만 Arrays가 볼 때는 Integer 입니다.
		int [] ar = {123,333,12685,33,243,533,147};
		//정렬하지 않은 상태에서 binary search 수행
		//binary search는 정렬이 안된 상태에서 하면 올바른 결과를 가져오지 못합니다.
		int result = Arrays.binarySearch(ar, 333);
		System.out.printf("%d\n", result);
		//먼저 정렬을 수행하고 binary search 수행
		//33,123,147,243,333,533,12685
		Arrays.sort(ar);
		result = Arrays.binarySearch(ar, 333);
		System.out.printf("%d\n", result);

	}

}
