import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		String countryName = "";
		File file = new File("data.txt");
		Scanner scan = new Scanner(file);
		HashMap<Long, String> names = new HashMap<>();
		RBTree tree = new RBTree(0);
		String finalToString = "";
		while (scan.hasNext()) {
			String country = scan.next();
			long phoneNum = scan.nextLong();
			String name = scan.next();
			tree.insert(phoneNum);
			names.put(phoneNum, name);// kd saves the day w/ hm
		}
		scan.close();

		Scanner input = new Scanner(System.in);
		/*
		 * The while loop is the concept we should chase. We want to keep the
		 * command line going until a condition is met which means we need a
		 * loop. The while loop will bring the user back to the top if they
		 * specify in the bottom if-statement, that they want to do another
		 * search P.S. The braces for the while loop have been placed in their
		 * respective location
		 */
		while (input.next() != "exit") {
			System.out.print("enter country code: ");
			String countryCodeStr = input.next();
			System.out.print("\nenter rest of phone number: ");
			String restOfNumStr = input.next();

			int countryCodeInt = Integer.parseInt(countryCodeStr);
			long goodPhoneNumber = Long.parseLong((countryCodeStr + restOfNumStr));

			boolean isThere = tree.search(goodPhoneNumber);




    switch (countryCodeInt) {
				case (1):
					countryName = "United States/Canada";
					break;
				case (91):
					countryName = "India";
					break;
				case (52):
					countryName = "Mexico";
					break;
				case (61):
					countryName = "Australia";
					break;
				default:
					countryName = "unlisted";
				}
            
			if (isThere) {

				finalToString += "\n\nSearch Succesful!\nCountry: " + countryName + "\n";

				String callerName = names.get(goodPhoneNumber);

				finalToString += "Caller Name: " + callerName + "\n";

				finalToString += "Phone Number: " + (countryCodeStr + restOfNumStr) + "\n";

            System.out.println(finalToString);
        
            
			} else {
				// changed to a print statement because it now serves as a
				// prompt instead of
				// a final toString
            
				//System.out.print("The search was inconslusive.\nAdd phone number to our database? (Y/N)");// ask yes or no
            System.out.print("The search was inconslusive, the call originated from " + countryName + "\nAdd phone number to our database? (Y/N)");// ask yes or no
																											
				String addNum = input.next();
				if (addNum.equalsIgnoreCase("y")) {
					// if yes, add phone
					tree.insert(goodPhoneNumber);
					System.out.print("The phone number has been added successfully. Thank you for your assistance."
							+ " Have a great day!");
				} else {
					// if no, ask to search/add again
					System.out.println("Would you like to search another number?(Y/N)");
					String answer = input.next();
					if (answer.equalsIgnoreCase("y")) {
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
