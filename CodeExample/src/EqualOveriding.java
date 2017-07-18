public class EqualOveriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p=new Person();
		p.setId(1);
		p.setFirstName("arun");
		p.setLastName("ram");
		Person q=new Person();
		q.setId(1);
		q.setFirstName("aru");
		q.setLastName("ram");
		if(p.equals(q))
		{
			System.out.println("true");
			
		}else
		{
			System.out.println("false");
			//System
		}

	}

}

class Person {
	private int id;
	private String firstName;
	private String lastName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Person guest = (Person) obj;
		return id == guest.id
				&& (firstName == guest.firstName || (firstName != null && firstName
						.equals(guest.getFirstName())))
				&& (lastName == guest.lastName || (lastName != null && lastName
						.equals(guest.getLastName())));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + id;
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}
}
