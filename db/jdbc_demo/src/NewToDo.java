
import java.text.SimpleDateFormat;
import java.util.Date;
// 테이블 만들기
/*
 	use labdb;
	create table newtodo (
		id int primary key auto_increment,
	    title varchar(150) not null,
	    writeDate date default (now()),
	    completed boolean default (false)
	);
*/

public class NewToDo {
	
	private int id;
	private String title;
	private Date writeDate;
	private boolean completed;
	
	public NewToDo() {
		
	}
	public NewToDo(String title) {
		this.title = title;
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
	
	@Override
	public String toString() {
		String sCompleted = this.completed ? "완료" : "진행";
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd"); // 날짜 -> 지정된 형식의 문자열
		String sWriteDate = sdf.format(writeDate);
		
		// %d : 정수, %s : 문자열, %b : boolean
		return String.format("%3d.[%s][%s][%s]", id, title, sWriteDate, sCompleted);
	}
}











