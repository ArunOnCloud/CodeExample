package Hackerrank;

import java.util.Scanner;

public class testClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner s = new Scanner(System.in);
        int t=s.nextInt();
        for(int t1=0;t1<t;t1++)
	     {
        	int n=s.nextInt();
	        long p=s.nextLong();
	        long[] arr=new long[n];
	        
	        
	        for(int i=0;i<n;i++) {
	        	arr[i]=s.nextLong();
	        }
	        System.out.println(fun(arr,p));
        }
        

	}
	
	static Long fun(long[] arr,long p) {
		long ans=0;
		int n=arr.length;
		//System.out.println("n:"+n);
		long a=0;
		long b=0;
		
		long count=0;
		for(int i=0;i<n;i++) {
			/*if(i==0) {
				if(arr[0] >0) {
					//ans+=arr[0]* p;
					count+=arr[0];
				}else {
					
				}
			}else {
				long temp=arr[i -1]- arr[i];
				if(temp <0) {
					//ans+=((-temp)* p);
					count+=(-temp);
				}
			}*/
			count+= a -arr[i];
			if( count< 0) {
				ans+= (-count);
				count=0;
			}
			a=arr[i];
			//count+= arr[i-1]- arr[i];
			
		}
		
		
		
		
		return ans*p;
		
	}
	
	
	
	static int lcm(int a,int b){
        int lcm=0 ;
        int x,y; 
        if(a>b){
            x=a ;
            y=b ;
        }else{
            x=b ;
            y=a ;
        }
        lcm = x ;
        while(true){
            if(lcm % x == 0 && lcm % y == 0){
                break;
            }else{
                lcm++;
            }
        }
        return lcm ;
        
        
    }

}
