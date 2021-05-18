package Objectorvalue;

/**
 * Created by ZKY on 2017-07-06 18:49.
 */
public class TestProcess
{
    public static void main(String[] args)
    {
        Process process = new Process();
        int a = 18;
        System.out.println(a);
        process.function3(a);
        System.out.println(a);
        a = 18;
        process.function4(a);
        System.out.println(a);

        Car car = new Car("red");

        System.out.println(car);
        //        process.function1(car);
        process.function2(car);
        System.out.println(car);
    }
}
