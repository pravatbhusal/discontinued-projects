package methods;

public class constructors {

	/* a constructor (has same name as the class)
	 * this constructor method enables us to initiate instance values within the class
	 * the constructor can also be declared multiple times with different parameters (overloading)
	 * the constructor may NOT have a return type
	 */
	int x;
	int num;
	static String name;
	public constructors() {
		x = 5;
		num = 0;
		name = "None";
	}
	//this overloads the original constructors() method with different parameters if this is called instead
	public constructors(int num) {
		System.out.println(num); //prints the number parameter
	}
	
	//this is an example of a class to be called in another class
	public void getName() {
		System.out.println(name);
	}
	
	//this sets the instance variable 'name' equal to the parameter 'name'
	public void setName(String name) {
		this.name = name;
	}
}
