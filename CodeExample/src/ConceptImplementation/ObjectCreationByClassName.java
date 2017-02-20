package ConceptImplementation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ObjectCreationByClassName {
	ObjectCreationByClassName(String str){
		System.out.println("constructor called");
	}
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		// TODO Auto-generated method stub
		Class<?> clazz=ObjectCreationByClassName.class;
		//Class<?> clazz=Class.forName();
		Constructor<?> ctor = clazz.getConstructor(String.class);
		//Object object = ctor.newInstance(new Object[] { ctorArgument });
		Object object = ctor.newInstance("man");

	}

}
