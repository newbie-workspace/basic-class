package research_a;

public class TestMain {

	public static void main(String[] args) {
		
		Person person = new Person();
		//person.name = "Therese"; //private 이므로 외부에서 접근 불가.
		//person.setName("Therese"); //일반적인 방법.
		
		//lombok 을 이용한 방법. lombok 설치 후 project 우클 -> build path -> add external archive -> lombok.jar 선택
		//Person 클래스 위에 @Setter, @Getter 또는
		//Person 클래스 위에 @Data : 모든 필드 (변수)에 대해 자동으로 getter, setter 생성
		person.setName("Therese"); 
		String name = person.getName();
		System.out.println(name);
	}
}
