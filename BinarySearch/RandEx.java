import java.util.concurrent.ThreadLocalRandom;

public class RandEx {
  public static final int RANGE = 1000;
  public static void main(String[] argv)  {
    System.out.println("Show  getRandomIndex(1,6)\n");
    for (int i=1; i<10; i++) 
     System.out.println
      ("At "+i+"th trial, getRandomIndex(1,6) gives : " + getRandomIndex(1,6));
    int[] r = randPermute(100);
    for (int i=0; i<r.length; ++i) {
      System.out.println(r[i]);
    }
    
  } // end main   

// Write a Java program that reads in an array of numbers [0 , .. , n-1] of 
// length n, permutes the numbers in a random fashion.

// Algorithm
// Input: an array A, the length of the array n
// Output: a permutation of the values [0 .. n-1] stores in A 

public static int [] randPermute (int n) {
// n must be non-negative
int [] answer = new int[n];
for (int i=0; i<n; i++)
 answer[i] =i;
int len = n;
while (len > 1){
  swap(answer, getRandomIndex(0,len-1),len-1);
  len--;} // end while
return answer;
} // end of randPermute

public static void swap(int [] a, int s, int t) {//  0<=s<=t<a.length
  int temp = -1;
  temp = a[s];
  a[s] = a[t];
  a[t] = temp;
} // end of swap

public static int getRandomIndex(int r, int s){ // requires 0 <= r <= s 
// needs to add the line import java.util.concurrent.ThreadLocalRandom;
   return ThreadLocalRandom.current().nextInt(r, s + 1);
} // end getRandomIndex

} // end of randDemo class