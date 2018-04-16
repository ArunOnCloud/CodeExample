package ConceptImplementation;

public class TrickeyInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A2 a=new B2();
		System.out.println(a.sum(2,3));
		
		B2 b=new B2();
		
		//System.out.println(b.sum(2.0f, 3, 4));

	}
	
	

}
class A2{
	int sum(int a,int b) {
		return a+b;
	}
}
class B2 extends A2{
	/*int sum(int a,int b,int c) {
		return a+b+c;
	}*/
	void  sum(int a) {
		//return (a+b);
	}
	/*float sum(float a,int b,int c) {
		return (float)(a+b+c);
	}*/
}