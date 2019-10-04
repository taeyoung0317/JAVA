package ip;

import java.net.InetAddress;

public class IPMain {

	public static void main(String[] args) {
		//파일, 네트워크, 데이터베이스를 사용할  때는
		//예외처리를 강제하는 경우가 많습니다.
		try {
			InetAddress [] ia = InetAddress.getAllByName("www.naver.com");
			for(InetAddress ad : ia) {
			System.out.printf("네이버 IP : %s\n", ad);
			}
			//구글의 서버 IP주소를 전부 출력
			InetAddress [] googles = InetAddress.getAllByName("www.google.com");
			for(InetAddress address : googles) {
				System.out.printf("%s\n", address);
			}
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
		}
	}

}
