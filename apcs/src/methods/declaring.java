package methods;

public class declaring {

	//so far until now we've only focused on the main() method
	public static void main(String[] args) {
		System.out.println(name()); //prints "Hello World" since that's the return value
		test("Goodbye World!");
	}
	
	//a private static method that returns a string
	private static String name() { //it's static so we can run in the main() method
		return "Hello World";
	}
	
	//a public static method that is void (void means it does not return anything)
	//it also contains a parameter which can be passed from the method call
	public static void test(String text) {
		System.out.println(text); //prints the parameter
	}
}
