// This is a revised version of BTNode specifically for
// HW06 (CIS 351, Fa19)
// The following methods is added (implementation of them
// are part of the HW06)

// File: BTNode.java from the package edu.colorado.nodes
// Complete documentation is available from the BTNode link in:
//   http://www.cs.colorado.edu/~main/docs/

// package edu.colorado.nodes;

/******************************************************************************
* A <CODE>BTNode</CODE> provides a node for a binary tree. Each node 
* contains a piece of data (which is a reference to an E object) and references
* to a left and right child. The references to children may be null to indicate
* that there is no child. The reference stored in a node can also be null.
*
* <b>Limitations:</b> 
*   Beyond <CODE>Int.MAX_VALUE</CODE> elements, <CODE>treeSize</CODE>, is
*   wrong.
*
* <b>Java Source Code for this class:</b>
*   <A HREF="../../../../edu/colorado/nodes/BTNode.java">
*   http://www.cs.colorado.edu/~main/edu/colorado/nodes/BTNode.java </A>
*
* @author Michael Main 
*   <A HREF="mailto:main@colorado.edu"> (main@colorado.edu) </A>
*
* @version Feb 10, 2016
******************************************************************************/
public class BTNode<E>
{
   // Invariant of the BTNode<E> class:
   //   1. Each node has one reference to an E Object, stored in the instance
   //      variable data.
   //   2. The instance variables left and right are references to the node's
   //      left and right children.
   private E data;
   private BTNode<E> left, right;   

   /**
   * Initialize a <CODE>BTNode</CODE> with a specified initial data and links
   * children. Note that a child link may be the null reference, 
   * which indicates that the new node does not have that child.
   * @param initialData
   *   the initial data of this new node
   * @param initialLeft
   *   a reference to the left child of this new node--this refebrence may be null
   *   to indicate that there is no node after this new node.
   * @param initialRight
   *   a reference to the right child of this new node--this reference may be null
   *   to indicate that there is no node after this new node.
   * <b>Postcondition:</b>
   *   This node contains the specified data and links to its children.
   **/   
   public BTNode(E initialData, BTNode<E> initialLeft, BTNode<E> initialRight)
   {
      data = initialData;
      left = initialLeft;
      right = initialRight;
   }       
   
   
   /**
   * Accessor method to get the data from this node.   
   * @return
   *   the data from this node
   **/
   public E getData( )   
   {
      return data;
   }
   
   
   /**
   * Accessor method to get a reference to the left child of this node. 
   * @return
   *   a reference to the left child of this node (or the null reference if there
   *   is no left child)
   **/
   public BTNode<E> getLeft( )
   {
      return left;                                               
   } 
   
   
   /**
   * Accessor method to get the data from the leftmost node of the tree below 
   * this node.
   * @return
   *   the data from the deepest node that can be reached from this node by
   *   following left links.
   **/
   public E getLeftmostData( )
   {
      if (left == null)
         return data;
      else
         return left.getLeftmostData( );
   }
      
   
   /**
   * Accessor method to get a reference to the right child of this node. 
   * @return
   *   a reference to the right child of this node (or the null reference if there
   *   is no right child)
   **/
   public BTNode<E> getRight( )
   {
      return right;                                               
   } 


   /**
   * Accessor method to get the data from the rightmost node of the tree below 
   * this node.
   * @return
   *   the data from the deepest node that can be reached from this node by
   *   following right links.
   **/
   public E getRightmostData( )
   {
      if (right == null) // Error from the authors' code: (left == null)
         return data;
      else
        return right.getRightmostData( );
        //  Error from the author's code: return left.getRightmostData( );
   }
   
   
   /**
   * Uses an inorder traversal to print the data from each node at or below
   * this node of the binary tree.
   * <b>Postcondition:</b>
   *   The data of this node and all its descendants have been written by
   *   <CODE>System.out.println( )</CODE> using an inorder traversal.
   **/
   public void inorderPrint( )
   {
      if (left != null)
         left.inorderPrint( );
      System.out.println(data);
      if (right != null)
         right.inorderPrint( );
   }  

//**************************************************************************
// Discussions for the lab session
//**************************************************************************
 
    
   /**
   * Uses an inorder traversal to put the data from each node at or below
   * this node of the binary tree to a doubly linked list, where the left
   * (resp. right) link of the BTNode will be used as the prev (resp. next)
   * link of a doubly linked list
   * 
   * <b>Postcondition:</b>
   *   The function will return a "doubly linked list" to order the node
   *   and all its descendants via an inorder.
   */
   
   public BTNode<E> inorder( )
   {
     BTNode<E> leftLst = null;
     BTNode<E> rghtLst = null;
     if (left != null)
       leftLst  = left.inorder();
     BTNode<E> aNode = new BTNode<E> (data,null,null); 
     if (right != null)
       rghtLst  = right.inorder();
     return  appendLst (leftLst,aNode,rghtLst);
   }
     

   private BTNode<E> appendLst (BTNode<E> lst1,BTNode<E> aNode,BTNode<E> lst2) {
     if (lst2 != null) {
       lst2.setLeft(aNode);
       aNode.setRight(lst2);
     }
     if (lst1 == null)
       return aNode;
     else {
        // go to the right most node of lst1
       BTNode<E> it = lst1;
       while (it.getRight() != null)
         it = it.getRight();
       // end while
       
       // At this step it reaches the rigth most node of lst1
         it.setRight(aNode);
         aNode.setLeft(it);
         return lst1;
     }
   }

//**************************************************************************
// End of Discussion for the lab session
//**************************************************************************
 
   
   /**
   * Accessor method to determine whether a node is a leaf. 
   * @return
   *   <CODE>true</CODE> (if this node is a leaf) or 
   *   <CODE>false</CODE> (if this node is not a leaf.
   **/
   public boolean isLeaf( )
   {
      return (left == null) && (right == null);                                               
   } 


   /**
   * Uses a preorder traversal to print the data from each node at or below
   * this node of the binary tree.
   * <b>Postcondition:</b>
   *   The data of this node and all its descendants have been writeen by
   *   <CODE>System.out.println( )</CODE> using a preorder traversal.
   **/
   public void preorderPrint( )
   {
      System.out.println(data);
      if (left != null)
         left.preorderPrint( );
      if (right != null)
         right.preorderPrint( );
   } 
   
      
   /**
   * Uses a postorder traversal to print the data from each node at or below
   * this node of the binary tree.
   * <b>Postcondition:</b>
   *   The data of this node and all its descendants have been writeen by
   *   <CODE>System.out.println( )</CODE> using a postorder traversal.
   **/
   public void postorderPrint( )
   {
      if (left != null)
         left.postorderPrint( );
      if (right != null)
         right.postorderPrint( );
      System.out.println(data);
   }   

//****************************************************************************
//  Breadth first order traversal: ADDED for CIS 351, FA19   
//****************************************************************************
   
   
    /**
   * Uses a bforder traversal to print the data from each node at or below
   * this node of the binary tree.
   * <b>Postcondition:</b>
   *   The data of this node and all its descendants have been writeen by
   *   <CODE>System.out.println( )</CODE> using a bforder traversal.
   **/
   
   public void bforderPrint() { 
     SLList<BTNode<E>> q = new SLList<BTNode<E>>(); 
     if (this != null) q.add(this); 
     while (!q.isEmpty()) { 
       BTNode<E> u = q.remove();
       System.out.println(data);
       if (u.left != null) q.add(u.left); 
       if (u.right != null) q.add(u.right); 
     } 
   }
   
   
   /**
   * Uses an inorder traversal to print the data from each node at or below
   * this node of the binary tree, with indentations to indicate the depth
   * of each node.
   * @param depth
   *   the depth of this node (with 0 for root, 1 for the root's
   *   children, and so on)(
   * <b>Precondition:</b>
   *   <CODE>depth</CODE> is the depth of this node.
   * <b>Postcondition:</b>
   *   The data of this node and all its descendants have been writeen by
   *   <CODE>System.out.println( )</CODE> using an inorder traversal.
   *   The indentation of each line of data is four times its depth in the
   *   tree. A dash "--" is printed at any place where a child has no
   *   sibling.
   **/
   public void print(int depth)
   {
      int i;
   
      // Print the indentation and the data from the current node:
      for (i = 1; i <= depth; i++)
         System.out.print("    ");
      System.out.println(data);

      // Print the left subtree (or a dash if there is a right child and no left child)   
      if (left != null)
         left.print(depth+1);
      else if (right != null)
      {
         for (i = 1; i <= depth+1; i++)
            System.out.print("    ");
         System.out.println("--");
      }

      // Print the right subtree (or a dash if there is a left child and no left child)  
      if (right != null)
         right.print(depth+1);
      else if (left != null)
      {
         for (i = 1; i <= depth+1; i++)
            System.out.print("    ");
         System.out.println("--");
      }
   }
   

   /**
   * Remove the leftmost most node of the tree with this node as its root.
   * @return
   *   The tree starting at this node has had its leftmost node removed (i.e.,
   *   the deepest node that can be reached by following left links). The
   *   return value is a reference to the root of the new (smaller) tree.
   *   This return value could be null if the original tree had only one
   *   node (since that one node has now been removed).
   **/
   public BTNode<E> removeLeftmost( )
   {
      if (left == null)
         return right;
      else
      {
         left = left.removeLeftmost( );
         return this;
      }
   }


   /**
   * Remove the rightmost most node of the tree with this node as its root.
   * @return
   *   The tree starting at this node has had its rightmost node removed (i.e.,
   *   the deepest node that can be reached by following right links). The
   *   return value is a reference to the root of the new (smaller) tree.
   *   This return value could be null if the original tree had only one
   *   node (since that one node has now been removed).
   **/
   public BTNode<E> removeRightmost( )
   {
      if (right == null)
         return left;
      else
      {
         right = right.removeRightmost( );
         return this;
      }
   }
       
   /**
   * Modification method to set the data in this node.   
   * @param newData
   *   the new data to place in this node
   * <b>Postcondition:</b>
   *   The data of this node has been set to <CODE>newData</CODE>.
   **/
   public void setData(E newData)   
   {
      data = newData;
   }                                                               
   
   
   /**
   * Modification method to set the link to the left child of this node.
   * @param newLeft
   *   a reference to the node that should appear as the left child of this node
   *  (or the null reference if there is no left child for this node)
   * <b>Postcondition:</b>
   *   The link to the left child of this node has been set to <CODE>newLeft</CODE>.
   *   Any other node (that used to be the left child) is no longer connected to
   *   this node.
   **/
   public void setLeft(BTNode<E> newLeft)
   {                    
      left = newLeft;
   }
    
    
   /**
   * Modification method to set the link to the right child of this node.
   * @param newRight
   *   a reference to the node that should appear as the right child of this node
   *  (or the null reference if there is no right child for this node)
   * <b>Postcondition:</b>
   *   The link to the right child of this node has been set to <CODE>newRight</CODE>.
   *   Any other node (that used to be the right child) is no longer connected to
   *   this node.
   **/
   public void setRight(BTNode<E> newRight)
   {                    
      right = newRight;
   }  
    
    
   /**
   * Copy a binary tree.
   * @param source
   *   a reference to the root of a binary tree that will be copied (which may be
   *   an empty tree where <CODE>source</CODE> is null)
   * @param <E>
   *   type of data in each node of the tree
   * @return
   *   The method has made a copy of the binary tree starting at 
   *   <CODE>source</CODE>. The return value is a reference to the root of the copy. 
   * @exception OutOfMemoryError
   *   Indicates that there is insufficient memory for the new tree.   
   **/ 
   public static <E> BTNode<E> treeCopy(BTNode<E> source)
   {
      BTNode<E> leftCopy, rightCopy;

      if (source == null)
         return null;
      else
      {
         leftCopy = treeCopy(source.left);
         rightCopy = treeCopy(source.right);
         return new BTNode<E>(source.data, leftCopy, rightCopy);
      }
   }
   

   /**
   * Count the number of nodes in a binary tree.
   * @param root
   *   a reference to the root of a binary tree (which may be
   *   an empty tree where <CODE>source</CODE> is null)
   * @param <E>
   *   type of data in each node of the tree
   * @return
   *   the number of nodes in the binary tree  
   * <b>Note:</b>
   *   A wrong answer occurs for trees larger than 
   *   <CODE>INT.MAX_VALUE</CODE>.    
   **/ 
   public static <E> long treeSize(BTNode<E> root)
   {
      if (root == null)
         return 0;
      else
         return 1 + treeSize(root.left) + treeSize(root.right);
   }   
   
  public static <E> long treeHeight(BTNode<E> root)
   {
      if (root == null)
         return -1;
      else {
        
        return 1 + Math.max(treeHeight(root.left) , treeHeight(root.right));
      }
    }  
    
     
   // ** A simple demo added for CIS 351 Fa19 
   
   public static void main(String[] args) { 
    // Create a Binary Tree where each node contains an integer
    
     BTNode<Integer> node4 = new BTNode<Integer> (4, null, null);
     BTNode<Integer> node5 = new BTNode<Integer> (5, null, null);
     BTNode<Integer> node6 = new BTNode<Integer> (6, null, null);
     BTNode<Integer> node7 = new BTNode<Integer> (7, null, null);
     
     BTNode<Integer> node2 = new BTNode<Integer> (2, node4, node5);
     BTNode<Integer> node3 = new BTNode<Integer> (3, node6, node7);
     
     BTNode<Integer> node1 = new BTNode<Integer> (1,node2, node3);
     
     
     System.out.println
       ("******************************************************************");
     
     System.out.println
       ("* Show how to perform iteration for the list returned by inorder *");
     
     System.out.println
       ("******************************************************************");
     
     BTNode<Integer> root = node1;
     BTNode<Integer> order = node1.inorder();
     BTNode<Integer> it = order;
     
     while (it != null){
       System.out.println(it.data);
       it = it.getRight();
     }
         
     
     System.out.println("***** apply inorderPrint *****");
     root.inorderPrint();
     
      /* YOU MAY ADD YOUR OWN TEST CODE HERE */
  }
   
}
           