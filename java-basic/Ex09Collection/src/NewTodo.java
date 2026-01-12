import java.text.SimpleDateFormat;
import java.util.Date;

public class NewTodo {
	
	// 1. 변수 만들기 : 접근성 제어 설정
	private int id;
	private String title;
	private Date writeDate;
	private boolean completed;
	
	private static int nextId = 1; // static : 모든 인스턴스가 공유하는 변수. 
	
	public NewTodo(String title){
		
		this.id = nextId++; // nextId 를 this.id 에 저장한 후 nexID 값을 1 증가
		this.title = title;
		this.writeDate = new Date(); // new Date() : 현재 날짜 및 시간.
	}
	
	// 2. 메서드 만들기 : 생성자 -> getter, setter -> Object 상속 메서드 재정의 -> 다른 메서드
	
	@Override
	public String toString() {
		
		String sCompleted = this.completed ? "완료" : "진행";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // 날싸 -> 지정된 형식의 문자열
		String sWriteDate = sdf.format(writeDate);
		
		// %d : 정수, %s : 문자열, %b : boolean
		return String.format("[%3d].[%s][%s][%s]", id, title, sWriteDate, sCompleted);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	
	
	
	
	
}	