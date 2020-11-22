import java.io.Serializable;
public class Person implements Serializable {
	String name;
	String email;
	String bday;
	String phonenumber;
	
	
	public Person() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getBday() {
		return bday;
	}


	public void setBday(String bday) {
		this.bday = bday;
	}


	public String getPhonenumber() {
		return phonenumber;
	}


	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}


	@Override
	public String toString() {
		return "Person  Name = " + name + ", Email = " + email + ", Birthday = " + bday + ", Phone Number =" + phonenumber;
	}
	
	
	
	

}
