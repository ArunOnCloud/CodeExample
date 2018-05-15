package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class ThoughtWorks1 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		/*System.out.println(Long.MAX_VALUE);
		Scanner s = new Scanner(System.in);
        int  t = s.nextInt();
        // Reading input from STDIN
        run();
       while(t>0){
           long temp=s.nextLong();
           int val=fun(temp);
           System.out.println(val);
           t--;
       }*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
        //String name = br.readLine();                // Reading input from STDIN
        //System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        
        Scanner s = new Scanner(System.in);
        String str=br.readLine();
        String[] ar=str.split(" ");
        int n=Integer.parseInt(ar[0]);
        int q=Integer.parseInt(ar[1]);
       // s.nextLine(); 
       // String a = s.nextLine(); 
         //String b = s.nextLine(); // Reading input from STDIN
          String a = br.readLine(); 
         String b = br.readLine();
         //System.out.println(a);
         //System.out.println(b);
         util(a,b);
         for(int i=0;i<q;i++){
        	 str=br.readLine();
             int temp=Integer.parseInt(str);
            // str=br.readLine();
             //System.out.println("temp:"+temp);
             fun(temp-1);
         }

	}
	static int size=38;
	static long[] arr=new long[size+1];
	
	static long pow(long a,long n) {
		if(n==0) {
			return 1l;
		}else {
			long temp=pow(a,n/2);
			if(n%2 == 0) {
				return temp*temp;
				
			}else {
				return temp*temp*a;
			}
		}
	}
	static void run() {
		for(int i=0;i<=size; i++) {
			
			long ans= (3*(pow(3, i)-1))/2;
			
			arr[i]=ans;
			//System.out.println("i:"+i+" :"+ans+" ");
		}
		//System.out.println();
		//int ind=Arrays.binarySearch(arr, n);
		//ind =  -(ind+1);
		//System.out.println("ind:"+ind);
	//	return ind;
		
	}
	static int fun(long n){
	    int ind=Arrays.binarySearch(arr, n);
	    if(ind<0)
		{
	    	ind =  -(ind+1);
		}
		//System.out.println("ind:"+ind);
		return ind;
	}
	static String sba=null;
	static StringBuilder sbb=null;
	static int ind=0;
	static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	static void util(String s,String b) {
		sba=s;
		sbb=new StringBuilder(b);
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i) > b.charAt(i)) {
				ind=i;
				break;
			}else if(s.charAt(i) < b.charAt(i)){
				ind=Integer.MAX_VALUE;
				break;
			}
		}
	}
	static void adjustIndex() {
		while(ind< sba.length()) {
			if(sba.charAt(ind) ==sbb.charAt(ind)) {
				ind++;
			}else if(sba.charAt(ind) < sbb.charAt(ind)) {
				ind=Integer.MAX_VALUE;
			}else {
				break;
			}
			
		}
	}
	
	static void fun(int val) throws Exception {
		sbb.setCharAt(val, '1');
		adjustIndex();
		//System.out.println("ind:"+ind);
		
		//int v=sba.compareTo(sbb.toString());
		if(ind == sba.length()) {
			//System.out.println("YES");
			bw.write("YES");
		}else if(ind == Integer.MAX_VALUE) {
			//System.out.println("YES");
			bw.write("YES");
		}else if(val < ind) {
			//System.out.println("NO");
			bw.write("NO");
		}
		/*if(val < ind ) {
			System.out.println("NO");
		}else {
			System.out.println("YES");
		}*/
		//System.out.println(v);
		
	}


}
