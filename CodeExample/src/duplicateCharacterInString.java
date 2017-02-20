/*
 * author: Arun Kumar Ram
 * date:16 june 2015
 */
public class duplicateCharacterInString {
	public static void duplicateCharacter(String s){
		int[] arr=new int[127];
		for(int i=0;i<127;i++)
		{
			arr[i]=0;
		}
	   for(int i=0;i<s.length();i++)
	   {
		   char c=s.charAt(i);
		   int ind=c-' ';
		   arr[ind]++;
	   }
	  // now arr index value with more than one will be duplicate value
	   for(int i=0;i<127;i++)
	   {
		   //char c;
		   if(arr[i]>1)
		   {
			   
			   System.out.print((char)(i+' '));
		   }
	   }
	   System.out.println();
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
           String s="sathu ## hareesh ";
           duplicateCharacter(s);
	}

}
