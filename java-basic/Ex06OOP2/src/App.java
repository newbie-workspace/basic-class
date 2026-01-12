import shape.TheRectangle;

public class App {

	public static void main(String[] args) {
		
		ThePoint point1 = new ThePoint(); // 전달인자 없는 생성자 메서드 호출
		point1.x = 100;
		point1.y = 200;
		String info = point1.info();
		System.out.println(info);
		
		ThePoint point2 = new ThePoint(10, 20);
		System.out.println(point2.info());
		
		ThePoint2 point3 = new ThePoint2(); // 전달인자 없는 생성자 메서드 호출
		// point3.x = 100; // 오류 : private field 는 외부에서 사용할 수 없음.
		// point3.y = 200; // 오류 : private field 는 외부에서 사용할 수 없음.
		point3.setX(50);
		point3.setY(70);
		System.out.println(point3.info());
		System.out.printf("[X + Y = %d]", point3.getX()+point3.getY());
		System.out.println();
		point3.setX(-5);
		
		ThePoint2.shared = 100; // static member 는 클래스 이름으로 접근
		System.out.println(ThePoint2.shared);
		System.out.println(point3.shared); // static member 객체 생성없이 바로 접근하는 것이 권장됨
											// static member 는 공유하기 때문에 다른 곳에서 변경한 값이 적용됨
		
		
		//shape.TheRectangle r = new shape.TheRectangle();
		TheRectangle r = new TheRectangle(); // import 구문을 사용하여 package 이름 생략 가능
		// r.leftX = 19; // 오류 : 다른 패키지에 있는 클래스의 default member 사용할 수 없다.
		
	}
	
}
