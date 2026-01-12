
public class DoWhileStatement {

	public static void main(String[] args) {
		
		// [0 , 100] 숫자 사용자 입력 받기 -> 변수에 저장
		// 범위를 벗어나면 다시 입력
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		
		int number;
		
		do {
			System.out.print("숫자(0~100)를 입력하세요 : ");
			number = scanner.nextInt();
			
		} while (number < 0 || number > 100);
		
		System.out.printf("[Number : %d]\n", number);
		
		
		
		
	}

}
