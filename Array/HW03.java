package hw03;
import java.util.Scanner;
/**
 * Name: Li, Jiaqi       // Format: Lastname, Firstname 
 * Section:  M004   // Enter either M001/M004 
 */
 
import java.util.concurrent.ThreadLocalRandom;
public class HW03 {
  
public enum Dir { // an enum class which represents the four directions
    UP, DOWN, LEFT, RIGHT 
  }

  
 public static void main(String[] args){
    task1();
    task2();
    task3();
  }
    
  // generate random integers with [r.s] (inclusive)
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s 
    // needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomIndex

// UNLESS OTHERWISE STATED, IN THIS HOMEWORK, you are expected to 
// use the displayExcept method appropriately when displaying your puzzle
// display all IntStack objects as a stack in the order where the top of 
// the stack should be printed first, and so on ...
 
  // Task 1:
  // 1.1 complete the function generatePuzzle

  
  public static void generatePuzzle
    (GridWorld init, GridWorld aPuzzle, int k, IntStack moves, IntStack sol, int blank) {
	  //aPuzzle = init;
	  int brow = 0;
	  int bcol = 0;
	  for ( int i = 0; i < 4; i++) {
		  for ( int j = 0; j < 4;j++) {
			  if (init.getVal(i, j)==blank) {
				  brow = i;
				  bcol = j;
			  }
		  }
	  }
	  
	 // k = 12;
	  for (int i = 0; i < k; i++) {
		  int d = getRandomInt(0,3); 
		  // if d = 0,(up), check if i can move up without going out of the grid
		  if(d==0) {
			  if(brow-1>=0) {
				 int temp1 = aPuzzle.getVal(brow-1,bcol);
				 aPuzzle.setVal(temp1, brow, bcol);
				 aPuzzle.setVal(blank, brow-1, bcol);
				 brow-=1;
				 if (!moves.isEmpty()) {
					 if(moves.peek()==1) {
					 moves.pop();
				 }
				 
				 else {
					 moves.push(d);
				 }
 
			  }
		  
			  else {
				  moves.push(d);
			  }
			  }
		  else if(d == 1) {
			  if(brow+1 < 4) {
				  int temp2 = aPuzzle.getVal(brow+1, bcol);
				  aPuzzle.setVal(temp2,brow,bcol);
				  aPuzzle.setVal(blank, brow+1, bcol);
				  brow+=1;
				  if(!moves.isEmpty()) {
					  if(moves.peek() == 0) {
						  moves.pop(); 
					  }
					  else {
						  moves.push(d);
					  }
				  }
					  
				  }
				  else {
					  moves.push(d);
				  }
			  
		  }
		  else if(d == 2) {
				if (bcol-1 >=0) {
					int temp3 = aPuzzle.getVal(brow, bcol-1);
					aPuzzle.setVal(temp3, brow, bcol);
					aPuzzle.setVal(blank, brow, bcol-1);
					bcol-=1;
					if(!moves.isEmpty()) {
						if(moves.peek() == 3) {
							moves.pop();
						}
					}
					else {
						moves.push(d);
					}
				}
				else {
					moves.push(d);
				}
		  }
			  
		  else if(d == 3) {
			  if ( bcol+1 < 4) {
				  int temp4 = aPuzzle.getVal(brow, bcol+1);
				  aPuzzle.setVal(temp4, brow, bcol);
				  aPuzzle.setVal(blank, brow, bcol+1);
				  bcol+=1;
				  if(!moves.isEmpty()) {
					  if(moves.peek() == 2) {
						  moves.pop();
					  }
				  }

				  else {
					  moves.push(d);
				  }
			  }
			  else {
				  moves.push(d);
			  }
		  }
		  
		  } 
	  //3
	  // reverse the moves stack to form the move stack
	  
/*	  int [] tempArr = new int [moves.size()];
	  for ( int a = 0; a < tempArr.length;a++) {
		  int val = moves.pop();
		  tempArr[a]= val;
	  }
	  
	  for ( int b = tempArr.length-1;b>0;b--) {
		  moves.push(tempArr[b]);
	  */
	 



	//5. prepare the solution to aPuzzle
	int solution [] = new int [moves.size()];
	for (int k1 = 0; k1 < solution.length;k1++) {
		int step = moves.pop();
		solution[k1] = step;
	}
	for (int j = 0; j < solution.length;j++) {
		moves.push(solution[j]);
		if(solution[solution.length-1-j] == 0) {
			sol.push(1);
		}
		else if(solution[solution.length-1-j] ==1) {
			sol.push(0);
		}
		else if(solution[solution.length-1-j] == 2) {
			sol.push(3);
		}
		else if(solution[solution.length-1-j] == 3) {
			sol.push(2);
		}
		
	}
	  
  }
  }
  
  // 1.2 Verify and assess the function generatePuzzle
  
  public static void task1 () { 
    System.out.println(" ************ Task 1 ************ ");
    // t1.   Test generatePuzzle
 // t1a.  create a GridWorld grid1a, where it represents the puzzle grid init in Figure 1 from
 //       our homework description
 // t1b.   use generatePuzzle and grid1a as the initial grid1a with k=30, generate a puzzle puzzle1a
 //       display puzzle1a, the moves and the sol stacks obtained. 
 
 // t2.    Conduct an computational experiment
 // t2a.    For k=51, ..., 100
 //       use grid1a and the function generatePuzzle to create puzzles
 // t2b.   Compute, among the 50 puzzles created, the one where the no of elements in the sol, as
 //       a stack, is the maximum among all 50 puzzles
 // t2c.   display the initial grid, the puzzle, the moves and the sol for that case.
    GridWorld grid1a = new GridWorld();
    GridWorld puzzle = new GridWorld();
    IntStack moves = new IntStack();
    IntStack sol = new IntStack();
    
    generatePuzzle(grid1a,puzzle,5,moves,sol,16);
    System.out.println("Initial grid");
    grid1a.displayExcept(16);
    System.out.println("Initial puzzle");
    puzzle.displayExcept(16);
    
    
    IntStack maxSol = null;
    IntStack maxMoves = null;
    GridWorld maxPuzzle = null;
    for ( int k = 51; k <= 100; k++) {
    		GridWorld grid1b = new GridWorld();
        GridWorld puzzle1 = new GridWorld();
        IntStack moves1 = new IntStack();
        IntStack sol1 = new IntStack();
        
    		generatePuzzle(grid1b,puzzle1,k,moves1,sol1,16);
    		
    		if(maxSol == null || sol1.size() > maxSol.size()) {
    			maxSol = sol1;
    			maxMoves = moves1;
    			maxPuzzle = puzzle1;
    		}
    		
    		
    }
    System.out.println("maxPuzzle");
    System.out.println("max steps = " + maxSol.size());
    maxPuzzle.displayExcept(16);
    maxSol.display();
    System.out.println("");
    maxMoves.display();
    
    
    
  }
  
 // Task 2:
 // 2.1 complete the function  extractSol and visualizeSol
  

 public static void extractSol(Dir[] moveSequence , IntStack sol)
 {
	 final int UP =0;
	 final int DOWN = 1;
	 final int LEFT = 2;
	 final int RIGHT = 3;
	 int [] solution = new int [sol.size()];
	 
	 for ( int i = 0; i< solution.length;i++) {
		 int val = sol.pop();
		 solution[i]=val;
		 if (solution[i] == 0) {
			 moveSequence[i] = Dir.UP;
		 }
		 else if(solution[i] == 1) {
			 moveSequence[i] = Dir.DOWN;
		 }
		 else if(solution[i] == 2) {
			 moveSequence[i] = Dir.LEFT;
		 }
		 else if(solution[i] == 3) {
			 moveSequence[i] = Dir.RIGHT;
		 }
		
	 }
	 
	 
	 
  // First, use the same definition from the Point class for the enum type Dir
  // define it in this homework file HW03.java
  // This function will translate a solution of the puzzle, sol, to an array
  // of directions, moveSequence, to describe the solution 
 }
  
    public static void visualizeSol(IntStack sol, GridWorld pz, int blank)
 {
    		
     // assuming sol is a solution for the fifteen puzzle pz, where blank is the integer
  // that represents the `blank` to the puzzle
        // this function will display the solution to screen stepwise.
        // for each step, it will display the current grid, and the next direction (type Dir)
        // the blank will move, and wait for the user to continue (or quit)
  // after all the steps are executed, the user can quit.
  // An example is given separately to show how to interact with the user. 

   // 2.2 Verify and assess the functions extractSol and visualizeSol
    	
    	//here 
    		int brow =0;
	  	int bcol = 0;
	  	
    		Scanner userInput = new Scanner(System.in);
        System.out.println("*********** 15 puzzle ***********");
        int input =-1;
        System.out.println(" Display the initial settings here ");
        while((input !=0) && sol.size()!=0) {
          System.out.println("Please enter 0 (to quit) or 1 (to continue)");
          input = userInput.nextInt();
          if (input == 1 && sol.size()>0) {
        	  System.out.println(" Display next step here");  
        	  	//Show the move being made
        	 
        	  	int d = sol.pop();
        	  	
        	  	for ( int r = 0; r< 4;r++) {
        	  		for ( int c = 0 ; c< 4;c++ ) {
        	  			if (pz.getVal(r,c)== blank){
        	  				brow = r;
        	  				bcol = c;
        	  			}
        	  		}
        	  	}
        	  	
        	  	if(d==0) {
      			  if(brow-1>=0) {
      				 int temp1 = pz.getVal(brow-1,bcol);
      				 pz.setVal(temp1, brow, bcol);
      				 pz.setVal(blank, brow-1, bcol);
      				 brow-=1;
      				 
      			  }
      		  }
        	  	
      		  else if(d == 1) {
      			  if(brow+1 < 4) {
      				  int temp2 = pz.getVal(brow+1, bcol);
      				  pz.setVal(temp2,brow,bcol);
      				  pz.setVal(blank, brow+1, bcol);
      				  brow+=1;

      			  }
      		  }
      		  else if(d == 2) {
      				if (bcol-1 >=0) {
      					int temp3 = pz.getVal(brow, bcol-1);
      					pz.setVal(temp3, brow, bcol);
      					pz.setVal(blank, brow, bcol-1);
      					bcol-=1;
      				
      				}
      		  }
        	  	
      		  else if(d == 3) {
      			  if ( bcol+1 < 4) {
      				  int temp4 = pz.getVal(brow, bcol+1);
      				  pz.setVal(temp4, brow, bcol);
      				  pz.setVal(blank, brow, bcol+1);
      				  bcol+=1;		
      			  }
      		  }
    	  
        	  pz.displayExcept(16);
          }
            
          else if (input !=0) {
            System.out.println("Invalid choice");
            break;
          } // end if-elseif
          
        // end while
        }
        System.out.println("*********** BYE ***********");
       // userInput.close();
        
 }
    
     // assuming sol is a solution for the fifteen puzzle pz, where blank is the integer
  // that represents the `blank` to the puzzle
        // this function will display the solution to screen stepwise.
        // for each step, it will display the current grid, and the next direction (type Dir)
        // the blank will move, and wait for the user to continue (or quit)
  // after all the steps are executed, the user can quit.
  // An example is given separately to show how to interact with the user. 

   // 2.2 Verify and assess the functions extractSol and visualizeSol

   public static void task2 () {
     System.out.println(" ************ Task 2 ************ ");
     // t2. 
     GridWorld grid1A = new GridWorld();
     IntStack s1 = new IntStack();
     IntStack s2 = new IntStack();
     IntStack s3 = new IntStack();
     Dir [] moveSequences1 = new Dir[s1.getCapacity()];
     Dir [] moveSequences2 = new Dir[s2.getCapacity()];
     Dir [] moveSequences3 = new Dir[s3.getCapacity()];
     s1.push(3);
     s1.push(2);
     s1.push(1);
     s1.push(0);
     extractSol(moveSequences1 , s1);
     //print out all the values in the dir array
     for(int i = 0; i < 4;i++) {
    	 	if(i!= 3) {
    	 		System.out.print(moveSequences1[i]+", ");
    	 	}
    	 	else {
     	 		System.out.print(moveSequences1[i]+"]");
     	 	}
     }
     s2.push(1);
     s2.push(2);
     s2.push(3);
     s2.push(0);
     extractSol(moveSequences2 , s2);
     for(int i = 0; i < 4;i++) {
 	 	if(i!= 3) {
 	 		System.out.print(moveSequences2[i]+", ");
 	 	}
 	 	else {
 	 		System.out.print(moveSequences2[i]+"]");
 	 	}
  }
     s3.push(2);
     s3.push(1);
     s3.push(1);
     s3.push(3);

     extractSol(moveSequences3 , s3);
     for(int i = 0; i < 4;i++) {
 	 	if(i!= 3) {
 	 		System.out.print(moveSequences3[i]+", ");
 	 	}
 	 	else {
 	 		System.out.print(moveSequences3[i]+"]");
 	 	}
  }
     System.out.println();
     
     // t2a: 
     // create three InStacks
     // s1 = 0 <- top  s2 = 0 <- top    s3 = 3 <-top 
     //      1              3                1
     //      2              2                1
     //      3              1                2         
     // write code to display the directions arrays obtained from extractSol
     // for s1, the moveSequence should be [UP, DOWN, LEFT, RIGHT] and your
     // test should display them in this format
     int k = getRandomInt(30,50);
     //GridWorld grid1A = new GridWorld();
     GridWorld pz = new GridWorld();
     IntStack pzMoves = new IntStack();
     IntStack pzSol = new IntStack();
     
	 generatePuzzle(grid1A,pz,k,pzMoves,pzSol,16);
     // t2b: 
     // generate a number k in the range [30, 50] randomly, using the getRandomInt function.
     // use generatePuzzle with the k given to create a puzzle pz from init (init ref. to 
     // Figure 1 in HW) with the blank specified correctly
     // 
     // t2c: 
     // use visualizeSol to display the solution obtained in steps.
	 visualizeSol(pzSol,pz,16);
  }

  
   // Task 3: 
   // 3.1 complete the following function:manhattanD according to the specification stated
   // in the homework description. You may assume that the init and aPuzzle is consistent.
   // That is, both grid uses the same collection of distinct integers and use the same number
   // to represent a blank
   
   public static int manhattanD (GridWorld init, GridWorld aPuzzle, int blank){
     //return -1;
     int [][] initialLocation = new int [init.r*init.c][2];
     int [][] aPuzzleLocation = new int [aPuzzle.r*aPuzzle.c][2];
     int manhattanD = 0;
     for (int k = 0; k < init.r*init.c;k++) {
    	 	for (int j = 0; j<init.r;j++) {
    	 		for(int i = 0; i<init.c;i++) {
    	 			if(init.grid[i][j] == (k+1)){
    	 				initialLocation[k][0] = i;
    	 				initialLocation[k][1] = j;
    	 			}
    	 		}
    	 	}
     }
     for (int k = 0; k < init.r*init.c;k++) {
 	 	for (int j = 0; j<init.r;j++) {
 	 		for(int i = 0; i<init.c;i++) {
 	 			if(aPuzzle.grid[i][j] == (k+1)){
 	 				aPuzzleLocation[k][0] = i;
 	 				aPuzzleLocation[k][1] = j;
 	 			}
 	 		}
 	 	}
  }
     for (int i = 0; i < init.r*init.c;i++) {
    	 	if(!(i+1 == blank)) {
    	 		manhattanD += (Math.abs(initialLocation[i][0] -aPuzzleLocation[i][0]) + Math.abs(initialLocation[i][1]-aPuzzleLocation[i][1]));
    	 	}
    	 	
     }
     return manhattanD;
     // comment out the above line and write your code 
   }
   
   // 3.2 Verify and assess the function manhattanD
   
  public static void task3 () {
   System.out.println(" ************ Task 3 ************ ");
   // t3
   GridWorld init = new GridWorld();
   GridWorld aPuzzle = new GridWorld();
   GridWorld grid3A = new GridWorld();
   GridWorld grid3B = new GridWorld();
   GridWorld grid3C = new GridWorld();
   GridWorld grid3D = new GridWorld();
   GridWorld grid3E = new GridWorld();
   IntStack moves = new IntStack();
   IntStack sol = new IntStack();
   int[][] grid1 = {{2,1,5,9},{8,6,11,13},{3,10,7,16},{4,15,14,12}};	
   int[][] grid2 = {{9,10,15,4},{5,1,6,13},{3,7,12,16},{2,11,14,8}};	
   int[][] grid3 = {{2,1,14,9},{8,5,15,12},{3,7,6,13},{16,10,4,11}};	
   int[][] grid4 = {{13,2,7,9},{16,8,6,11},{1,4,14,5},{12,3,10,15}};	
   int[][] grid5 = {{5,6,16,9},{1,7,15,14},{2,4,10,12},{3,8,13,11}};
   generatePuzzle(init,aPuzzle,30,moves,sol,16);
   grid3A.grid = grid1;
   System.out.println("\ngrid3A");
   grid3A.displayExcept(16);
   System.out.println("Manhattan distance of grid3A: " + manhattanD(init,grid3A,16));
   
   grid3B.grid = grid2;
   System.out.println("\ngrid3A");
   grid3A.displayExcept(16);
   System.out.println("Manhattan distance of grid3B: " + manhattanD(init,grid3B,16));
   
   grid3C.grid = grid3;
   System.out.println("\ngrid3A");
   grid3A.displayExcept(16);
   System.out.println("Manhattan distance of grid3C: " + manhattanD(init,grid3C,16));
   
   grid3D.grid = grid4;
   System.out.println("\ngrid3A");
   grid3A.displayExcept(16);
   System.out.println("Manhattan distance of grid3D: " + manhattanD(init,grid3D,16));
   
   grid3E.grid = grid5;
   System.out.println("\ngrid3A");
   grid3E.displayExcept(16);
   System.out.println("Manhattan distance of grid3E: " + manhattanD(init,grid3E,16));
   
   // t3a: use the generatePuzzle function to obtain init and aPuzzle
   //      compute and display the manhattan distance between init and aPuzzle
   
   // t3b. create five GridWorld objects: grid3a, grid3b, grid3c, grid3d and grid3e (shown
   //      in a separate document task3eg).
   //      compute and display the manhattan distance between init and each of these grids
    
  }
}