
public class ThePoint {
	
	int x;
	int y;
	
	// 생성자 메서드 : 클래스 이름과 같고 return 결과형이 없다. (void 도 아니다.)
	ThePoint() {
		System.out.println("전달인자 없는 생성자 메서드");
	}
	
	ThePoint(int x, int y) { // 오버로딩 : 전달인자의 갯수나 자료형을 다르게 하여 같은 이름의 함수를 쓸 수 있다.
		System.out.println("전달인자 있는 생성자 메서드");
		this.x = x;
		this.y = y;
	}
	
	String info() {
		//  String.format : javacript 의 grave accent string 과 같은 역활 -> template literal
		return String.format("[X : %d][Y : %d]", x, y);
	}
	
}
