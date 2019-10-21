package hackerearth;

public class PeopleStrongChalengeOne {
   static long mod = 10000000011L;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long x=2;
		long y=100000;
		int z=Integer.MAX_VALUE;
		System.out.println(bits(z));
		System.out.println(power(x,y));

	}
	
	public static long power(long x,long y)
	{
		if(y==0)
		{
			return 1;
		}else if(y==1)
		{
			return x;
		}else
		{
			long res=1;
			long midValue=power(x,y/2)%mod;
			System.out.println("x:"+x+" y:"+y+" midValue:"+midValue);
			if(y%2==0)
			{
				//return (midValue*midValue)%mod;
				return mulmod(midValue,midValue,mod)%mod;
			}else
			{
				return (x *mulmod(midValue,midValue,mod))%mod;
			}
		}
			
			
			
	}
	static long mulmod(long a, long b, long mod)
	{
		long res = 0; // Initialize result
	    a = a % mod;
	    while (b > 0)
	    {
	        
	        if (b % 2 == 1)
	            res = (res + a) % mod;
	 
	        // Multiply 'a' with 2
	        a = (a * 2) % mod;
	 
	        // Divide b by 2
	        b /= 2;
	    }
	 
	    // Return result
	    return res % mod;
	}
	static long solve(int[] a){
       long res=0l;
       for(int i=0;i<a.length;i++)
       {
    	   Integer temp=bits(a[i]);
    	   long x=temp;
    	   long  y=(i+1);
    	    res+=power(x,y);
    	    res=res%mod;
    	   
       }
       return res;
    }
	public static int bits(int x)
	{
		int count=0;
		for(int i=0;i<32;i++)
		{
			int temp=1;
			temp= temp<<(i+1);
			if((x & temp) > 0)
			{
				count++;
			}
		}
		
		return count;
	}

}
