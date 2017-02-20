
public class classObjPassing {
	public static void main(String args[]){
          test obj=new test();
          test obj1=new test();
          obj.a=1;
          obj.b=12;
          System.out.println(" before modifiction a:"+obj.a+" b:"+obj.b);
          obj1.modify(obj);
          System.out.println("modifiction a:"+obj.a+" b:"+obj.b);
	}
	

}
class test{
	public int a;
	public int b;
	test(){
		a=2;
		b=3;
	}
	public void modify(test obj){
		a=obj.a+obj.b;
		b=obj.a;
		obj.a=33;
		obj.b=54;
	}
}
