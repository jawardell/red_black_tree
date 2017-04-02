package schooldatabase;

public class Faculty {
	long id;
	String name;
	long cell;
	String email;
	
	public Faculty(long id, String name, long cell, String email) {
		this.id = id;
		this.name = name; 
		this.cell = cell;
		this.email = email;
	}
	
	public String getName() {
		return name;
	}
	
	public long getID() {
		return id;
	}
	
	public long getCell() {
		return cell;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String toString() {
		return "\nFaculty\nName: " + name + " ID: " + id + " Classification: " + classification + " Email: " + email;
	}
}
