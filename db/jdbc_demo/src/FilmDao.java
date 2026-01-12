

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FilmDao {
	
	// 전달인자는 BizLogic 클래스에서 넘어오는 데이터 표시
	// 결과형은 BizLogic 클래스로 반환하는 데이터 표시
	public ArrayList<FilmDto> selectFilmsByTitle(String keyword) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FilmDto> films = new ArrayList<>(); // 조회 결과를 저장할 변수
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "human", "human");

			String sql = "select * from film where title like ? limit 20" ; // ? : 여기에 데이터가 결합될 예정
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%"); // JDBC 는 순서가 1부터. 첫 번째 ? 
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) { 
				FilmDto film = new FilmDto();
				film.setFilmId(rs.getInt(1));
				film.setTitle(rs.getString(2));
				film.setRating(rs.getString("rating"));
				// 한 행의 데이터를 저장한 FilmDto 객체를 목록에 추가
				films.add(film);
			} 
			
			
		} catch (Exception ex) {
			
		} finally {
			try {rs.close();} catch (Exception ex) {}
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
		
		return films;
	}
}
