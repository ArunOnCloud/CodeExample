package PhoneticalySimilarWords;
import org.apache.commons.codec.language.*;

public class MetaphoneSampleOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Metaphone meta=new Metaphone();
		String str=meta.metaphone("lenovo");
		System.out.println("str:"+str);
	    if(meta.isMetaphoneEqual("city", "siti"))
	    {
	    	System.out.println("true");
	    }else
	    {
	    	System.out.println("false");
	    }
	    System.out.println(meta.metaphone("city"));
	    
		

	}

}
