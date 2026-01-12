
public class LottoMy {
	// 기본 번호 뽑는 메서드 만들기 (LottoApp2 참고)
	
	void lottery() {
		
		int[] numbers = new int[6];
		for (int i = 0; i < 6; i++) {
			numbers[i] = (int) (Math.random() * 45) + 1;
			for (int j = 0; j < i; j++) { 
				if (numbers[i] == numbers[j]) { 
					i--; 
				}
			}
		}
		
		for (int number : numbers) {
			System.out.printf("[%2d]", number);
		}
		System.out.println();
	} // 번호 뽑기 메서드 끝
	
	
	java.util.Scanner scanner = new java.util.Scanner(System.in);
	
	String answer = "_";
	
	void menu() {
			while(true) {
					while(true) {
					
						System.out.println("******************************");
						System.out.println("* 1. 당첨 예상 번호 뽑기.");
						System.out.println("* 9. 종료.");
						System.out.println("******************************");
						System.out.print("작업 선택 : ");
						
						answer = scanner.nextLine();
						if (answer.equalsIgnoreCase("1") || answer.equalsIgnoreCase("9")) {
							break;
						}
						System.out.println();
						System.out.println("잘못된 입력입니다. ");
						System.out.println();
					} // 메뉴 질문 끝
		
			if (answer.equalsIgnoreCase("1")) {
				lottery();
			}
			if (answer.equalsIgnoreCase("9")) {
				System.out.println("행운을 빕니다. ");
				System.out.println("프로그램을 종료합니다. ");
				break;
			}
		}	
	} // 메뉴 나오는 로또
	
	
	
}
