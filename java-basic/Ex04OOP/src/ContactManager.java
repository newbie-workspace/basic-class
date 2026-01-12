
public class ContactManager {

	// 연락처 관리 프로그램.
	// 1. 연락처 클래스(Contact) 만들기 // -필드 : no, name, phone, email, 
								  // -메소드 : info, 각 필드의 값을 하나의 문자열로 만들어서 반환. (no + name + phone....식으로
								  // -메소드 : getter/setter
								  // -메소드 : 생성자
	
	public static void main(String[] args) {
	
		// 나
//		Contact contact = new Contact(1,"jane doe", "123-2345-2345", "janedoe@vtmb.com");
//		
//		String i = contact.info();
//		
//		System.out.println(i);
		
	// 2. 연락처 클래스 사용
		// 연습 
//		Contact contact = new Contact(1, "jane doe", "123-2345-1234", "janedoe@vtmb.com");
//		String info = contact.info();
//		System.out.println(info);
		
	// 3. 연락처 3개를 저장하는 배열 만들기
	//    배열의 각 요소에 연락처를 만들어서 저장
	//    배열에 저장된 모든 연락처 출력
			
       // 나
//		String[][] array = new String[3][4];
//		for (int j = 0; j < 3; j++) {
//			
//			for(int i = 0 ; i < 3; i++) {
//				array[i][j] = {j, "name", "phone"j, "email"j};................
//			}.............
//			............
//		}
		// 나
		//Contact contact = new Contact()
		// String[] array = new String[3]
		// ...
		
		
		Contact[] contacts = new Contact[3];
		
		for ( int i = 0; i < contacts.length; i++) {
			
			contacts[i] = new Contact();
			contacts[i].setNo(i+1);
			contacts[i].setName("Name "+ (i+1));
			contacts[i].setEmail("Email "+ (i+1));
			contacts[i].setPhone("Phone "+ (i+1));
			
		}
		
		for (Contact contact : contacts) {
			System.out.println(contact.info());
		}
		
		
		
		
			
			
			
		
		
		
		
		
		
		
	}

}
