package ConceptImplementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LambdaInSorting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list=new ArrayList<>();
		list.add(34);
		list.add(-2);
		list.add(98);
		list.add(999);
		Collections.sort(list,(i,j)->{ return j-i;});
		list.sort((i,j)->{return i-j;});
		
		System.out.println(list);
		
		Integer val=list.stream().max( (i,j) -> {return i-j;}).get();
		
		//Integer sum=list.stream().
		System.out.println(val);
		
		
		

	}

}
