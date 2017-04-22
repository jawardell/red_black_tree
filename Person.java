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
		if(role.equals("Faculty")) {
			       return "\n" + role + "\nName: " + name + "\nID: " + id + "\nPhone Number: " + corp + "\nEmail: " + email;
		}
		return "\n" + role + "\nName: " + name + "\nID: " + id + "\nClassification: " + corp + "\nEmail: " + email;
	}
}

