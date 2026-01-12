
public class Array02 {

	public static void main(String[] args) {

		
		
		// 1. 2차원 배열 만들기
		int[][] ar = new int[5][7];

		for (int row = 0; row < ar.length; row++) {
			// System.out.println(ar[row]);
			for (int col = 0; col < ar[row].length; col++) {
				ar[row][col] = (int) (Math.random() * 900) + 100; // 100~1000

			}

		}

		for (int row = 0; row < ar.length; row++) {

			for (int col = 0; col < ar[row].length; col++) {
				System.out.printf("[%d]", ar[row][col]);
			}
			System.out.println();
		}

		System.out.println(ar[3]); // ar -> 변수 -> 배열 생성 (크기[5])
									// 각 배열 안에 다른 배열 (크기[7]) 을 각각 지정하는 주소 저장;;
		System.out.println(ar);

		System.out.println(java.util.Arrays.toString(ar));
		
		//2. 2차원 배열 초기화
		// int[] ar2 = new int[] {1,2,3};
		
		int[][] ar2 = new int [][] { {1, 2}, {3, 4}, {5, 6} }; //3행 2열 배열 초기화		
		// int[][] ar2 = { {1, 2}, {3, 4}, {5, 6} }
		
		for (int row = 0; row < ar2.length; row++) {

			for (int col = 0; col < ar2[row].length; col++) {
				System.out.printf("[%d]", ar2[row][col]);
			}		
			System.out.println();
		}
		
		//3. 각 행의 요소 갯수가 다른 2차원 배열 만들기
		
		int[][] ar3 = new int[5][]; // 모든 행의 요소 갯수가 확정되지 않음. 배열 인스턴스가 생성 안됨.
		System.out.println(ar3[1]); // null.
		
		for (int i = 0; i < ar3.length; i++) {
			ar3[i] = new int[i + 3]; //각 행에 크기가 서로 다른 배열 지정.			
		}
		
		System.out.println(ar3[1]); //주소
		
		for (int i = 0; i < ar3.length; i++) {
			
			for (int j = 0; j < ar3[i].length; j++) {
				ar3[i][j] = (int) (Math.random() * 900) + 100; // 100~1000

			}

		}

		for (int i = 0; i < ar3.length; i++) {

			for (int j = 0; j < ar3[i].length; j++) {
				System.out.printf("[%d]", ar3[i][j]);
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
