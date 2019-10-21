package interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeGeneration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		PrimeGeneration primeGeneration=new PrimeGeneration();
		primeGeneration.generatePrime();
		/*for(int i=0;i<primeGeneration.size;i++) {
			if(primeGeneration.parr[i] > 1000000)
			{
				System.out.println(primeGeneration.parr[i]+ " i:"+i);
				break;
			}
		}*/
		ArrayList<Integer> val=new ArrayList<>();
		val.add(4);
		val.add(5);
		val.add(7);
		//primeGeneration.generatePrime();
		
		//System.out.println(primeGeneration.solve(val));
		
		
		String string="bbbabbbacc";
	    Long ans=1L;
	    for(int i=1;i<=string.length();i++) {
	    	String str=string.substring(0, i);
	    	int ind=1;
	    	ans*=i;
    		ans%=mod;
    		int index=string.indexOf(str, ind);
	    	while((index=string.indexOf(str, ind)) >=0) {
	    		//System.out.println(str);
	    		//System.out.println(index);
	    		ans*=i;
	    		ans%=mod;
	    		ind=string.indexOf(str, ind)+1;
	    	}
	    }
	   System.out.println(ans.intValue());
		
		
	}
	
	
	
	
	
	int size=1000000;
	int[] parr=new int[size];
	void generatePrime() {
		
		parr[0]=2;
		parr[1]=3;
		parr[2]=5;
		int i=5;
		int n=3;
		while(n<size) {
			int j=0;
			int t=0;
		//	System.out.println("i:"+i+" j:"+j+" n:"+n);
			while(parr[j]*parr[j] <= i) {
		//		System.out.println("j:"+j);
				if(i%parr[j] ==0) {
					t=1;
					break;
				}
				j++;
			}
			if(t==0) {
				parr[n]=i;
				n++;
			}
			i++;
		}
		
	}
	static long mod=1000000007l;
	long power(long i,long n) {
		if(n==0 ) {
			return 1;
		}else {
			long temp=power(i,n/2);
			if(n%2 ==0) {
				return (temp*temp)% mod;
			}else {
				return (((temp*temp)% mod)*i)%mod;
			}
		}
		
	}
	
	boolean checkPrime(int i) {
		if(Arrays.binarySearch(parr,i) <0) {
			return false;
		}else {
			return true;
		}
	}
	public int solve(ArrayList<Integer> A) {
        Integer n=0;
        for(int i=0;i<A.size();i++){
            if(checkPrime(A.get(i))){
               // System.out.println(n);
                n++;
            }
        }
        long ans=power(2,n);
        if(n>0)
        return (int) ans -1;
        else
        return 0;
    }

}
