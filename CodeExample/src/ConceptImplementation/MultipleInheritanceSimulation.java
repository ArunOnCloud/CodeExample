package ConceptImplementation;

public class MultipleInheritanceSimulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new M();
		a.print("adf");
        //B b=a;
	}

}

interface A {
	void print(String s);
}
interface B{
	void print(String s);
}
class M implements A,B{
	public void print(String s)
	{
		System.out.println(" arun kumar Ram :"+s);
	}
}