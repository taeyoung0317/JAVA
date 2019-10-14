package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import domain.Buy;

public class BuyDao {
	
	//클래스를 처음 사용할 때 한번만 수행하는 코드
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.printf("클래스 로드 예외:%s\n", e.getMessage());
			e.printStackTrace();
		}
	}
	
	//데이터베이스 연동에 필요한 변수
	//데이터베이스 연결 변수
	Connection con;
	//SQL 실행 변수
	PreparedStatement pstmt;
	//select 구문의 결과 사용 변수
	ResultSet rs;
	
	//데이터를 삽입하는 메소드
	public int insertBuy(Buy buy) {
		int result = -1;
		try {
		con = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.0.13:1521:xe",
				"user06","user06");
		pstmt = con.prepareStatement("insert into buy(buycode,itemname,customerid,count) values(buyseq.nextval,?,?,?)");
		//sql에 물음표가 있으면 실제 데이터로 바인딩
		pstmt.setString(1, buy.getItmename());
		pstmt.setString(2, buy.getCostumerid());
		pstmt.setInt(3, buy.getCount());		
		//sql실행
		result = pstmt.executeUpdate();
		//정리
		con.close();
		pstmt.close();
		
		}catch(Exception e) {
			System.out.printf("데이터 삽입 예외:%s\n", e.getMessage());
			e.printStackTrace();
		}		
		return result;
	}
	
	
	//데이터를 수정하는 메소드
	public int updateBuy(Buy buy) {
		int result = -1;
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.13:1521:xe",
					"user06","user06");
			pstmt = con.prepareStatement("update buy set itemname=?, customerid=?, count=? where buycode=?");
			pstmt.setString(1, buy.getItmename());
			pstmt.setString(2, buy.getCostumerid());
			pstmt.setInt(3, buy.getCount());
			pstmt.setInt(4, buy.getBuycode());
			
			result = pstmt.executeUpdate();
			
			con.close();
			pstmt.close();
			
			
		}catch(Exception e) {
			System.out.printf("데이터 수정 예외:%s\n", e.getMessage());
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	//데이터를 삭제하는 메소드
	public int deleteBuy(int buycode) {
		
		int result = -1;
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.13:1521:xe",
					"user06","user06");
			pstmt = con.prepareStatement("delete from buy where buycode=?");
			pstmt.setInt(1, buycode);
			
			result = pstmt.executeUpdate();
			
			con.close();
			pstmt.close();
			
			
		}catch(Exception e) {
			System.out.printf("데이터 수정 예외:%s\n", e.getMessage());
			e.printStackTrace();
		}
		
		return result;
		
	}

	//전체 데이터를 조회하는 메소드
	public List <Buy> getList(){
		List<Buy> list = new ArrayList<>();
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.13:1521:xe",
					"user06","user06");
			pstmt = con.prepareStatement("select * from buy");
			//select 구문 실행
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Buy buy = new Buy();
				buy.setBuycode(rs.getInt("buycode"));
				buy.setItmename(rs.getString("itemname"));
				buy.setCustomerid(rs.getString("customerid"));
				buy.setCount(rs.getInt("count"));
				buy.setBuydate(rs.getDate("buydate"));
				list.add(buy);
			}
			
			con.close();
			pstmt.close();
			rs.close();
			
		}catch(Exception e) {
			System.out.printf("전체 데이터 조회 예외:%s\n", e.getMessage());
			e.printStackTrace();
		}
		return list;
	}
	
	//기본키를 가지고 조회하는 메소드
	public Buy getBuy(int buycode) {
		Buy buy = null;
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.0.13:1521:xe",
					"user06","user06");
			pstmt = con.prepareStatement("select * from buy where buycode=?");
			pstmt.setInt(1, buycode);
			//select 구문 실행
			rs = pstmt.executeQuery();
			if(rs.next()) {
				buy = new Buy();
				buy.setBuycode(rs.getInt("buycode"));
				buy.setItmename(rs.getString("itemname"));
				buy.setCustomerid(rs.getString("customerid"));
				buy.setCount(rs.getInt("count"));
				buy.setBuydate(rs.getDate("buydate"));
				
			}
			
			con.close();
			pstmt.close();
			rs.close();
			
		}catch(Exception e) {
			System.out.printf("전체 데이터 조회 예외:%s\n", e.getMessage());
			e.printStackTrace();
		}
		return buy;
	}
	
}














