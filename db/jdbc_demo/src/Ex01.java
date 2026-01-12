

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.xdevapi.Result;

public class Ex01 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 준비 // mvnrepository.com
			// DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			Class.forName("com.mysql.cj.jdbc.Driver"); // 위와 동일한 결과
			
			// 2. 연결 객체 만들기0
			conn = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "human", "human");
										// 서버와 데이터베이스 위치 지정 		     // ID   // Password
			
			// 3. SQL 작성 + 명령 객체 만들기 
			String sql = "select * from film limit 10" ;
			pstmt = conn.prepareStatement(sql);
			
			// 4. 명령 실행 + 결과가 있으면(select 인 경우) 수신
			rs = pstmt.executeQuery();
			
			// 5. 결과가 있다면( select 인 경우 결과 처리
			while (rs.next()) { // .next() : 다음 row 로 넘어가고 true 반환. 더 이상 데이터가 없으면 false.
				System.out.printf("[%d][%s][%s]\n", rs.getInt(1), rs.getString(2),rs.getString(11));
			} 
			// rs.get자료형(열 번호).
			// getInt(1) : 1 열에 있는 숫자 읽어오기.
			// getString(11) : 11 열에 있는 문자 읽어오기.	
		
		// 6. 연결 종료
		} catch (Exception ex) {
			
		} finally {
			try {rs.close();} catch (Exception ex) {}
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
	}
}
