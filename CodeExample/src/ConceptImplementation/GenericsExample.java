package ConceptImplementation;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GenericsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lint=new LinkedList<>();
		lint.add(3);
		lint.add(6);
		lint.add(123);
		MaxElement<Integer> maxEle=new MaxElement<>();
		Integer max=maxEle.getMax(lint);
		System.out.println(max);

	}

}

class MaxElement<T>{
	public T getMax(List<T> list) {
		T max=list.get(0);
		for(int i=0;i<list.size();i++) {
		   T ele=list.get(i);		
		  if(ele instanceof Comparable ) {
			  Comparable com=(Comparable) ele;
			  Comparable ano=(Comparable) max;
			  if(com.compareTo(ano) >0) {
				  max=ele;
				  
			  }
			
		  }
	  }
		return max;
		
	}
}
