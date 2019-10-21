package machinecoding;

import java.util.LinkedList;
import java.util.List;

public class UserManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
   private	List<User> userList=new LinkedList<>();
   private int userCounter;
   
   public void addUser(String name) {
	   User user =new User();
	   user.setId(userCounter);
	   user.setName(name);
	   userList.add(user);
	   userCounter++;
   }
   public User getUserByName(String name) {
	   for(User user: userList) {
		   if(user.getName().equalsIgnoreCase(name)) {
			   return user;
		   }
	   }
	   return null;
   }
   

}
