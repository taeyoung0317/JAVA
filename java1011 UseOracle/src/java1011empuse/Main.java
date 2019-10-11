package java1011empuse;

import javax.swing.JOptionPane;

import dao.EMPDAO;

public class Main {

	public static void main(String[] args) {
		/*
		try {
			
			//오라클 드라이버 클래스 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//데이터베이스 접속
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.13:1521:xe","user06","user06");
			//SQL 실행 객체 만들기
			PreparedStatement pstmt = con.prepareStatement("select * from emp");
			//SQL 실행
			ResultSet rs = pstmt.executeQuery();
			//select 구문의 결과를 읽기
			while(rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				//null인 데이터를 자바에서 처리하고자 할 때는
				//문자열로 받아서 null인 경우를 비교해서 작업
				//오라클에서 처리할 때는 nvl(컬럼이름,대체값)
				String comm = rs.getString("comm");
				System.out.printf("사원번호:%d,이름:%s,상여금:%s\n",empno,ename,comm);
			}
			rs.close();
			pstmt.close();
			con.close();
			
		}catch(Exception e) {
			System.out.printf("%s\n",e.getMessage());
			e.printStackTrace();
		}
		*/
		
		//static 코드는 클래스이름이 처음 사용될 때 호출
		EMPDAO dao = new EMPDAO();
		//전체 출력
		//System.out.printf("%s\n",dao.getList());
		//번호에 해당하는 하나의 데이터 출력
		//7788인 데이터가 존재해서 출력
		//System.out.printf("%s\n", dao.getEMP(7788));
		//1000번인 데이터가 존재하지 않아서 null이 리턴되서 출력되지 않음
		//System.out.printf("%s\n", dao.getEMP(1000));
		
		/*
		EMP emp = new EMP();
		Scanner sc= new Scanner(System.in);
		while(true) {
			System.out.printf("사원번호입력:");
			int empno = sc.nextInt();
			//사원번호에 해당하는 데이터 조회
			EMP temp = dao.getEMP(empno);
			//데이터가 없다면 다음 작업을 진행
			if(temp == null) {
				//사원번호 설정
				emp.setEmpno(empno);
				break;
			}
			//데이터가 있으면 반복문으로 시작으로 이동
			System.out.printf("중복된 사원번호입니다.\n");
		}
		sc.close();
		
		//emp.setEmpno(9999);
		emp.setEname("MOON");
		emp.setJob("SALES");
		emp.setMgr(7788);
		Calendar cal = new GregorianCalendar(2019,11,11);
		emp.setHiredate(new Date(cal.getTimeInMillis()));
		emp.setSal(5000);
		emp.setComm(1000);
		emp.setDeptno(20);
		
		int r = dao.insertEMP(emp);
		if(r>=0) {
			System.out.printf("삽입성공\n");
		}else {
			System.out.printf("삽입실패\n");
		}
		*/
		
		int r = JOptionPane.showConfirmDialog(null, "정말로 삭제","데이터삭제?",JOptionPane.YES_NO_OPTION);
		if(r==JOptionPane.YES_OPTION) {
			dao.deleteEMP(9999);
			JOptionPane.showMessageDialog(null, "삭제 성공");
		}else {
			JOptionPane.showMessageDialog(null, "삭제하지 않음");
		}
	}
	

}
