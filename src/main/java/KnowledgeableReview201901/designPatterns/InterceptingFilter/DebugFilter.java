package KnowledgeableReview201901.designPatterns.InterceptingFilter;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-21
 * Time: 13:28:50
 * Description:
 */
public class DebugFilter implements Filter
{

    @Override
    public void execute(String request)
    {
        System.out.println("request log: "+request);
    }
}
