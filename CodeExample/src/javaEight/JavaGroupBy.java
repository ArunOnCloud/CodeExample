package javaEight;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public class JavaGroupBy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<Person> people = Stream.of(new Person("Paul", 24), new Person("Mark", 30), new Person("Will", 28),new Person("arun", 28));
		Map<Integer, List<String>> peopleByAge = people
		    .collect(Collectors.groupingBy(p -> p.age, Collectors.mapping((Person p) -> p.name, Collectors.toList())));
		System.out.println(peopleByAge);
		
		List<Person> list=new LinkedList<Person>();
		list.add(new Person("Paul", 24));
		list.add(new Person("paul2", 23));
		list.add(new Person("Paul3", 27));
		list.add(new Person("Paul4", 23));
		list.add(new Person("Paul5", 24));
		
		Map<Integer, List<String>> peopleByAge1 = list.stream()
			    .collect(Collectors.groupingBy(p -> p.age, Collectors.mapping((Person p) -> p.name, Collectors.toList())));
		System.out.println(peopleByAge1);

	}
	static class Person {
	    private String name;
	    private int age;
	 
	    Person(String name, int age) {
	 
	        this.name = name;
	        this.age = age;
	    }
	 
	    @Override
	    public String toString() {
	        return String.format("Person{name='%s', age=%d}", name, age);
	    }
	}
}
