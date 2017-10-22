package objectorvalue;

/**
 * Created by ZKY on 2017-07-06 18:52.
 */
public class Car
{
    private String color;

    public Car(String color)
    {
        this.color = color;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    @Override
    public String toString()
    {
        return "Car{" + "color='" + color + '\'' + '}';
    }
}
