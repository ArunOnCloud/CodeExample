package javaEight;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamApiExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new LinkedList<Integer>();
		List<Integer> collector=new LinkedList<Integer>();
		list.add(12);
		list.add(98);
		list.add(100);
		list.add(-3);
		list.add(-199);
		
		//list.stream().anyMatch();
		collector=list.stream().filter((i)->{return(i>0)?true:false;}).collect(Collectors.toList());
		
		System.out.println(collector);
		System.out.println("original list:"+list);
		
		
 
	}

}
