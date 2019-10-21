package hackerearth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortingArrayOfStringByLength {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        CusString[] cusStrings=new CusString[N];
        for(int i=0;i<N;i++)
        {
        	line=br.readLine();
        	line=line.trim();
        	CusString cusString=new CusString();
        	cusString.data=line;
        	cusStrings[i]=cusString;
        }
        Arrays.sort(cusStrings);
        for(int i=0;i<N;i++)
        {
        	System.out.println(cusStrings[i].data);
        }
         

	}

}
class CusString implements Comparable<CusString>{
	public String data;
	public int compareTo(CusString cusData)
	{
		
		return this.data.length()-cusData.data.length();
	}
}
