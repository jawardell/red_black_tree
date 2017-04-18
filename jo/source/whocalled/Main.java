package whocalled;

import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws Exception {
		String countryName = "";
		File file = new File("data.txt");
		Scanner scan = new Scanner(file);
		HashMap<Long, String> names = new HashMap<>();
		RBTree tree = new RBTree(0);
		String finalToString = "", countryCodeStr = "";
		while (scan.hasNext()) {
			String country = scan.next();
			long phoneNum = scan.nextLong();
			String name = scan.next();
			tree.insert(phoneNum);
			names.put(phoneNum, name);
		}
		scan.close();
		Scanner input = new Scanner(System.in);
		System.out.print("\n\n\"exit\" ends the program.\nenter country code: ");
		while (!input.next().equals("exit")) {
			countryCodeStr = input.next();
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
				finalToString += "\n\nSearch Successful!\nCountry: " + countryName + "\n";
				String callerName = names.get(goodPhoneNumber);
				finalToString += "Caller Name: " + callerName + "\n";
				finalToString += "Phone Number: " + (countryCodeStr + restOfNumStr) + "\n";
				System.out.println(finalToString);
				System.out.print("To begin new search, type \"begin\". Type \"exit\" to quit.\n");
			} else {

				System.out.print("The search was inconclusive, the call originated from " + countryName
						+ "\nAdd phone number to our database? (Y/N)");
				String addNum = input.next();
				if (addNum.equalsIgnoreCase("y")) {
					tree.insert(goodPhoneNumber);
					System.out.print("The phone number has been added successfully. Thank you for your assistance."
							+ " Have a great day!");
				} else {
					System.out.println("Would you like to search another number?(Y/N)");
					String answer = input.next();
					if (answer.equalsIgnoreCase("y")) {
						continue;
					} else {
						finalToString += "GoodBye! \t\t Type 'exit' to end program";
						break;
					}

				}
				System.out.println(finalToString);
			} 
		}
	}
}
