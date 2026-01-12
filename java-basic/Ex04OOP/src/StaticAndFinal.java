
public class StaticAndFinal {

	int ino;
	
	// static 멤버는 인스턴스와 관계가 없이 1번 만들어지고 모든 인스턴스가 공유
	static int sno;
	
	// static 메서드도 만들 수 있다.
	static int getSno() {
		// ino = 100; // 오류 : static 메서드 안에서 인스턴스 멤버를 사용할 수 없다.
		return sno;
	}
	
	// static 초기화 구문 : static 멤버를 초기화 하는 용도
	static {
		sno = 100;
	}
	
	int vno = 1;
	final int fno = 1;
	final int fno2;
	static final int sfno = 1; // static final member는 필드 초기화만 가능
	
	StaticAndFinal() {
		
		vno = 20;
	//	fno = 20;  // 이미 초기화 된 것은 안됨.
		fno2 = 20; // final member 는 생성자에서 값 저장 가능. 
	//	sfno = 20; // static final member는 필드 생성자에서 값 저장 불가능
		
	}
	
	void m() {
		
		vno = 10;
//		fno = 10;    final member 의 값 변경할 수 없다.
//		fno2 = 10;   final member 의 값 변경할 수 없다.
//		sfno = 10;   final member 의 값 변경할 수 없다.
		
	}
	
}
