package knowledgeable.review201901.designPatterns.InterceptingFilter;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-21
 * Time: 13:29:27
 * Description:
 */
public class Target
{
    public void execute(String request)
    {
        System.out.println("Executing request: "+request);
    }
}
