package ConceptImplementation;

public class PassByValueConcept {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair a=new Pair();
		a.x=10;
		a.y=5;
		Pair b=new Pair();
		b.x=100;
		b.y=50;
		System.out.println("A:"+a);
		
		System.out.println("B:"+b);
		swap(a,b);
        System.out.println("A:"+a);
		
		System.out.println("B:"+b);
		
		swapContent(a,b);
         System.out.println("A:"+a);
		
		System.out.println("B:"+b);

	}
	public static void swap(Pair p,Pair q)
	{
		Pair temp=p;
		p=q;
		q=temp;
		
	}
	public static void swapContent(Pair p,Pair q)
	{
		Pair temp=new Pair();
		temp.x=p.x;
		temp.y=p.y;
		p.x=q.x;
		p.y=q.y;
		q.x=temp.x;
		q.y=temp.y;

	}

}

class Pair{
	int x;
	
	int y;
	Pair(){
		x=0;
		y=0;
	}
	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
}
