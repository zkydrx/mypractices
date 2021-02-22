package knowledgeable.review201901.java.interfaces;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-15
 * Time: 13:11:56
 * Description:
 */
public interface Things extends Alienware,Apple,Computer
{
    String go();
    String look();

    static void main(String[] args)
    {
        System.out.println("test interface.");
    }
}
