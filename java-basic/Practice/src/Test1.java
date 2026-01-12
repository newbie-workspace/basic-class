import java.util.ArrayList;
import java.util.Scanner;

public class Test1 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		try {
			
			int x = Integer.parseInt(input);
			
		} catch (NumberFormatException ex) {
			System.out.println("wrong input");
		}
		
		scanner.close();
		
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			array.add(i+1);
		}
		
	}

}
