package ConceptImplementation;

public class InheritaceOveriridingConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InheritaceOveriridingConcept obj=new InheritaceOveriridingConcept();
		Base base=obj.new Base();
		base.run();
		 base=obj.new Child();
		 base.run();

	}
	private class Base{
		public void run() {
			System.out.println("Base run method");
			identity();
		}
		protected void identity() {
			System.out.println("Base identity class");
		}
	}
	private class Child extends Base{
		public void run() {
			System.out.println("Child run method");
			identity();
		}
		protected void identity() {
			System.out.println("Child identity class");
		}
	}

}
 
