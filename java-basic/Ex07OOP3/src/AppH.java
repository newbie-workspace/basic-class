// 1. 인터페이스 정의

interface TheInterface4 {
	
	void im(); // 알아서 -> public abstract void im(); 
	// void im2(); // 4. 인터페이스에 새 기능 추가 -> 인터페이스를 구현하는 모든 클래스에 오류 발생
	default void im2() {
		System.out.println("TheInterface4 의 default method im2()");
	}
	
}

// 2. 인터페이스 구현 클래스 정의
class TheImplement4 implements TheInterface4 {
	
	@Override
	public void im() {
		System.out.println("TheImplement4.im()");
	}
	
}

public class AppH {

	public static void main(String[] args) {
	
		// 3. 인터페이스 사용
		TheInterface4 i = new TheImplement4();
		i.im();
		i.im2(); // 인터페이스의 디폴트 메서드는 재정의 없이 사용 가능.

	}

}
