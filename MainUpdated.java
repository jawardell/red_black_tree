import java.util.*;
import java.io.*;

class MainUpdated {
	public static void main(String[] args) {

		try {
			String countryName = "";
			File file = new File("data.txt");
			Scanner scan = new Scanner(file);
			HashMap<Long, String> names = new HashMap<>();
			RBTree tree = new RBTree(0);
			String finalToString = "", countryCodeStr = "";
			boolean exit = true;
			while (scan.hasNext()) {
				String country = scan.next();
				long phoneNum = scan.nextLong();
				String name = scan.next();
				tree.insert(phoneNum);
				names.put(phoneNum, name);
			}
			scan.close();
			Scanner input = new Scanner(System.in);
			System.out.println("\n**************************************************************"
					+ "\n**        Welcome to WHOCALLED phone lookup service         **"
					+ "\n**                                                          **"
					+ "\n**   Have you received a call from a strange number lately? **"
					+ "\n**               We're here to help                         **"
					+ "\n**                                                          **"
					+ "\n**************************************************************\n\n");

			while (exit) {
				finalToString = "";
				System.out.println("enter country code: ");
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
				case (501):
					countryName = "Belize";
					break;
				case (55):
					countryName = "Brazil";
              				 break;
   				case (44):
					countryName = "England";
					break;
   				case (81):
					countryName = "Japan";
					break;
				case (975):
					countryName = "Bhutan";
					break;
				case (90):
					countryName = "Turkey";
					break;
				case (256):
					countryName = "Uganda";
					break;
				case (260):
					countryName = "Zambia";
					break;
				case (998):
					countryName = "Uzbekistan";
					break;
				case (66):
					countryName = "Thailand";
					break;
				case (20):
					countryName = "Egypt";
					break;
				case (672):
					countryName = "Antarctica";
					break;
				case (56):
					countryName = "Chile";
					break;
				case (57):
					countryName = "Colombia";
					break;
				case (30):
					countryName = "Greece";
					break;
				case (31):
					countryName = "Netherlands";
					break;
				case (381):
					countryName = "Serbia";
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
					System.out.println("Search again?\n");
					String answer = input.next();
					if (answer.equalsIgnoreCase("y")) {
						exit = true;
					} else {
						exit = false;

					}
				} else {

					System.out.print("The search was inconclusive, the call originated from " + countryName
							+ "\nSearch again? (Y/N)");
					String answer = input.next();
					if (answer.equalsIgnoreCase("y")) {
						exit = true;
					} else {
						exit = false;

					}
					System.out.println(finalToString);

				}
			}

		} catch (Exception e) {
			System.out.print("Please review your input and try again.\nExiting gracefully.");
		}

	}
}
