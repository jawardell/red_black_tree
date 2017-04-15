import java.util.*;
import java.io.*;

class Main2 {
	public static void main(String[] args) throws Exception {
		String countryName = "";
		File file = new File("SchoolDB.txt");
		Scanner scan = new Scanner(file);
		HashMap<String, Long> names = new HashMap<>();
		RBTree tree = new RBTree(0);
		String finalToString = "";
		while (scan.hasNext()) {
			String ForS = scan.next(); //faculty or student
			long id= scan.nextLong();
			String firstName = scan.next();
         String lastName = scan.next();
         String email = scan.next();
         String CorP = scan.next(); //classification or phone number
         scan.nextLine(); //to avoid the problem with different # of arguments, doesnt work though lol
			tree.insert(id);
			names.put(firstName + " " + lastName, id);// kd saves the day w/ hm
		}
		scan.close();
      
		Scanner input = new Scanner(System.in);
      long identify = -1;
      boolean isThere = false;
      long duration = 0;
      String possibles = "";
		/*
		 * The while loop is the concept we should chase. We want to keep the
		 * command line going until a condition is met which means we need a
		 * loop. The while loop will bring the user back to the top if they
		 * specify in the bottom if-statement, that they want to do another
		 * search P.S. The braces for the while loop have been placed in their
		 * respective location
		 */
      System.out.print("Would you like to search by name or ID? ");
      String choice = input.next();
		while (choice != "exit") {
         if(choice.equalsIgnoreCase("ID")){
			   System.out.print("Enter student ID:");
			   identify = input.nextLong();

			   isThere = tree.search(identify);
         }
         if(choice.equalsIgnoreCase("Name")){
            System.out.println("Enter first or last name: ");
            String key = input.next();
            
            for(Map.Entry<String,Long> match: names.entrySet()){
               long t1 = System.nanoTime();
               if(match.getKey().contains(key)){
                  possibles += match.getKey() + "\n";
                  duration = System.nanoTime() - t1;
               }
            }
            //System.out.println("Search Complete. There were multiple occurences of the name" +
            //                   " you searched
         }
			if (isThere) {

            System.out.println("it's there! " + identify + "***" + ((double)duration/1000000000));
				}

				/*finalToString += "\n\nSearch Succesful!\nCountry: " + countryName + "\n";

				String callerName = names.get(goodPhoneNumber);

				finalToString += "Caller Name: " + callerName + "\n";

				finalToString += "Phone Number: " + (countryCodeStr + restOfNumStr) + "\n"; 
            } */
            else {
				// changed to a print statement because it now serves as a
				// prompt instead of
				// a final toString
				System.out.print("The search was inconslusive.The student you searched for doesn't exist" +
                              " in our database;");// ask yes or no
																											
				String addNum = input.next();
				if (addNum.equals("y")) {
					// if yes, add phone
					tree.insert(identify);
					System.out.print("The phone number has been added successfully. Thank you for your assistance."
							+ " Have a great day!");
				} else {
					// if no, ask to search/add again
					System.out.println("Would you like to search another number?(Y/N)");
					String answer = input.next();
					if (answer.equals("y")) {
						// leads user to beginning of while loop
						continue;
					} else {
						finalToString += "GoodBye! \t\t Type 'exit' to end program";
						break;// hops out of outer-most if-statement
						// Note: while loop is still running
					}

				}
				System.out.println(finalToString);

			} // end of while
		}
	}
}
