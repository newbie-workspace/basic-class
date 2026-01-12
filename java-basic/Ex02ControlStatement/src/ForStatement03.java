
public class ForStatement03 {

	public static void main(String[] args) {
		
		// 1 ~ 9 범위의 숫자 입력
		// 입력된 단의 구구단 출력
		// 예. 5 입력
		// 5 * 1 = 5, 
		// 5 * 2 =10,
		// ...
		// 5 * 9 =45
		
		java.util.Scanner scan = new java.util.Scanner(System.in);
		System.out.println("출력할 구구단 : ");
	    int a = scan.nextInt();
	    
	    for (int i = 1; i < 10; i++) {
	    	
	    	int j = a * i; 
	    	
	    	System.out.printf("%d * %d = %2d\n", a, i, j); //%2d : 2 자릿수로 출력 (오른쪽 부터 정렬)
	    													//%-2d : 2 자릿수로 출력 (왼쪽 부터 정렬)
	    }
	    	// 이런 방식으로도 가능.
			//	    for (int i = 1; i < 10; i++) {		
			//  		 System.out.printf("%d * %d = %d\n", a, i, a * i);
			//   }
	    
	    System.out.println();
	    

	    	
	    ///////////////////////////////////////////////////////////////////
	    
	    // 1단 ~ 9단 모두 출력
	    // 1 * 1 = 1	2 * 1 = 2	3 * 1 = 3 ... 9 * 1 = 9
	    // 1 * 2 = 2	2 * 2 = 4	3 * 2 = 6 ... 9 * 2 = 18
	    // ...
	    // 1 * 9 = 9	2 * 9 = 18	3 * 9 = 27 ... 9 * 9 = 81
	    
	    for (int y = 1 ; y < 10 ; y ++) {
	    	for (int x = 1 ; x < 10 ; x++) {
	    		System.out.printf("%d x %d = %2d  ", x , y, x * y);
	    	}
	    	System.out.println();
	    }
	    
	    
	    // Math.round(r); -> r의 값을 소숫점 이하에서 반올림.
	    // Math.random(); -> [0, 1) 사이의 임의의 실수.
	    
	        
	    
	    
	    
	    
	    
	    
		
		
	}

}
