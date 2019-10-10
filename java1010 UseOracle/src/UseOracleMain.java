import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UseOracleMain {

	public static void main(String[] args) {
		
		try {
		//데이터베이스 드라이버 클래스 로드
		Class.forName("oracle.jdbc.driver.OracleDriver");
		//데이터베이스 연결
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe", "user06", "user06");
		con.setAutoCommit(false);
		/*
		Statement stmt = con.createStatement();
		//SQL을 작성할 때 예약어는 대소문자 구분을 안하고 앞 뒤에 공백을 추가
		int r = stmt.executeUpdate("insert into dept(deptno, dname, loc) values(99,'비서','서울')");
		//삽입일 때는 0이 리턴되면 실패
		if(r>0) {
			System.out.printf("삽입성공\n");
		}else {
			System.out.printf("삽입실패\n");
		}
		stmt.close();
		*/
		/*
		Statement stmt = con.createStatement();
		int r = stmt.executeUpdate("update dept set loc='종로' where deptno=10");
		if(r>0) {
			System.out.printf("삽입성공\n");
		}else {
			System.out.printf("10번이 없음\n");
		}
		stmt.close();
		*/
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from dept");
		while(rs.next()) {
			int deptno = rs.getInt(1);
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");
			System.out.printf("부서번호:%d,부서이름:%s,지역:%s\n", deptno, dname, loc);
		}
		rs.close();
		stmt.close();
		
		con.close();
		
		}catch(Exception e) {
			System.out.printf("%s\n",e.getMessage());
			e.printStackTrace();
		}
	}

}
