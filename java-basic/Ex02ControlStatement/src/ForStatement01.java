
public class ForStatement01 {

	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i = i + 1) { 
			
			System.out.printf("[round %d]\n", (i+1));
			
		}
		
			System.out.println("===================");		
			
		for (int i = 0; i < 10; i++) { //i++ : i = i + 1 
	
			System.out.printf("[round %d]\n", (i+1));

		}

		
		System.out.println("===================");		
		
		for (int i = 10; i > 0; i--) { //i-- : i = i - 1 
	
			System.out.printf("round %d\n", (i));

		}
		
		System.out.println("===================");
		
		for (int i = 1; i < 11; i++) { //i++ : i = i + 1 
			
			if ( i == 5 ) {
				continue; // 반복문의 처음 위치로 이동, 
			}
			
			System.out.printf("[round %d]\n", (i));

		}
		
		
		
			
		
		
	}
}
