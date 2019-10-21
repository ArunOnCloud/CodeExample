package hackerearth;

public class PeopleStrongTwo {
    static int[] arr=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generatePrime();
		for(int i=0;i<arr.length;i++)
		{
			//System.out.println(arr[i]);
		}
		System.out.println(countDiv(6));
	}
	
	
	static void generatePrime()	
	{
	    int MAX=100000;
	    arr=new int[MAX];
	    arr[0]=2;
	    arr[1]=3;
	    boolean t=true;
	    int i=5;
	    int ind=2;
	   while(ind<MAX)
	    {
	       
	        for(int j=0;arr[j]*arr[j]<=i;j++)
	        {
	        	int temp=arr[j];
	            if((i%temp)==0)
	            {
	                t=false;
	                break;
	            }
	        }
	        if(t==true)
	        {
	            arr[ind]=i;
	            ind++;
	        }
	        i+=2;
	        t=true;
	    }
	}
    static int  countDiv(int x)
    {
    	int ind=0;
    	int ans=1;
    	int temp=x;
    	while(ind<arr.length && arr[ind] <=x)
    	{
    		//int temp=x;
    		int count=0;
    		while(temp%arr[ind]==0)
    		{
    			count++;
    			temp=temp/arr[ind];
    		}
    		//System.out.println("count:"+count);
    		ans*=(count+1);
    		ind++;
    	}
    	return ans;
    }
	

}
