package ConceptImplementation;

public class OverridingEqual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p=new Person("arun",1);
		Person q=new Person("arun",1);
		Person r=new Person("ar",1);
		Student s=new Student("arun",1,1);
		Person t=new Student("arun",1,1);
		System.out.println("p and q :"+ p.equals(q));
		System.out.println("p and r :"+ p.equals(r));
		System.out.println("with inheritance p and s :"+ p.equals(s));
		System.out.println("with inheritance p and t :"+ p.equals(t));
		
		System.out.println("a============:"+ (s instanceof Person));
		
		

	}
	
	

}
class Person{
	String name;
	int gendor;
	public Person()
	{
		
	}
   public 	Person(String name, int g)
	{
		this.name=name;
		gendor =g;
	}
   @Override
   public boolean equals(Object o)
   {
	   //super();
	   if(o==null)
		   return false;
	   
	   if(o.getClass() != this.getClass())//for eliminating inheritance
	   {
		   return false;
	   }
	   
	  // System.out.println(o.getClass());
	  // System.out.println((o instanceof Person));
//	   if(!(o instanceof Person)  )
//	   {
//		   return false;
//	   }
	   final Person obj=(Person)o;
	   if(!this.name.equals(obj.name) || gendor !=obj.gendor)
	   {
		  return false; 
	   }else
		   return true;
	   
	   
   }
}

class Student extends Person
{
	//String name;
	//int gendor;
	int id;
     Student(String name, int g,int id)
	{
		this.name=name;
		gendor =g;
		this.id=id;
	}
   @Override
   public boolean equals(Object o)
   {
	   //super();
	   if(o==null)
		   return false;
	   
	   if(o.getClass() != this.getClass())
	   {
		   return false;
	   }
	   final Student obj=(Student)o;
	   if(!this.name.equals(obj.name) || gendor !=obj.gendor || id!=obj.id)
	   {
		  return false; 
	   }else
		   return true;
	   
	   
   }
}
