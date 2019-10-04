import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPClient {

	public static void main(String[] args) {
		try {
			//입력받는 스캐너
			Scanner sc= new Scanner(System.in);
			while(true) {
				Thread.sleep(3000);
				//System.out.printf("전송할 내용:");
				//String str = sc.nextLine();
				//전송할 소켓 생성
				DatagramSocket ds = new DatagramSocket();
				DatagramPacket dp = new DatagramPacket(
						"DDOS".getBytes(), "DDOS".getBytes().length,
						InetAddress.getByName("192.168.0.131"), 8888);
				//데이터 전송
				ds.send(dp);
				ds.close();
				System.out.printf("전송 성공\n");
				
			}
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}

}
