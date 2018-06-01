package geeksforgeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


class LRUCache {
	 
    /*Inititalize an LRU cache with size N */
	Map<Integer,Integer> map=new HashMap<Integer,Integer>();
	List<Integer> list=new LinkedList<Integer>();
	Integer capacity;
    public LRUCache(int N) {
       //Your code here
    	capacity=N;
    	
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Scanner sc=new Scanner(System.in);
    	
    	int t=0;
    	t=sc.nextInt();
    	while(t>0)
    	{
    		int n=sc.nextInt();
    		LRUCache cache=new LRUCache(n);
    		int m=sc.nextInt();
    	    for(int i=0;i<m;i++)
    	    {
    	    	int type=sc.nextInt();
    	    	if(type==1)
    	    	{
    	    		int x,y;
    	    		x=sc.nextInt();
    	    		y=sc.nextInt();
    	    		cache.set(x, y);
    	    	}else
    	    	{
    	    		int x=sc.nextInt();
    	    		System.out.println(cache.get(x));
    	    	}
    	    }
    		
    		t--;
    	}

	}
    
    /*Returns the value of the key x if 
     present else returns -1 */
    public int get(int x) {
       //Your code here
    	if(map.containsKey(x))
    	{
    		Integer xObj=x;
    		list.remove(xObj);
    		
    		list.add(0, x);
    		return map.get(x);
    	}else
    	{
    		return -1;
    	}
    }
    
    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
       //Your code here
    	if(map.containsKey(x))
    	{
    		Integer xObj=x;
    		list.remove(xObj);
    		list.add(0, x);
    		map.put(x, y);
    	}else
    	{
    		list.add(0, x);
    		map.put(x, y);
    		if(list.size() > capacity)
    		{
    			int n=list.size();
    			int key=list.get(n-1);
    			list.remove(n-1);
    			map.remove(key);
    		}
    	}
    }
}

