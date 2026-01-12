class TheBase5 {
	
	final int x = 10; // final : 값을 변경할 수 없는 상수
	
	final void baseMethod() { // final method 는 overriding 불가능
		// x = 20; // 오류 : final 이므로.
	}
	
}

class TheDerived5 extends TheBase5 {
	
	// @Override void baseMethod() {} // 오류 : final method 는 overriding 불가능
		
}

final class TheBase52 { // 상속 불가능 클래스 
	
}

// class TheDerived52 extends TheBase52 {} // final class 는 상속할 수 없다. 

public class AppE {

	public static void main(String[] args) {
		
	}

}
