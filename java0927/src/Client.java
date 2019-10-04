import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			//클라이언트 만들기
			Socket socket = new Socket(InetAddress.getByName("192.168.0.131"),8000);
			//전송할 메세지 입력
			Scanner sc = new Scanner(System.in);
			System.out.printf("메세지");
			String str = sc.nextLine();
			//메세지 보내기
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			pw.println(str);
			pw.flush();
			
			//서버가 보낸 메세지 읽기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			str = br.readLine();
			System.out.printf("서버가 보낸 메세지:%s\n", str);
			
			br.close();
			pw.close();
			sc.close();
			socket.close();
		}catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
			e.printStackTrace();
		}
	}

}
