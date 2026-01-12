
// 일반적으로는 클래스를 이렇게 한 곳에 만들지 않음.

class TheBase {

	private int number;
	String name;
	
	public void parentMethod() {
		
		System.out.println("TheBase.parentMethod()가 호출되었습니다.");
		
	}

}

class TheDerived1 extends TheBase { // TheBase 가 가지고 있는 모든 멤버를 자동으로 포함. 생성자 제외
	
	// 상속받은 클래스는 새로운 멤버를 추가하거나 기존 멤버를 변경하는데 의미가 있다.
	
	String descendant;
	
	public void childMethod() {

		name = "Jane Doe"; // private 이 아닌 부모의 멤버는 사용 가능. 
		//number = 100; // 부모 클래스의 private 멤버는 자식 클래스에서 사용할 수 없다.
		System.out.println("TheDervied1.childMethod()가 호출되었습니다.");
		
	}
	
}

public class AppA { // public class 의 이름과 파일 이름은 일치해야 한다.
	
	public static void main(String[] args) {
		
		TheBase b1 = new TheBase();
		b1.parentMethod();
		//b1.childMethod(); // 부모 클래스는 자식의 멤버를 사용할 수 없다.
		
		TheDerived1 d1 = new TheDerived1();
		d1.parentMethod(); // TheBased 에서 상속한 멤버 사용
		d1.childMethod();
		
	}
	
}