class TheObject {

	// int x; // 이 변수에는 정수만 저장.
	Object v; // 이 변수에는 모든 자료형의 데이터를 저장.
}

class TheGeneric<T, E> {
	T v; // 미확정 자료형 T 타입의 변수 선언. ( 이 클래스로 변수르 만들 때 결정 ) 
	E v2;
}

public class GenericDemo {

	public static void main(String[] args) {
		
		// 1.
		TheObject obj1 = new TheObject();
		obj1.v = 11; // 다른 자료형 -> Object  일 때, 암시적 형변환.
		
		TheObject obj2 = new TheObject();
		obj2.v = "nameless";
		
		System.out.println((int)obj1.v + 30); // Object -> 다른 자료형 일 때, 명시적 형변환.
		// System.out.println((int)obj2.v + 30); // compile 오류 없음, 그러나 runtime 오류 생김. (문자열 -> 정수 변환)
		
		// 2.
		TheGeneric<Integer, String> gobj1 = new TheGeneric<>(); // T타입을 integer 로. 
		gobj1.v = 11;
		TheGeneric<String, Integer> gobj2 = new TheGeneric<>(); // T타입을 integer 로.
		gobj2.v = "Jeanette Voerman";
		
		System.out.println((int)gobj1.v + 30); // Generic 은 형변환 불필요.
		// System.out.println((int)gobj2.v + 30); compile 오류 : 형변환 문제 상황 자동 검출.
	}
}
