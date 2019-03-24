package operators;

public class logical {

	public static void main(String[] args) {
		/*
		 * && = checks if the multiple statements are all true or false
		 * || = checks if one statement is true or false from multiple statements
		 * ! = not operator, checks if the opposite is true
		 */
		
		int x = 5;
		System.out.println(x > 3 && x == 5); /*checks if x is greater than 3
		and it is equal to 5, and this actually returns true*/
		
		//short-circuit evaluation ||
		System.out.println(1 == 1 || 2 == 3 || 4 == 4); /*in this evaluation, since 1 is equal to 1 then there is no need to
			evaluate the rest of the if statement from the 'or' operators
			, so the circuit returns true*/
		
		//short-circuit evaluation &&
		System.out.println(1 == 2 && 1 == 1); /*in this evaluation, once we see that the first statement is false,
			 * then the rest of the statements are not considered due to the
			 * 'and' operators, so the circuit returns false
			 */
		
		//short-circuit evaluation with an && and || (study the orderofopp class)
		System.out.println(1 == 1 && 2 == 3 || 4 == 3); /*this will also be short-circuit since the && compares the left and right
			 * statements only and not the entire statement, so the circuit returns false due
			 * to a short-circuit with the first statement
			 */
	}
}
