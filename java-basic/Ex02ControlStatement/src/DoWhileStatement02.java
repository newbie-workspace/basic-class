
public class DoWhileStatement02 {

	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in);

		
		while (true)  { 
			
			int score1;
			int score2;
			int score3;
						
			do {
				System.out.print("첫 번째 정수 (0~100) : ");
				score1 = scanner.nextInt();
			} while (score1 < 0 || score1 > 100);
				
		
			do {
				System.out.print("두 번째 정수 (0~100) : ");
				score2 = scanner.nextInt();
			} while (score2 < 0 || score2 > 100);
			
			do {
				System.out.print("세 번째 정수 (0~100) : ");
				score3 = scanner.nextInt();
			} while (score3 < 0 || score3 > 100);
			
			
			int total = score1 + score2 + score3;
			double average = total / 3.0;

			char grade = '_';
			

			switch ((int) average % 10) {

					case 9, 10 -> grade = 'A';
					case 8 -> grade = 'B';
					case 7 -> grade = 'C';
					case 6 -> grade = 'D';
					case 5 -> grade = 'E';
					case 4, 3, 2, 1, 0 -> grade = 'F';
			}

			
				
			System.out.printf("[평균 : %.2f][등급 : %c]\n", average, grade);
					
			

			System.out.print("계속? (y/n) : ");
			String again = scanner.next(); // enter를 입력으로 처리하지 않는 명령 (비. nextLine)
			// if (again.equalsIgnoreCase("y") == false) {
			if (!again.equalsIgnoreCase("y")) {		
				break;
			}
			
			
		} // end of while

	}

}
