package javaEight;
import java.util.*;

public class LambdaConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Function<Integer,Integer> add = (i,j) -> {return i+j;};
		
		//FunctionOne<String> printString=(s)->{ System.out.println(s);};
		//evaluate( (String s) -> System.out.println(s) , "maon");
		// Convert Fahrenheit to Celsius
	      System.out.println(convert(input -> (input-32)*5.0/9.0, 98.6));

	      // Convert Kilometers to Miles
	      System.out.println(convert(input -> input/1.609344, 8));
	      
	      Converter con=(input)-> {System.out.println(input);return input;};
	      
	      System.out.println(con.convert(9));
	    

	}

	public static void evaluate(FunctionOne<String> sp, String value) {
		sp.print(value);
	}

	static double convert(Converter converter, double input) {
		return converter.convert(input);
	}

}

@FunctionalInterface
interface FunctionOne<U> {
	public void print(U u);
}

@FunctionalInterface
interface Converter {
	double convert(double input);
}


