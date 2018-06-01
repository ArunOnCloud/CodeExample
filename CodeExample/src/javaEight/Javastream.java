package javaEight;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Javastream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list=new LinkedList<>();
		list.add(10);
		list.add(12);
		list.add(100);
		list.add(-24);
		list.add(11);
		list.add(-89);
		List<Integer> l=list.stream().filter(i -> {return i<50;}).filter((i)->{return i>10;}).collect(Collectors.toList());
        System.out.println(list);
        System.out.println(l);
        
        
        int sum=list.stream().filter(i-> true).collect(Collectors.summingInt(Integer::intValue));
        
        System.out.println(sum);
        int sum1=list.stream().filter(i-> true).mapToInt((i)->i).sum();
        System.out.println(sum1);
        
        int sum2=list.stream().filter(i-> true).mapToInt((i)->i).sum();
        System.out.println(sum1);
        
        
	}

}
