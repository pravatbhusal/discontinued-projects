package keywords;

public class encapsulation {

	//how objects may control their data through encapsulation
	private int x = 5; //only this class has access to the variable x
	public int y = 5; //all classes that import this class has access to variable y
	public static int z = 5; /* all classes that import this class has access to
	variable z. the value of z is the same for every object and any change for value
	of z will change every other object's value of z.*/
	
	
	/* NOTE: static methods cannot use instance variables that are non-static
	 * However, non-static methods may use instance variables that are static and non-static
	 */
	public static void main(String[] args) {
	}
}
