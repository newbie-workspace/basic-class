
public class SwitchStatement {

	public static void main(String[] args) {

		// 계산기 만들기
		// 1. 숫자 입력 -> 변수에 저장
		// 2. 연산자 (문자, +, -, *, /) 입력 -> 변수에 저장
		// 3. 숫자 입력 -> 변수에 저장
		// 4. 연산자에 따라 연산을 수행

		java.util.Scanner scanner = new java.util.Scanner(System.in);

		System.out.print("정수 값 입력 : ");
		int input1 = scanner.nextInt();
		scanner.nextLine(); // 입력 버퍼 비우기

		System.out.print("연산자 (+, -, *, /, %) 입력 : ");
		String operator = scanner.nextLine();

		System.out.print("정수 값 입력 : ");
		int input2 = scanner.nextInt();
		scanner.nextLine(); // 입력 버퍼 비우기

		double result = 0; // 초기화 : 변수를 만들면서 특정 값을 저장하는 것. -> 아무 데이터가 없는 변수 지정 비권고
		
		boolean valid = true;
		
		switch (operator) {
		
		case "+":
			result = input1 + input2;
			break;
		case "-":
			result = input1 - input2;
			break;
		case "*":
			result = input1 * input2;
			break;
		case "/":
			result = (double)input1 / input2;
			break;
		case "%":
			result = input1 % input2; // % : modulo 연산자 -> 결과 modulus. 
			break;
		default:
			System.out.print("error");
			valid = false;
		}

		if (valid) {
		System.out.printf("%d %s %d = %f", input1, operator, input2, result);
		}
		
		
		
	}

}
