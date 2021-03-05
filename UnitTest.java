//Lab 2 Anastasia Golev
import java.util.*;
import java.io.File;

public class UnitTest {

	//Scanner variable input is a Scanner object
	Scanner input = new Scanner(System.in);
	
	//create an ArrayList<String> variable answers that represents the correct answers on the exam
	ArrayList<String> answers = new ArrayList<String>();
	
	//constructor reads from the file "answers.txt" which represents the correct answers for the exam.
	public UnitTest() {
		try {
			input = new Scanner(new File("/Users/anastasiagolev/Documents/eclipse-workspace/Lab2_Class Assignment/src/answers.txt"));
		}catch( Exception e) {
			System.out.println("Something awful happened when trying to read the file!");
			e.printStackTrace();
			System.exit(0);//closes the program
		}
		//while loop will add the correct answers from text file to ArrayList answers.
		while (input.hasNext()) {
			answers.add(input.next());
		}
	}
	
	//method calculateGrade takes an ArrayList of Strings as a parameter
	//The ArrayList has all of the Students answers for their exam. calculateGrade
	//compares the answers, if they're equal, counts them as correct. the methods 
	//returns a percerntage as a double in the range [0.0 ... 100.0]
	public double calculateGrade( ArrayList<String> studentAnswers) {
		//double variable final grade holds the final grade of the students beggining with 100.0
		double finalGrade = 100.0;
		
		//double wrongAnswerCounter is a counter variable that will subtract 10.0 for every wrong answer
		double wrongAnswerCounter = 10.0;
		
		//compare the correct answers with the student answers
		for ( int i = 0; i< studentAnswers.size(); i++) {
			
			//if a student's answer for a question is incorrect, finalGrade variable will be subtracted
			//by wrongAnswerCounter
			if (!answers.get(i).equals(studentAnswers.get(i))) {
				finalGrade-=wrongAnswerCounter;
			}//else correct answer and score stays the same
		}
		return finalGrade;
	}
}
 