package fromeFaceBook.JavaProgramming.ExtendsClasses;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-08
 * Time: 09:45
 * Description:
 */
public class MySub extends MySuper
{
    int b =3;
    void myMethod()
    {
        System.out.println("y"+b);
    }

    public static void main(String[] args)
    {
        MySub mySub =new MySub();
    }
}
