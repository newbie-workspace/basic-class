import java.util.Scanner;
	// 블 : 이번 연습은 실제 사용성 보다는 배운 것을 연습하는 용도
public class ContactManager2 {
	// 입력기 인스턴스 만들기
	private Scanner scanner = new Scanner(System.in);
	
	private Contact[] contacts = new Contact[1000]; // 연락처를 저장할 배열	
	private int nextIdx = 0; // 다음 연락처가 저장될 위치. // 블 : 이 부분의 논리를 다시 생각해 볼 필요.
												   // 블 : 연락처를 한 번의 입력으로 저장하는 것이 아니고 사용자의 입력에 따라
												  // 블 : 한번씩 저장하기 때문에, 저장하고 나서 "다음에" 저장하는 것을 표시하는 변수가 필요
	public void run() {
		
		menuLoop : while (true) {
			
			String selection = selectTask();
			
			System.out.println();
			
			switch (selection) {
			
				case "1" : 
					printAllContacts();
					break;
					
				case "2" : 
					searchContact(); 
					break;
					
				case "3" :
					registerContact();
					break;
					
				case "4" : 
					break;
					
				case "5" :
				deleteContact();
					
					break;
					
				case "9" : 
					System.out.println("프로그램을 종료합니다. ");
					break menuLoop; 
					
				default : 
					System.out.println("지원하지 않는 명령입니다. ");
					System.out.println();
					
			}
			
			System.out.println();
		} // menuLoop ends
			
			
	}




	   private void deleteContact() {
		// 삭제할 연락처 이름 입력 -> 변수에 저장
		// 검색해서 표시
		
		System.out.print("삭제할 연락처 이름 : ");
		String name = scanner.nextLine();
		System.out.println("대상 연락처 목록");
		boolean found = false; // 삭제 대상의 발견 여부를 저장하는 변수.
			for (int i = 0; i < nextIdx; i++) {
				 if (contacts[i].getName().indexOf(name) > -1) {
					String info = contacts[i].info();
					System.out.println(info); 
					found = true; // 삭제 대상 발견
				} 
			}
			if ( found == false) {
				System.out.println("삭제 대상 검색 실패");
				return; // method 를 멈추는 것.
			}
		// 삭제 대상 선택 ( 번호로 입력 )
		System.out.print("삭제 대상 연락처 번호 : ");
		int idxToDelete = scanner.nextInt();
		scanner.nextLine(); //입력 버퍼 지우기
		// 번호에 해당되는 연락처 삭제
		// 번호 이후의 전체 연락처를 앞으로 이동
			for ( int i = idxToDelete; i < nextIdx; i++) {
				contacts[i-1] = contacts[i]; // 한칸 앞으로 이동.
				contacts[i-1].setNo(contacts[i-1].getNo()-1); // 번호 1 감소.
			}
		nextIdx--;
		
		// 블 : 삭제 대상에서 없는 번호를 입력한 경우 등 고려해야 할 것이 많음. 
		// 블 : 여기서는 사용자가 제대로 입력할 것으로 가정.
	   }




	private void searchContact() {   // 블 : 한번에 여러 기능을 하는 메서드를 만드는 것은 좋은 습관이 아님.
		// 검색할 연락처 이름 입력 -> 변수에 저장
		// 목록을 순회하면서 각 연락처에 일치하는 이름과 일치 여부 -> 일치하면 출력
		System.out.print("검색할 이름 : ");
		String name = scanner.nextLine();
		boolean found = false;
//					for (int i = 0; i < nextIdx; i++) {
//						String ni = contacts[i].getName();     // 완전 일치 검색
//						if (name.equals(ni)) {						
//						System.out.println(contacts[i].info()); 
//						break;								
//					} 
		// 나 : contacts 는 배열이고 각 원소가 클래스 Contact.			
		// 나 : 따라서 Contact.getName(); 한 것처럼 contacts[i].getName();
		// 나 : 생각해보면 간단하지만.
		
		for (int i = 0; i < nextIdx; i++) {
			
			 if (contacts[i].getName().indexOf(name) > -1) {	// indexOf : 앞에서 부터 해당 문자열이 존재하는 위치
			//if (contacts[i].getName().contains(name)) {	
				String info = contacts[i].info();
				System.out.println(info); 
				found = true;
			//break; 를 없애야 해당되는 것들이 다 나옴.								
			} 
		}
		if ( found == false) {
			System.out.println("검색 대상 검색 실패");
			return;
		}
		
	}




	private void printAllContacts() {
		System.out.println("~~~연락처 목록~~~");
		for (int i = 0; i < nextIdx; i++) {
			
			System.out.println(contacts[i].info());
			
		}
	}




	private void registerContact() {
		// 이름, 전화번호, 이메일 입력 
		System.out.println("~~~ 새 연락처 정보 입력 ~~~");
		System.out.print("이름 : ");
		String name = scanner.nextLine();
		System.out.print("전화번호 : ");
		String phone = scanner.nextLine();
		System.out.print("Email : ");
		String email = scanner.nextLine();
		// 입력받은 데이터를 사용해서 Contact instance 만들기
		Contact contact = new Contact(nextIdx +1, name, phone, email);
		// 만든 instance 	를 배열에 저장
		contacts[nextIdx] = contact; // 나 : 각각 생각해보면 쉬운데, 종합적인 사고가 어렵웠음.
		nextIdx++;				     // 나 : 이 부분의 논리를 다시 생각해 볼 필요.
	}




	private String selectTask() {
		// 메뉴 표시
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(" 1. 연락처 목록 보기" );
		System.out.println(" 2. 연락처 검색" );
		System.out.println(" 3. 연락처 등록" );
		System.out.println(" 4. 연락처 수정" );
		System.out.println(" 5. 연락처 삭제" );
		System.out.println(" 9. 연락처 등록" );
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.print("작업을 선택하세요 : ");
		String selection = scanner.nextLine();
		System.out.println();
		return selection;
	}
	
	
	
	
	public static void main(String[] args) {
		
		ContactManager2 manager = new ContactManager2();
		manager.run();
		
	}

}
