package github;

/**
 * Java Class from zybooks Ch.10, Section 1
 */

/***** Homework 4 *****/
/* Last Name:  Li
 * First Name: Jiaqi
 * Section: M004    (MOO1 / M004)
 */

public class GenericItem {
  public void setId (int num) {
    id = num;
  }
  public void setName(String newName) {
    itemName = newName;
  }

  public void setQuantity(int newQty) {
    itemQuantity = newQty;
  }

   public void setPrice (double newPrice) {
     itemPrice = newPrice;
   }
     
   public void printItem() {
     System.out.println(itemName + " " + itemQuantity);
   }
   
   public double getPrice() {
     return itemPrice;
   }
   
   public int getId () {
     return id;
   }
   
   public String toString() {
     return ("Name: " + itemName + "; Quantity: " + itemQuantity +"; Price: " + itemPrice +" \n");
   }
   
   protected int id;
   protected double itemPrice;
   protected String itemName;
   protected int itemQuantity;
}

