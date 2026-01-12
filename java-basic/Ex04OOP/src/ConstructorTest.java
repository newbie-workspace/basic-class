
public class ConstructorTest {

	String s;
	int i;
	
	
	ConstructorTest() { 
		
		this("test", 20); // 같은 클래스에 다른 생성자 메서드 호출하는 구문
		System.out.println("기본 생성자");
		
	//생성자 메서드르 만들지 않으면 자동으로 전달인자 없는 생성자 메소드가 만들어진다.
		
	}
	
	
	//다른 생성자 메소드를 만들면 기본 생성자 메서드가 자동으로 만들어지지 않는다.

	
	ConstructorTest(String s, int i) {
	
		//	this(); // 같은 클래스에 다른 생성자 메서드 호출하는 구문 (순환 호출)
		System.out.println("추가 생성자");
		this.s = s; 
		this.i = i;
		
	}
	
	
	
	
}
