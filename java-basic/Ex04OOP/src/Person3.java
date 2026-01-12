


public class Person3 {  
	
	// private : 클래스 외부에서 접근할 수 없는 멤버
	private int age;
	private String name;
	private String email;
	private String phone;
    
	
	// public : 클래스 외부에서 접근할 수 있는 멤버
	public Person3() {
		
	}
	
	public Person3(String name, String p, String e, int a) { 
		
		this.name = name;  
		this.phone = p;
		this.email = e;
		this.age = a;
	
	}
	
	// alt shift s
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	
	
		
}
