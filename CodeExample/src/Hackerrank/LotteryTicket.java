package Hackerrank;

import java.util.HashSet;
import java.util.TreeSet;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LotteryTicket {

	 static int winningLotteryTicket(String[] tickets) {
	        // Complete this function
	        Set<Integer> set=new HashSet<>();
	        set.add(key(tickets[0]));
	        int count=0;
	        int sum=1023;
	        for(int i=1;i<tickets.length;i++)
	        {
	           if(!set.contains(key(tickets[i])))
	           {
	        	  set.add(key(tickets[i])) ;
	           }
	        }
	        for(int i=0;i<tickets.length;i++)
	        {
	            int temp=key(tickets[i]);
	           // System.out.println("xor:"+(sum^temp));
	            /*if(set.contains(sum-temp))
	            {
	                count++;
	            }*/
	            int test=checkValidation(set,tickets[i]);
	            if(test>0)
	            {
	            	//System.out.println("countStr:"+tickets[i]+ "count:"+test);
	                count+=test;
	            }
	            
	            
	                set.add(key(tickets[i]));
	            //addKey(set,tickets[i]);
	            
	            //}
	        }
	        return count/2;
	    }
	  static int checkValidation(Set<Integer> set,String str){
		//  System.out.println("str:"+str);
		  int[] arr=new int[10];
	        for(int i=0;i<str.length();i++)
	        {
	            Character ch=str.charAt(i);
	            int val=Integer.parseInt(ch.toString());
	            arr[val]=1;
	            
	        }
	        List<Integer> list= genKey(arr);
	        int count=0;
	        for(Integer val:list)
	        {
	            if(set.contains(1023-val))
	            {
	                count++;
	            }
	        }
	        return count;
	  }
	    static void addKey(Set<Integer> set,String str)
	    {
	        int[] arr=new int[10];
	        for(int i=0;i<str.length();i++)
	        {
	            Character ch=str.charAt(i);
	            int val=Integer.parseInt(ch.toString());
	            arr[val]=1;
	            
	        }
	        List<Integer> list= genKey(arr);
	        for(Integer val:list)
	        {
	            if(!set.contains(val))
	            {
	                set.add(val);
	            }
	        }
	        
	    }
	    static int key(String str)
	    {
	        int[] arr=new int[10];
	        for(int i=0;i<str.length();i++)
	        {
	            Character ch=str.charAt(i);
	            int val=Integer.parseInt(ch.toString());
	            arr[val]=1;
	            
	        }
	        int ans=0;
	        for(int i=0;i<10;i++)
	        {
	            if(arr[i]==1)
	            {
	                //Double d=Math.pow(2,i);
	                ans+=Math.pow(2,i);
	            }
	        }
	        //System.out.println("ans:"+ans);
	        return ans;
	    }
	    
	    static List<Integer> genKey(int[] arr){
	        int n=arr.length;
	        List<Integer> list=new ArrayList<>(11);
	        util(list,arr,0,0);
	        return list;
	        
	        
	    }
	    static void util(List<Integer> list,int[] arr,int ind,int val)
	    {
	        int n=arr.length;
	        if(ind<n)
	        {
	            //list.add(Math.pow(2,i))
	            int curVal=0;
	            if(arr[ind] == 1)
	            { 
	                curVal+= Math.pow(2,ind);
	                
	                if(!list.contains(val) && val!=0)
	                {
	                    list.add(val);
	                }
	                if(!list.contains(val+curVal))
	                {
	                    list.add(val+curVal);
	                }
	                util(list,arr,ind+1,val);
	                util(list,arr,ind+1,val+curVal);
	            }else
	            {
	                util(list,arr,ind+1,val);
	            }
	                

	        }
	    }

	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String[] tickets = new String[n];
	        for(int tickets_i = 0; tickets_i < n; tickets_i++){
	            tickets[tickets_i] = in.next();
	        }
	        int result = winningLotteryTicket(tickets);
	        System.out.println(result);
	        in.close();
	    	
	    	//int[] arr={1,1,1,0,0,0,0,0,0,1} ;
	    	//System.out.println(genKey(arr));
	    	//String[] tickets = {"01234","56789","198","0123456789"};
	        /*Set<Integer> set=new TreeSet<Integer>();
	        addKey(set, "0123456789");
	        addKey(set, "01233");
	        System.out.println(set);*/
	        
	       // System.out.println(key("0123"));
	       // System.out.println(key("456789"));
	       // System.out.println(winningLotteryTicket(tickets));
	        
	        
	    }

}
