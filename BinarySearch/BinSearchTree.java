/***** Homework 6: BinSearchTree *****/

/* Last Name:  Li
 * First Name: Jiaqi
 * Section:   M004     (MOO1 / M004)
 */

import java.util.*;
public class BinSearchTree {
  
  private BTNode<Pair<Integer,String>> root;
    
  public BinSearchTree() { 
    root = null;
  }
  
  public BinSearchTree(BTNode<Pair<Integer,String>> aNode){
     this.root = aNode; 
  }
  
  public BinSearchTree(Pair<Integer,String> aPair) { 
    this.root = new BTNode<Pair<Integer,String>>(aPair,null, null);
  }
   

//**************************************************************************
// Discussions for the lab session: compare function
//**************************************************************************
  
  public static int compare (Pair<Integer,String> Pair1, Pair<Integer,String> Pair2) 
  {
    return Pair1.getX().compareTo(Pair2.getX());
  }
    
  public long treeSize(){
    return BTNode.treeSize(this.root);
  }
      
  public long treeHeight(){
    return BTNode.treeHeight(this.root);
  }

//**************************************************************************
// Discussions for the lab session: insert function
//**************************************************************************
 
  
  public boolean insert(Pair<Integer,String> aPair){    
    // return false; // if the insert operation did insert aPair to the tree.
                  // otherwise, it will return false.
    BTNode<Pair<Integer,String>>
      current = root;
    
    BTNode<Pair<Integer,String>> 
      aNode = null;
    
    boolean inserted =false;
    
    if (root == null) {
      aNode = new BTNode<Pair<Integer,String>>(aPair,null,null);
        root = aNode;
    }
    else {
      while ((current != null) && !inserted) 
      { 
        int ans = compare(aPair, (current.getData()));
        if (ans < 0) {
          if (current.getLeft() == null) {
            aNode = new BTNode<Pair<Integer,String>>(aPair,null,null);
            current.setLeft(aNode);
            inserted = true;
          }
          else 
            current = current.getLeft();
        }
        
        if (ans > 0) {
          if (current.getRight() == null) {
            aNode = new BTNode<Pair<Integer,String>>(aPair,null,null);
            current.setRight(aNode);
            inserted = true;
          }
          else
            current = current.getRight();
        }
        
        if (ans == 0) {
          inserted = false;
          break; // leave the while loop
        }
      }
    }
    return (inserted);
  }

  
//**************************************************************************
// did not discuss in the lab session: delete function
// hints given below 
//**************************************************************************
 
// a helper function for the delete operation  
 private BTNode<Pair<Integer,String>> findReplacement
   (BTNode<Pair<Integer,String>> aNode) {
   while (aNode.getLeft() != null) aNode = aNode.getLeft();
   return aNode;
 }
  
    
  public  BTNode<Pair<Integer,String>> 
    delete
    (BTNode<Pair<Integer,String>> aNode)
  {
    // return null; // delete the data item with the given key
                 // if the delete operation fails, it will return null
    
    // if the tree is null (empty), return null     
    if (root == null) return null; 
    else { // tree is not null
      
     //  Set a reference p at the root
      BTNode<Pair<Integer,String>> p = root;
   
    // find out which direction (left or right) to continue
      int ans = compare(aNode.getData(), (p.getData()));
      //if the int of aNode(the node we want to delete) is less than the int of the root
      if (ans < 0) {  // go to the left tree and apply recursion to the left subtree
        BinSearchTree tr = new BinSearchTree(p.getLeft());
        p.setLeft(tr.delete(aNode));
      }//end of if statement
      //if the int of aNode is greater than the int of the root
      else if (ans > 0) { // go to the right tree and apply recursion to the right subtree 
         BinSearchTree tr = new BinSearchTree(p.getRight());
        p.setRight(tr.delete(aNode));
      }
      //if the node we want to delete is the root node
      else {
        //if the root is a leaf node
        if(p.getLeft() == null && p.getRight() == null) {
         
         return null;
         //if the tree doesn't have a left sub tree
        } else if (p.getLeft() == null){
          return p.getRight();
          //if the tree doesn't have a right sub tree
        } else if (p.getRight() == null){
          return p.getLeft();
          //if the root(node we want to delete) is not a leaf node
        } else{
          //it's easier to look for the largest number on the right sub tree to be the replacement
        BTNode<Pair<Integer,String>> r = findReplacement(p.getRight());
        
        p.setData(r.getData());
        BinSearchTree tree = new BinSearchTree(p.getRight());
        p.setRight(tree.delete(r));
        }
      }
      return p;
    }
  }


//**************************************************************************
// Discussions for the lab session: search function
//**************************************************************************
 
  
  public BTNode<Pair<Integer,String>> search(Pair<Integer,String> aPair){
    // return null; // return the value that correspond to the given key
                 // if search fails, it will return the string null    
     BTNode<Pair<Integer,String>>
      current = root;
    
    BTNode<Pair<Integer,String>> 
      aNode = null;
    
    boolean found =false;
    
    if (root == null) {
      found =false;
    }
    else {
      while ((current != null) && !found) 
      { 
        int ans = compare(aPair, (current.getData()));
        if (ans < 0) { 
            current = current.getLeft();
        }
        
        if (ans > 0) {         
            current = current.getRight();
        }
        
        if (ans == 0) {
          found = true;
        }
      }
    }
    return current;
  }

  
//**************************************************************************
// did not discuss in the lab session: rangeSearch function
// hints given below
//**************************************************************************
 
   
   public void rangeSearch (Integer a, Integer b){ // requires 0 <= a <= b
    // print all the data items (key, value) where a <= key <= b 
    // eg. for a BinSearchTree tree storing the data set Hash.csv, 
    // tree.rangeSearch(10000,10301) will print
    // (10001,NEW YORK)
    // (10301,STATEN ISLAND)
     
     // Step 1: extract an inorder listing (say, sortedLst) of 
     // the nodes in the tree
     
     BTNode<Pair<Integer,String>> sortedLst = root.inorder( );
     
     
     // Start the iteration at the beginning of the list
     BTNode<Pair<Integer,String>> itrA = sortedLst;
     
     // iterate through the list obtained and print the segment 
     // of nodes, if any, with their keys in the range [a,b]
       
     // Add your code here
 
     
     while(itrA.getRight() != null){
       Pair<Integer,String> curPair = itrA.getData();
       if(curPair.getX() >= a && curPair.getX() <= b){
         System.out.println(curPair.toString());
       
       }
       itrA = itrA.getRight();
     }
     
   }
  
    
    public void inorderPrint(){
    root.inorderPrint(); // return the value that correspond to the given key
                 // if search fails, it will return the string null        
  }

    
//**************************************************************************
// Discussions for the lab session: may try out the implementation such as
// those list below, if time permits
//**************************************************************************
 
    
  public static void main(String[] args) { 
   
    // Create a tree tree1   
    Pair<Integer,String> Pair1 = new Pair<Integer,String> (10011,"NYC1");
    Pair<Integer,String> Pair2 = new Pair<Integer,String> (10012,"NYC2");
    Pair<Integer,String> Pair3 = new Pair<Integer,String> (10013,"NYC3");
    Pair<Integer,String> Pair4 = new Pair<Integer,String> (10004,"NYC4");
    Pair<Integer,String> Pair5 = new Pair<Integer,String> (10005,"NYC5");
    Pair<Integer,String> Pair6 = new Pair<Integer,String> (10006,"NYC6");
 
    BinSearchTree tree1 = new BinSearchTree();
 
    // Test insert   
    
    tree1.insert(Pair1);
    tree1.insert(Pair2);
    tree1.insert(Pair3);
    tree1.insert(Pair4);
    tree1.insert(Pair5);
    tree1.insert(Pair6);
    
    System.out.println(tree1.treeSize());
    System.out.println(tree1.treeHeight());
    tree1.inorderPrint();
    
    // test search and see if the node can be found   
    
    System.out.println(tree1.search(Pair1).getData());
    System.out.println(tree1.search(Pair2).getData());
    System.out.println(tree1.search(Pair3).getData());
    System.out.println(tree1.search(Pair4).getData());
    System.out.println(tree1.search(Pair5).getData());
    System.out.println(tree1.search(Pair6).getData());
    
    //BTnode<Pair<Integer,String>> nd = new BTNode<Pair<Integer,String>>();
    //tree1.delete(nd);
   
     /* YOU MAY ADD YOUR OWN TEST CODE HERE */
//    BTNode <Pair<Integer,String>> nd = new BTNode<Pair<Integer,String>>(Pair1,null,null);
//    tree1.delete(nd);
//    tree1.inorderPrint();
//    System.out.print("size of tree 1 is " + tree1.treeSize());
  }
  
 
  
}