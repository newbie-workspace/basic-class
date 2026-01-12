
public class WhileStatement03 {

	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);

		
		while (true)  { 
			
			System.out.print("첫 번째 정수 (0~100) : ");
			int score1 = scanner.nextInt();
			System.out.print("두 번째 정수 (0~100) : ");
			int score2 = scanner.nextInt();
			System.out.print("세 번째 정수 (0~100) : ");
			int score3 = scanner.nextInt();

			int total = score1 + score2 + score3;
			double average = total / 3.0;

			char grade = '_';
			boolean valid = true;

			switch ((int) average % 10) {

					case 9, 10 -> grade = 'A';
					case 8 -> grade = 'B';
					case 7 -> grade = 'C';
					case 6 -> grade = 'D';
					case 5 -> grade = 'E';
					case 4, 3, 2, 1, 0 -> grade = 'F';
					default -> valid = false;

			}

			if (valid) {
				
					System.out.printf("[평균 : %.2f][등급 : %c]\n", average, grade);
					
			}

			System.out.print("계속? (y/n) : ");
			String again = scanner.next(); // enter를 입력으로 처리하지 않는 명령 (비. nextLine)
			// if (again.equalsIgnoreCase("y") == false) {
			if (!again.equalsIgnoreCase("y")) {		
				break;
			}
			
			
		} // end of while

	}

}
