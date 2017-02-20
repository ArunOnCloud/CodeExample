package PhoneticalySimilarWords;

import java.io.PrintWriter;

public class UnderstandingSwitch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bacdef";
		char[] c = s.toCharArray();
		PrintWriter pw = new PrintWriter(System.out, true);
		for (int i = 0; i < c.length; i++) {
			char ch = c[i];
			switch (ch) {
			case 'a': {
				pw.println("in a");
				//break;
			}
			case 'b': /*{
				pw.println("in b");
				//break;
			}*/
			case 'c': {
				pw.println("in c");
				break;
			}
			case 'd': {
				pw.println("in d");
				break;
			}
			}
		}

	}

}
