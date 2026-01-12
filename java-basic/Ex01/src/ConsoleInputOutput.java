
public class ConsoleInputOutput {

	public static void main(String[] args) {

		java.util.Scanner scanner = new java.util.Scanner(System.in); 
		// 터미널 환경에서 사용자 입력을 받는 입력기
		
		System.out.print("이름을 입력하세요. : "); // print : 출력 이후에 엔터를 처리하지 않는다. println : 출력 이후에 엔터를 처리.
		String input = scanner.nextLine(); // 사용자의 입력을 문자열 형식으로 받는 명령
		System.out.println(input + "님 반갑습니다.");
		System.out.printf("%s 님 반갑습니다.", input); // %s place holder
	
	}

}

// 출력 서식 ( printf 과 같은 메서드에서 사용 )
// %s : String 형식 데이터
// %c : char
// %d : 정수 계열
// %f : 실수 계열