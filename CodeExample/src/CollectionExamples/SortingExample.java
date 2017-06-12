package CollectionExamples;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SortingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> list=new LinkedList<Integer>();
		
		list.add(23);
		list.add(93);
		list.add(33);
		list.add(273);
		
		list.add(23);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
		
		
		
		

	}

}
