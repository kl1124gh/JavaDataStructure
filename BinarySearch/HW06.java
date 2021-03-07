/***** Homework 6 *****/
/* Last Name:  Li
 * First Name: Jiaqi
 * Section:  M004      (MOO1 / M004)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 
import java.util.concurrent.ThreadLocalRandom; // for getRandomInt
public class HW06 {
    
  public static void main(String[] args) { 
    // ********************************************************************************
    // Load the zip code data  to myData (a doubly linked list of data pairs)
    // DO NOT MODIFY THE CODE IN THIS BLOCK
    // ********************************************************************************
        DLList<Pair<Integer,String>> myData = new DLList<Pair<Integer,String>>();
        String row;
         try {
            //Reading data from  CSV File 
            BufferedReader csvReader = new BufferedReader(new FileReader("Hash.csv"));            
            while ((row = csvReader.readLine()) != null) {
              Pair<Integer,String> item = new Pair<Integer,String>();
              String[] data = row.split(",");
              item.setX(Integer.valueOf(data[1]));  
              item.setY(data[0]);
              myData.add(item);
            }           
            csvReader.close();
         }
         catch(IOException e) {
            e.printStackTrace();
         } 
         System.out.println(myData.size() + " Zip code data has been loaded ");
    // ********************************************************************************
    //  Data are Loaded to myData
    // ********************************************************************************
  
    // ********************************************************************************
    // Task 1: Verify your implementation of insert/treeSize/treeHeight operations
    // ********************************************************************************     
   
         
    // a. Create a BinSearchTree tree1 and initialize it to an empty tree
    // b. Randomly select 10 data item from myData and insert them to the tree1
    // c. After each insert operation, display the item inserted, treeSize and treeHeight 
    //    of tree1 in the form of a table 
         
    BinSearchTree tree1 = new BinSearchTree();
  
    for(int i = 0; i < 10; i++){
      int randNum = getRandomInt(0,myData.size()-1);
      Pair<Integer,String> currentPair = myData.get(randNum);

      tree1.insert(currentPair);
      
      System.out.println("Item inserted: "+ currentPair);
      System.out.println();
      System.out.println("Tree size: " + tree1.treeSize());
      System.out.println();
      System.out.println("Tree height: " + tree1.treeHeight());
                         
    }
    
         
         
         
         
    // **************************************************************************
    // Task 2: Study the average height of a binary search tree built by 
    //         inserting the data randomly to an empty tree
    // **************************************************************************     
         
          
    // a. Create a BinSearchTree tree2 and initialize it to an empty tree
    // b. Use the randPermute function to create a random permutation P
    // c. Insert the data item following the order in the random permutation P to 
    //    tree2
    // c. Compute the treeSize of tree2 and treeHieght of tree2
    // d. Repeat step a, step b and step c 50 times. Compute average treeHeight,
    //    using the values you collected in step c.
    // e. Display the average treeHeight to the screen 
   
     BinSearchTree tree2 = new BinSearchTree();
     int [] p = RandEx.randPermute(1613);
     for ( int i = 0; i < p.length;i++){
       
       tree2.insert(myData.get(p[i]));
     }
     BinSearchTree [] trees = new BinSearchTree[50];
     
       long treeSize = 0;
       long treeHeight = 0;
       long totalHeight = 0;
       long totalSize = 0;
       long aveHeight = 0;
         
     
  for( int j = 0; j < trees.length;j++) {
   p = RandEx.randPermute(1613);
   trees[j] = new BinSearchTree();
   
   for(int k = 0; k < p.length;k++) {
   trees[j].insert(myData.get(p[k])); 
   }//end of for loop\
   
   totalSize+= trees[j].treeSize();
   totalHeight += trees[j].treeHeight();
   
   
   
   
  }
  aveHeight = totalHeight/ 50;
  
     System.out.println("The average tree height is " + aveHeight);
    // **************************************************************************
    // Task 3: Testing the delete operation
    //            
    // **************************************************************************     
         
    // a. Create a BinSearchTree tree3 and initialize it to an empty tree
    // b. Insert the data in myData, one by one, to tree3
    // c. Display the size and height of tree3
    // d. Randomly select 100 data items from myData
    // e. Delete the 100 data items selected from tree3
    // f. Display the size and height of tree3 
    BinSearchTree tree3 = new BinSearchTree();
    Iterator <Pair<Integer,String>> iter1 = myData.iterator();
    while(iter1.hasNext()){
      Pair<Integer,String> myPair = iter1.next();
      tree3.insert(myPair);
    }
    for ( int i = 0; i< 100;i++){
      int randNum = getRandomInt(0,myData.size()-1);
      Pair<Integer, String> currentPair = myData.get(randNum);
      BTNode<Pair<Integer,String>> nd = new BTNode<Pair<Integer,String>>(currentPair,null,null);
      tree3.delete(nd);
    }
    
    System.out.println("The size of tree3 is " + tree3.treeSize());
    System.out.println("The height of tree3 is " + tree3.treeHeight());
    
    
    
     


 // **************************************************************************
    // Task 4: Retreive data from queries
    //              
    // **************************************************************************     
         
    // a. Divide myData into two lists myData1 (the first 800 data) and 
    //    myData2 (the remaining data) 
    //           
    // b. Create a BinSearchTree tree4 by inserting all the data in myData1 to tree4
    // c. Randomly select 5 data from myData1, say their keys are:
    //    k1, k2, k3, k4, k5     
    // d. Randomly select 5 data from myData2, say their keys are:
    //    k6, k7, k8, k9, k10 
    // e. Apply the search function with the input k1, k2, .. , k10
    //    and display the results as a table to the screen.
    //    For example: a possible list may look like:
    //    
  DLList<Pair<Integer,String>> myData1 = new DLList<Pair<Integer,String>>();
  DLList<Pair<Integer,String>> myData2 = new DLList<Pair<Integer,String>>();
  for ( int i1 = 0; i1 < 800; i1++) {
     Pair<Integer,String> curPair = myData.get(i1);
     myData1.add(curPair);
     }
  for ( int j = 800; j < myData.size();j++) {
     Pair<Integer,String> curPair1 = myData.get(j);
     myData2.add(curPair1);
     }
  BinSearchTree tree4 = new BinSearchTree();
  Iterator<Pair<Integer,String>> iter2 = myData1.iterator();
  while(iter2.hasNext()){
    Pair<Integer, String> curPair2 = iter2.next();
    
    tree4.insert(curPair2);
  
  }
  DLList<Pair<Integer,String>> keyData = new DLList<Pair<Integer,String>>();
  for (int i = 0; i < 5; i++){
    int randNum = getRandomInt(0,myData1.size()-1);
    Pair<Integer,String> curPair3 = myData1.get(randNum);
    keyData.add(curPair3);
  }
  
  DLList<Pair<Integer,String>> keyData1 = new DLList<Pair<Integer,String>>();
  for (int k = 0; k < 5; k++){
    int randNum1 = getRandomInt(0,myData2.size()-1);
    Pair<Integer,String> curPair4 = myData2.get(randNum1);
    
    keyData1.add(curPair4);
  }
  
  System.out.println("-----------------------------------------------");
  System.out.println("Key                                      Value");
  System.out.println("-----------------------------------------------");
  Iterator<Pair<Integer,String>> iter3 = keyData.iterator();
  while(iter3.hasNext()){
    Pair<Integer,String> curPair5 = iter3.next();
    System.out.print(curPair5.getY());
    if(tree4.search(curPair5) != null) {
      System.out.println("      " + tree4.search(curPair5).getData());
    }
    else {
      System.out.println("      Not found");
    }
    
  }
  
  Iterator<Pair<Integer,String>> iter4 = keyData1.iterator();
  while(iter4.hasNext()){
    Pair<Integer,String> curPair6 = iter4.next();
    System.out.print(curPair6.getY());
    if(tree4.search(curPair6) != null) {
  System.out.println("      " + tree4.search(curPair6).getData());
    }
     else {
  System.out.println("      Not found");
     }
  }
  
         
  System.out.println("-----------------------------------------------");
    //    -------------------------
    //    key                 value
    //    ------------------------- 
    //    .....               .....
    //    .....               .....
    //    .....               .....
    //    .....               .....
    //    .....               ..... 
    //    .....           Not found
    //    .....           Not found
    //    .....           Not found
    //    .....           Not found
    //    .....           Not found
    //    -------------------------
    
  
         
    // **************************************************************************
    // Task 5: Range queries
    //              
    // **************************************************************************     
    
    // a. Create a BinSearchTree tree5 and initialize it to an empty tree
    // b. Insert the data in myData, one by one, to tree5
    // c. Display the size and height of tree5
         
    // d. use the function rangeSearch (you developed in this file) to display the 
    //    following results from range search    
         
       // rangeSearch(tree5,1,10000);
       // rangeSearch(tree5,14801,14810);
       // rangeSearch(tree5,11000,11050);
  BinSearchTree tree5 = new BinSearchTree();
  
  for(int i = 0;i< myData.size();i++) {
   tree5.insert(myData.get(i));
  }
  System.out.println("The height of tree 5 is "+tree5.treeHeight());
  System.out.println("The size of tree 5 is " + tree5.treeSize());
  rangeSearch(tree5,1,10000);
  rangeSearch(tree5,14801,14810);
  rangeSearch(tree5,11000,11050);
  } // end of main function
      
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s   
  // needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomInt
  
  // rangeSearch will take aTree, a and b (0 <= a <= b) as input
  // print the zipcode data (as tuples) where the zipcode is in the range [a,b]
  // For example,  rangeSearch(tree5,10000,10500) should print
  //
  // (10001, NEW YORK)
  // (10301, STATEN ISLAND)
  // (10451, BRONX)
  //  
  // to the screen
  
  public static void rangeSearch(BinSearchTree aTree,Integer a, Integer b){
    // requires 0 <= a <= b
    aTree.rangeSearch(a, b);
    
  }

// You may add any functions here to carry out the tasks above

  
  
  
}// end of HW06 class