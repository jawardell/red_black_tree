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

         finalToString += "\n\nSearch Succesful!\nCountry: " + countryName + "\n";
      
         String callerName = names.get(goodPhoneNumber);
      
         finalToString += "Caller Name: " + callerName + "\n";
         
         finalToString += "Phone Number: " + (countryCodeStr + restOfNumStr) + "\n";

      } else {
         //changed to a print statement because it now serves as a prompt instead of
         //a final toString
         System.out.print("The search was inconslusive.\nAdd phone number to our database? (Y/N)");//ask yes or no
         String addNum = input.next();
         if(addNum.ignoreCase().equals("y")){
            //if yes, add phone
            tree.insert(goodPhoneNumber);
            System.out.print("The phone number has been added successfully. Thank you for your assistance." +
                             " Have a great day!");
         }
         else if(addNum.ignoreCase().equals("n")){
         //if no, ask to search/add again
            System.out.println("Would you like to search another number?(Y/N)");
            String answer = input.next();
            if(answer.ignoreCase().equals("y")){
               //this is where we left off   
            }
         }
               
      }
    System.out.println(finalToString);
      
      
   }
}
