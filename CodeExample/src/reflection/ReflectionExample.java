package reflection;

public class ReflectionExample {

	public static void main(String[] args) throws Exception, IllegalAccessException {
		// TODO Auto-generated method stub
		Class c=Simple.class;
		Simple simple=(Simple)c.newInstance();
		simple.print();

	}

}

class Simple{
	
	public void print(){
		System.out.println("run time simple called");
	}
}
