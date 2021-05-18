package knowledgeable.review201901.designPatterns.MVC;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-21
 * Time: 10:38:13
 * Description:
 */
public class Test
{
    public static void main(String[] args)
    {
        Student model = retriveStudentFromDatabase();

        StudentView view = new StudentView();
        StudentController studentController = new StudentController(model, view);

        studentController.updateView();
        studentController.setStudentName("Job");
        studentController.updateView();


    }

    private static Student retriveStudentFromDatabase()
    {
        Student student = new Student();
        student.setName("Aboot");
        student.setRollNo("100");
        return student;
    }
}
