class Employee{
	private String name;
	private int salary;
	public void setName(String s)
	{
		name=s;
	}
	public String getName()
	{
		return name;
	}
	public void setSalary(int n)
	{
		salary=n;
	}
	public int getSalary()
	{
		return salary;
	}
}
public class encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee obj=new Employee();
		obj.setName("arun");
		System.out.println("Emloyee name:"+obj.getName());
		obj.setSalary(12000);
		System.out.println("Salary:"+obj.getSalary());
		
		

	}

}
