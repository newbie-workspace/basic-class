
public class Todo {

	private int userId;
	private int id;
	private String title;
	private Boolean completed;
	
	@Override
	public String toString() {
		return String.format("[%d]\n[%s]\n[%s]\n", id, title, completed);
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Boolean getCompleted() {
		return completed;
	}
	public void setCompleted(Boolean completed) {
		this.completed = completed;
	}
	
}
