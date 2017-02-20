 class A1{
	A1()
	{
		System.out.println("A contructor called");
	}
	void print()
	{
		System.out.println("A print():");
	}
}
 class B1 extends A1{
	B1()
	{
		System.out.println(" B constructure ");
		
	}
	void print(){
		System.out.println("B print()");
	}
}
 class C1 extends B1{
	C1(){
		System.out.print("C constructor");
		
	}
	void print(){
		System.out.print("C print()\n");
	}
}
public class polymorphism {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A1[] a=new A1[3];
		a[0]=new A1();
		a[1]=new B1();
		a[2]=new C1();
		for(A1 i:a)
		{
		   i.print();
		}

	}

}
