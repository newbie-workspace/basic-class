
public class Array01 {

	public static void main(String[] args) {
		
//		String str = new String("is String"); // 직접 메모리 공간을 만들고 사용. str 에 값을 지닌 공간의 주소가 저장 
//		String str2 = "is String2"; // literal 표현 : 만들어진 공간에 직접적으로 데이타 입력
//		int a = 10; 
		
		
		// 1. 배열 만들기
		
		
		
		int[] ar; // 참조 변수 만들고
		ar = new int[10]; // instance   
		// 다른 방법 : int[] ar = new int[10]; // int 자료형 데이터 10개를 모아서 저장하는 배열 생성
		
		for ( int i = 0; i < 10; i++ ) {
			ar[i] = (int) (Math.random() * 900) + 100 ; //??(int) 의 범위?? -> 바로 옆 : 100까지 안감.
		}
		
		for ( int i = 0; i < 10; i++ ) {
			System.out.println(ar[i]);
		}
		
		
		// 2. 배열 초기화
		
		int[] ar2 = new int[] {1, 2, 3, 4, 5}; 
		for ( int i = 0; i < 5; i++ ) {
			System.out.println(ar2[i]);
		}
		
		// 3. 배열 초기화
		
		int[] ar3 = {1, 2, 3, 4, 5}; 
		for ( int i = 0; i < 5; i++ ) {
			System.out.println(ar3[i]);
		}
		
		// 4. 배열 각 요소의 초기값
		
		int[] ar4 = new int[5]; // default 값
		for ( int i = 0; i < 5; i++ ) {
			System.out.println(ar4[i]);
		}
		
		// 5. 배열의 속성 : 배열.legnth
		
//		int arraySize = 10;
//		int[] ar5 = new int[arraySize]; // 하드코딩 권고하지 않음. -> 변수화     
//		
//		
//		for ( int i = 0; i < arraySize ; i++ ) {
//			ar5[i] = (int) (Math.random() * 900) + 100 ; 
//			System.out.println(ar5[i]);
//		}

		int[] ar6 = new int[6];
		
		for ( int i = 0; i < ar6.length; i = i + 2 ) {  // 배열.length : 배열에 포함된 요소 갯수
			ar6[i] = (int) (Math.random() * 900) + 100 ; 
			System.out.println(ar6[i]);
		}
		
		// 6. enhanced for 
		
		for ( int n : ar6 ) {  // ar6 배열에서 순서대로 처음부터 값을 꺼내서 n에 저장
			System.out.println(n);
		}
		
		// 참조 변수의 초기화
		
		int[] ar7 = null; // null : 참조 변수가 가르키는 인스턴스가 없음.
		System.out.println(ar7[0]); // null 로 초기화 되면 컴파일 오류는 사라지지만(실행은 됨),  오류 발생
		
		
		
	}

}
