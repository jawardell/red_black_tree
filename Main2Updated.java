import java.util.*;
import java.io.*;
import java.io.FileNotFoundException;
public class Main2Updated {//
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
      boolean exit = true;


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
			tree.insert(person);
		}
		scanner.close();
      
      System.out.println("**************************************************************"
      			+ "\n**        Welcome to Sierra University People Search        **"
	      		+ "\n**                                                          **"
      			+ "\n**    For security reasons,Our database is limited to use   **"
      			+ "\n**               by students and faculty                    **"
      			+ "\n**                                                          **"
      			+ "\n**************************************************************\n\n");
      System.out.println("If you see any problems with our database, please call us at 908-674-1124\n\n");
      
      
		while(exit) {
			possible = "";
			String key = "";
         count = 0;
			//System.out.print("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n\nNew Search\n\n");
			System.out.print("Do you want to search by name or ID:\n");
			choice = input.next();
			if(choice.equalsIgnoreCase("Name")) {
				System.out.print("Enter \"1\" for first and last name format.");
				System.out.print("\nEnter \"2\" for single name format.\n");
				int casey = input.nextInt();
				switch(casey) {
					case 1 :
						System.out.print("Enter first and last name:\n");
                  String firstname = input.next();
                  String lastname = input.next();
						key = firstname.substring(0,1).toUpperCase() + firstname.substring(1) + " " + lastname.substring(0,1).toUpperCase() + lastname.substring(1);
						break;
					case 2:
						System.out.print("Enter single name:\n");
						key = input.next();
                  key = key.substring(0,1).toUpperCase() + key.substring(1);
						break;
				}

				for(String name1 : names.keySet()) {
					if(name1.contains(key)) {
						count++;
						possible += names.get(name1).getName() + "\n";
					}
				}


				if(count > 1) {
					System.out.print("There were multiple occurrences:\n");
					System.out.print(possible);
					System.out.print("\nType the first and last name of one you want:\n");
					String searchByFirstName = input.next();
               				String searchByLastName = input.next();
					searchByName = searchByFirstName.substring(0,1).toUpperCase() + searchByFirstName.substring(1) + " " + searchByLastName.substring(0,1).toUpperCase() + searchByLastName .substring(1);
					found = true;
				} else if (count == 1) {
					searchByName = possible.substring(0, possible.length()-1);
					found = true;
				} else {
					System.out.print("There are 0 occurrences");
               found = false;
				}

				if(found) {
					Person person = names.get(searchByName);
					System.out.print(person.toString());
				}

			}




			if(choice.equalsIgnoreCase("ID")) {
				System.out.print("Enter ID:\n");
				searchById = input.nextLong();
				if(tree.search(searchById)) {//this tiny line searches thru 2000+ ids @ lightning speed
					Person person = ids.get(searchById);
					System.out.print("\nSearch Successful!\n" + person.toString());
				} else {
					System.out.print("\nSearch Failed.");
				}
			}
         
         System.out.println();
         System.out.println("\nWould you like to search again? [Y,N]");
         Scanner scan2 = new Scanner(System.in);
         String answer = scan2.next();
         if (answer.equalsIgnoreCase("Y")){
         
         }
         else
            exit = false;
		}

	}
}

