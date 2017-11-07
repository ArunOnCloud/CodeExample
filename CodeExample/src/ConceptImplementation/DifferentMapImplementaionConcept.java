package ConceptImplementation;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;



public class DifferentMapImplementaionConcept {

	public static void main(String[] args)
	{
		
	  Map<Integer,Object> map=new ConcurrentHashMap<Integer, Object>();
	  map=new HashMap<Integer,Object>();
	  map = Collections.synchronizedMap(map);
	  
	  Set<Integer> val=new HashSet<Integer>();
	  TreeMap<Integer,Object> treemap;
	  
	  //Comparator
		
	}
}