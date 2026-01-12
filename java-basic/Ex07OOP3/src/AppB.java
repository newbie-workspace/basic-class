
// 일반적으로는 클래스를 이렇게 한 곳에 만들지 않음.

class TheBase2 {
	private int number;
	String name;

	public void parentMethod() {
		System.out.println("TheBase2.parentMethod()가 호출되었습니다.");
	}
}

class TheDerived2 extends TheBase2 { 
	String descendant;
	
	public void childMethod() {
		name = "Jane Doe";  
		System.out.println("TheDervied2.childMethod()가 호출되었습니다.");
	}
}

public class AppB { 
	public static void main(String[] args) {
		// 1. 상속 관계에 있는 클래스는 참조타입과 인스턴스 타입이 다를 수 있다.
		// 1-1. 암시적 형변환 ( TheDerived -> TheBase2 )
		TheBase2 b1 = new TheDerived2(); 

		// 1-2. 명시적 형변환 ( TheBase2 -> TheDerived )
		// TheDerived2 d1 = (TheDerived2) new TheBase2(); // compile 오류는 피해가지만 runtime 오류 발생
		
		// 1-3. 명시적 형변환2
		TheDerived2 d2 = (TheDerived2) b1; // runtime 오류 발생하지 않는다. 실제 가르키고 있는 인스턴스는 TheDerived2 타입이므로 가능
		
		
		// 2. instanceof : 형변환 가능 여부 확인 (안전한 형변환)
		TheBase2 b3 = new TheBase2();
		TheBase2 b4 = new TheDerived2();
		
		if (b3 instanceof TheDerived2) {
			System.out.println("b3은 TheDerived2로 형변환 가능");
		} else {
			System.out.println("b3는 TheDerived2로 형변환 불가능");
		}
		
		if (b4 instanceof TheDerived2) {
			System.out.println("b4은 TheDerived2로 형변환 가능");
		} else {
			System.out.println("b4는 TheDerived2로 형변환 불가능");
		}
		
		System.out.println("end of program.");
	}
}









