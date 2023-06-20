package knowledgeable.review201803.designPatterns.MVC;

/**
 * Created with IntelliJ IDEA. Author: Abbot Date: 2018-03-21 Time: 10:28:25
 * Description: view
 */
public class StudentView {
	public void printStudentDetails(String studentName, String studentRollNo) {
		System.out.println("Student: ");
		System.out.println("Name: " + studentName);
		System.out.println("Roll No: " + studentRollNo);
	}
}
