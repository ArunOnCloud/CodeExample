package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MillyAndRanksRangDeChallenge {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int t = Integer.parseInt(line);
        while(t!=0)
        {
        	line = br.readLine();
        	int n=Integer.parseInt(line);
        	line = br.readLine();
        	String[] strArr=line.split(" ");
        	int[] arr=new int[n];
        	for(int i=0;i<n;i++)
        	{
        		arr[i]=Integer.parseInt(strArr[i].trim());
        	}
        	System.out.println(fun(arr,n));
        	t--;
        }
	}
	public static int fun(int[] arr,int n)
	{
		int ans=0;
		Arrays.sort(arr);
		int ind=1;
		int prev=arr[0];
		while(ind<n)
		{
			int i=ind;
			while(i<n && arr[i]==prev )
			{
				arr[i]++;
				ans++;
				i++;
				//arr[]
				//System.out.println("i:"+i);
			}
			if(i<n)
			{
				prev=arr[i];
				ind=i;
			}else
			{
				break;
			}
			
			
		}
			
		return ans;
	}

}
