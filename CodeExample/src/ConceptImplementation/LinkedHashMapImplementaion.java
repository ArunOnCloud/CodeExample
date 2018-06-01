package ConceptImplementation;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapImplementaion {
	public static void main(String[] args) {
		Map<Integer,Integer> map=new LinkedHashMap<>();
		map.put(1,100);
		map.put(4,200);
		map.put(6,800);
		map.put(2, 300);
		System.out.println(map);
		map.put(6, 900);
		System.out.println(map);
		map.put(9, 1000);
		map.put(10, 1000);
		System.out.println(map);
	}

}
