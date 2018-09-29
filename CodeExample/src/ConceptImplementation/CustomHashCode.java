package ConceptImplementation;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.nostra13.universalimageloader.core.assist.deque.LinkedBlockingDeque;

public class CustomHashCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       CustomHashCode customHashCode=new CustomHashCode();
       Byte byte1=new Byte((byte) 12);
       String str=customHashCode.getHashCode("adfasdk");
       System.out.println(str);
       List<Integer> list=new LinkedList<>();
       java.util.Collections.synchronizedList(list);
       
       
	}

	public String getHashCode(Object obj){
		Integer res=obj.hashCode();
		return res.toString();
	}
}
