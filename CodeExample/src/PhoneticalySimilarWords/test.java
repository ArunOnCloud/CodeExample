package PhoneticalySimilarWords;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        
		//GenerateStringSampleFour test = new GenerateStringSampleFour();
		//GenerateStringSampleFive test = new GenerateStringSampleFive();
		GenerateStringSampleSix test = new GenerateStringSampleSix();
		int top = 20;
		String[] arr = test.genPhoneticalyString("city", top);
		for (String val : arr) {
			System.out.println(val);
		}
        System.out.println("size:"+arr.length);
		/*double f=0.80;
		double s=0.85;
		int ind=Double.compare(s, f);
		System.out.println("com:"+Double.compare(s, f));*/
		String str = "monday";
		System.out.println("substring:" + str.substring(1, 5));
	}

}
