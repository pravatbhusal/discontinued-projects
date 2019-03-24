package operators;

public class arithmetic {

	public static void main(String [] args) {
		/*
		 * + = addition
		 * - = subtract
		 * / = divide (NOTE: 6 / 4 will equal to 1 since it is dividing integers)
		 * * = multiply
		 * % = modulus (remainder)
		 * += = addition and equal to
		 * -= subtraction and equal to
		 * /= = division and equal to
		 * *= = multiplication and equal to
		 * %= modulus and equal to
		 */
		
		//increment and decrements
		int x = 5 * 4; //returns 20
		x ++; //increments to 21 but outputs 20
		x --; //decrements to 20 but outputs 21
		++ x; //increments to 21 and outputs 21
		-- x; //decrements to 21 and outputs 21
		
		//modulus rules
		int y = 5 % 3; //returns 2, which is the remainder of 5 and 3
		y = 1 % 3; //returns first number (1), since this division cannot return a remainder
		y = 3 % 3; //returns 0 since there's no remainder
		
		//assignment operators
		int z = 5;
		z += 5; //z now equals to 10 (same thing as saying z = z + 5)
		z %= 3; //z now equals to 1 (same thing as saying z = z % 3)
	}
}
