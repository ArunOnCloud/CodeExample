package ConceptImplementation;

public class GSInterviewJavaConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp=new SoftEmployee();
		System.out.println(emp.getName());
		SoftEmployee emp1=(SoftEmployee)emp;
		System.out.println(emp1.getType());

	}

}
 class Employee{
	public String getName() {
		return "arun";
	}
}
 
 class SoftEmployee extends Employee{
	 public String getName() {
			return "softArun";
		}
	 public String getType() {
			return "software";
		}
	 
 }
 
 
 
