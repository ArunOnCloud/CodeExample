package Hackerrank;

import java.util.Scanner;

public class Ubona2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
        
        int f,p;
        f=s.nextInt();
        p=s.nextInt();
        int[] arr=new int[f];
        for(int i=0;i<f;i++)
        {
        	arr[i]=s.nextInt();
        }
        System.out.println(fun(arr,f-1,p));
        System.out.println(util(arr,f,p));

	}
	public static long fun(int[] arr,int f,int p){
		long res=0l;
		if(f >=0 &&  p>0)
		{
			return fun(arr,f,p-arr[f])+ fun(arr,f-1,p);
		}else if( f<0 || p<0)
		{
			return 0l;
		}else if( p==0)
		{
			return 1l;
		}
		
		 
		
		return res;
	}
	static long mod=1000000007l;
	public static long util(int[] arr,int f,int p){
		long res=0l;
		long[][] dp=new long[f][p+1];
		for(int i=0;i<f;i++)
		{
			for(int j=1;j<=p;j++)
			{
				int ptemp=j-arr[i];
				long val1=0;
				int ftemp=i-1;
				long val2=0;
				if(ptemp ==0)
				{
					val1=1l;
				}else if(ptemp >0)
				{
					val1=dp[i][ptemp];
				}
				if(ftemp < 0)
				{
					val2=0;
				}else if(ftemp >= 0)
				{
					val2=dp[ftemp][j];
				}
				dp[i][j]=(val1+val2)%mod;	
				
			}
		}
		/*for(int i=0;i<f;i++)
		{
			for(int j=0;j<=p;j++)
			{
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}*/
		return dp[f-1][p];
	}

}
