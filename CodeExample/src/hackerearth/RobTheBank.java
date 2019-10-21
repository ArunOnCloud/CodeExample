package hackerearth;

import java.util.Scanner;

public class RobTheBank {
	
	static Long fun(long[] arr)
	{
		int n=arr.length;
		Long ans=0l;
		if(n==1)
		{
			return arr[0];
		}
		long count=0;
		long sum=0;
		long sack=arr[0];
		count=1;
		sum=arr[0];
		ans=sum;
		for(int i=1;i<n;i++)
		{
			long temp=arr[i];
			for(int j=i-1;j>=0;j--)
			{
				if(arr[j]>= arr[i])
				{
					temp+=arr[i];
				}else
				{
					break;
				}
			}
			if(temp> ans)
			{
				ans=temp;
			}
		}
		for(int i=n-1;i>=0;i--)
		{
			long temp=arr[i];
			for(int j=i+1;j<n;j++)
			{
				if(arr[j]>= arr[i])
				{
					temp+=arr[i];
				}else
				{
					break;
				}
			}
			if(temp> ans)
			{
				ans=temp;
			}
		}
		
		
		
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0;i<t;i++)
        {
        	int n=s.nextInt();
        	long[] arr=new long[n];
        	for(int j=0;j<n;j++)
        	{
        		arr[j]=s.nextLong();
        	}
        	System.out.println(fun(arr));
        	
        }
        

	}
	

}
