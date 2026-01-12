
public class Contact {

		private int no;
		private String name;
		private String phone;
		private String email;
	
	// 나
//	public String info() {
//		
//		String i = this.no + " : " + this.name + "  " + this.phone + "  " + this.email; 
//		return i;
//	}
	
	// cf.	
	public String info() {
		return no + " " + name + " " + phone + " " + email;
	}
	
	
	
		
	// generate constructor using fields (alt + shift + s, source 옵션)
	public Contact() {
		
	}
	
	// generate constructor using fields (alt + shift + s, source 옵션)
	public Contact(int no, String name, String phone, String email) {
		
		this.no = no;
		this.name = name;
		this.phone = phone; 
		this.email = email;
		
	}
	
	

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
