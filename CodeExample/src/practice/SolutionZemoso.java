package practice;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SolutionZemoso {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        int N = Integer.parseInt(line);
//        for (int i = 0; i < N; i++) {
//            System.out.println("hello world");
//        }
          int[] A={  4, 3, 2, 5, 1, 1};
          
          //int n=Arrays.length();
          
           int n=A.length;
           int max=-1000000009;
           int[] arr=new int[n];
           for(int i=0;i<n;i++)
           {
        	   arr[i]=max;
           }
           int[] rev=new int[n];
           for(int i=n-1;i>=0;i--)
           {
        	   rev[i]=max;
           }
           for(int i=0;i<n;i++)
           {
        	   if(A[i]>max)
        	   {
        		   max=A[i];
        	   }
        	   arr[i]=max;
           }
           
           max=-1000000009;
           for(int i=n-1;i>=0;i--)
           {
        	   if(A[i]>max)
        	   {
        		   max=A[i];
        	   }
        	   rev[i]=max;
           }
//           System.out.println(arr);
//           System.out.println(rev);
//           print(arr);
//           print(rev);
           
           int maxInd=0;
//           int abs=Math.abs(arr[0]-rev[1]);
//           int absMax=M
           int absMax=0;
           for(int i=0;i<n-1;i++)
           {
        	   int absTemp=Math.abs(arr[i]-rev[i+1]);
        	   //System.out.println(absTemp);
        	   if(absTemp>absMax)
        	   {
        		   absMax=absTemp;
        		   maxInd=i;
        	   }
           }
//           int absTemp=Math.abs(arr[n-1]);
//           if(absTemp>absMax)
//    	   {
//    		   absMax=absTemp;
//    		   maxInd=n-1;
//    	   }
           System.out.println(absMax);
           
           

	}
	public static void print(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			System.out.print(" "+a[i]);
		}
		System.out.println(" ");
	}

}
