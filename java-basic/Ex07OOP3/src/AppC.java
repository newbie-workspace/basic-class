
// 일반적으로는 클래스를 이렇게 한 곳에 만들지 않음.

class TheBase3 {
	
	private int number;
	String name;

	public void parentMethod() {
		System.out.println("TheBase3.parentMethod()가 호출되었습니다.");
	}
	
}

class TheDerived3 extends TheBase3 { 
	
	String descendant;
	
	@Override // @ : annotation : 메서드, 클래스 등에 대한 부연 설명 및 구현
	public void parentMethod() { // overriding
		name = "Jane Doe";  
		System.out.println("TheDervied3.parentMethod()가 호출되었습니다.");
	}
	
}

public class AppC { 
	
	public static void main(String[] args) {
		
		// 1. method overriding
		
		TheBase3 b1 = new TheBase3();
		b1.parentMethod();
		
		TheDerived3 d1 = new TheDerived3();
		d1.parentMethod();
		
		// 2. 참조타입과 인스턴스 타입이 다를 때, 오버라이딩된 메서드를 호출하면 어떤 메서드가 호출?
		// 메서드 호출 형식은 같지만 참조하고 있는 인스턴스에 따라 다른 기능 수행 -> polymorphism (다형성)
		TheBase3 b2 = new TheDerived3();
		
		b2.parentMethod(); // 인스턴스 타입 기준으로 호출
		
		System.out.println("end of program...");
		
	}
	
}









