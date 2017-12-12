package Hackerrank;

import java.util.Scanner;

public class Sapient2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		long[] arr=new long[n];
		for(int i=0;i<n;i++)
		{
			arr[i]=s.nextLong();
		}
		long[] g=new long[n];
		long[] l=new long[n];
		for(int i=0;i<n;i++)
		{
			int t=0;
			for(int j=i+1;j<n;j++)
			{
			  if(arr[i]> arr[j])
			  {
				  l[i]=j;
				  t=1;
				  break;
			  }
			}
			if(t==0)
			{
				l[i]=-1;
			}
			
		}
		for(int i=0;i<n;i++)
		{
			int t=0;
			for(int j=i+1;j<n;j++)
			{
			  if(arr[i] < arr[j])
			  {
				  g[i]=j;
				  t=1;
				  break;
			  }
			  
			}
			if(t==0)
			{
				g[i]=-1;
			}
		}
		for(int i=0;i<n;i++)
		{
			if(g[i]>0)
			{
				Long ln=g[i];
				Long val=l[ln.intValue()];
				if(val >=0)
				{
					System.out.print( arr[val.intValue()] + " ");
				}else
				{
					System.out.print("-1 ");
				}
				
			}else
			{
				System.out.print("-1 ");
			}
		}
		System.out.println();
		/*for(int i=0;i<n;i++)
		{
			System.out.print( g[i]+" ");
		}
		System.out.println();
		for(int i=0;i<n;i++)
		{
			System.out.print( l[i]+" ");
		}*/

	}

}
