package ConceptImplementation;

import java.io.IOException;
import java.util.ArrayList;


public class ErasureConcept {
	public static void main(String[] args) throws IOException {
		ArrayList<String> al = new ArrayList<String>();
		al.add("a");
		al.add("b");
 
		//accept(al);// it
		accept(al);// it
	}
 //below implementation with line 13 give compilation error because erasure is implementated at compilation level
	
//	public static void accept(ArrayList<Object> al){
//		for(Object o: al)
//			System.out.println(o);
//	}
	public static void accept(ArrayList<? extends Object> al){
		for(Object o: al)
			System.out.println(o);
	}
}
