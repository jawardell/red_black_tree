package school;
import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
public class Main2 {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("SchoolDB.txt");
		TreeMap<String, Person> names = new TreeMap<>();
		TreeMap<Long, Person> ids = new TreeMap<>();
		RBTree tree = new RBTree(0);
		Scanner scanner = new Scanner(file), input = new Scanner(System.in);
		String searchByName = "", possible, choice = "";
		boolean found = false;
		long searchById = 0;
		int count = 0;


		while(scanner.hasNext()) {
			String role = scanner.next();
			long id = scanner.nextLong();
			String firstName = scanner.next();
			String lastName = scanner.next();
			String email = scanner.next();
			String corp = scanner.next();
			Person person = new Person(role, id, firstName + " " + lastName, corp, email);
			names.put(person.getName(), person);
			ids.put(person.getID(), person);
			tree.insert(person.getID());
		}
		scanner.close();


		while(!choice.equals("exit")) {
			possible = "";
			String key = "";
			System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n\nNew Search\n\n");
			System.out.print("\n\nType \"exit\" to quit. Search by name or ID:\n");
			choice = input.next();
			if(choice.equalsIgnoreCase("Name")) {
				System.out.print("Enter \"1\" for first and last name format.");
				System.out.print("\nEnter \"2\" for single name format.\n");
				int casey = input.nextInt();
				switch(casey) {
					case 1 :
						System.out.print("Enter first and last name:\n");
						key = input.next() + " " + input.next();
						break;
					case 2:
						System.out.print("Enter single name:\n");
						key = input.next();
						break;
				}

				for(String name1 : names.keySet()) {
					if(name1.contains(key)) {
						count++;
						possible += names.get(name1).getName() + "\n";
					}
				}


				if(count > 1) { //if multiple occurrences found
					System.out.print("There were multiple occurrences:\n");
					System.out.print(possible);
					System.out.print("\nType the first and last name of one you want:\n");
					searchByName = input.next();
					searchByName += " " + input.next();
					found = true;
				} else if (count == 1) {
					searchByName = possible.substring(0, possible.length()-1);
					found = true;
				} else {
					System.out.print("There are 0 occurrences");
				}

				if(found) {
					Person person = names.get(searchByName);
					System.out.print(person.toString());
				}

			}




			if(choice.equalsIgnoreCase("ID")) {
				System.out.print("Enter ID:\n");
				searchById = input.nextLong();
				found = tree.search(searchById);    //this tiny line searches thru 2000+ ids @ lightning speed

				if(found) {
					Person person = ids.get(searchById);
					System.out.print("\nSearch Successful!\n" + person.toString());
				} else {
					System.out.print("\nSearch Failed.");
				}
			}


		}


	}
}
