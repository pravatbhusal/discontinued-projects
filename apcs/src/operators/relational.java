package operators;

public class relational {

	public static void main(String[] args) {
		/* These operators are only usable for PRIMITIVE types and their reference types
		 * > = greater than
		 * < = less than
		 * >= = greater than or equal to
		 * <= = less than or equal to
		 * == = equal to comparision
		 * != = not equal to comparision
		 */
		
		int x = 5;
		int y = 6;
		System.out.println(x > y); //outputs false since 5 is not greater than 6
		System.out.println(x == y); //outputs false since 5 is not equal to 6
		System.out.println(x <= y); //outputs true since 5 is less or equal to 6
	}
}
