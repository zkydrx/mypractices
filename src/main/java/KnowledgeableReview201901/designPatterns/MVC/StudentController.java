package KnowledgeableReview201901.designPatterns.MVC;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-21
 * Time: 10:30:48
 * Description:
 * Controller
 */
public class StudentController
{
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view)
    {
        this.model = model;
        this.view = view;
    }

    public void setStudentName(String name)
    {
        model.setName(name);
    }

    public String getStudentName()
    {
        return model.getName();
    }

    public void setStudentRollNo(String rollNo)
    {
        model.setRollNo(rollNo);
    }

    public String getStudentRollNo()
    {
        return model.getRollNo();
    }

    public void updateView()
    {
        view.printStudentDetails(model.getName(),model.getRollNo());
    }


}
