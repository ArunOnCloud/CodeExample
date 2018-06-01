package interviewbit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RepeatAndMissingNumberArray {

	public static void main(String[] args)throws Exception {
	  
		//writeInput();
		Scanner sc = new Scanner(new File("C:/Users/arunram/Desktop/temp/input.txt"));
		int n=sc.nextInt();
		List<Integer> list=new ArrayList<Integer>(n);
		for(int i=0;i<n;i++)
		{
			int temp=sc.nextInt();
			list.add(temp);
			
		}
		repeatedNumber(list);
		
		
	}
	
	public static void writeInput() throws Exception
	{
		FileWriter fw=new FileWriter(new File("C:/Users/arunram/Desktop/temp/input.txt"));
		int n=100000;
		fw.write(""+n);
		for(int i=1;i<n;i++)
		{
			fw.write(" "+i);
		}
		fw.write(" "+(n-1));
		fw.flush();
	}
    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        
        Long actual=0l;
        for(int i=0;i<A.size();i++)
        {
            actual+=Long.parseLong(A.get(i).toString());
        }
        Long actualS=0l;
        for(int i=0;i<A.size();i++)
        {
            Integer mul=A.get(i);
            Long temp=Long.parseLong(mul.toString());
            Long temp1=temp*temp;
            actualS+=Long.parseLong(temp1.toString());
        }
        Integer n=A.size();
        System.out.println("n:"+n);
        Long ln=Long.parseLong(n.toString());
        Long sumLong=(ln*(ln+1))/2;
        Long sumSLong=(((ln*(ln+1))/2l)*(2*ln +1))/3l;
       // Long sumSLong=(((ln*ln*ln)/3l) + ((ln*ln)/2l) + (ln/6l));
         System.out.println("sumSLong:"+sumSLong);
         System.out.println("sumLong:"+sumLong);
         System.out.println("actualS:"+actualS);
        Long plusSum=(sumSLong-actualS)/(sumLong -actual);
         System.out.println("plusSum:"+plusSum);
         System.out.println("(sumLong -actual):"+(sumLong -actual));
         System.out.println("(sumSLong-actualS):"+(sumSLong-actualS));
        Long m,r;
        m=((sumLong -actual)+plusSum)/2;
        r= (plusSum-(sumLong -actual))/2;
        System.out.println("m:"+m);
        System.out.println("r:"+r);
        
        ArrayList<Integer> res=new ArrayList<Integer>();
        res.add(r.intValue());
         res.add(m.intValue());
        //res.add(Integer.parseInt(r.toString()));
       // res.add(Integer.parseInt(m.toString()));
        
        return res;
        
        
    }


}
