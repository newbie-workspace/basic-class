

public class MainApp {
	
	public static void main(String[] args) {
		
		Space space = new Space();
			
		// 1. Person class에 변수 만들기 및 사용
			Person person; // 참조 변수 만들기
			person = new Person();// 인스턴스 만들기 + 인스턴스의 주소를 person 변수에 저장
			
			person.age = 35; // person 인스턴스의 age 필드(변수)에 값 저장		
			person.name = "Jane Doe";
			person.email = "janedoe@vtmb.com";
			person.phone = "189-2343-2323";
			
			//확인
			System.out.printf("[%s]\n[%s]\n[%s]\n[%d]\n", person.age, person.email, person.phone, person.age);
		 
        space.jump();
			
		// 2. Utility 클래스 사용 (메서드 연습)
			Utility utility = new Utility();
			utility.drawBox(); // 매서드의 장점: 관리의 효용성 (가독성), 재사용성.
			
		space.jump();
			
		// 3. Utility 클래스 사용 2 (메서드 연습2)
			
			
			int weight = 30;  //입력 받은 것으로 가정
			int height = 15; //입력 받은 것으로 가정
			String s = "#";
			utility.drawBox2(weight, height, s);//전달인자, parameter
			utility.drawBox2(height, weight, s);
			
        space.jump();
		
		// 4. Utility 클래스 연습 3
		
			int result = utility.sum(50, 20);
			System.out.println(result);
			
			int result2 = utility.sum(150, 50, 200);
			System.out.println(result2);
			
			int result3 = utility.sumAll(150, 50, 200, 200, 199, 239, 23, 234, 23);
			System.out.println(result3);
			
		space.jump();
			
			
			
			
		// 5. Lotto 변수(인스턴스) 만들기
		// 기본번호 뽑는 메서드 호출
		// 결과 출력
			
				
			//me
		
//			LottoMy lotto = new LottoMy();
//			
//			lotto.lottery();
//			
//			lotto.menu();
		
			//me ends
		
			Lotto lotto = new Lotto();
						
//			boolean valid; 
//			int[] numbers;
//			
//			do {
//				numbers = lotto.selectBasicNumbers();
//				valid = lotto.checkAverage(numbers); // 평균 검사.
//			} while (!valid); //while (valid == false);
//			
//			lotto.printNumbers(numbers);
			
			// 위의 방법은 클래스의 유용성을 잘 나타내지 못한다. 자기 완결적 클래스가 아님
			
	        int[] numbers = lotto.selectWinningNumbers();
	        lotto.printNumbers(numbers);
			
			
		space.jump();
	        
	        
		    // 6. 생성자 constructor 메소드 1
		        
		    Person2 p2 = new Person2();
		    System.out.println(p2.name);  
		    
		    // 6.2 생성자 constructor 메소드 2
	        
		    String name = "Jane Doe";
		    Person2 p3 = new Person2(name, "123-2323-2323", "janedoe@vtmb.com", 33);
		    System.out.printf("[%s][%s][%s][%d]", p3.name, p3.email, p3.phone, p3.age);  
		    
		    System.out.println();
		    
		    // 6-3 생성자 메소드 3
		    
		    ConstructorTest ct = new ConstructorTest();
	        															
		space.jump();
		
		
		    // 7. 멤버 접근 제어 (권고 사항: 변수 -> private,  메소드 -> public )
		    
		    Person3 p7 = new Person3();
		   // p7.name = "홍길동"; // 오류 : private member 이므로 
		    
		    p7.setName("Jane Doe");
		    p7.setEmail("janedoe@vtmb.com");
		    p7.setPhone("123-2345-2345");
		    p7.setAge(33);
		    
		    System.out.printf("[%s]\n[%s]\n[%s]\n[%d]\n", p7.getName(), p7.getEmail(), p7.getPhone(), p7.getAge());
		    
		    
		    
		 
		 space.jump();
		    
		  // 8. static
		  System.out.println(StaticAndFinal.sno); // static 초기화 구문에서 저장한 값 사용.
		  StaticAndFinal saf1 = new StaticAndFinal();
		  saf1.ino = 1;
		  saf1.sno = 1;
		  StaticAndFinal saf2 = new StaticAndFinal();
		  saf2.ino = 2;
		  saf2.sno = 2;
		  System.out.println(saf1.ino + "/" + saf1.sno);
		  System.out.println(saf2.ino + "/" + saf2.sno);
		  
		  // static member 는 참조 변수로 접근하지 않고 클래스의 이름으로 접근한다.
		  
		  System.out.println(saf1.getSno());
		  System.out.println(StaticAndFinal.getSno()); 
		  
		  
		 // static 사용 사례
		   double f = Math.random();
		   System.out.println(f); // 여기서 out 은 static member
		  
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
	}

}

