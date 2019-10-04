package socketprogramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class DaumHTMLDownload {

	public static void main(String[] args) {
		try {
			//www.daum.net 의 IP 주소 만들기
			//접속할 서버의 주소를 만들기
			InetAddress address = InetAddress.getByName("www.daum.net");
			//서버에 접속하는 소켓을 생성
			//www.daum.net:80에 접속하는 소켓을 생성
			Socket socket = new Socket(address, 80);
			//30초 동안 접속을 시도해보고 접속이 안되면 접속 시도를 중지합니다.
			socket.setSoTimeout(30000);
			//문자열을 전송하기 위한 스트림을 생성
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			//메세지 전송
			out.println("GET http://www.daum.net");
			out.flush();
			//문자열을 읽어오기 위한 스트림을 생성
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			//읽은 내용을 출력하기
			while(true) {
				//한 줄 읽기
				String line = br.readLine();
				//읽은 것이 없으면 중단
				if(line == null) {
					break;
				}
				//읽은 데이터가 있으면 데이터를 사용
				System.out.printf("%s\n", line);
			}
			//사용을 다하고 나면 close 를 호출해서 닫기
			br.close();
			out.close();
			socket.close();
			
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
		}
	}

}
