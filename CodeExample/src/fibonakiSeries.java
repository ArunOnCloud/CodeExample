/*
 * author: Arun Kumar Ram
 * assumption : given input n 
 *  function should return nth fibonaki number
 *  first fibonaki number is 0 and second is 1
 */
public class fibonakiSeries {
	//public static int util
	public static int fibo(int n){
		if(n==1)
			return 0;
		else if(n==2)
			return 1;
		else
			return fibo(n-1)+fibo(n-2);	
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		System.out.println("nth fibonaki number:"+fibo(n));

	}

}
