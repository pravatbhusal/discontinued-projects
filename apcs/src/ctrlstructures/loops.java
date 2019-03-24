package ctrlstructures;

public class loops {

	public static void main(String[] args) {
		
		/* the loop starts with i equaling to 1 (start statement)
		 * then the i <= 3 is checked and if it's true then the body is executed
		 * once the body is finished executing, the i++ statement is executed
		 * and then the loop repeats to the i <= 3 and repeats until i is NOT <= 3
		 */
		for(int i = 1; i <= 3; i++) { //this for loop will run 3 times
			System.out.println("For loop: " + i);
		}
		
		//nested for loops
		for(int i = 0; i < 3; i++) { //runs 3 times
			for (int j = 6; j > 0; j--) { //runs 6 times
				System.out.print("*"); //6 columns (use print statement)
			}
			System.out.println(); //3 rows (use println statement)
		}
		
		int i = 1;
		while(i <= 6) { //this loop will run 6 times
			System.out.println("While Loop: " + i);
			i++; /*increments i so that the loop is not infinite
			NOTE: this increment can be located anywhere inside the body, and 
			it won't make a difference*/
		}
	}
}
