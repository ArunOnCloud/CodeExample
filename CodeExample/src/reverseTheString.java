
public class reverseTheString {
	public static String reverse(String s){
	   String rev="";
	   for(int i=s.length()-1;i>=0;i--)
	   {
		   String temp=s.substring(i,i+1);
		   //System.out.println(temp);
		   rev=rev.concat(temp);
	   }
	   return rev;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="abcdefgh";
		String rev=reverse(s);
		System.out.println(rev);
		

	}

}
