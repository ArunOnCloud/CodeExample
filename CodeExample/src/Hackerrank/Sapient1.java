package Hackerrank;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;


/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class Sapient1 {
    public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        */
        //Scanner
        Scanner s = new Scanner(System.in);
        //String name = s.nextLine();                 // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT
        int n=s.nextInt();
        int[] a=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=s.nextInt();
        }
        util();
        List<Integer> prime=new java.util.ArrayList<Integer>();
        List<Integer> nonPrime=new java.util.ArrayList<Integer>();
        for(int i=0;i<n;i++)
        {
            if(checkPrime(a[i]))
            {
                prime.add(a[i]);
            }else
            {
                nonPrime.add(a[i]);
            }
        }
        Collections.sort(prime, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
        	
        });
        Collections.sort(nonPrime, new Comparator<Integer>(){

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
        	
        });
        //System.out.println(prime);
        //System.out.println(nonPrime);
        for(int i=0;i<prime.size();i++)
        {
        	System.out.print(prime.get(i)+" ");
        }
        for(int i=0;i<nonPrime.size();i++)
        {
        	System.out.print(nonPrime.get(i)+" ");
        }

        // Write your code here
       
    }
    static int[] arr=new int[100000];
    static int ind=0;
    public static void util()
    {
        ind=2;
        arr[0]=2;
        arr[1]=3;
        for(int i=5;i<100000;i+=2)
        {
            int j=0 ;
            int t=0;
            while(j<ind && arr[j]*arr[j] <i)
            {
                if(i%arr[j] == 0)
                {
                    t=1;
                    break;
                }
                j++;
            }
            if(t==0)
            {
                arr[ind]=i ;
                ind++;
            }
        }
        
    }
    static boolean checkPrime(int num)
    {
    	if(num  == 1)
    		return false;
    	if(num == 2 || num == 3 || num ==5)
    	return true;
        for(int i=0;i<ind;i++)
        {
           if(num%arr[i] == 0)
           {
               return false;
           }
           if(arr[i]* arr[i] >num)
           {
               break;
           }
        }
        return true;
    }
}

