package hw03;

/**
 * For HW03
 * Name:  Li, Jiaqi      // Format: Lastname, Firstname 
 * Section:   M004   // Enter either M001/M004 
 */

// Instructions: follow the comments stated, fill in your code
// for each of the functions declared
import java.util.concurrent.ThreadLocalRandom; 
public class GridWorld {
  // data
  
  int [][] grid; // a "r by c" grid will all entries of type int
  int r; // no. of rows 
  int c; // no. of cols
  
  final static int ROW = 4;  // Default row size 
  final static int COL = 4;  // Default col size

  // constructors 
  // 1. default constructor: construct a 4x4 Grid of int
  //    the entry at row i and col j is  4*i+j+1 
  public GridWorld() { 
	  r=ROW;
	  c=COL;
	  grid = new int[r][c];
	  for (int i=0;i<r;i++){
	    for(int j=0;j<c;j++){
	      grid[i][j]= (4*i+j+1);
	      }
	  }
  }
  
  // 2. parameterized constructor: construct a row x col
  //    Grid of int where all the entries are 0
  public GridWorld(int row, int col){
	  for ( r = 0; r< row; r++) {
		  for(c = 0; c< row;c++) {
			  grid[r][c] = 0;
		  }
	  }
  }

    
  // getters
  // 1. return the value at grid[r1][c1]
  
  public int getVal(int r1, int c1){
    // comment out the line below and add your code
	  return grid[r1][c1];
  //return 0;
  }
  
  // setters
  // 1. set the value at grid[r2,c2] to val
  public void setVal(int val, int r2, int c2) {
	  grid[r2][c2] = val;
  }
 
  
  // display functions
  // 1. display
  // display the grid neatly to the screen with all
  // the values stored in the 2D array shown.
  // eg. If you display the object after you have
  // created it via the default constructor, it will
  // look like
  
  /* 
   * -----------------------------
     |    1 |    2 |    3 |    4 |
     -----------------------------
     |    5 |    6 |    7 |    8 |
     -----------------------------
     |    9 |   10 |   11 |   12 |
     -----------------------------
     |   13 |   14 |   15 |   16 |
     -----------------------------
  */
 public void display() {   
	 for (int i=0;i<r;++i){System.out.print("--------");
	    }
	    for (int i=0;i<r;i++){
	      System.out.println(" ");
	      for (int j=0;j<c;j++){
	        System.out.printf("|%4d ",grid[i][j]);
	        }
	    System.out.print("|");
	    }
	    System.out.print(" ");
	    System.out.println("");
	    for (int i=0;i<r;++i){System.out.println("--------");}
	       
 } 
  
  // 2. displayExcept(int i)
  // This function will print the grid neatly to the screen. 
  // All the entries,except the entry i,will be displayed as itself.
  // If the entry is i,it will display aâ€˜blankâ€™instead. 
 
 public void displayExcept(int i) {   
	 for (int k=0;k<r;++k){System.out.print("--------");
	    }
	    for (int j=0;j<r;j++){
	      System.out.println(" ");
	      for (int a =0;a <c;a++){
	        System.out.print("|");
	        if (grid[j][a]!=i){
	          System.out.printf("|%4d ",grid[j][a]);
	          }
	        else
	          System.out.print("|     ");
	      }
	      System.out.println(" ");
	      for (int b = 0; b<r;b++) {
	    	  System.out.print("--------");
	      }
	      
	    }
	  }  
  

 public static void main(String[] args) {
    task0();
 }   
 // generate random integers with [r.s] (inclusive)
 public static int getRandomInt(int r, int s){ // requires 0 <= r <= s 
    // needs to add the line import java.util.concurrent.ThreadLocalRandom;
 return ThreadLocalRandom.current().nextInt(r, s + 1);
 } // end getRandomInt

 public static void task0(){
 System.out.println(" ************ Task 0 ************ ");
    // 1a. create a GridWorld object grid1, where grid1 is:
 /* 
 * -----------------------------
     |    1 |    2 |    3 |    4 |
     -----------------------------
     |    5 |    6 |    7 |    8 |
     -----------------------------
     |    9 |   10 |   11 |   12 |
     -----------------------------
     |   13 |   14 |   15 |   16 |
     -----------------------------
 */
    // 1b. use the function getRandomInt to generate an int, say k
 //     where the range is between 1 to 16  
    // 1c. Execute grid1.displayExcept(k);
      
     // ADD your code here
 System.out.println("1a");
 GridWorld grid1 = new GridWorld();

 
 
System.out.println("2b");

 int k = getRandomInt(1,17);
 grid1.displayExcept(k);
 }
}
