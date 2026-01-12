import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LottoApp2 {

	public static void main(String[] args) throws Exception {

		java.util.Scanner scanner = new java.util.Scanner(System.in);
		LottoDao dao = new LottoDao();
		// 로또 번호 추출기
		// 1. 숫자 여섯 개를 저장할 배열 만들기
		int[] numbers = new int[6];

		outer: while (true) {
			
			System.out.println("******************************");
			System.out.println("* 1. 당첨 예상 번호 뽑기.");
			System.out.println("2. 과거 당첨 번호 초기화");
			System.out.println("3. 회차별 당첨 번호 조회");
			System.out.println("* 9. 종료.");
			System.out.println("******************************");
			System.out.print("작업 선택 : ");
			String selection = scanner.nextLine();
			
			switch(selection) {
			
			case "9": 				
				System.out.println("행운을 빕니다.");
				System.out.println("프로그램을 종료합니다.");
				break outer; // outer라는 이름이 붙은 반복문 또는 switch문 break
			
			case "1":
				// 2. 당첨 예상 번호 뽑기
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

				// 3. 뽑힌 숫자 출력 : ( 반복문 사용 )
				for (int number : numbers) {
					System.out.printf("[%2d]", number);
				}
				System.out.println();
				
				break;
			
			case "2":
				
				// 기존 데이터 제거
				LottoDao.deleteAll();
				
				FileInputStream fis = null;		// 파일에 대한 byte[] 입출력
				InputStreamReader isr = null;	// String <-> byte[] 변환
				BufferedReader br = null;		// 한 줄씩 읽는 기능 제공
				
				try {
					
					fis = new FileInputStream("lotto-winning-numbers.csv");
					isr = new InputStreamReader(fis);
					br = new BufferedReader(isr);
					
					while (true) {
						String line = br.readLine();	// 텍스트 파일에서 한 줄 읽기
						if (line == null) {				// EOF
							break;
						}
						
						String[] data = line.split(","); // split : "abc-efg-xy-tac".split("-") --> ["abc", "efg", "xy", "tac"]
						LottoDto n = new LottoDto();
						n.setRnd(Integer.parseInt(data[0]));
						 java.util.Date d = LottoDto.sdf.parse(data[1]);
						n.setGameDate(d);
						n.setNumber1(Integer.parseInt(data[2]));
						n.setNumber2(Integer.parseInt(data[3]));
						n.setNumber3(Integer.parseInt(data[4]));
						n.setNumber4(Integer.parseInt(data[5]));
						n.setNumber5(Integer.parseInt(data[6]));
						n.setNumber6(Integer.parseInt(data[7]));
						n.setBonus(Integer.parseInt(data[8]));
						dao.insertLotto(n);
						
					}			
				} catch (Exception ex) {
					ex.printStackTrace();
				} finally {
					try { br.close(); } catch (Exception ex) {}
					try { isr.close(); } catch (Exception ex) {}
					try { fis.close(); } catch (Exception ex) {}
				}
				break;
			
			case "3":
				
				System.out.print("조회할 회차 번호를 선택 : ");
				LottoDto result = dao.selectLottoByRnd(scanner.nextInt());
				scanner.nextLine();
				
				if (result == null) {
					
					System.out.println("해당 회차의 번호 존재하지 않음");
					
				} else {
					
					System.out.printf
						("[%d][%d][%d][%d][%d][%d][%d]\n",
								result.getRnd(), 
								result.getNumber1(),
								result.getNumber2(),
								result.getNumber3(),
								result.getNumber4(),
								result.getNumber5(),
								result.getNumber6(),
								result.getBonus()
						);
				};
				break;
			
			default:
				System.out.println("지원하지 않는 명령입니다.");
			}			
		}
	}	
}
