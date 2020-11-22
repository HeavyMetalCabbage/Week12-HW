import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Serialization {

	
	public static void main(String[] args) {
		Scanner inp = new Scanner(System.in);
		Person p1 = new Person();
		int choice;
		String redo;
		
		System.out.println("What would you like to do?");
		System.out.println("Enter 1 to Add to file");
		System.out.println("Enter 2 to Read file");
		System.out.println("Enter 3 to Delete information");
		System.out.println("Enter 4 to Update Information");
		System.out.println("Enter 5 to Exit");
		
		choice = inp.nextInt();
		

			switch(choice) {
			case 1: 
				System.out.println("Please enter in all information in order: Name, Phone Number ");
				System.out.println(", Birthday, and E-Mail address.");
				p1.name = inp.next();
				p1.phonenumber = inp.next();
				p1.bday = inp.next();
				p1.email = inp.next();
		
					try {
						writeToFile(p1);
					} catch (IOException e) {
						e.printStackTrace();
					}
					break;
			case 2: try {
					readFile();
				} catch (ClassNotFoundException | IOException e) {
				
					e.printStackTrace();
				}
					break;
			case 3:
				System.out.println("What would you like to delete?");
				redo = inp.next();
				if(redo.equalsIgnoreCase("Name"))
				{
					System.out.println("Name Deleted");
					p1.setName(null);
					try {
						writeToFile(p1);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
				}
			
				else if(redo.equalsIgnoreCase("PhoneNumber"))
				{
					System.out.println("Phone Number Deleted");
					p1.name = p1.name;
					p1.bday = p1.bday;
					p1.email = p1.email;
					p1.phonenumber = null;
				}
			
				else if(redo.equalsIgnoreCase("Birthday"))
				{
					System.out.println("Birthday Deleted ");
					p1.name = p1.name;
					p1.bday = null;
					p1.email = p1.email;
					p1.phonenumber = p1.phonenumber;
				}
			
				else if(redo.equalsIgnoreCase("Email"))
				{
					System.out.println("email address deleted");
					p1.name = p1.name;
					p1.bday = p1.bday;
					p1.email = null;
					p1.phonenumber = p1.phonenumber;
				}
				
			
				

				break;
			case 4:
				System.out.println("What would you like to update?");
				redo = inp.next();
				if(redo.equalsIgnoreCase("Name"))
				{
					System.out.println("Please re-enter the name:");
					p1.name = inp.next();
				}
				
				else if(redo.equalsIgnoreCase("PhoneNumber"))
				{
					System.out.println("Please re-enter the phone number");
					p1.phonenumber = inp.next();
				}
				
				else if(redo.equalsIgnoreCase("Birthday"))
				{
					System.out.println("Please re-enter the Birthday: ");
					p1.bday = inp.next();
				}
				
				else if(redo.equalsIgnoreCase("Email"))
				{
					System.out.println("Please re-enter the email address");
					p1.email = inp.next();
				}

				try {
					writeToFile(p1);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
					

			case 5: return;
				}
			
		}
		
		
	
	public static void writeToFile(Person p) throws IOException
	{
		ObjectOutputStream objOut = new ObjectOutputStream(new FileOutputStream("Person.bin"));
		
		objOut.writeObject(p);
	}
	
	public static void readFile() throws  IOException, ClassNotFoundException
	{
		ObjectInputStream objInp = new ObjectInputStream(new FileInputStream("Person.bin"));
		
		Person p2 = (Person) objInp.readObject();
		System.out.println(p2);
		
	}

}


