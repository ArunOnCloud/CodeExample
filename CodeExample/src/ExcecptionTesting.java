
public class ExcecptionTesting {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		ExcecptionTesting excecptionTesting=new ExcecptionTesting();
		try {
			throw new ExceptionB();
		}catch (ExceptionA ex) {
			ex.message();
		}catch (Exception ex) {
			//ex.message();
			ex.printStackTrace();
			
		}
		

	}

}
class ExceptionA extends Exception{
	public void message() {
		System.out.println("base class A");
	}
}
class ExceptionB extends ExceptionA{
	public void message() {
		System.out.println("base class B");
	}
}
