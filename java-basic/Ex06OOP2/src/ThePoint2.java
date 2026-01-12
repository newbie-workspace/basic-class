
public class ThePoint2 {
	
	public static int shared;
	
	private int x;
	private int y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		if (x < 0) {
			System.out.println("x < 0 일 수 없음.");
			return;
		}
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// 생성자 메서드 : 클래스 이름과 같고 return 결과형이 없다. (void 도 아니다.)
	public ThePoint2() {
		System.out.println("전달인자 없는 생성자 메서드");
	}
	
	public ThePoint2(int x, int y) { // 오버로딩 : 전달인자의 갯수나 자료형을 다르게 하여 같은 이름의 함수를 쓸 수 있다.
		System.out.println("전달인자 있는 생성자 메서드");
		this.x = x;
		this.y = y;
	}
	
	public String info() {
		//  String.format : javacript 의 grave accent string 과 같은 역활 -> template literal
		return String.format("[X : %d][Y : %d]", x, y);
	}
	
}
