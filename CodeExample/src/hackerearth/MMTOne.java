package hackerearth;

import java.util.Scanner;

public class MMTOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      System.out.println(isPowerOfTwo(1024));
      
      Scanner s = new Scanner(System.in);
      String str = s.nextLine(); 
      // Reading input from STDIN
      
      buildData(str);
      int t=s.nextInt();
      for(int i=0;i<t;i++){
          int k=s.nextInt();
          System.out.println(fun(k));
      }
	}
	
	static boolean isPowerOfTwo(long n){
        long ind=1l;
        for(int i=0;i<62;i++){
            long temp=(ind <<i);
            if(n == temp){
                return true;
            }else if(temp >n){
                return false;
            }
        }
        return false;
        
    }
	static int[][] arr=null;
	static int size=0;
	static void buildData(String s) {
		int n=s.length();
		arr=new int[26][n];
		size=n;
		for(int i=0;i<n;i++) {
			int ind= (int)(s.charAt(i) - 'a');
			for(int j=0;j<26;j++) {
				if(i>0)
				arr[j][i]=arr[j][i-1];
				else
					arr[j][i]=0;
				if(ind==j) {
					arr[j][i]++;
				}
			}
			//arr[ind][i]++;
		}
		/*for(int i=0;i<26;i++) {
			for(int j=0;j<size;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}*/
		
	}
	static int fun(int k) {
		int ans=-1;
		for(int k1=k-1;k1<size;k1++) {
			if(k1 == 3) {
				//ad
				String str="";
			}
			for(int i=0;i<size-k1;i++) {
				if(isPalindrome(i, i+k1,k)) {
					ans=k1;
					break;
				}
				
			}
			if(ans>-1) {
				break;
			}
		}
		if(ans!=-1) {
			ans++;
		}
		return ans;
	}
	
	static boolean isPalindrome(int s,int e,int k) {
		int even=0;
		int oddCount=0;
		int oddVal=0;
		for(int i=0;i<26;i++) {
			int val=0;
			if(s>0) {
				val= arr[i][e]-arr[i][s-1];
			}else {
				val= arr[i][e]-0;
			}
			//int val= arr[i][e]-arr[i][s-1];
			/*if(arr[i][s]>0) {
				val++;
			}*/
			if(val%2 ==0) {
				even+=val;
			}else {
				even+= val-1;
				oddVal++;
				oddCount++;
			}
		}
		if(even >=k) {
			return true;
		}else if(oddCount == 1 && k%2==1 && even+1>=k){
			return true;
		}else if(oddCount >1 && k%2==1 && even+1==k){
			return true;
		}else {
			return false;
		}
		
		/*if(odd >1 ) {
			return false;
			
		}else {
			return true;
		}*/
	}

}
