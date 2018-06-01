import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



public class TrickyInputOutput {

	public static void main(String[] args) {
		// TODO Auto-generated method stubte
	   Integer i=new Integer(15);
	   Integer j=new Integer(5);
	   System.out.println((i==j));
	
	   System.out.println((5 == j));
	   System.out.println((i == 15));
	   
	   double d=Math.random();
	   System.out.println(d);
     
	   final List<String> modifiable = new ArrayList<>();
	   modifiable.add("Java");
	   modifiable.add("is");

	   final List<String> unmodifiable = Collections.unmodifiableList(modifiable);
	   System.out.println("Before modification: " + unmodifiable);

	   modifiable.add("the");
	   modifiable.add("best");

	   System.out.println("After modification: " + unmodifiable);
	   
	   final List<PersonCustom> modifiablePersonList=new ArrayList<>();
	   modifiablePersonList.add(new PersonCustom("arun", 10));
	   modifiablePersonList.add(new PersonCustom("arun", 11));
	   modifiablePersonList.add(new PersonCustom("arun", 12));
	   modifiablePersonList.add(new PersonCustom("arun", 13));
	   
	   final List<PersonCustom> unmodifiablePersonList = Collections.unmodifiableList(modifiablePersonList);
	   System.out.println("Before modification: " + unmodifiablePersonList);
	   modifiablePersonList.add(new PersonCustom("arun", 14));
	   modifiablePersonList.add(new PersonCustom("arun", 15));
	   System.out.println("After modification: " + unmodifiablePersonList);
	   unmodifiablePersonList.get(0).name="arun fafd";
	   System.out.println("After object modification: " + unmodifiablePersonList);
	   
	   
	   unmodifiablePersonList.set(0, new PersonCustom("man", 9));
	   System.out.println("After object modification: " + unmodifiablePersonList);
	}

}
class PersonCustom{
	 String name;
	 Integer age;
	PersonCustom(String name,Integer age){
		this.name=name;
		this.age=age;
	}
	public String toString() {
		return "name:"+this.name+ " age:"+this.age;
	}
	
}
