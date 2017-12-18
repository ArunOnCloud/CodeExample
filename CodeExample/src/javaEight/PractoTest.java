package javaEight;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class PractoTest {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
        //String name = s.nextLine();
        String line = br.readLine();
        // Reading input from STDIN
        String[] arr=line.split(" ");
        int n=Integer.parseInt(arr[0]);
        int k=Integer.parseInt(arr[1]);
        int[] str=new int[n];
        line = br.readLine();
        line=line.trim();
        for(int i=0;i<n;i++)
        {
        	Character ch=line.charAt(i);
        	str[i]=Integer.parseInt(ch.toString());
        }
        int ind=0;
        TreeMap<Interval,Interval> map=new TreeMap<Interval,Interval>(new IntervalComp());
        int result=0;
        for(int i=0;i<n;i++)
        {
        	if(str[i]==1)
        	{
        		int temp=i+1;
        		while(temp<n)
        		{
        			if(temp ==n || str[temp]==0)
        			{
        				break;
        			}
        			temp++;
        		}
        		Interval interval=new Interval();
        		interval.s=i;
        		interval.e=temp-1;
        		//interval
        		map.put(interval, interval);
        		
        		if(temp-i > result)
        		{
        			result=temp-i;
        		}
        		i=temp-1;
        	}
        }
        Set<Interval> set=map.keySet();
        Interval[] intervalArr=new Interval[1];
        intervalArr= set.toArray(intervalArr);
       // intervalArr=(Interval[]) set.toArray();
        
        while(ind<k)
        {
        	int q=s.nextInt();
        	if(q==2)
        	{
        		int x=s.nextInt();
        		Interval o=new Interval();
        		o.s=x;
        		o.e=x;
        		if(str[x-1]==1)
        		{
        			
        		}else
        		{
        			o.s=x-1;
            		o.e=x-1;
            		System.out.println(" %%%%%%");
            		Interval putVal=new Interval();
            		
            		//if(map.containsKey(o))
            	    if(Arrays.binarySearch(intervalArr, o, new IntervalComp())>=0)
            		{
            			System.out.println(" ----");
            		   Interval val=map.get(o);
            		   putVal.s=val.s;
            		   map.remove(val, val);
            		   
            		}
            		o.s=x+1;
            		o.e=x+1;
            		
            		//if(map.containsKey(o))
            			 if(Arrays.binarySearch(intervalArr, o, new IntervalComp())>=0)
            		{
            			System.out.println(" ++++ ");
            		   Interval val=map.get(o);
            		   putVal.e=val.e;
            		   
            		   map.remove(val, val);
            		}
            		int temmp=putVal.e -putVal.s +1;
            		if(temmp>result)
            		{
            			result=temmp;
            		}
        		}
        		
        	}else
        	{
        		System.out.println(result);
        	}
        	ind++;
        }

	}
	//public static findInteval(Interval)

}
class Interval{
	public int s;
	public int e;
	
}
class IntervalComp implements Comparator<Interval>{

	@Override
	public int compare(Interval o1, Interval o2) {
		// TODO Auto-generated method stub
		if(o1.s-o1.e == 0 )
		{
			if(o1.s >=o2.s && o1.s <=o2.e)
			{
				return 0;
			}else if(o1.s <o2.s )
			
			{
				return -1;
			}else
			{
				return 1;
			}
			
		}else if(o2.s-o2.e == 0 )
		{
			if(o2.s >=o1.s && o2.s <=o1.e)
			{
				return 0;
			}else if(o2.s <o1.s )
			
			{
				return -1;
			}else
			{
				return 1;
			}
			
			
		}else 
		{
			return o1.s-o2.s;
		}
		
	}
	
}
