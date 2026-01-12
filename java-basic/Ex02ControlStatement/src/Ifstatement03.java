
public class Ifstatement03 {

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

		System.out.print("연산자 입력(+, -, *, /, %) : ");
		String operator = scanner.nextLine();

		System.out.print("정수 값 입력 : ");
		int input2 = scanner.nextInt();
		scanner.nextLine(); // 입력 버퍼 비우기

//		-> 이 부분에서 입력 버퍼를 지운다는 뜻 -> nextInt(); 가 scanner에서 숫자만 읽어오고 enter키는 입력 버퍼에 그대로 남아있는데, 
//		nextLine() 은 enter 까지도 읽기 때문에 바로 실행이 되버려서 operator 값이 빈 문자열이 됨
//		입력 버퍼를 비우거나, 아니면 scanner.nextLine() 대신 scanner.next() 를 쓰면 됨
//		-> next() 는 스페이스, 엔터, 탭을 읽지 않으므로 ex. "hello world" 의 첫 공백 전까지만 읽고 입력 버퍼를 남기게 됨.
		

		double result = 0; // 초기화 : 변수를 만들면서 특정 값을 저장하는 것. -> 아무 데이터가 없는 변수 지정 비권고
		// if (operator == "+") 문자열을 비교할 때에는 == 연산자를 사용할 수 없다.
		
		boolean valid = true;
		
		if (operator.equals("+")) { // 문자열을 비교할 때에는 equals 를 사용
			result = input1 + input2;
		} else if (operator.equals("-")) {
			result = input1 - input2;
		} else if (operator.equals("*")) {
			result = input1 * input2;
		} else if (operator.equals("/")) {
			result = (double) input1 / input2; // 변수 input1, input2 의 자료형 자체는 바뀌지 않음.
		} else if (operator.equals("%")) {
			result = input1 % input2;
		}

		else {
			System.out.println("error");
			valid = false;
		}
		if (valid) {

			System.out.printf("%d %s %d = %f", input1, operator, input2, result);

		}

	}

}
