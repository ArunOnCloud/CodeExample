class gen<T> {
	T data;
	gen()
	{
		data=null;
	}
    void setData(T a){
    	data=a;
    }
    T getData(){
    	return data;
    }
   void showType(){
	   System.out.println(data.getClass().getName());
   }
}
class Temp{
	Integer data;
    Temp(){
    	data=0;
    }
	void setData(Integer d){
		data=d;
		
	}
	Integer getData(){
		return data;
	}
	String getName()
	{
		return "Temp";
	}
	
}
public class generic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*gen<Integer> obj=new gen<Integer>();
		obj.setData(123);
       System.out.println(obj.data);
       obj.showType();*/
		gen<Temp> obj=new gen<Temp>();
		//obj.showType();

	}

}
