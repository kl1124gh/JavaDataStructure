//Jiaqi Li
/**
 * Java Code for Lab 4
 */


public class OrderedPair<T> implements Pairable {

  private T first, second;  // Data: the ordered pair is (first, second)

  /* Member functions */

  public OrderedPair(T item1, T item2)  { // Fill in the required code and comment
  first = item1;
  second = item2;
  }
  public T getFirst(){
    return first; // Replace this line and fill in the required code and comment
  }
  public T getSecond(){
    return second; // Replace this line and fill in the required code and comment
  }
  public void swap(){ // Fill in the required code and comment
    T temp;

    temp = first;
    first = second;
    second = temp;
  }

  public static void main (String [] argv){
      {
      System.out.println("Part A:");
      for(int row = 0; row <= 9; row ++){ //first item

          for (int col = 0; col <= 9; col ++){ //second item
            OrderedPair<Integer> pairTriangle = new OrderedPair<Integer>(row,col);

            System.out.print("["+ pairTriangle.getFirst() + "," + pairTriangle.getSecond() + "]");
            }
          System.out.println();
        }


        } //end of part A
        System.out.println();
        System.out.println("Part B:");
      {
      for(int row = 0; row <= 9; row ++){ //first item

          for (int col = 0; col <= 9; col ++){ //second item
            OrderedPair<Integer> pairTriangle = new OrderedPair<Integer>(row,col);
            if (col<row){
                System.out.print("     ");
            }

            else{
                System.out.print("["+ pairTriangle.getFirst() + "," + pairTriangle.getSecond() + "]");
            }
          }

          System.out.println();
        }
        } //end of part B
        System.out.println();
        System.out.println("Part C:");
      {
      for(int row = 0; row <= 9; row ++){ //first item

          for (int col = 0; col <= 9; col ++){ //second item
            OrderedPair<Integer> pairTriangle = new OrderedPair<Integer>(row,col);
            if (col>row){
                System.out.print("     ");
            }

            else{
                System.out.print("["+ pairTriangle.getFirst() + "," + pairTriangle.getSecond() + "]");
            }
          }

          System.out.println();
        }
        }//end of Part C


    // In order to get credit, you must use the OrderedPair generic class to
    // create ordered pairs

  } // end of main
 } // end OrderedPair class

/*Output
Part A:
[0,0][0,1][0,2][0,3][0,4][0,5][0,6][0,7][0,8][0,9]
[1,0][1,1][1,2][1,3][1,4][1,5][1,6][1,7][1,8][1,9]
[2,0][2,1][2,2][2,3][2,4][2,5][2,6][2,7][2,8][2,9]
[3,0][3,1][3,2][3,3][3,4][3,5][3,6][3,7][3,8][3,9]
[4,0][4,1][4,2][4,3][4,4][4,5][4,6][4,7][4,8][4,9]
[5,0][5,1][5,2][5,3][5,4][5,5][5,6][5,7][5,8][5,9]
[6,0][6,1][6,2][6,3][6,4][6,5][6,6][6,7][6,8][6,9]
[7,0][7,1][7,2][7,3][7,4][7,5][7,6][7,7][7,8][7,9]
[8,0][8,1][8,2][8,3][8,4][8,5][8,6][8,7][8,8][8,9]
[9,0][9,1][9,2][9,3][9,4][9,5][9,6][9,7][9,8][9,9]

Part B:
[0,0][0,1][0,2][0,3][0,4][0,5][0,6][0,7][0,8][0,9]
     [1,1][1,2][1,3][1,4][1,5][1,6][1,7][1,8][1,9]
          [2,2][2,3][2,4][2,5][2,6][2,7][2,8][2,9]
               [3,3][3,4][3,5][3,6][3,7][3,8][3,9]
                    [4,4][4,5][4,6][4,7][4,8][4,9]
                         [5,5][5,6][5,7][5,8][5,9]
                              [6,6][6,7][6,8][6,9]
                                   [7,7][7,8][7,9]
                                        [8,8][8,9]
                                             [9,9]

Part C:
[0,0]
[1,0][1,1]
[2,0][2,1][2,2]
[3,0][3,1][3,2][3,3]
[4,0][4,1][4,2][4,3][4,4]
[5,0][5,1][5,2][5,3][5,4][5,5]
[6,0][6,1][6,2][6,3][6,4][6,5][6,6]
[7,0][7,1][7,2][7,3][7,4][7,5][7,6][7,7]
[8,0][8,1][8,2][8,3][8,4][8,5][8,6][8,7][8,8]
[9,0][9,1][9,2][9,3][9,4][9,5][9,6][9,7][9,8][9,9]
*/
