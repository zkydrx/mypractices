package Objectorvalue;
/**
 * Created by ZKY on 2017-07-06 18:47.
 */
public class Process
{
    public void function1(Car car)
    {
        car.setColor("blue");
    }

    public void function2(Car car)
    {
        Car car1 =new Car("black");

        car = car1;
        car.setColor("orange");
    }

    public void function3(int a )
    {
        a = 2;
    }

    public void function4(int a)
    {
        int b = 6;
        a = b;
    }
}
