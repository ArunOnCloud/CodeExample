
class ExecutDemo {
	public static void main(String args[]) {
		Runtime r = Runtime.getRuntime();
		Process p = null;
		try {
			p = r.exec("notepad");
			p.waitFor();
			System.out.println("Thank you");
		} catch (Exception e) {
			System.out.println("Error executing notepad.");
		}
		
	}
}