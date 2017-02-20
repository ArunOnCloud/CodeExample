
class PBDemo {
	public static void main(String args[]) {
		try {
			ProcessBuilder proc = new ProcessBuilder("notepad.exe", "testfile");
			proc.start();
			//proc.wait();
			proc.command();
		} catch (Exception e) {
			System.out.println("Error executing notepad.");
		}
		System.out.println("finish executing notepad.");
		System.out.println(System.getProperty("user.dir"));
	}
}