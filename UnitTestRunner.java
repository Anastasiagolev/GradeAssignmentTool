//Lab 2 Anastasia Golev

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
public class UnitTestRunner {

	public static void main(String[] args) {
	
		// TODO Auto-generated method stub

		//create an instance of UnitTest called test1
		UnitTest test1 = new UnitTest();

		//create a Scanner variable
		Scanner input1 = new Scanner(System.in);
		
		//read in students information from the file allExams.txt
		try {
			input1 = new Scanner(new File("/Users/anastasiagolev/Documents/eclipse-workspace/Lab2_Class Assignment/src/allExams.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File cannot be found.");
			e.printStackTrace();
			System.exit(0);//closes the program	
		}
		
		//create a String variable called concatinated to hold the concatinated versions of Student's names
		String concatinated = null;
		
		//create an ArrayList of Students
		ArrayList<Student> theStudents = new ArrayList<Student>();

		//while loop to traverse the text file allExams.txt 
		while (input1.hasNext()) {
	
			//create an ArrayList of Strings that will reset with even line (every student)
			//this will save the next students answers to a new ArrayList
			ArrayList<String> allAnswers = new ArrayList<String>();
			
			//create and assign String variable line to be a line of input1 associated with a student
			String line = input1.nextLine();
			
			//split by first instance of space and then last space 
			String[] info = line.split("\\s");
			
			//create and assign String variable lastName to hold last name of student associated with info[0]
			String lastName = info[0];
			
			//create and assign String variable firstName to hold first name of student associated with info[1]
			String firstName = info[1];
	
			//put to lowercase and concatinate
			concatinated =lastName.toLowerCase() + firstName.toLowerCase();
		
			//add student's answers into the arrayList allAnswers (one student/line at a time)
			for (int i = 2; i < info.length; i++) {
				allAnswers.add(info[i]);
			}
		
			//create Student objects using the last name and first name String objects read from the file
			Student student = new Student(lastName, firstName);
			
			//add student to theStudent arrayList
			theStudents.add(student);
		
			
			//create a HashMap of type <String, ArrayList<String>> called testMap
			//the String key must be the concatenation of a student's last name followed by their first name, 
			//with no spaces and in lower case. The value to put into the HashMap is their ArrayList<String> answers
			HashMap<String, ArrayList <String>> testMap= new HashMap<String, ArrayList<String>>();
			testMap.put(concatinated, allAnswers);
			
			//traversing ArrayList of Student objects to get the answers from the HashMaps
			//using calculateGrade method from the UnitTest object to grade the Student's exams
			//iterate through map
			for (Map.Entry<String, ArrayList<String>> entry : testMap.entrySet()) {
				//using mutator method for average in the Student object to save the grade as the average
				student.setAverage(test1.calculateGrade(entry.getValue()));
			
			}

			//print all of the Student's names and their grade 
			System.out.println(student.getFirstName() + " " + student.getLastName() + " " + student.getAverage()) ;
			
		}		
	}

} 

/* Current Output
 
Christian Tobacco 100.0
James Russo 30.0
John Smith 30.0
James Henderson 30.0
Michael Russo 20.0
John DeMartino 80.0
Frank Scafuri 80.0

*/

/* Additional Question 
 * 
 * 		UnitTest could be modified to be more specific to exams. For this exam, 
 * there are only 10 questions and each question hold a weight of 10 points.
 * One way to modify UnitTest could be to assign individual weights to question. Or in
 * the case of a exam where there are more questions, to have a variable that calculates
 * a uniformly weighed variable based on the number of questions in the exam 
 * to calculate the grade.
 * 		Another method in UnitTest that may be useful to teachers would be a function to
 * compare the students exams to one another; this would aid in catching possible 
 * instances of cheating. Although it wouldn't be accurate to assume that all instances
 * of the same scores are evidence of cheating, but if the instructor had a suspicion 
 * of a case of cheating, this method could help confirm or deny it. In addition to this,
 * another method to add to UnitTest could be one that exports the students data, their 
 * names and test scores for exams, into an excel file for better organization. For the 
 * reverse, a method that imports data from an excel file could also be beneficial to
 * an instructor. This method would import the scores of mutliple exams and return a 
 * final grade for that student based on all the exams they have completed that year, 
 * or semester. 
 * 
 */
