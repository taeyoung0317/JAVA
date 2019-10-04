

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static void main(String[] args) {
		try {
			//서버 소켓을 생성
			//클라이언트의 요청은 9000번 포트로 받음
			ServerSocket ss = new ServerSocket(9800);
			while(true) {
				System.out.printf("서버 대기중.......");
				//클라이언트 요청 대기 중
				Socket socket = ss.accept();
				//접속한 클라이언트 정보를 출력
				System.out.printf("접속자:%s\n", socket.toString());
				//클라이언트가 전송한 내용을 출력
				BufferedReader br = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				while(true){
					String line = br.readLine();
					if(line == null) {
						break;
					}
					System.out.printf("전송한 내용:%s\n", line);
				}
				br.close();
				socket.close();
				
				
			}
			
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}

}
