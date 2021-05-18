package knowledgeable.review201901.designPatterns.InterceptingFilter;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-21
 * Time: 13:27:56
 * Description:
 */
public class AuthenticationFilter implements Filter
{

    @Override
    public void execute(String request)
    {
        System.out.println("Authenticating  request:" + request);
    }
}
