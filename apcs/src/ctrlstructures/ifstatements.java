package ctrlstructures;

public class ifstatements {

	public static void main(String[] args) {
		int x = 2;
		
		if(x == 2) { //a boolean will return the if() parameter
			//if the boolean was true, then the if() {} body will be executed
			System.out.println("The boolean was true!");
		} else if(x == 3){ /*you can also include else if statements to executive when the boolean was false
			and check if another statement is true instead */
			System.out.println("The boolean originally was false, but this one is true!");
		} else { //if nothing was true, then execute this statement
			System.out.println("Everything was false.");
		}
		/*if any of the statements in the if(), else if(), or else statements are executed
		then the other bodies won't be executed*/
		
		if(x == 2 && x == 3) { //nested if statement to check multiple booleans
			System.out.println("x is equal to 2 and 3, weird...");
		}
		
		if(x == 2) //if statements can be used without {} if its just one line
			System.out.println("This if() requires no {} because it uses one line!");
		else //the same scenario can be done with the else without any {}
			System.out.println("The else statement without {}");
	}
}
