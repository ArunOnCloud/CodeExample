package Hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class LotteryTicket2 {
	private static class CustomData{
		List<Long> list=new ArrayList<>(1024);
		long count=0;
		/*public  void toString() {
			System.out.println("count:":)
		}*/
		
	}
	static Map<Long,CustomData> map=new TreeMap<Long, LotteryTicket2.CustomData>();
	static Map<Long,Long> mapUtil=new TreeMap<Long, Long>();
	 static int winningLotteryTicket(String[] tickets) {
		 int res=0;
		 buildMap();
		 mapUtil.put(0l, 0l);
		 int count1023=0;
		 for(int i=0;i<tickets.length;i++)
		 {
			 long key=key(tickets[i]);
			 if(key == 1023)
			 {
				 count1023++;
			 }
			 if(mapUtil.containsKey(key))
			 {
				 long c=mapUtil.get(key);
				 mapUtil.put(key, c+1);
			 }else
			 {
				 mapUtil.put(key, 1l);
			 }
			 
		 }
		 for(Map.Entry<Long,CustomData> entry:map.entrySet())
		 {
			 CustomData customData=entry.getValue();
			 List<Long> list=customData.list;
			 int count=0;
			 for(Long val:list)
			 {
				 if(mapUtil.get(1023-val) > 0)
				 {
					 count+=mapUtil.get(1023-val);
				 }
			 }
			 //res+=count;
			// customData.count=count* mapUtil.get(entry.getKey());
			 if(mapUtil.get(entry.getKey())>0)
			 {
				 customData.count=count* mapUtil.get(entry.getKey());

			 }else
			 {
				 customData.count=count;
			 }
		 }
		 for(int i=1;i<1023;i++)
		 {
			 long iL=i;
			 if(mapUtil.get(iL) > 0l)
			 {
				CustomData customData =map.get(iL);
//				System.out.print("i:"+i+" count:"+mapUtil.get(i)+" ");
//				System.out.print("1023-i:"+(1023-i)+" ");
//				System.out.print("countData:"+customData.count+" ");
//				System.out.println("list:"+customData.list);
				//System.out.println("i")
				try{
				res+=(customData.count );
				/*if(mapUtil.get(i)>1)
				{
					System.out.println("added:"+((customData.count * ((mapUtil.get(i)-1)*2))*1));
					res+=((customData.count * ((mapUtil.get(i)-1)*2))*1);
					//res-=(customData.count );
				}else
				{
					res+=(customData.count );
				}*/
				}catch(Exception e){
				//	System.out.println("i:"+i);
				}
				 
			 }
		 }
		 //System.out.println("res:"+res);
		 res=res/2;
		// System.out.println("count1023:"+count1023);
		 if(count1023>0)
		 {
			 
			 /*if(tickets.length ==2 && count1023 ==2)
			 {
				 res+=1;
			 }else
			 {
			 res+=((tickets.length-1)*count1023);
			 }*/
			 res+=((tickets.length-1)*count1023);
			// System.out.println("witn:"+((tickets.length-1)*count1023));
			 Long l=(long)count1023;
			 Long l1=(l*(l-1))/2;
			// System.out.println("sub:"+l1);
			 res-=(l1.intValue());
		 }
		 return res;
		 
	 }
	static void buildMap()
	{
		for(int i=1;i<1024;i++)
		{
			int[] arr=setBits(i);
			List<Long> list=genKey(arr);
			Collections.sort(list);
			CustomData customData=new CustomData();
			customData.count=0;
			customData.list=list;
			long lon=i;
			map.put(lon, customData);
			mapUtil.put(lon, 0l);
		}
	}
	static int[] setBits(int num){
		int[] arr=new int[10];
		int temp=1;
		for(int i=0;i<11;i++)
		{
			if((num & (temp<<i))>0)
			{
				arr[i]=1;
			}
		}
		return arr;
	}
	static long key(String str)
    {
        long[] arr=new long[10];
        for(int i=0;i<str.length();i++)
        {
            Character ch=str.charAt(i);
            Long val=Long.parseLong(ch.toString());
            arr[val.intValue()]=1;
            
        }
        long ans=0;
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
    

	static List<Long> genKey(int[] arr){
        int n=arr.length;
        List<Long> list=new ArrayList<>(11);
        util(list,arr,0,0);
        return list;
        
        
    }
    static void util(List<Long> list,int[] arr,int ind,long val)
    {
        int n=arr.length;
        if(ind<n)
        {
            //list.add(Math.pow(2,i))
            long curVal=0;
            if(arr[ind] == 1)
            { 
                curVal+= Math.pow(2,ind);
                
                if(!list.contains(val) && val!=0)
                {
                	long lval=val;
                    list.add(lval);
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

    static int bruteForce(String[] tickets){
    	int res=0;
    	Map<Long,cusDub> map=new TreeMap<>();
    	for(int i=0;i<tickets.length-1;i++)
    	{
    		for(int j=i+1;j<tickets.length;j++)
    		{
    			//System.out.println("i:"+i+" j: "+j+" "+key(tickets[i]+tickets[j]));
    			if(key(tickets[i]+tickets[j]) == 1023)
    			{
    				//System.out.println("i:"+i+" j: "+j+" "+key(tickets[i]+tickets[j]));
    				long key=key(tickets[i]);
    				if(map.containsKey(key))
    				{
    					cusDub da=map.get(key);
    					da.data=da.data +1;
    					da.list.add(tickets[j]);
    					map.put(key, da);
    				}else
    				{
    					cusDub da=new cusDub();
    					da.data=1l;
    					da.list.add(tickets[j]);
    					map.put(key, da);
    				}
    				res+=1;
    			}
    		}
    	}
    	for(Map.Entry<Long, cusDub> entry:map.entrySet())
    	{
    		//System.out.println("key:"+entry.getKey()+ " count:"+entry.getValue().data + " list:"+entry.getValue().list);;
    	}
    	return res;
    }
    static class cusDub{
    	List<String> list=new ArrayList<String>();
    	Long data=0l;
    }
    static int nextLong()
    {
    	Random random=new Random();
    	int n=random.nextInt();
    	if(n<0)
    	{
    		return nextLong();
    	}else
    	{
    		return n;
    	}
    	
    }
    static void testing(){
    	String[] res=null;
    	int index=0;
    	int w=0;
    	int b=0;
    	while(index<100)
    	{
	    	Random random=new Random();
	    	int n=nextLong()%1000;
	    	System.out.println("n:"+n);
	    	String[] arr=new String[n];
	    	for(int i=0;i<n;i++)
	    	{
	    	   int len=nextLong()%100;
	    	   if(len==0)
	    	   {
	    		   len=1;
	    	   }
	    	   String str="";
	    	   for(int j=0;j<len;j++)
	    	   {
	    		   str+=(nextLong()%10);
	    	   }
	    	   arr[i]=str;
	    		   
	    	}
	    	w=winningLotteryTicket(arr);
	    	b=bruteForce(arr);
	    	if(w!= b)
	    	{
	    		res=arr;
	    		
	    		for(String str:arr)
	    		{
	    			System.out.print(str+" ");
	    		}
	    		break;
	    	}
	    	index++;
    	}
    	System.out.println();
    	System.out.println(res.length);
    	for(String str:res)
		{
			System.out.print(str+" ");
		}
    	System.out.println();
    	System.out.println("w:"+w);
    	System.out.println("b:"+b);
    	System.out.println("finished");
    }
	 public static void main(String[] args) {
	        /*Scanner in = new Scanner(System.in);
	        int n = in.nextInt();
	        String[] tickets = new String[n];
	        for(int tickets_i = 0; tickets_i < n; tickets_i++){
	            tickets[tickets_i] = in.next();
	        }
	        int result = winningLotteryTicket(tickets);
	        System.out.println(result);
	        in.close();*/
	    	
	    	//int[] arr={1,1,1,0,0,0,0,0,0,1} ;
	    	//System.out.println(genKey(arr));
	    	//String[] tickets = {"000123456789","0123456789","012345","123456789","0123456789"};
	    	String[] tickets = {"08188302953816488766250028","283870673","6","78437281881537297023","9358172507786574780680709","8632086871247088257737174436","79470046634337161175","34178375458223660","1","7849898728712","148267863373392290108","33635300436339768114217396087","974336190984313371154631","3250567015009","2367307472423241806039","69053","35661383","9022161145108208663236","5751270748"
};
	    	//String[] tickets={"0","0","915947822634","481","146068523978","44536485","62376231463111","7"};
	        /*Set<Integer> set=new TreeSet<Integer>();
	        addKey(set, "0123456789");
	        addKey(set, "01233");
	        System.out.println(set);*/
	        
	       // System.out.println(key("0123"));
	       // System.out.println(key("456789"));
	        System.out.println(winningLotteryTicket(tickets));
	    	System.out.println(bruteForce(tickets));
	        testing();
	       /*int[] arr= setBits(5);
	       for(int i=0;i<arr.length;i++)
	       {
	    	   System.out.print(arr[i]);
	       }*/
	       //buildMap();
	       //System.out.println(map);
	        
	    }

}
