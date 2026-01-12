
public class LottoApp {
	public static void main(String[] args) {

		// 로또 번호 추출기
		// 1. 숫자 여섯 개를 저장할 배열 만들기
		// 2. [1, 45] 범위의 (중복되지 않는) 6개의 난수 뽑기. -> 배열에 저장.
		// 3. 출력
		// 4. 사용자가 원할 때까지 반복.
				
		java.util.Scanner scan = new java.util.Scanner(System.in);
		String t = "_";
		
		int[] numbers = new int[6];
		
		while(true) {
			
			while(true) {
					
					for (int i = 0; i < numbers.length; i++) {
						numbers[i] = (int) (Math.random() * 45) + 1; // [1, 45]
			
						for (int j = 0; j < i; j++) { // 현재 뽑힌 위치 이전까지 반복
							if (numbers[i] == numbers[j]) {
								i--; // for 문에 i가 증가하더라도 현재 i위치를 다시 뽑도록 미리 1 감소.
							}
						}
					}
					// 평균이 20 ~ 26 범위에 있지 않으면 다시 뽑기
					int s = 0;
					
					for (int i = 0; i < 6; i++) {
						s += numbers[i];
					}
					
					int average = s / 6;
			
					if (average >= 20 && average <= 26) {
							System.out.printf("AVERAGE %2d\n", average);
							break;
					}
			
			}
			
			for (int n : numbers) {
				System.out.printf("[%2d]", n);
			}
			
			System.out.println();
			System.out.print("다시 실행? (y or n) ");
			
			t = scan.nextLine();
		
			if(!t.equalsIgnoreCase("y")) {
				break;
			}
		
		}
		
		
		
		
		
	}
}
