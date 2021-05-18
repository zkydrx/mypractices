package fromeFaceBook.JavaProgramming.StaticClasses;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-02
 * Time: 01:42
 * Description:
 * <p>
 * he difference between static and instance variables
 * Here is the link to the answer explanation: http://www.sarmaroof.com/java-quiz-3-the-difference-betwee…/
 */
public class MyClass
{
    int x;
    static int y;

    MyClass(int i)
    {
        x += i;
        y += i;
    }

    public static void main(String[] args)
    {
        /**
         * the static value will be changed in the first time
         */
        new MyClass(2);
        /**
         * now the static value will be reload last time.
         */
        MyClass mc = new MyClass(3);

        System.out.println(mc.x + "," + mc.y);
    }
}
