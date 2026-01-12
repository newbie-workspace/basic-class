

/**
 * Film 테이블 데이터를 저장하기 위한 DTO 클래스
 */

public class FilmDto { // DTO : data transfer object
	
	private int filmId; // DTO의 필드(변수)는 열에 매핑해서 작성.
	private String title;
	private String description;
	// ... 다른 열에 대한 필드 정의는 생략
	private String rating;
	
	public int getFilmId() {
		return filmId;
	}
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return String.format("[%d][%s][%s]", filmId, title, rating);
	}
}
