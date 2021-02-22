package knowledgeable.review201901.designPatterns.proxy;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-22
 * Time: 09:34:49
 * Description:
 */
public class Test
{
    public static void main(String[] args)
    {
        Image image = new ProxyImage("BeautyGirl.jpg");
        image.display();
    }
}
