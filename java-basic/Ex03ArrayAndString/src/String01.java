
public class String01 {
	
	public static void main(String[] args) {
		
		
		// 1.
		String str1 = "Hello, String";
		String str2 = "Hello, String";
		
		// 문자열에 대한 == 연산자는 주소를 비교 ( 값 비교 X)
		if (str1 == str2) { //같은 문자열 리터럴은 한 번만 만들어지기 때문에 주소가 같습니다. 
			System.out.println("두 문자열의 주소가 같습니다. ");
		} else {
			System.out.println("두 문자열의 주소가 다릅니다. ");
		}
		System.out.println(str1 == str2);
		
		
		// 2.  
		String str3 = new String("Hello, String"); // new : 매번 새 공간을 생성
		String str4 = new String("Hello, String");
		
		
		if (str3 == str4) { // new 로 만들어진 문자열은 매번 새로 만들어지기 때문에 주소가 다르다.
			System.out.println("두 문자열의 주소가 같습니다. ");
		} else {
			System.out.println("두 문자열의 주소가 다릅니다. ");
		}
		System.out.println(str3 == str4);
				
		// 문자열에 대한 내용(값) 비교는 equals 
		if (str3.equals(str4)) { // new 로 만들어진 문자열은 매번 새로 만들어지기 때문에 주소가 다르다.
			System.out.println("두 문자열이 같다.");
		} else {
			System.out.println("두 문자열이 다르다. ");
		}
		
		// 3.
		
		String str5 = new String("Hello, String"); 
		String str6 = str5; // 주소 복사
		str5 = str5 + " 추가된 내용"; // 문자열의 변경 사항은 새로운 문자열을 만들어서 적용.
		
		if (str5 == str6) { 
			System.out.println("두 문자열의 주소가 같습니다. ");
		} else {
			System.out.println("두 문자열의 주소가 다릅니다. ");
		}
				
		System.out.println(str5);
		System.out.println(str6);
		//
		
	}
}
