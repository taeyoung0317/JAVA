import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args) {
		try {
			//데이터를 받는 소켓 생성
			DatagramSocket ds = new DatagramSocket(8888);

			while(true) {
				//데이터를 넘겨받을 배열을 생성
				//바이트 배열은 반복문 안에 작성해야 새로운 메세지가 작성될 때마다 새로운 내용 출력
				//밖에 배열을 만들면 이전내용+새로운내용 출력
				//반복문 안에서 만들어야 매번 새로 생성
				//바깥에서 만들면 이전 내용이 출력될 수 있음
				byte [] data = new byte[512];
				DatagramPacket dp = new DatagramPacket(data, 512);
				ds.receive(dp);
				//보낸 곳 확인
				System.out.printf("보낸 곳:%s\n", dp.getAddress().getHostAddress());
				//받은 내용을 문자열로 변환해서 출력
				String message= new String(data);
				System.out.printf("메세지:%s\n", message.trim());
				}
			
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}

}
