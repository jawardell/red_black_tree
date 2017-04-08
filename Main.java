import java.util.*;
import java.io.*;

class Main {
   public static void main(String[] args) throws Exception {
      File file = new File("data.txt");
      Scanner scan = new Scanner(file);
      HashMap<Integer, String> names = new HashMap<>();
      RBTree tree = new RBTree(0);
      String finalToString = "";
      while(scan.hasNext()) {
         String country = scan.next();
         int phoneNum = scan.nextInt();
         String name = scan.next();
         tree.insert(phoneNum);
         names.put(phoneNum, name);
         //scan.nextLine();//go to next line in doc
      }
      scan.close();
      
      Scanner input = new Scanner(System.in);
      System.out.print("enter phone number: ");
      int phoneNumRequest = input.nextInt();
      
      //get country code
      
      String phoneString = phoneNumRequest+"";
      String countryString = phoneString.substring(0, 3);
      int country = Integer.parseInt(countryString);
      String countryName = "";
      
            
      boolean isThere = tree.search(phoneNumRequest);
      
      if(isThere) {
      
         switch (country) {
         case(001) :
            countryName = "America";
            break;
         case(000) :
            countryName = "India";
            break;
         case(052) :
            countryName = "Mexico";
            break;
         case(061) :
            countryName = "Australia";
            break;
         default : 
            countryName = "unlisted";
         }

         finalToString += "\n\nSearch Succesful!\nCountry Name: " + countryName + "\n";
      
         String callerName = names.get(phoneNumRequest);
      
         finalToString += "Caller Name: " + callerName + "\n";
         
         finalToString += "Phone Number: " + phoneNumRequest + "\n";

      } else {
         finalToString += "The search was inconslusive.\nAdd phone number to our database?";
         
         //ask yes or no
         //if yes, add phone
         //if no, ask to search/add again
      }
    System.out.println(finalToString);
      
      
   }
}