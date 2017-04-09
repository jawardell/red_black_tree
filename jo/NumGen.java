import java.util.*;
import java.io.*;

public class NumGen {
   public static void main(String[] args) throws FileNotFoundException {
      File file = new File("rands.txt");
      File file2 = new File("log.txt");
      long[] array = new long[1000];
      PrintWriter pw = new PrintWriter(file);
      PrintWriter pw2 = new PrintWriter(file2);
      for(int i = 0; i < 1000; i++) {
         int rand = (int)((0000000000) + Math.random()*Integer.MAX_VALUE);
         long randy = (long)rand;
         array[i] = randy;
      }
      ArrayList<Long> list = new ArrayList<>();
      for(int i = 0; i < 1000; i++) {
         if(i == 0) {continue;}
         if(array[i-1] == array[i]) {continue;}
         else{list.add(array[i]);}
      }
      ArrayList<Long> list2 = new ArrayList<>();
      String debug = "";
      boolean inhere = false;
      int inherenum = 0;
      for(Long i : list) {
         String numstr = list.get(list.indexOf(i)) + "";
         if(numstr.length() < 10) {
            int missing = 10 - numstr.length();
            inhere = true; inherenum++; debug += "\nlist[" + list.indexOf(i) + "] , missing: " + missing + " before change: " + numstr + " ";
            for(int j = missing-1; j >= 0; j--) {
               String onerand = ((int)(Math.random()*10)) + "";
               numstr = onerand + numstr;
               
            }
            debug += "post change: " + numstr + "\n";
            pw2.print(debug);
            list2.add(Long.parseLong(numstr.substring(0, numstr.length())));
         }
      }
      pw2.close();
      
      for(Long i : list2) {
         list.add(list2.get(list2.indexOf(i)));
      }
      int cool = 0;
      try {
      for(int i = list.size()-1; i > 0; i--) {
         if(i == 0) {continue;}
         if(list.get(i).compareTo(list.get(i)-1) == 0) {
            
               list.remove(list.indexOf(i)); 
               cool = i;
         }
      }
      } catch(ArrayIndexOutOfBoundsException e) { System.out.print("Oops: AL.len=" + list.size() + "Bad indx: " + cool);}
      String country = "";
      for(Long i : list) {
         int casey = (int)(Math.random()*6);
         switch(casey) {
            case 0: 
               country = "India";
               pw.println("91" + list.get(list.indexOf(i)) + " " + country);
               break;
            case 1: 
               country = "Australia";
               pw.println("61" + list.get(list.indexOf(i)) + " " + country);
               break;
            case 2:
               country = "Canada";
               pw.println("1" + list.get(list.indexOf(i)) + " " + country);
               break;
            case 3: 
               country = "Mexico";
               pw.println("52" + list.get(list.indexOf(i)) + " " + country);
               break;
            case 4: 
               country = "USA";
               pw.println("1" + list.get(list.indexOf(i)) + " " + country);
               break;

         
         }
         
      }
      
      boolean repeats = false;
      for(Long i : list) {
         if(list.indexOf(i) == 0) {continue;}
         if(list.get(list.indexOf(i)).compareTo(list.get(list.indexOf(i)-1)) == 0 ) {
            repeats = true;
         }
      }
      pw.println("Repeats? " + (repeats + ""));
      pw.close();
   
   }
}