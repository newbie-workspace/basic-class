
public class Lotto {

	// 1. 기본 번호 뽑는 메서드 만들기 (LottoApp2 참고)
	
	
	int[] selectBasicNumbers() {
		int[] numbers = new int[6];
		for (int i = 0; i < 6; i++) {
			numbers[i] = (int) (Math.random() * 45) + 1; 
			for (int j = 0; j < i; j++) { 
				if (numbers[i] == numbers[j]) { 
					i--; 
				}
			}
		}
		return numbers;
	}
	
	// 2. 6개 번호를 출력하는 메서드 만들기 (전달인자 int[], 결과형 : void)
	
	void printNumbers(int[] numbers) {
		
		for (int number : numbers) {
			System.out.printf("[%d]", number);
		}
	}
	
	// 3. 평균을 검사하는 함수를 만들기
	
	boolean checkAverage(int[] numbers) {
		
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += numbers[i];
		}
		int average = sum / 6;
		// System.out.println(average); ->평균 출력. 
		
//		if (average >= 20 && average <= 26) {
//			return true; 
//		} else {
//			return false;
//		}
		
		return (average >= 20 && average <= 26);
		
	}
	
	// 4. 위의 개별 기능 메서드를 사용해서 당첨 예상 번호를 뽑는 메서드
	
	int[] selectWinningNumbers() {
		
		int[] numbers; // = null; 권장사항
		boolean valid; // = false; 
		do {
			numbers = selectBasicNumbers(); //같은 클래스 안에 있는 메소드 직접 사용 가능
			valid = checkAverage(numbers); 
			
		} while (!valid);
		
		return numbers;
	}
	
	
	
	
	
	
	
	
	
	
}
