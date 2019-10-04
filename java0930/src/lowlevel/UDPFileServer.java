package lowlevel;

import java.io.PrintStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPFileServer {

	public static void main(String[] args) {
		
		try {
			
			//받기 위한 데이터 그램 소켓 생성
			DatagramSocket socket = new DatagramSocket(7777);
			socket.setReceiveBufferSize(30000000);
			while(true) {
			//데이터를 받기위한 바이트 배열 생성
			byte [] b = new byte[65536]; // 64k - 한글로는 20000글자
			//데이터를 받아오기 위한 패킷을 생성
			DatagramPacket dp = new DatagramPacket(b, b.length);
			
			System.out.printf("서버 대기 중.........");
			
			//데이터 받아오기
			socket.receive(dp);
			System.out.printf("보낸 곳:%s\n",dp.getAddress().getHostAddress());
			//받아온 데이터가 문자열 이라면
			String msg = new String(b);
			//전송한 데이터가 65536이 안되면 뒤에 공백이 있을 수 있습니다.
			System.out.printf("파일 이름:%s\n", msg.trim());
			
			//파일의 내용 받기
			//파일의 내용을 저장하기 위한 배열 생성
			//크기를 모르므로 크게 생성
			byte [] fb = new byte[1024*1024*5]; //5MB 배열 생성
			//데이터 받기
			dp = new DatagramPacket(fb, fb.length);
			socket.receive(dp);
			//받은 내용을 파일에 기록
			PrintStream ps = new PrintStream("./"+msg.trim());
			ps.write(fb, 0, dp.getLength());
			ps.flush();
			//ps 닫기
			ps.close();
			}
			
			
			
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}

}
