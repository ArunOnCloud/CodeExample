package ConceptImplementation;

public class SimpleOverridingConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal a=new Dog();
		a.getInstance();

	}

}

class Animal{
	public Animal getInstance() {
		System.out.println("ANimal called");
		return this;
	}
}

class Dog extends Animal{
	@Override
	public Dog getInstance() {
		System.out.println("dog called");
		return this;
	}
}
