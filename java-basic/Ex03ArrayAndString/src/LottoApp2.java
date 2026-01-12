
public class LottoApp2 {

	public static void main(String[] args) {

		// 로또 번호 추출기
		// 1. 숫자 여섯 개를 저장할 배열 만들기
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		int[] numbers = new int[6];

		outer : while (true) { // label outer:

			System.out.println("******************************");
			System.out.println("* 1. 당첨 예상 번호 뽑기.");
			System.out.println("* 9. 종료.");
			System.out.println("******************************");
			System.out.print("작업 선택 : ");

			String selection = scanner.nextLine();

			switch (selection) {
				case "9":
				System.out.println("행운을 빕니다. ");
				System.out.println("프로그램을 종료합니다. ");
				break outer; //outer 라는 이름이 붙은 반복문 또는 스위치 문을 break.

				case "1":
				while (true) {
					// 2-1. [1, 45] 범위의 (중복되지 않는) 6개의 난수 뽑기 -> 배열에 저장 : ( 반복문 사용 )
					for (int i = 0; i < 6; i++) {
						numbers[i] = (int) (Math.random() * 45) + 1; // [1 ~ 45]
						for (int j = 0; j < i; j++) { // 현재 뽑힌 위치 이전까지 반복
							if (numbers[i] == numbers[j]) { // 현재 뽑힌 숫자와 이전 숫자가 같다면(중복)
								i--; // for 문에 i가 증가하더라도 현재 i 위치를 다시 뽑도록 미리 1감소
								// i = -1; // for 문에 i가 증가하더라도 처음부터 다시 뽑도록 -1로 설정
							}
						}
					}

					// 2-2. 평균이 [20 ~ 26] 범위를 벗어나면 2-1부터 다시 (다시뽑기)
					int sum = 0;
					for (int i = 0; i < 6; i++) {
						sum += numbers[i];
					}
					int average = sum / 6;
					if (average >= 20 && average <= 26) { // 정상
						System.out.printf("[AVERAGE %2d]", average);
						break;
					}
				}

				for (int number : numbers) {
					System.out.printf("[%2d]", number);
				}
				System.out.println();

				break;

				default:
				System.out.println("지원하지 않는 명령.");
			}

		}

	}

}