package Hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;



public class AccoliteChallenge {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        String[] numArr=line.split(" ");
	        long n,m;
	        n=Integer.parseInt(numArr[0]);
	        m=Integer.parseInt(numArr[1]);
	        line=br.readLine();
	       
	        String[] monk=line.split(" ");
	        line=br.readLine();
	        String[] arr=line.split(" ");
	        int len=monk.length;
	        Integer[] a=new Integer[len];
	        for(int i=0;i<monk.length;i++)
	        {
	        	a[i]=Integer.parseInt(monk[i]);
	        }
	         len=arr.length;
	         Integer[] b=new Integer[len];
	        for(int i=0;i<arr.length;i++)
	        {
	        	b[i]=Integer.parseInt(arr[i]);
	        }
	        //Collections.
	        Arrays.sort(a);
	        Arrays.sort(b);
	        //for(int i=0;i<n;i++)
	        //for score of a
	        long sa=0;
	        for(int i=0;i<a.length;i++)
	        {
	        	int f=findGreater(b,a[i],0,b.length-1);
	        	int g=findless(b,a[i],0,b.length-1);
	        	sa+=(f*g);
	        	//System.out.println("f:"+f+" g:"+g+" sa:"+sa);
	        	
	        }
	        long sb=0;
	        for(int i=0;i<b.length;i++)
	        {
	        	int f=findGreater(a,b[i],0,a.length-1);
	        	int g=findless(a,b[i],0,a.length-1);
	        	sb+=(f*g);
	        	//System.out.println("f:"+f+" g:"+g+" sb:"+sb);
	        	
	        }
	        //System.out.println("sa:"+sa);
	        //System.out.println("sb:"+sb);
	        
	        if(sa>sb)
	        {
	        	System.out.println("Monk "+(sa-sb));
	        }else if(sb>sa)
	        {
	        	System.out.println("!Monk "+(sb-sa));
	        }else
	        {
	        	System.out.println("Tie ");
	        	
	        }
	  }
	        
	       

	
	public static int findGreater(Integer[] a,int ele,int i,int j){
		//System.out.println("i:"+i+" j:"+j+" ele:"+ele);
		if(j>=a.length || i<0)
		{
			return 0;
		}
		int mid=(i+j)/2;
		if(j-i>1)
		{
			
				if(a[mid]<ele)
				{
				  return findGreater(a,ele,mid,j);
				}else if(a[mid]>ele)
				{
				 return findGreater(a,ele,i,mid);
				}else
				{
					return findGreater(a,ele,mid,j);
				}
				
			
		}else
		{
			//System.out.println("adsf");
			if(j-i==0)
			{
				System.out.println("oe print");
				if(ele<a[i])
				{
					//if(i==a.length-1)
						return a.length-i;
				}else
				{
					return 0;
				}
				//return a.length-mid-1;
			}else
			{
				if(ele<a[j] && ele>a[i])
				{
					return a.length-i-1;
				}else if(ele<a[i])
				{
					return a.length-i;
				}else
				{
					return 0;
				}
				//System.out.println("oe a[i]:"+a[i]+" a[j]"+a[j]);
//				if(ele<a[i])
//				{
//					return a.length-i-1;
//				}else if(ele==a[i])
//				{
//					return a.length-j-1;
//				}else if(ele==a[j])
//				{
//					return a.length-j-1;
//				}else if(ele>a[j])
//				{
//					return 0;
//				}else
//				{
//					//System.out.println("oe adsf ");
//					return a.length-j;
//				}
			}
		}
		//return 0;
		
		
	}
	public static int findless(Integer[] a,int ele,int i,int j){
		//System.out.println("i:"+i+" j:"+j+" ele:"+ele);
		if(j>=a.length || i<0)
		{
			return 0;
		}
		int mid=(i+j)/2;
		if(j-i>1)
		{
			
				if(a[mid]<ele)
				{
				  return findless(a,ele,mid,j);
				}else if(a[mid]>ele)
				{
				 return findless(a,ele,i,mid);
				}else
				{
					return findless(a,ele,i,mid);
				}
				
			//}
		}else
		{
			//System.out.println("oe a[i]:"+a[i]+" a[j]"+a[j]);
			if(j-i==0)
			{
				//System.out.println("oe a[i]:");
				if(ele> a[i])
				{
					return i;
				}else
				{
					return 0;
				}
				
			}else
			{
				//System.out.println("===1");
				if(ele<a[j] && ele>a[i])
				{
					return i;
				}else if(ele>a[j])
				{
					return j;
				}else
				{
					return 0;
				}
				
			}
		}
		//return 0;
		
		
	}

}
