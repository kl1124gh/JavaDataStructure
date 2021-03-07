/***** Homework 5 *****/
/* Last Name:  Li
 * First Name: Jiaqi
 * Section:  M004 (MOO1 / M004)
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*; 
import java.util.concurrent.ThreadLocalRandom; // for getRandomInt

//import HW5.HTable.HNode;
public class HW05 {
    
  public static void main(String[] args) { 
    // ********************************************************************************
    // Load the zip code data  to myData (a doubly linked list of data pairs)
    // DO NOT MODIFY THE CODE IN THIS BLOCK
    // ********************************************************************************
        DLList<Pair<String,Integer>> 
          myData = new DLList<Pair<String,Integer>>();
        String row;
         try {
            //Reading data from  CSV File 
            BufferedReader csvReader = new BufferedReader(new FileReader("Hash.csv"));            
            while ((row = csvReader.readLine()) != null) {
              Pair<String,Integer> item = new Pair<String,Integer>();
              String[] data = row.split(",");
              item.setX(data[0]);
              item.setY(Integer.valueOf(data[1]));  
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
  
    // **************************************************************************
    // Task 1: Verify your implementation of the dictionary operations
    // **************************************************************************     
         
    // a. Create a HTable h1 with table size 103 (a prime number) 
         HTable<String, Integer > h1 = new HTable(103);
    // b. Insert the data from myData, one by one, to h1
         // myData is of type DLList of a pair of string and integer
         //make sure inserting at the beginning of the list
         Iterator <Pair<String,Integer>> iter = myData.iterator();
         while(iter.hasNext()) {
           Pair<String,Integer> curPair = iter.next();
           h1.insert(curPair.getX(), curPair.getY());
         }
    // c. Display the table size of h1 and noOfItems of h1 to the screen
         System.out.println("The size of table h1 is " + h1.getTableSize());
         System.out.println("The number of items stored in h1 is " + h1.getNoOfItems());
    // d. Randomly select five distinct data from myData, say their keys are:
    //    k1, k2, k3, k4, k5
    //    delete the data with these keys from h1
    //    and then display the noOfItems of h1 to the screen 
         String [] myKeys  = new String [5];
         for(int i = 0; i < myKeys.length;i++) {
           int randNum = getRandomInt(0,myData.size()-1);
            Pair<String,Integer> currentPair = myData.get(randNum);
            myKeys[i] = currentPair.getX();
            h1.delete(myKeys[i]);
         }
         System.out.print("noOfItem of h1 is "+ h1.getNoOfItems());
    
         
         
    // **************************************************************************
    // Task 2: Load randomly chosen zip code data to a hash table and compute
    //         the maximum length among all the chains in the table 
    // **************************************************************************     
         
    // a. Create a HTable h2 with table size 311 (a prime number) 
         HTable<String, Integer > h2 = new HTable(311);
    // b. Insert the 500 data, selectly randomly, from myData to h2
         //Iterator <Pair<String,Integer>> iter2 = myData.iterator();
         for ( int i = 0; i < 500; i++ ) {
           int randNum2 = getRandomInt(0,myData.size()-1);
           Pair<String,Integer> currentPair1 = myData.get(randNum2);
           h2.insert(currentPair1.getX(),currentPair1.getY());
         }
         System.out.println("The size of table 2 is " + h2.getTableSize());
         System.out.println("noOfItem of table 2 is " + h2.getNoOfItems());
         
         
    // c. Display the table size of h2 and noOfItems of h2 to the screen
    // d. Compute the maximum length among all the chains in h2 and call it d
    //    and display d to the screen      
         int d = h2.maxChainLength();
         System.out.println("The maximun chain length of h2 is " + d);
     
    // **************************************************************************
    // Task 3: Compare the performance of hashing using hash tables of
    //         different sizes     
    // **************************************************************************     
         
    // a. Create a HTable h3 with table size 257 (a prime number) 
    //    and Create a HTable h4 with table size 256 (= 2^8)       
    // b. Insert the data in myData, one by one, to h3
    // c. Insert the data in myData, one by one, to h4
    // d. Compute the maximum length among all the chains in h3, call it d3
    //    and display d3 to the screen   
    // e. Compute the maximum length among all the chains in h4, call it d4
    //    and display d4 to the screen   
         HTable<String, Integer > h3 = new HTable(257);
         HTable<String, Integer > h4 = new HTable(256);
         Iterator <Pair<String,Integer>> iter3 = myData.iterator();
         
         while(iter3.hasNext()) {
           Pair<String,Integer> curPair1 = iter3.next();
           h3.insert(curPair1.getX(), curPair1.getY());
           h4.insert(curPair1.getX(), curPair1.getY());
         
         }
         int d3 = h3.maxChainLength();
         int d4 = h4.maxChainLength();
         System.out.println(d3);
         System.out.println(d4);
         

         
         
    // **************************************************************************
    // Task 4: Retreive data from queries
    //              
    // **************************************************************************     
         
    // a. Divide myData into two lists myData1 (the first 800 data) and 
    //    myData2 (the remaining data) 
             
    // b. Create a HTable h5 by inserting all the data in myData1 to h5
    // c. Randomly select 5 data from myData1, say their keys are:
    //    k1, k2, k3, k4, k5     
    // d. Randomly select 5 data from myData2, say their keys are:
    //    k6, k7, k8, k9, k10 
    // e. Apply the search function with the input k1, k2, .. , k10
    //    and display the results as a table to the screen.
    //    For example: a possible list may look like:
    //     
    //    -------------------------
    //    key                value
    //    ------------------------- 
    //    SHORTSVILLE         14548
    //    EDWARDS             13635
    //    HOLMES              12531
    //    EAST QUOGUE         11942
    //    CHESTERTOWN         12817
    //    HEMPSTEAD       Not found
    //    CANASERAGA      Not found
    //    MASSAPEQUA PARK Not found
    //    DELHI           Not found
    //    CAMBRIA HEIGHTS Not found
    //    ----------------------

         DLList<Pair<String,Integer>> myData1 = new DLList<Pair<String,Integer>>();
         DLList<Pair<String,Integer>> myData2 = new DLList<Pair<String,Integer>>();
         for ( int i = 0; i < 800; i++) {
           Pair<String,Integer> curPair = myData.get(i);
           myData1.addBefore(myData1.dummy,curPair);
         }
         for ( int j = 800; j < myData.size();j++) {
           Pair<String,Integer> curPair1 = myData.get(j);
           myData2.addBefore(myData2.dummy,curPair1);
         }
         
         
         HTable<String, Integer > h5 = new HTable(800);
         Iterator <Pair<String,Integer>> iter5 = myData1.iterator();
         while(iter5.hasNext()) {
           Pair<String,Integer> nd1 = iter5.next();
           h5.insert(nd1.getX(), nd1.getY());
        
      }
         String [] keyData2 = new String [5];
         for ( int i = 0; i < 5; i++ ) {
           int randNum3 = getRandomInt(0,myData1.size()-1);
           Pair<String,Integer> currentPair3 = myData1.get(randNum3);
           keyData2[i] = currentPair3.getX();
      }
         
         String [] keyData3 = new String [5];
         for ( int i = 0; i < 5 ; i++ ) {
           int randNum4 = getRandomInt(0,myData2.size()-1);
           Pair<String,Integer> currentPair4 = myData2.get(randNum4);
           keyData3[i] = currentPair4.getX();
        
      }
         System.out.println("-----------------------------------------------");
         System.out.println("Key                                      Value");
         System.out.println("-----------------------------------------------");
         
         for ( int i = 0; i < keyData2.length;i++) {
           System.out.print(keyData2[i]);
           if(h5.search(keyData2[i]) != null) {
            System.out.println("            " + h5.search(keyData2[i]));
           }
           else {
            System.out.println("          Not Found");
           }
         }
         for ( int i = 0; i < keyData3.length;i++) {
           System.out.print(keyData3[i]);
           if(h5.search(keyData3[i]) != null) {
             System.out.println("        " + h5.search(keyData3[i]));
        }
           else {
             System.out.println("             Not Found");
        }
      }
         
         
         System.out.println("-----------------------------------------------");
    //    -----------------       
  } // end of main function
  
      
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s   
  // needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomInt
  

// You may add any functions here to carry out the tasks above

  
  
  
} // end of HW05 class