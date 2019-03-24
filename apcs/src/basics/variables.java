package basics;

public class variables {
	final String constantVar = "contant"; //the final keyword makes a variable a constant

	public static void main(String[] args) {
		//primitive variables (built-in and lowercase)
		int x = 1; /*integers and are whole numbers from -+2,147,483,648
		NOTE: if in any case an integer parses a double, it always rounds DOWN!
		ex: 1.75 will round to 1*/
		double y = 1.5; //doubles are any numbers 
		boolean True = true; //true boolean (Yes)
		boolean False = false; //false boolean (No)
		
		//reference variables (typically uppercase)
		String text = "Hello World"; //a reference datatype that contains text
		String newText = new String("Hello World"); //reference variables may also use the new keyword
		
		int z; //you may only declare variables
		z = 2; //you may initialize variables later on
		
		/* identifiers are NOT allowed to contain
		1. spaces
		2. starting with numbers
		3. using hyphens
		4. using operators, including modulus (%)
		5. using ^, &, *,(),#,@,!,`,~
		6. all english punctuations
		*/
	}
	private void castingValues() {
		double doubNum = Double.parseDouble("12.5"); //parses a string to a double
		int intNum = Integer.parseInt("12"); //parses a string to an integer
		String strDoubText = Double.toString(doubNum); //parses a double to string
		String strIntText = Integer.toString(intNum); //parses an integer to String
		double doubDown = 10.50;
		int intDown = (int) doubDown; //this casts a double into an integer, which rounds down to 10
	}
}
