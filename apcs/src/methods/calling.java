package methods;

public class calling {

	public static void main(String[] args) {
		constructors test1 = new constructors(); //creating new contructors class with 0 parameters
		test1.getName(); //calling the getName() class, which prints "None"
		test1.setName("Bob");
		
		constructors test2 = new constructors(5); /*creating new contructors 
		class with 1 parameter. this prints out your parameter*/
		test2.getName(); //calling this method prints "Bob" since the 'name' variable was static
	}
}
