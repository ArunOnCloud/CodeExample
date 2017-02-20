/*
 * Name:Arun Kumar Ram
 * Date: 11 june 2015
 */
public class useOfThrows {
	static int divide(int a,int b) throws ArithmeticException{
		int x=a/b;
		
		return x;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		int b=0;
		int x=divide(a,b);

	}
	

}
