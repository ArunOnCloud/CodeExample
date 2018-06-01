package ConceptImplementation;

public class TrickyOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
		 System.out.println((Double.MIN_VALUE));
		 
		 try {
			 //System.exit(0);
			 int val = 5/0;
			 //return;
			 //System.exit(0);
		 }catch(Exception ex) {
			 ex.printStackTrace();
			 
		 }finally {
			 System.out.println("in finally block");
		 }
		 A1.fun();
		 B1.fun();

	}
	
	

}
class A1 {
	public static void fun() {
		System.out.println("A method");
	}
	void method() {
		
	}
}

class B1 extends A1{
	public static void fun() {
		System.out.println("B method");
	}
	/*public void fun(int a) {
		System.out.println("B non static method");
	}*/
	public void bfun() {
		
	}
}

