
public class IfStatement02 {

	public static void main(String[] args) {
		
		//점수 처리기 만들기 
		// 변수를 만들고 사용자 입력을 받아서 변수에 저장 *3
		// 세 변수에 저장된 값을 더해서 다른 변수에 저장
		// 합을 3으로 나누어서 평균을 계산하고 다른 변수에 저장
		// 합과 평균을 출력
		// 평균을 기준으로 등급을 계산하고 그것을 출력
			
		
//		내가 작성한 코드		
//		java.util.Scanner scanner = new java.util.Scanner(System.in);
//		System.out.println("국어 점수는? : ");
//		int x = scanner.nextInt();
//		System.out.println("수학은? : ");
//		int y = scanner.nextInt();
//		System.out.println("도덕은? : ");
//		int z = scanner.nextInt();
//		
//		int h = x + y + z;
//		double j = h/3.0; 
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		System.out.println("총 점수 : " + h +" , " + "평균 : " + j);
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//		if(j <= 30) {
//			System.out.println("낙제!");
//		} else if(j > 30 && j <=50) {
//			System.out.println("별로");
//		} else if(j > 50 && j <=90) { 
//			System.out.println("잘했다~");
//		} else {
//			System.out.println("매우 잘했어요!");
//		}
//		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.println("첫 번째 정수 (0~100) : ");
		int score1 = scanner.nextInt();
		System.out.println("두 번째 정수 (0~100) : ");
		int score2 = scanner.nextInt();
		System.out.println("세 번째 정수 (0~100) : ");
		int score3 = scanner.nextInt();
		
		//테스트 코드 : System.out.println(score1 + "/" + score2 + '/' + score3); //비권고사항 : 문자열 더하기
		
		int total = score1 + score2 + score3;
		
		//테스트 : System.out.println(total);
		
		double average = total / 3.0; // 같은 자료형 연산 -> 같은 자료형으로 결과가 나오고, 
										//다른 자료형 사이의 연산은 결과가 큰 자료형
										//정수와 실수 연산이므로 실수 자료형 
										// 3.0 대신에 3. 또는 3F 사용 가능

		
		// System.out.println(average);
		System.out.printf("\"평균\" : %.2f\n", average); // %.2f : 소숫점 이하 2자리까지 출력.
													// 문자열 안에서 특수한 문자를 표기하는 방법 escape sequence
													//		\n : enter
													//		\t : tab
													//		\" : "
													//		\' : '
													//		\r : home
													//		\b : backspace
													//		\f : form feed
		
	
		
		char grade = '_'; //if 구문에서 제일 마지막 경우에 grade 값이 주어지지 않으므로 초기화 문자 대입.
		boolean valid = true;
		
		if(average >= 90 && average <= 100) {   // 90 <= average <= 100 를 왼쪽 부터 계산하면 true <= 100 또는 false <= 100 이므로 불가능
			//System.out.println("등급 : A");
			grade = 'A';
		} else if(average >= 80 && average < 90){
			//System.out.println("등급 : B");
			grade = 'B';
		} else if(average >= 70 && average < 80){
			//System.out.println("등급 : C");
			grade = 'C';
		} else if(average >= 60 && average < 70){
			//System.out.println("등급 : D");
			grade = 'D';
		} else if(average >= 50 && average < 60){
			//System.out.println("등급 : E");
			grade = 'E';
		} else if (average >= 0 && average < 50) {
			grade = 'F';
			//System.out.println("등급 : F");
		}
			
		else { // 100보다 크거나 0보다 작은 경우
			System.out.println("error");
			valid = false;
		}
		
		
		if(valid) {
			System.out.println("\"등급\" : " + grade); //비권고사항 : 문자열 더하기
		    System.out.printf("\"등급\" : %c", grade); //%c 문자 place holder, %s 문자열 place holder
		}
		
	}

}
