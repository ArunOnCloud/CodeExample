package javaEight;

import java.util.function.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class JavaBuiltInFunctionalInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		biConsumerInterfaceExample((s,n)->System.out.println("Age of "+s+" is "+n),"arun",24);
		BiConsumer<String, Integer> biCon2 = (name, age)->System.out.println(name+" "+age);  
        biCon2.accept("Peter", 28); 
        BiConsumer<String, Integer> biCon3= biCon2.andThen(biCon2);
        biCon3=biCon3.andThen(biCon3);
        biCon3.accept("Peter", 281);
        //Consumer
        
        Consumer<String> consumer=(s)->System.out.println(s);
        consumer.accept("arun");
        
        Function<Integer,Integer> add=(i)-> { return i+1;};
       System.out.println( add.apply(12));
        
        Predicate<Integer> check=(i)->{
        	return (i>0)? true:false;
        };
        System.out.println( check.test(-2));
        BiFunction<Integer,Integer,Integer> a=(i,j)->{return i+j;};
        System.out.println("given 2 3 add:"+a.apply(2, 3));
        
        BinaryOperator<Integer> bo=(i,j)->{return i*j;};
        System.out.println(bo.apply(2, 3));
        
        
        

	}
	
	static void biConsumerInterfaceExample(BiConsumer<String,Integer> val,String name,Integer age)
	{
		val.accept(name, age);
	}
	

}
