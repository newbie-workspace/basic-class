
public class DataTypeAndVariable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 변수 만들기 ( 변수 선언 )
		int a; // 4byte 정수형 공간을 만들고 이름을 a로 지정
		a = 100; // a 변수에 100 저장
		a = a * 10; // a 변수에 a * 10 저장
		System.out.println("a에 저장된 값 : " + a);
		
		// 변수 만들기 2
		double b; // 메모리에 8byte 실수형 공간을 만들고 이름을 b로 지정
		b = 12.23; // b에 12.23 저장
		System.out.println("b에 저장된 값 : " + b); // 암시적 형변환 b가 문자열 -> 문자열과 숫자가 합해질 때,
		
		// 한글 변수 만들기
		int 나이;
		나이 = 32; 
		System.out.println("나이 : " + 나이); 
		
		int c = 3;
		System.out.println(c+b+a);

		// 
		int d; // 4byte 정수형 변수
		// d = 12.23; -> 오류 : 실수형 데이터를 정수형 변수에 저장할 수 없음.
		d = (int)12.23; // 명시적 형변환 (explicit type casting, narrowing conversion) : 12.23을 정수형으로 변경
		System.out.println(d);
		
		double e;
		e = 100; // 암시젹 형변환 (implicit type casting, widening conversion ) ( 정수 -> 실수, 부동소수점 )
		System.out.println(e);
		
		// 문자형
		// 문자열 : 0개 이상의 문자 집합. : "..." : 자료형은 String
		// 문자 : 1개의 문자 : 'A' : 자료형은 char
		
		char ch = 'a'; // 문자 a를 해당하는 코드 값(97)으로 저장. UTF-8 유니코드
		System.out.println(ch);
		System.out.println((int)ch); // 문자를 숫자로 명시적 형변환

		int g = 2147483647; // 4byte 정수 자료형이 표현할 수 있는 한계 값 2^(4 * 8)-1
		int h = g + 1;
		System.out.println(h);
		
	}

}
