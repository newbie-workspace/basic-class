
	// class TheAbstract {abstract void am();} // error : a class that has an abstract method must be abstract itself.
abstract class TheAbstract { // abstract class : cannot be instantiated
	
	// 2. abstract method
	// abstract void am() {} // error : abstract method does not have a body
	abstract void am();
	
}
	// 3-1. abstract class is specifically designed to be a parent class
	// class that is derived from an abstract class must override all of its abstract methods
class TheConcrete extends TheAbstract {
	
	@Override
	void am() {
	}
	
}

public class AppF {

	public static void main(String[] args) {

		// 1. abstract class
		// TheAbstract a = new TheAbstract(); // abstract class cannot create an instance
		TheAbstract a; // but can create a reference variable of an abstract class
		a = new TheConcrete();
		
		// 3-2. usage of abstract class : anonymous inner class
		TheAbstract a2 = new TheAbstract() { // create an anonymous inner class that inherits from TheAbstract 
											 // + create an instance of that class
			
								@Override
								void am() {
									System.out.println("method am of the anonymous inner class");
								}
								
							};
						
			a2.am();
		
		}

}
