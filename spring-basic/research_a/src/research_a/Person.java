package research_a;

import lombok.Data;
//import lombok.Getter;
//import lombok.Setter;

@Data //Person 클래스 위에 @Data : 모든 필드 (변수)에 대해 자동으로 getter, setter 생성
public class Person {
	
	//@Getter
	//@Setter
	private String name;
	private String phone;
	private String email;
	private int age;
	
}
