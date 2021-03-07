/* 1. A HTable is a chained hash table where its data are:
 * 1a.  table:
*  the table is an ArrayList of HNodes:

*   A HNode is an object where the data are
    
*     1a.1. key  type: K  (uses equals method from K to compare keys)
*     1a.2. val  type: V
*     1a.3. link  type: DLList<HNode> 

1b. noOfItems: the no of data items stored in HTable

1c. tableSz: the number of chains in the table (length of the array) 
*/
import java.util.ArrayList;  // use ArrayList to declare the table.
// Each chain the the table is a DLList (code from ods).
import java.util.Iterator;
import java.util.ListIterator;
public class HTable <K,V> {
 // Data %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
 
 private ArrayList<DLList<HNode<K,V>>> table;
 private int noOfItems;
 private int tableSz;

 // HNode class %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

 class HNode<K,V> {
 
  K key;
  V val;
 
  public HNode(K key, V val)
  {
  this.key = key;
  this.val = val;  
  }
  
  public K getKey () {return key;}
  public V getVal () {return val;}
 }  // end of HNode class
 
 
 
// Member functions  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 
// 2. The member functions of HTable are:
// 2a. Constructors
//   2a.1.  HTable(int tableSz)  
//      Constructors

 public HTable(int sz) {
  if (sz <= 0)
   throw new IllegalArgumentException("Table size must be positive.");
  // create table
  table = new ArrayList<DLList<HNode<K,V>>>();
  // determine table size
  tableSz = sz;
  // Initialize table by creating empty chains
  for (int i=0; i<tableSz; ++i){
    DLList<HNode<K,V>> aNewList = new DLList<HNode<K,V>>();
    table.add(aNewList);
  }
 }
 
// 2b.  getters
//  2b.1. getTableSize()
  
 public int getTableSize(){return tableSz;}
  
//  2b.2. getNoOfItems()

 public int getNoOfItems(){return noOfItems;}

//   2b.3. isEmpty()
 
 public boolean isEmpty() {return getNoOfItems() == 0;}
    
    
// 2c. functions for performing hashing and dictionary operations
// 2c.1. hash: hash(k) = (k.hashCode())%size

  public int hash (K key) {
   int hashCode = key.hashCode();
   int index = Math.abs(hashCode % tableSz);
   return index;   
  }
//  Dictionary operations  
//  2c.2. insert
//  The function insert will take key and val as input
//  1. Use hash(key) to find the chain, say C, to insert the data pair 
//  2.  Determine if the chain contains a data with the same key
//  2a. if so, do nothing and return false to indicate no new data item
//      are added
//  2b. if not, store the data pair in a HNode node N and insert
//      N to the chain C.
//  2c. Update the noOfItems value
//  2d. return true to indicate a new data item is added
 public V contains(DLList<HNode<K,V>> chain, K key) {
  ListIterator<HNode<K,V>> iter = chain.listIterator(0);
  while(iter.hasNext()) {
   HNode<K,V> node = iter.next();
   if(key.equals(node.getKey())) {
    return node.getVal();
   }
  }
  return null;
 }
 
 public boolean insert (K key, V val){  
   // comment out the return statement below 
   // and complete your implementation
  // return false;
  //this allows me to go to a specific DLList in the hash table
 int index = hash(key);
 DLList<HNode<K,V>> a = table.get(index);
 if (a.size()==0 || contains(a, key) == null) {
  HNode<K,V> node = new HNode<K,V>(key, val);
  a.add(0,node);
  noOfItems++;
  return true;
 }else {
  return false;
 }

  
  } 

 
//  2c.3. delete (K key) 
//  The function delete will take key as input
//  1. Use hash(key) to find the chain, say C, to start searching for dat
//  2.  Determine if the chain contains a data with the same key
//  2a. if so, remove the Node (with that key), say Nd 
//      in the doubly linked list C and return the value stored in Nd  
//  2b. if not, return null to indicate that the search fails


 public V delete (K key) { 
   // comment out the return statement below 
   // and complete your implementation
  // return null;
  int index = hash(key);
  int i = 0;
  DLList<HNode<K,V>> C = table.get(index);
  ListIterator<HNode<K,V>> iter = C.listIterator(0);
  while(iter.hasNext()) {
   HNode<K,V> node = iter.next();
   if(key.equals(node.getKey())) {
    break;
   }
   i++;
   
  }
  C.remove(i);
  noOfItems--;
  V val = contains(C,key);
  return val;

 }
// 2c.4. search 
//  The function search will take key as input
//  1. Use hash(key) to find the chain, say C, to start searching for dat
//  2.  Determine if the chain contains a data with the same key
//  2a. if so, say the Node (with that key) in the doubly linked list C, is Ns.
//      Get the value stored in Ns and return it   
//  2b. if not, return null to indicate that the search fails
 
 public V search (K key) {
   // comment out the return statement below 
   // and complete your implementation
  
   //return null;  
  //get the index of the current chain(DLList)
  int index = hash(key);
  DLList<HNode<K,V>> a = table.get(index);
  
  if(a.size()==0) {
   return null;
  }
  else {
   V ans = contains(a,key);
   return ans;
  }
  
 }
 
 // For each chain in the chained hash table,
 // the chain length is the number of data items stored
 // in the chain.  
 // The maxChainLength function will compute and return 
 // the maximum length among all the chains in the hash table
 public int maxChainLength () {
   // comment out the return statement below 
   // and complete your implementation
 int currentLen = 0;
 int maxLen = 0;
 ListIterator <DLList<HNode<K,V>>> iter = table.listIterator();
 while(iter.hasNext()) {
  currentLen = iter.next().size();
  if( currentLen > maxLen) {
   maxLen = currentLen;
  }
 }
 return maxLen;
 }

public static void main(String[] args) { 
  HTable<String,Integer> Example1 = new HTable<String,Integer> (103);
  System.out.println("Table size for Example 1 is " + Example1.getTableSize());
  System.out.println("No. of items for Example 1 is " + Example1.getNoOfItems());
  // You are encourage to add your test code below to check your implementation 
  // of HTable
  // Put additional test code in the space below 
}

} // END of HTable class %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%% 