
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ToDoDao {
	
	public void insertToDo(NewToDo todo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			String sql = "insert into newtodo (title) values(?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, todo.getTitle());
			pstmt.executeUpdate(); // insert, update, delete, create, alter, drop, ...
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 개발하는 과정에서 사용하는 코드 : 오류 메시지 출력
		} finally {
		}
	}
	
	public ArrayList<NewToDo> showToDo() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<NewToDo> todos = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb", "human", "human");

			String sql = 
					"select * from newtodo";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) { 
				NewToDo todo = new NewToDo();
				todo.setId(rs.getInt(1));
				todo.setTitle(rs.getString(2));
				todo.setWriteDate(rs.getDate(3));
				todo.setCompleted(rs.getBoolean(4));
				todos.add(todo);
			}
			
		} catch (Exception ex) {
			
		} finally {
			try {rs.close();} catch (Exception ex) {}
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
		
		return todos;	
	}
	
	public void deleteToDo(int id) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			String sql = "delete from newtodo where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate(); // insert, update, delete, create, alter, drop, ...
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 개발하는 과정에서 사용하는 코드 : 오류 메시지 출력
		} finally {
		}
	}
	
	public ArrayList<NewToDo> search(String keyword){
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<NewToDo> searchResults = new ArrayList<>();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb", "human", "human");

			String sql = 
					"select * from newtodo";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) { 
				NewToDo todo = new NewToDo();
				todo.setId(rs.getInt(1));
				todo.setTitle(rs.getString(2));
				todo.setWriteDate(rs.getDate(3));
				todo.isCompleted();
				if (todo.getTitle().contains(keyword)) {
					searchResults.add(todo);
				}
			}
			// select * from newtodo where title like ? 
			// pstmt.setString(1, "%" + keyword + "%"); 
			
		} catch (Exception ex) {
			
		} finally {
			try {rs.close();} catch (Exception ex) {}
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
		
		return searchResults;
	}
	
	public void edit(String editTitle, int editNumber, boolean completed) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			String sql = "update newtodo set title = ?, completed = ?  where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, editTitle );
			pstmt.setBoolean(2, completed);
			pstmt.setInt(3, editNumber);
			pstmt.executeUpdate(); // insert, update, delete, create, alter, drop, ...
			
		} catch (Exception ex) {
			ex.printStackTrace(); // 개발하는 과정에서 사용하는 코드 : 오류 메시지 출력
		} finally {
		}
		
	}
}
