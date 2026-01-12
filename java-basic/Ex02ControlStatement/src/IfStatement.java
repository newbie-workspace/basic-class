
public class IfStatement {

	public static void main(String[] args) {

		// int a = 0;

		
		// double a = Math.random();// [0 , 1) 범위의 난수 발생 
		// a = a - 0.5;
		System.out.println("=====================");
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("정수를 입력하시요 : ");
		int a = scanner.nextInt(); //정수 입력 받는 명령
		
		System.out.println("=====================");
		
		if (a > 0) {
			System.out.println("a는 0보다 크다.");
		} else if (a < 0) {
			System.out.println("a는 0보다 작다.");
		} else {
			System.out.println("a는 0이다.");
		}
		
	}

}
