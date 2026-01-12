

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.xdevapi.Result;

public class Ex02 {

	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "human", "human");
			
			String keyword =  "HUMAN";
			
//			String sql = "select * from film where title like '%" + keyword + "%' limit 20" ;
//			pstmt = conn.prepareStatement(sql);
			String sql = "select * from film where title like ? limit 20" ; // ? : 여기에 데이터가 결합될 예정
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%"); // JDBC 는 순서가 1부터. 첫 번째 ? ㅇ
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) { 
				System.out.printf("[%d][%s][%s]\n", rs.getInt(1), rs.getString(2),rs.getString("rating"));
			} 
			
		} catch (Exception ex) {
			
		} finally {
			try {rs.close();} catch (Exception ex) {}
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
	}
}
