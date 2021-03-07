/**
 * Name:  Jiaqi Li     
 * 
 */

import java.util.concurrent.ThreadLocalRandom; // required for getRandomInt
public class HW01 {
  
  public static void main(String[] args) { 
  testtask(1);
  testtask(2);
  testtask(3);
  testtask(4);
  testtask(5);
  }
  
  public static void testtask(int i){
  System.out.println("Testing Task "+i+"\n");
  switch (i) {
            case 1:  task1();
                     break;
            case 2:  task2();
                     break;
            case 3:  task3();
                     break;
            case 4:  task4();
                     break;
            case 5:  task5();
                     break;           
            default: System.out.println("Invalid task number");
                     break;   
  } // end switch
  }
  public static void task1() {
  // print a table of the recursively defined sequence Leo
    
 
  System.out.println("The leo number leo(0), ... , leo (9) are:");
  // Write code to print the required leo numbers in the form of
  // a table (see the homework description) in the space below.
  
  System.out.println("n" + "      " + "leo(n)");
  System.out.println("----------------");
  for ( int i =0; i<=9;i++){
    System.out.println(i+ "      " + leo(i));
  }
  
  }
  public static void task2() {
    // testing the function count 
    // Show the results of the tests below:
    // test 2.1: count 'a' ['s', 'y', 'r', 'a', 'c', 'u', 's', 'e']
    // test 2.2: count 'a' ['A',' ', 'O', 'R', 'A', 'N', 'G', 'E']
    // test 2.3: count 'a' empty array
    char [] a = {'s', 'y', 'r', 'a', 'c', 'u', 's', 'e'};
    char [] b = {'A',' ', 'O', 'R', 'A', 'N', 'G', 'E'};
    char [] c = new char[0];
    System.out.println(count ('a',a));
    System.out.println(count ('a',b));
    System.out.println(count ('a',c));

    
  }
  public static void task3() {
    // test permute(p,a)
    // Show the results of the tests below:
    // test 3.1: p = [0,4,3,2,1] ; a = [10,9,8,7,6]
    // test 3.2: p = [1,4,2,0,3,5] ; a = [7,6,10,8,5,9]
    // test 3.3: p = [9,8,7,6,5,4,3,2,1,0] ; a = [0,2,4,6,8,10,12,14,16,18]
    int p [] = new int []{0,4,3,2,1};
    int a [] = new int [] {10,9,8,7,6};
    permute (p,a,5);
    int p1 [] = new int[]{1,4,2,0,3,5};
    int a1 [] = new int[]{7,6,10,8,5,9};
    permute(p1,a1,6);
    int p2 [] = new int[] {9,8,7,6,5,4,3,2,1,0};
    int a2 [] = new int[] {0,2,4,6,8,10,12,14,16,18};
    permute (p2,a2,10);
    
    
  }
  public static void task4() {
    int a [] = new int []{1,2,3,4,5,6};
    shift(a,5);
    shift(a,-3);
    shift(a,3);
    // print the results of leftShift (r, a) 
    // test 4.1: r = 5,  a = [1,2,3,4,5,6]
    // test 4.2: r = -3, a = [1,2,3,4,5,6]
    // test 4.3: r = 3,  a = [1,2,3,4,5,6]   
  }
  public static void task5() {
    // print the results of shuffle (a, l)
    // where
    // test 5.1: a = [1,2,3,4,5] l=5
    // test 5.2: a = [1,2,3,4,5,6,7,8,9,10] l=10
    // test 5.3: a = [1,3,5,7,9,2,4,6,8,10],l=10 
    int [] a = new int[] {1,2,3,4,5};
    int [] a1 = new int[] {1,2,3,4,5,6,7,8,9,10};
    int [] a2 = new int[] {1,3,5,7,9,2,4,6,8,10};
    
    shuffle(a,5);
    shuffle(a1,10);
    shuffle(a2,10);
  }
//  // function(s) for task 1
  public static int leo(int n) {
    // comment out the following line and then add your own code
    
    if (n == 0 || n ==1){
      return 1;
    }
    else if ( n >= 2){
      return leo(n-1) + (leo(n-2)/2) + 1;
    }
    
    return leo(n);
    //return 0;   
  }
  
  // function(s) for task 2
  public static int count(char c, char[] a) {
    int counter = 0;
    for (int i = 0; i< a.length;i++){
      if (Character.toLowerCase(a[i])== c){
        counter++;
      }
    }
    return counter;   
  }
  
   //function(s) for task 3
  
  public static void permute(int[] p, int[] a, int len) {
    
    int b [] = new int [a.length];
    for ( int i = 0; i < a.length; i++){
      b[i] = a[p[i]];
    }
    System.out.print("[");
    for ( int i = 0; i < a.length; i++){
      System.out.print(b[i]);
      if ( i < b.length-1){
      System.out.print(", ");
      }
      
    }
    System.out.print("]");
    System.out.print("");
  }
    
   //function(s) for task 4
  
  public static void shift(int [] c, int k){
    
    for ( int i = 0; i < k; i++){
      int temp = c[0];
      for ( int x = 1; x < c.length; x++){
        c[x-1] = c[x];
      }
      c [c.length-1] = temp;
    }
    System.out.print("{");
    for ( int i = 0;i < c.length;i++){
      System.out.print(c[i]);
      if ( i < c.length-1){
      System.out.print(", ");
      }
    }
    System.out.print("}");
    
  }
  
  public static void shuffle (int[] a, int len) {
    
    for ( int i = 0; i < 1000; i++){
     int temp = a[0];
     int randomIndex = getRandomInt(1,a.length-1);
     a[0] = a[randomIndex];
     a[randomIndex] = temp;
    }
    
  }
  
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s 
  // needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomIndex
}