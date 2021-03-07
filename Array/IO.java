package hw03;

/**
 * Auto Generated Java Class.
 */
import java.util.Scanner;
public class IO {
  
  
  public static void main(String[] args) { 
    Scanner userInput = new Scanner(System.in);
    System.out.println("*********** 15 puzzle ***********");
    int input =-1;
    System.out.println(" Display the initial settings here ");
    while(input !=0) {
      System.out.println("Please enter 0 (to quit) or 1 (to continue)");
      input = userInput.nextInt();
      if (input == 1) {
         System.out.println(" Display next step here");   
        }
      else if (input !=0) {
        System.out.println("Invalid choice");
      } // end if-elseif
      
    } // end while
    System.out.println("*********** BYE ***********");
  }
}