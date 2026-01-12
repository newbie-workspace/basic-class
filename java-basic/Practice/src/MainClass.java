class Parent {
	
	String s = "Mr.Voerman";
	
	static int staticNumber = 1;
	static void print() {
		System.out.println("This is the Parent Class");
	}
	
}

class Child extends Parent {
	
	// s = "필드 영역에 선언문만 가능"
	String s = "Jeanette Voerman";
	
	static int staticNumber = 10;
	static void print() {
		System.out.println("This is the Child Class");
	}
	
}



public class MainClass {

	public static void main(String[] args) {
		
		System.out.println(Parent.staticNumber);
		System.out.println(Child.staticNumber);
		
//		Parent test = new Child();
//		System.out.println(test.staticNumber); static field should be accessed in a static way.
//		test.print();	
		int a = Parent.staticNumber;
		System.out.println(a);
		Parent.print();
		
		
	}

}
