
public class ForStatement04 {

	public static void main(String[] args) {
		
		
		for (int r = 0; r < 10; r++) {
				
			for(int c = 0; c < r + 1; c++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		System.out.println();		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		String x = "*";
		
		for (int i = 0 ; i < 10 ; i++) {
			
			System.out.println(x);
			x = x + "*";
			
		}
		
		
		
		
		System.out.println();
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		
		for (int r = 0; r < 10; r++) {
			
			for(int c = 0; c < 10 - r - 1; c++) {
				
				System.out.print(" ");
			}
			
			for(int c = 0; c < r + 1; c++) {
				
				System.out.print("*");
			}
			
			System.out.println();
		}

		
		
		
		System.out.println();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		
		
		
		for (int row = 0; row < 10 ; row++) {
			for (int col = 0; col < 10 ; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		
		
		
		
		System.out.println();
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
	
		
		
		
		
		
		
		for (int row = 0; row < 10 ; row++) {
			for (int col = 0; col < 10 ; col++) {
				if (row == 0 || row == 9 || col ==0 || col ==9) {
				System.out.print("*");
				} else {
				System.out.print(" ");
				}
			}
			System.out.println();
		}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		
		
		
		
	}

}
