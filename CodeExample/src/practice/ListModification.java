package practice;

import java.util.ArrayList;
import java.util.List;

public class ListModification {

	public static void main(String[] args) {
		// TODO Auto-generated method stubIn>

		List<Integer> list=new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(2);
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(4);
		list.add(4);

		
		System.out.println(list);
		for(int i=0;i<list.size();i=i) {
			int val=list.get(i);
			if(val == 4) {
				list.remove(i);
			}else {
				i=i+1;
			}
			
		}
		System.out.println(list);
	}

}
