
interface TheInterface {
	
	// 1. interface : all methods are abstract methods -> public abstract (automatically set as such, if not written)
														// except for static and default methods.
	// void m1() {} // error : cannot create a normal method
	void m2(); // automatically becomes public abstract void m2();	
	
	// 2. interface : all fields are static final (automatically set as such, if not )
	int v1 = 100; // automatically becomes static final int v1 = 100;
	
}


 // 5. interface can inherit from another interface
interface TheInterface2 extends TheInterface {
	void m3();
}

// 4-1. interface is specifically designed to be implemented by a class
// 	  must override(provide an implementation for) all abstract methods of the interface
class TheImplement implements TheInterface {
	
	@Override
	public void m2() {
	}
	
}

public class AppG {

	public static void main(String[] args) {
		
		// 3. interface : cannot be instantiated ( new TheInterface(); )
		// TheInterface i1 = new TheInterface(); // 오류
		
		// 4-1. 
		TheInterface i2 = new TheImplement();
		
		// 4-1. interface : using an anonymous inner class
		TheInterface i3 = new TheInterface() { // creates an anonymous inner class that implements TheInterface 
											   // + creates an instance of that class
			
							@Override
							public void m2() {
								System.out.println("method m2() of the anonymous inner class");
							}
		};
		i3.m2();
		
	}

}
