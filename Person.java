

public class Person {
	long id;
	String name;
	String corp;
	String email;
	
	public Person(long id, String name, String corp, String email) {
		this.id = id;
		this.name = name; 
		this.corp = corp;
		this.email = email;
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
		return "\nPerson\nName: " + name + " ID: " + id + " Corp: " + corp + " Email: " + email;
	}
}

