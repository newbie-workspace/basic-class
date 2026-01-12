

// Person 클래스를 만들었다 -> Person 참조 자료형을 만든 것
public class Person2 {  
	
	int age;
	String name;
	String email;
	String phone;
    
	// 생성자 메소드의 특징  (인스턴스 초기화 메소드)
	// 1. 클래스의 이름과 같아야 한다.
	// 2. 결과형이 없음. void 가 아니다.
	// 3. instance 를 만들 때 자동으로 호출 ( = new...) -> 직접 명시적으로 호출할 수 없다.
	// 4. 오버로딩 가능 (여러 개의 생성자 메소드 만들 수 있다.)
	
	
	Person2() {
		
		System.out.println("test : 전달인자 없는 생성자 메소드.");
		name = "unnamed";
		phone = null;
		email = null;
		age = 0;
		
	}
	
	Person2(String name, String p, String e, int a) { 
		
		System.out.println("test : 전달인자 있는 생성자 메소드.");
		this.name = name; // this. : 현재 인스턴스를 참조하는 참조 변수 
		this.phone = p;
		this.email = e;
		this.age = a;
	
		
	}
		
}
