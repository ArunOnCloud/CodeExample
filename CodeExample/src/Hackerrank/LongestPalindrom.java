package Hackerrank;

import java.util.Scanner;
import java.util.*;

public class LongestPalindrom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int m = in.nextInt();
        int[] arr=new int[n+1];
        for(int i=0;i<=n;i++)
        {
        	arr[i]=0;
        }
        List< List<Integer> > graph=new ArrayList< List<Integer> >();
        for(int i=0;i<=n;i++)
        {
        	List<Integer> list=new LinkedList<Integer>();
        	graph.add(list);
        }
        int count=0;
        for(int a0 = 0; a0 < k; a0++){
            int x = in.nextInt();
            int y = in.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
                        	
        }
        
        for(int i=1;i<=n;i++)
        {
        	if(arr[i] ==0)
        	{
        		count++;
        		dfs(graph,arr,i,count);
        	}
        	//System.out.print(arr[i]+" ");
        }
        for(int i=0;i<=n;i++)
        {
        	
        	//System.out.print(arr[i]+" ");
        }
       // System.out.println();
        int[] a = new int[m];
        for(int a_i=0; a_i < m; a_i++){
            a[a_i] = in.nextInt();
        }
        int[][] dp=new int[m][m];
        for(int i=0;i<m;i++)
        {
        	for(int j=0;j<m;j++)
        	{
        		dp[i][j]=1;
        	}
        }
        //int res=sol(arr,a,dp,0,m-1);
        int res=solu(arr,a,dp);
        System.out.println(res);
		
		

	}
	public static void dfs(List< List<Integer> > graph,int[] arr,int ind,int count)
	{
		arr[ind]=count;
		List<Integer> list=graph.get(ind);
		for(int i=0;i<list.size();i++)
		{
			if(arr[list.get(i)]== 0)
			{
				dfs(graph,arr,list.get(i),count);
			}
		}
	}
	public static int sol(int[] arr,int[] a,int[][] dp,int i,int j)
	{
	   if(i>j)
		   return 0;
	   if(i == j)
		   return dp[i][j];
	   if(arr[a[i]] == arr[a[j]])
	   {
		   int one=1;
		   if(dp[i+1][j-1]==1)
		   {
			   one=sol(arr,a,dp,i+1,j-1);
		   }
		   dp[i][j]=one+2;
	   }else if(arr[a[i]] == arr[a[j]])
	   {
		   int one=1;
		   if(dp[i+1][j]==1)
		   {
			   one=sol(arr,a,dp,i+1,j);
		   }
		   int two=1;
		   if(dp[i][j-1]==1)
		   {
			   two=sol(arr,a,dp,i,j-1);
		   }
		   dp[i][j]=max(one,two);
	   }
		return dp[i][j];   
	   
	}
	
	public static int solu(int[] arr,int[] a,int[][] dp){
		int n=a.length;
		
		for(int len=2;len<=n;len++)
		{
			for(int i=0;i<n-len+1;i++)
			{
				int j=i+len-1;
				//System.out.println(" arr len:"+len+ " i:"+i);
				if(arr[a[i]] == arr[a[j]] && len==2)
				{
					dp[i][j]=2;
				}else if(arr[a[i]] == arr[a[j]] )
				{
					dp[i][j]=dp[i+1][j-1]+2;
				}else
				{
					dp[i][j]=max(dp[i+1][j],dp[i][j-1]);
				}
			}
		}
		
		return dp[0][n-1];
	}
	public static int max(int a,int b)
	{
		if(a>b)
			return a;
		else
			return  b;
	}

}
