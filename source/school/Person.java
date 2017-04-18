package school;

public class Person {
	long id;
	String name;
	String corp;
	String email;
	String role;
	
	public Person(String role, long id, String name, String corp, String email) {
		this.id = id;
		this.name = name; 
		this.corp = corp;
		this.email = email;
		this.role = role;
		if(this.role.equalsIgnoreCase("s")) {
			this.role = "Student";
		} else {
			this.role = "Faculty";
		}
	}
   
	public void setName(String name) {
		this.name = name;
	}
	
	public void setID(long id) {
	   this.id = id;
	}
	
	public void setCorp(String corp) {
		this.corp = corp;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public long getID() {
		return id;
	}
	
	public String getCorp() {
		return corp;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return "\n" + role + "\nName: " + name + "\nID: " + id + "\nCorp: " + corp + "\nEmail: " + email;
	}
}

