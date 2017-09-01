package CollectionExamples;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ComparatorExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random=new Random();
		System.out.println(random.nextInt());
		List<Student> list=new LinkedList<Student>();
		for(int i=0;i<4;i++)
		{
			Student s=new Student();
			s.id=random.nextInt();
			s.name="Arun"+i;
			s.cgpa=random.nextDouble();
			list.add(s);
		}
		System.out.println(list);
		StudentComparator studentComparator=new StudentComparator();
		Collections.sort(list,studentComparator);
		System.out.println(list);
		

	}

}
class Student{
	int id;
	
	String name;
	double cgpa;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", cgpa=" + cgpa + "]\n";
	}
	
}
class StudentComparator implements Comparator<Student>{
	
	public int compare(Student s1,Student s2)
	{
		//return s1.id -s2.id;
		
		return s1.name.compareTo(s2.name);
	}
//	public boolean equals(Student s)
//	{
////		if(this.id == s.id)
////		{
////			return true;
////		}else
////		{
////			return false;
////		}
//		
//		return true;
//	}
}