//Anastasia Golev

/* Student class has 3 private members to gather a student's data, such as name and grade average. 
* It includes 2 constructors, a default constructor and a 2 parameter constructor to create a student 
* based on user input. The class also has get methods for the private member variables and a set method
* for the average */

public class Student {

	private String lastName; //String variable to hold last name of student
	private String firstName; //String variable to hold first name of student
	private double average; //double variable to hold the average score of student
	
	//default constructor 
	public Student() {
		lastName = "Golev";
		firstName = "Anastasia";
		average = 0; //initial average of all Student objects is 0
	}
	
	//two param constructor to initialize firstName and lastName
	public Student( String nLastName, String nFirstName ) {
		lastName = nLastName;
		firstName = nFirstName;
		average = 0; //initial average of all Student objects is 0
	}
	
	//accessor methods for lastName and firstName
	public String getLastName() {
		return lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	
	//acessor method for average
	public double getAverage() {
		return average;
	}
	//mutator methods for average
	public void setAverage( double nAvg ) {
		average = nAvg;
	}
}
 
