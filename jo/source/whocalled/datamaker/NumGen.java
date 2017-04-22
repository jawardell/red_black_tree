/*This code generates the random phone numbers, adjusts them to the right length, removes duplicates, and checks again for duplicates.
It assigns a country at random using a switch statement and a randomly generated integer.
It reads from a list of 110 names and "pairs" the name with a phone number and country by chosing some random index of the array
   which holds the names.
We can delete the log file at some point if we want, it just contains my debugging information. It seems to be rather large because
   I was making twice as many adjustments as I needed (I've fixed that though). 
Feel free to add more names to the text file names.txt, just know that you will have to make adjustments to the array which holds them.
   There are currently 110 lines in names.txt and so the array which holds them has 110 items. We need to add campany names
   to names.txt.
   
I think we could easily use this to make the data for the school system.*/


import java.util.*;
import java.io.*;
public class NumGen {
   public static void main(String[] args) throws FileNotFoundException {
      File file = new File("rands.txt");
      File file2 = new File("log.txt");
      File file3  = new File("names.txt");
      Scanner scanner = new Scanner(file3);
      PrintWriter pw = new PrintWriter(file);
      PrintWriter pw2 = new PrintWriter(file2);
      
      
      //GET NAMES
      String[] names = new String[140];//make array for names
      for(int i = 0; i < 140; i++) {//read in names from names.txt
         names[i] = scanner.next();
      }
      
      
      
      
      
      //GENERATE RANDOM NUMBERS
         //generate
         //remove duplicates
         //add digits
         //merge lists
         //remove duplicates again
      long[] array = new long[2500];//make array for random phone numbers
      
      for(int i = 0; i < 2500; i++) {//generating random phone numbers
         int rand = (int)((0000000000) + Math.random()*Integer.MAX_VALUE);
         long randy = (long)rand;
         array[i] = randy;//put them in array
      }
      ArrayList<Long> list = new ArrayList<>();//make arraylist for unique numbers
      for(int i = 0; i < 2500; i++) {
         if(i == 0) {continue;}//avoiding out of bounds -1
         if(array[i-1] == array[i]) {continue;}//if there is a duplicate number, don't add it to the arraylist
         else{list.add(array[i]);}//if the number is unique, add it to the Arraylist
      }
      
      //we have a list of numbers that may or may not contain duplicates. however, the length of the numbers is not good. 
      //we want a number that has ten digits. lets check each number to see if it has ten digits.
      //if not, add the number of digits it needs to have ten digits, 
      //numbers that we make adjustments to get added into the second arraylist which will be merged with the 
      //original one.
      
      ArrayList<Long> list2 = new ArrayList<>();//make second arraylist for numbers who have to be adjusted
      
      String debug = ""; boolean inhere = false;int inherenum = 0; //keep a log of each number that gets adjusted
      
      for(int i = list.size()-1; i >= 0; i--) {//check each number in the list
         String numstr = list.get(i) + "";//convert to a string for positional access
         if(numstr.length() < 10) {//does the number contain less than 10 digits?
            int missing = 10 - numstr.length();//if so, how many more does it need to have 10
            inhere = true; inherenum++; //debug info that goes in the log..
            debug += "\nlist[" + i + "] , missing: " + missing + " before change: ";
            debug += numstr + " inherebool: " + inhere + " inherecount " + inherenum;
            
            list.remove(i);//if the number was adjusted, remove it from our original list *****************
            
            for(int j = missing-1; j >= 0; j--) {//add the number of digits the number needs (string concatination)
               String onerand = ((int)(1+Math.random()*10)) + "";//make rand int and convert to string
               numstr = onerand + numstr;//concat with needy number
            }
            debug += " post change: " + numstr + "\n"; pw2.print(debug);//debug records the change
            list2.add(Long.parseLong(numstr.substring(0, numstr.length())));//add the parsed string number into our second list
         }
      }
      pw2.close();
      for(Long i : list2) {
         list.add(list2.get(list2.indexOf(i)));//merge list of adjusted numbers with original numbers
      }
      int cool = 0;//more debugging incase index out of bounds
      try {
         for(int i = list.size()-1; i > 0; i--) {
            if(i == 0) {continue;}
            if(list.get(i).compareTo(list.get(i)-1) == 0) {
               list.remove(list.indexOf(i)); 
               cool = i;
            }
         }
      //if exception thrown, display why it was thrown
      } catch(ArrayIndexOutOfBoundsException e) { System.out.print("Oops: AL.len= " + list.size() + " Bad indx: " + cool);}
      
      
      
      
      
      
      //DETERMINE COUNTRY AND WRITE TO FILE
      
      String country = "";
      for(Long i : list) {
         //Where are these indexes used for? -KD
         //they work with an array of 110 names which get printed beside the numbers - Joanne
         int index = (int)(Math.random()*140);//if there is an exception, change this to 109
         //From what I understand, casey selects a random case and assigns the country -KD
         //yes. -Joanne
         int casey = (int)(Math.random()*9);
         switch(casey) {
            case 0: 
               country = "India";
               pw.println(country + " 91" + list.get(list.indexOf(i)) + " " + names[index]);
               break;
            case 1: 
               country = "Australia";
               pw.println(country + " 61" + list.get(list.indexOf(i)) + " " + names[index]);
               break;
            case 2:
               country = "Canada";
               pw.println(country + " 1" + list.get(list.indexOf(i)) + " " + names[index]);
               break;
            case 3: 
               country = "Mexico";
               pw.println(country + " 52" + list.get(list.indexOf(i)) + " " + names[index]);
               break;
            case 4: 
               country = "USA";
               pw.println(country + " 1" + list.get(list.indexOf(i)) + " " + names[index]);
               break;
            case 5:
               country = "Germany";
               pw.println(country + " 49" + list.get(list.indexOf(i)) + " " + names[index]);
               break;
            case 6:
               country = "England";
               pw.println(country + " 44" + list.get(list.indexOf(i)) + " " + names[index]);
               break;
            case 7:
               country = "Japan";
               pw.println(country + " 81" + list.get(list.indexOf(i)) + " " + names[index]);
               break;
            case 8:
               country = "Brazil";
               pw.println(country + " 55" + list.get(list.indexOf(i)) + " " + names[index]);
               break;
         }
      }
      
      //final check for repeats, no removal, just check.
      boolean repeats = false;
      for(Long i : list) {
         if(list.indexOf(i) == 0) {continue;}
         if(list.get(list.indexOf(i)).compareTo(list.get(list.indexOf(i)-1)) == 0 ) {
            repeats = true;
         }
      }
      pw.print("Repeats? " + repeats);
      pw.close();
   }
}


//so far, I haven't seen any duplicates, but please check for them. although it checks twice for duplicates,
//it always skips over the first element
//also, it uses compareTo to check for equality. maybe another duplicate check using some other comparison could be performed.
//for some reason, the log file seems to have copied entries; not really sure why at this point.
