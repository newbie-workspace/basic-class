package com.exampleweb.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.exampleweb.dto.LottoDto;

public class LottoDao {
	
	// 로또 번호 세트를 테이블에 저장하는 메서드
	public void insertLotto(LottoDto lotto) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = 
			DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");

			String sql = "insert into lotto values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, lotto.getRnd());
			long tick = lotto.getGameDate().getTime(); // 날짜 -> Tick (1970.1.1 이후 경과한 1/1000 초;
			java.sql.Date gameDate = new java.sql.Date(tick); // java.util.Date -> java.sql.Date
			pstmt.setDate(2, gameDate);
			pstmt.setInt(3, lotto.getNumber1());
			pstmt.setInt(4, lotto.getNumber2());
			pstmt.setInt(5, lotto.getNumber3());
			pstmt.setInt(6, lotto.getNumber4());
			pstmt.setInt(7, lotto.getNumber5());
			pstmt.setInt(8, lotto.getNumber6());
			pstmt.setInt(9, lotto.getBonus());
			pstmt.executeUpdate(); // insert, update, delete, create, alter, drop, ...
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
	}
	
	public static void deleteAll() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = 
			DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/labdb", "human", "human");
			String sql = "delete from lotto";
			pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
	}
	
	public LottoDto selectLottoByRnd(int rnd) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		LottoDto lotto = new LottoDto();
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 준비
			
			conn = // 연결 객체 만들기
			DriverManager.getConnection("jdbc:mysql://localhost:3306/labdb", "human", "human");

			String sql = // SQL 작성
					"select rnd, number1, number2, number3,"
					+ "number4, number5, number6, bonus from lotto where rnd = ?";
			pstmt = conn.prepareStatement(sql); // 명령 객체
			pstmt.setInt(1, rnd);
			
			rs = pstmt.executeQuery(); // 명령 실행
			if (rs.next()) { // rs.next() 가 false 일 수도 있으므로 if 또는 while 문으로 
				lotto.setRnd(rs.getInt(1));
				lotto.setNumber1(rs.getInt(2));
				lotto.setNumber2(rs.getInt(3));
				lotto.setNumber3(rs.getInt(4));
				lotto.setNumber4(rs.getInt(5));
				lotto.setNumber5(rs.getInt(6));
				lotto.setNumber6(rs.getInt(7));
				lotto.setBonus(rs.getInt(8));
			}
		} catch (Exception ex) {
			
		} finally {
			try {rs.close();} catch (Exception ex) {}
			try {pstmt.close();} catch (Exception ex) {}
			try {conn.close();} catch (Exception ex) {}
		}
		return lotto;	
	}
}
