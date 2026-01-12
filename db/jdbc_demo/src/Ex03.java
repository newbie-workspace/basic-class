

import java.util.ArrayList;
import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		FilmDao dao = new FilmDao();
		while(true) {
			
			System.out.println("검색할 영화 제목 (종료는 q) : ");
			String keyword =  scanner.nextLine().toUpperCase();
			
			if(keyword.equalsIgnoreCase("Q")) {
				System.out.println("프로그램 종료");
				break;
			}
			
			ArrayList<FilmDto> films = dao.selectFilmsByTitle(keyword);
			System.out.println("영화 검색 결과");
			for(FilmDto film : films) {
				System.out.println(film.toString());
			}
		}
		scanner.close();
	}
}
