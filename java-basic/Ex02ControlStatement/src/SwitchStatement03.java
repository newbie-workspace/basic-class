
public class SwitchStatement03 {

	public static void main(String[] args) {

		

		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.println("첫 번째 정수 (0~100) : ");
		int score1 = scanner.nextInt();
		System.out.println("두 번째 정수 (0~100) : ");
		int score2 = scanner.nextInt();
		System.out.println("세 번째 정수 (0~100) : ");
		int score3 = scanner.nextInt();

		// 테스트 코드 : System.out.println(score1 + "/" + score2 + '/' + score3); //비권고사항 :
		// 문자열 더하기

		int total = score1 + score2 + score3;

		// 테스트 : System.out.println(total);

		double average = total / 3.0; // 같은 자료형 연산 -> 같은 자료형으로 결과가 나오고,
										// 다른 자료형 사이의 연산은 결과가 큰 자료형
										// 정수와 실수 연산이므로 실수 자료형
										// 3.0 대신에 3. 또는 3F 사용 가능

		// System.out.println(average);
		System.out.printf("\"평균\" : %.2f\n", average); // %.2f : 소숫점 이하 2자리까지 출력.
														// 문자열 안에서 특수한 문자를 표기하는 방법 escape sequence
														// \n : enter
														// \t : tab
														// \" : "
														// \' : '
														// \r : home
														// \b : backspace
														// \f : form feed

		char grade = '_'; // if 구문에서 제일 마지막 경우에 grade 값이 주어지지 않으므로 초기화 문자 대입.
		boolean valid = true;
		
		
//		switch ((int) average % 10) {
//
//		case 9, 10 : 		 grade = 'A'; break;
//		case 8 : 			 grade = 'B'; break;
//		case 7 :			 grade = 'C'; break;
//		case 6 :			 grade = 'D'; break;
//		case 5 :			 grade = 'E'; break;
//		case 4, 3, 2, 1, 0 : grade = 'F'; break;
//		
//		default: valid = false;
//
//		}
		
		switch ((int) average % 10) {
		
		case 9, 10 ->		 grade = 'A'; 
		case 8 ->		 grade = 'B'; 
		case 7 ->			 grade = 'C'; 
		case 6 ->			 grade = 'D'; 
		case 5 ->			 grade = 'E'; 
		case 4, 3, 2, 1, 0 -> grade = 'F'; 
		
		default -> valid = false;
		
		}
		
		
		if (valid) {
			System.out.println("\"등급\" : " + grade); // 비권고사항 : 문자열 더하기
			System.out.printf("\"등급\" : %c", grade); // %c 문자 place holder, %s 문자열 place holder
		}

	}

}
