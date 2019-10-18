import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;

public class MongoMain {

	public static void main(String[] args) {
		
		String ip = null;
		int port = -1;
		String dbName = null;
		
		//문자를 읽기 위한 스트림을 생성
		//close()를 하지 않기 위해서 try()에서 생성
		try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("./db.txt")))) {
			//한 줄 읽기
			String line = br.readLine();
			
			// , 로 구분된 문자열을 배열에 저장하기
			String [] ar = line.split(",");
			//분할한 데이터를 저장
			ip=ar[0];
			port=Integer.parseInt(ar[1]);
			dbName=ar[2];
			//System.out.printf("ip:%s\n", ip);
			//System.out.printf("port:%s\n", port);
			//System.out.printf("dbName:%s\n", dbName);
			
			//MongoDB 연결
			MongoClient mc = new MongoClient(ip,port);
			//데이터베이스 연결
			MongoDatabase db=mc.getDatabase("mymongo");
			//데이터베이스 모든 컬렉션 가져오기
			MongoIterable<String>collections=db.listCollectionNames();
			//빠른 열거를 이용한 접근
			for(String data : collections) {
				System.out.printf("%s\n",data);
			}
			//데이터를 삽입하거나 삭제 및 수정 또는 조회를 할 컬렉션 가져오기
			MongoCollection<Document>users=db.getCollection("users");
			//쓰기 권한을 가져오기
			users.getWriteConcern();
			
			//데이터 읽기
			FindIterable<Document>documents=users.find(Filters.eq("id", "kim"));
			for(Document document : documents) {
				System.out.printf("%s\n", document);
				
			}
			
			
			mc.close();
			
			
		}catch(Exception e) {
			System.out.printf("파일 읽기 예외:%s\n",e.getMessage());
			e.printStackTrace();
			System.exit(0);
		}
		
		

	}

}
