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
      while(scan.hasNext()) {
         String country = scan.next();
         long phoneNum = scan.nextLong();
         String name = scan.next();
         tree.insert(phoneNum);
         names.put(phoneNum, name);//kd saves the day w/ hm
      }
      scan.close();
      
      Scanner input = new Scanner(System.in);
      System.out.print("enter country code: ");
      String countryCodeStr = input.next();
      System.out.print("\nenter rest of phone number: ");
      String restOfNumStr = input.next();
      
      int countryCodeInt = Integer.parseInt(countryCodeStr);
      long goodPhoneNumber = Long.parseLong((countryCodeStr + restOfNumStr));
      
      boolean isThere = tree.search(goodPhoneNumber);
      
      if(isThere) {
      
         switch (countryCodeInt) {
         case(1) :
            countryName = "America";
            break;
         case(91) :
            countryName = "India";
            break;
         case(52) :
            countryName = "Mexico";
            break;
         case(61) :
            countryName = "Australia";
            break;
         default : 
            countryName = "unlisted";
         }

         finalToString += "\n\nSearch Succesful!\nCountry Name: " + countryName + "\n";
      
         String callerName = names.get(goodPhoneNumber);
      
         finalToString += "Caller Name: " + callerName + "\n";
         
         finalToString += "Phone Number: " + (countryCodeStr + restOfNumStr) + "\n";

      } else {
         finalToString += "The search was inconslusive.\nAdd phone number to our database?";
         
         //ask yes or no
         //if yes, add phone
         //if no, ask to search/add again
      }
    System.out.println(finalToString);
      
      
   }
}
