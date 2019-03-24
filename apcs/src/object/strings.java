package object;

public class strings {

	//EVERY reference datatype extends the Object class (the superclass), including String
	public static void main(String[] args) {
		Object set = new Object(); //this creates a new Object equal to Bob
		set = "Bob";
		String name = set.toString(); //any object can be converted to a string with toString()
		
		name = "Happy"; //now the value of name is equal to Happy
		
		name = name + " Man"; //now the value of name is equal to "Happy Man" (this is called concatentation)
		
		int length = name.length(); //returns the number of characters in the string (returns 9)
		
		name = name.substring(0, 5); //returns the string from index 0 to 4 (returns 'Happy')
		
		name = name.substring(3); //returns the string from index 3 and forward (returns py)
		
		int index = name.indexOf("p"); //returns index where the first 'p' is in the string (returns 0), if it's not there then it returns -1
		
		char charAt = name.charAt(0); //returns the character at index of 0, (returns 'p')
		
		boolean equals = name.equals("py"); /*CASE-SENSITIVE and returns true if name equal to 'py' (returns true)
		we may NOT use the == since for reference variables the == is used to locate data in memory (pointers), NOT its value
		the == is only used for primitive types, and you may NOT use equals() for reference types*/
		
		int compare = name.compareTo("he"); /* checks which string is in alphabetical order.
		if the return value is less than 0, then 'name' is before the parameter in a dictionary
		if the return value is greater 0, then 'name' is after the parameter in a dictionary
		if the return value is equal to 0, then name and the parameter are equal
		the current compare variable equals to 8, but if we switched the 'name' and parameter location then it would be equal to -8
		*/
		System.out.println(compare);
	}
}
