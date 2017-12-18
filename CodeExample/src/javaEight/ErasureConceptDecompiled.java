package javaEight;
import java.util.ArrayList;


public class ErasureConceptDecompiled {
	  public ErasureConceptDecompiled() {}
	  
	  public static void main(String[] paramArrayOfString) throws java.io.IOException {
	    ArrayList localArrayList = new ArrayList();
	    localArrayList.add("a");
	    localArrayList.add("b");
	    System.out.println("println");
	    for (int i = 0; i < localArrayList.size(); i++)
	    {
	      String str = (String)localArrayList.get(i);
	      System.out.println(str);
	    }
	    
	    accept(localArrayList);

	    accept(localArrayList);
	  }
	  




	  public static void accept(ArrayList<? extends Object> paramArrayList)
	  {
	    for (Object localObject : paramArrayList) {
	      System.out.println(localObject);
	    }
	  }
	}