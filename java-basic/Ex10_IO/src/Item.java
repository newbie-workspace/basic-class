
import java.io.Serializable;
//이 클래스의 인스턴스를 IO 하려면 반드시 Serializable interface 를 구현해야 한다.
public class Item implements Serializable { // marker interface : 실제적인 내용은 없다.

	private static final long serialVersionUID = 1L;
	private int no;
	private String name;
		
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		 this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		 this.name = name;
	}
	
	public String toString() {
		return String.format("[%d][%s]", no, name);
	}
}
