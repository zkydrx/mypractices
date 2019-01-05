package KnowledgeableReview201901.designPatterns.Singleton;

/**
 * Created with IntelliJ IDEA.
 * Author: Abbot
 * Date: 2018-03-19
 * Time: 21:35:02
 * Description:
 */
public class Test
{
    public static void main(String[] args)
    {
        SingletonOne.getInstance().testPrint();
        SingletonTwo.getInstance().testPrint();
        SingletonThree.getInstance().testPrint();
        SingletonFour.getInstance().testPrint();
        SingletonFive.getInstance().testPrint();
        SingletonSix.INSTANCE.testPrint();
    }
}
