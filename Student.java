package schooldatabase;

public class Student {
	String name;
	long id;
	String classification;
	String email;
	
	public Student(String name, long id, String classification, String email){
		this.name = name;
		this.id = id;
		this.classification = classification;
		this.email = email;
	}
	
	public String getName(){
		return name;
	}
	
	public long getID(){
		return id;
	}
	
	public String getClassification(){
		return classification;
	}
	
	public String getEmail(){
		return email;
	}
	
	//do we want setters? 
	
	public String toString(){
		return "\nStudent\nName: " + name + " ID: " + id + " Classification: " + classification + "Email: " + email;
	}
}
