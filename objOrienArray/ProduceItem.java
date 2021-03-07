/**
 * Java Class from zybooks Chapter 10, section 1.
 */

public class ProduceItem extends GenericItem { // ProduceItem derived from GenericItem
   public void setExpiration(String newDate) {
      expirationDate = newDate;
   }
   public String toString() {
     return ("Name: " + itemName + "; Quantity: " + itemQuantity +"; Price: " + itemPrice  + " Expiration Date: "+
             getExpiration()+" \n");
   }
   
   public String getExpiration() {
      return expirationDate;
   }

   private String expirationDate;

}