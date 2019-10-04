

import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		try {
			//클라이언트 소켓 생성
			InetAddress serverIp = InetAddress.getByName("192.168.0.173");
			Socket socket = new Socket(serverIp, 9900);
			socket.setSoTimeout(30000);
			
			//기록을 해주는 스트림을 생성
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			//메세지 입력받기
			Scanner sc = new Scanner(System.in);
			System.out.printf("전송할 메세지");
			String msg = sc.nextLine();
			
			//메세지 전송
			pw.println(msg);
			pw.flush();
			
			//사용이 끝나서 종료
			pw.close();
			socket.close();
		
			
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}

}
