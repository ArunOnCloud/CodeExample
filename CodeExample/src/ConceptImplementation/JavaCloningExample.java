package ConceptImplementation;

public class JavaCloningExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	
	
    

}
class PersonConcept {
	String name;
	int age;
	City city;
	@Override
	public PersonConcept clone() throws CloneNotSupportedException {
		PersonConcept pc=(PersonConcept)super.clone();
		pc.age=this.age;
		pc.name=this.name;
		pc.city= (City) this.city.clone();
				
		
		return pc;
		 
	}
	public PersonConcept(String name,int age ,City city) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.age=age;
		this.city=city;
	}
	
}
class City{
	String name;
	String state;
	String country;
	@Override
	public Object clone() throws CloneNotSupportedException {
		City city=(City) super.clone();
		city.name=this.name;
		city.state=this.state;
		
		return city;
		
	}
	
}
