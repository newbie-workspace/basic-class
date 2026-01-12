

public class ForStatement02 {

	public static void main(String[] args) {
		
		// 1. 숫자 사용자 입력
		// 2. 1부터 사용자가 입력한 숫자까지 순서대로 출력
		
		// 1. 숫자 사용자 입력
		// 2. 1부터 사용자가 입력한 숫자까지의 합을 계산.
		// 3. 계산 값을 출력
		

		java.util.Scanner scan = new java.util.Scanner(System.in);
		
		System.out.print("정수 입력 : ");
		
		int n = scan.nextInt();
		for (int i = 1; i < n + 1; i++) {
			System.out.printf("[round %d]\n", i);
		}
		
		System.out.print("정수 입력 : ");
		int m = scan.nextInt();
		scan.nextLine(); // 입력 버퍼 지우기.
		int s = 0;
		
		for (int i = 0; i < m + 1; i++) {
			
			s += i; //s = s + i;
				
		}
		
		System.out.printf("S : %d\n", s);
		System.out.println("======================");
		String string = "";
		
		
		boolean wrongInput = false;
		do {
			wrongInput = false;
			try {
				
				System.out.print("정수를 입력 : ");
				string = scan.nextLine().trim();
				int x = Integer.parseInt(string);
				System.out.println(x);
				
			} catch (NumberFormatException ex) {
				wrongInput = true;
				System.out.printf("%s 는 올바른 입력값이 아님.\n", string);
			}
			
		} while (wrongInput);
	}
}
