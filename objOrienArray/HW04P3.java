/***** Homework 4 Phase 3 *****/
/* Last Name:  Li
 * First Name: Jiaqi
 * Section:  M004      (MOO1 / M004) 
 */
import java.util.Iterator;
import java.util.concurrent.ThreadLocalRandom; // for getRandomInt
public class HW04P3 {
  
  // DO NOT CHANGE THE FOLLOWING THREE QUANTITY
  static final int NUM_PRODUCE = 4;
  static final int NUM_GENERIC = 4;
  static final int MAX_ORDER_SIZE = 5;
    
  public static void main(String[] args) { 
 
    // Load the produce items of SU-coffee
    ProduceItem [] pItem = loadProduceItem ();
    // load the generic items of SU-coffee
    GenericItem [] gItem = loadGenericItem ();
  
    // Phase 3 
    // Note: you may need to use the functions from phase 2 in each of the steps 
    // below.
    
    // 1. Create a qOrder, and DLList of orders and initialize it to an empty list.
    
    // Add your code here
    DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> qOrder = new DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>>();
    
    // 2. Use the genAnOrder function (From Phase 2) to generate 50 orders,
    //    The number of items in an order is between 1 to MAX_ORDER_SIZE 
    //    (randomly generated). Insert (enqueue) them to the qOrder.
  //  qOrder.enqueue(genAnOrder(gItem,pItem,50));
    // Add your code here
    int numItem = getRandomInt(1,MAX_ORDER_SIZE);
    for ( int i = 0; i < 50; i++) {
    	 qOrder.add(genAnOrder(numItem,gItem,pItem));
    }
    // 3. Prepare the variables to use computeStatistics and  
    //    apply the computeStatistics function to retreive the statistics data
    //    from qOrder
    Pair<SLList<ProduceItem>,SLList<GenericItem>> maxOrder = new Pair<SLList<ProduceItem>,SLList<GenericItem>>();
    Pair<SLList<ProduceItem>,SLList<GenericItem>> minOrder = new Pair<SLList<ProduceItem>,SLList<GenericItem>>();
    double ans [] = computeStatistics(qOrder,maxOrder,minOrder);

    displayOrder(maxOrder);
    displayOrder(minOrder);
    System.out.println("The max total is: ");
    System.out.println(ans[0]);
    System.out.println("The min total is: ");
    System.out.println(ans[1]);
    System.out.println("The mean is: ");
    System.out.println(ans[2]);
    // Add your code here
    
    // 4. Display the following statistics data to the screen:
    
    // 4.1. The order in the queue where the total is the maximum, and,  
    //      the total of that order (maxTotal).    
    
    // 4.2. The order in the queue where the total is the minimum. and,
    //      the total of that order (minTotal).
       
    // 4.3. The mean (average) of order totals among all orders in the queue qOrder.
    
    
    // Add your code here
    
    // 5. Prepare and initialize the parameters and 
    //    apply the enforcePriority function to divide the qOrder into three queues: 
    // 
    // Add your code here
    DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q1 = new DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>>();
    DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q2 = new DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>>();
    DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q3 = new DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>>();
    enforcePriority(qOrder,q1,q2,q3);
    
    
    
    // 6. For each of the queues, say q1, q2 and q3 (classified by category)
    //    display the statistics data (as specified in 4.1, 4.2 and 4.3) to the screen:
    Pair<SLList<ProduceItem>,SLList<GenericItem>> maxOrder1 = new Pair<SLList<ProduceItem>,SLList<GenericItem>>();
    Pair<SLList<ProduceItem>,SLList<GenericItem>> minOrder1 = new Pair<SLList<ProduceItem>,SLList<GenericItem>>();
    Pair<SLList<ProduceItem>,SLList<GenericItem>> maxOrder2 = new Pair<SLList<ProduceItem>,SLList<GenericItem>>();
    Pair<SLList<ProduceItem>,SLList<GenericItem>> minOrder2 = new Pair<SLList<ProduceItem>,SLList<GenericItem>>();
    Pair<SLList<ProduceItem>,SLList<GenericItem>> maxOrder3 = new Pair<SLList<ProduceItem>,SLList<GenericItem>>();
    Pair<SLList<ProduceItem>,SLList<GenericItem>> minOrder3 = new Pair<SLList<ProduceItem>,SLList<GenericItem>>();
    double ans1 [] = computeStatistics(q1,maxOrder1,minOrder1);
    double ans2 [] = computeStatistics(q2,maxOrder2,minOrder2);
    double ans3 [] = computeStatistics(q3,maxOrder3,minOrder3);
    
    
    displayOrder(maxOrder1);
    displayOrder(minOrder1);
    System.out.println("The max total of order 1 is: ");
    System.out.println(ans1[0]);
    System.out.println("The max total of order 2 is: ");
    System.out.println(ans2[0]);
    System.out.println("The max total of order 3 is: ");
    System.out.println(ans3[0]);
    
    
    System.out.println();
    System.out.println("The min total of order 1 is: ");
    System.out.println(ans1[1]);
    System.out.println("The mix total of order 2 is: ");
    System.out.println(ans2[1]);
    System.out.println("The min total of order 3 is: ");
    System.out.println(ans3[1]);
    
    System.out.println();
    System.out.println("The mean of order 1 is: ");
    System.out.println(ans1[2]);
    System.out.println("The mean of order 2 is: ");
    System.out.println(ans2[2]);
    System.out.println("The mean of order 3 is: ");
    System.out.println(ans3[2]);
  }
  public static  Pair<SLList<ProduceItem>,SLList<GenericItem>> genAnOrder 
  (int orderSize, 
   GenericItem [] gItem, 
   ProduceItem [] pItem
  )       
{ // comment out the return statement below and add your own code 
  SLList<GenericItem> genericItem = new SLList<GenericItem>();
 SLList<ProduceItem> produceItem = new SLList<ProduceItem>();
 for ( int i = 0; i < orderSize;i++) {
   
   int list_select = getRandomInt(0,1);
   if(list_select == 0)
     genericItem.add(gItem[getRandomInt(0,gItem.length-1)]);
  else
    produceItem.add(pItem[getRandomInt(0,pItem.length-1)]);
 }
 Pair<SLList<ProduceItem>,SLList<GenericItem>> ordr = new Pair<SLList<ProduceItem>,SLList<GenericItem>>(produceItem,genericItem);
 
 return ordr;
}
  public static void displayOrder (Pair<SLList<ProduceItem>,SLList<GenericItem>> anOrder) 
  { 
    System.out.println("***** Display an order *****");
    // Add your code here
    SLList<ProduceItem>plist = anOrder.getX();
    SLList<GenericItem> glist = anOrder.getY();
    Iterator <ProduceItem> produce_iter = plist.iterator();
    Iterator <GenericItem> generic_iter = glist.iterator();
    while(produce_iter.hasNext()){
      System.out.println(produce_iter.next());
    }
  
    
    while(generic_iter.hasNext()){
      System.out.println(generic_iter.next());
    }
  
    
   
    System.out.println("*** An order is displayed ***\n");
  }
  
  public static double orderTotal (Pair<SLList<ProduceItem>,SLList<GenericItem>> anOrder) 
  { // comment out the return statement below and add your code 
   double totalp = 0.0;
   double totalg = 0.0;
   SLList<ProduceItem>plist = anOrder.getX();
   SLList<GenericItem> glist = anOrder.getY();
   Iterator <ProduceItem> produce_iter = plist.iterator();
   Iterator <GenericItem> generic_iter = glist.iterator();
   while(produce_iter.hasNext()){
      totalp += produce_iter.next().getPrice();
    }
  
    
   while(generic_iter.hasNext()){
      
     totalg += generic_iter.next().getPrice();
  }
  return totalg+totalp;
  }
// ***********************************************************************
// Phase 3: put the function computeStatistics in the space provided below
  public static double [] computeStatistics
  (DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> qStat,
  Pair<SLList<ProduceItem>,SLList<GenericItem>> maxOrder, Pair<SLList<ProduceItem>,SLList<GenericItem>> minOrder ){
	  
	  double maxTotal = 0;//orderTotal(maxOrder);
	  double minTotal = 9999;;//orderTotal(minOrder);
	  int maxIndex = 0;
	  int minIndex = 0;
	  int currentIndex = 0;
	  int sum = 0;

	  Iterator <Pair<SLList<ProduceItem>,SLList<GenericItem>>> iterate = qStat.iterator();
	  while(iterate.hasNext()) {
		  double total = orderTotal(iterate.next());
		  if (total > maxTotal ) {
			  maxTotal = total;
			  maxIndex = currentIndex;	  
			  
		  }
		  if(total < minTotal) {
			  minTotal = total;
			  minIndex = currentIndex;
		  }
		  currentIndex++;
		  sum+=total;
	  }
	  double [] ans = new double [3];
	  ans[0] = maxTotal;
	  ans[1] = minTotal;
	  ans[2] = sum/currentIndex;
	  maxOrder.setX(qStat.get(maxIndex).getX());
	  maxOrder.setY(qStat.get(maxIndex).getY());
	  minOrder.setX(qStat.get(minIndex).getX());
	  minOrder.setY(qStat.get(minIndex).getY());
  return ans;
  }
  
  
  
// End of function computeStatistics *************************************
  
  
// ***********************************************************************
// Phase 3: put the function enforcePriority in the space provided below  
  public static void enforcePriority(DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q0,
		  DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q1, 
		  DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q2,
		  DLList<Pair<SLList<ProduceItem>,SLList<GenericItem>>> q3) {
	  	  Iterator <Pair<SLList<ProduceItem>,SLList<GenericItem>>> iter = q0.iterator();
	  while (iter.hasNext()) {
		  Pair<SLList<ProduceItem>,SLList<GenericItem>> temp = iter.next();
		  //if it only consists produce Item
		  if(temp.getY() == null || temp.getY().isEmpty()) {
			  q1.add(temp);
		  }
		  // if it only has generic Item
		  else if (temp.getX() == null || temp.getX().isEmpty()) {
			  q2.add(temp);
		  }
		  else {
			  q3.add(temp);
		  }
	  }
	 q0.removeAll(q0);
  }

  
 
// End of function enforcePriority ***************************************
  
  
// ***********************************************************************
// Put the functions you have developed from Phase 2 in the space below.
  
  
// End of functions from Phase 2
// ***********************************************************************
    
  public static int getRandomInt(int r, int s){ // requires 0 <= r <= s 
// needs to add the line import java.util.concurrent.ThreadLocalRandom;
    return ThreadLocalRandom.current().nextInt(r, s + 1);
  } // end getRandomInt
  
    
  public static ProduceItem [] loadProduceItem () { 
    ProduceItem [] pItem = new ProduceItem[4];
    
    pItem [0] = new ProduceItem ();
    pItem [0].setId(1);
    pItem [0].setName("Sumatra");
    pItem [0].setQuantity(1);
    pItem [0].setExpiration("Dec 31, 2019");
    pItem [0].setPrice(10.0);
      
    pItem [1] = new ProduceItem ();
    pItem [1].setId(2);
    pItem [1].setName("Sumatra Capsules");
    pItem [1].setQuantity(12);
    pItem [1].setExpiration("Mar 31, 2020");
    pItem [1].setPrice(7.99);
    
    pItem [2] = new ProduceItem ();
    pItem [2].setId(3);
    pItem [2].setName("Kenya");
    pItem [2].setQuantity(1);
    pItem [2].setExpiration("Dec 15, 2019");
    pItem [2].setPrice(11.99);
    
    pItem [3] = new ProduceItem ();
    pItem [3].setId(4);
    pItem [3].setName("Kenya Capsules");
    pItem [3].setQuantity(18);
    pItem [3].setExpiration("April 1, 2020");
    pItem [3].setPrice(15.0);
    
    return pItem;
    
  }
   
    
  public static GenericItem [] loadGenericItem () { 
    GenericItem [] gItem = new GenericItem[4];;
    
    gItem [0] = new GenericItem ();
    gItem [0].setId(5);
    gItem [0].setName("Keurig K145");
    gItem [0].setQuantity(1);
    gItem [0].setPrice(89.99);
      
    gItem [1] = new GenericItem ();
    gItem [1].setId(6);
    gItem [1].setName("Mr. Coffee 12 cup");
    gItem [1].setQuantity(1);
    gItem [1].setPrice(26.99);
    
    gItem [2] = new GenericItem ();
    gItem [2].setId(7);
    gItem [2].setName("Melitta filter: 100 count");
    gItem [2].setQuantity(100);
    gItem [2].setPrice(1.49);
    
    gItem [3] = new GenericItem ();
    gItem [3].setId(8);
    gItem [3].setName("Melitta filter: 500 count");
    gItem [3].setQuantity(500);
    gItem [3].setPrice(4.99);
    
    return gItem;
  }
      
   
  
}