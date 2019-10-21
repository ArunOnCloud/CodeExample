package hackerearth;

/* IMPORTANT: Multiple classes and nested static classes are supported */

//uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;


class DistinctPowersRangDeChallenge {
public static void main(String args[] ) throws Exception {
   /*
    * Read input from stdin and provide input before running
    * Use either of these methods for input
    */
   //System.out.println("Hello World!");
   //BufferedReader
   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
   String line = br.readLine();
   int N = Integer.parseInt(line);
   // System.out.println("N:"+N);
   //Scanner
   //Scanner s = new Scanner(System.in);
   //int N = s.nextInt();

   for (int i = 0; i < N; i++) {
       //System.out.println("i:"+i);
       //int a=s.nextInt();
       line = br.readLine();
       int a=Integer.parseInt(line);
       System.out.println(fun(a));
   }
   

   
}
public static int fun(int a)
{
   int val=a;
   int k=1;
   int ans=0;
   for(int i=0;i<32;i++)
   {
       int d=(k << i);
       if((val & d ) == 0)
       {
           ans=(a|d);
           break;
       }
   }
   return ans;
}
}
