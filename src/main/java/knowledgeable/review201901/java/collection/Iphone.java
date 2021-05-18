package knowledgeable.review201901.java.collection;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-15
 * Time: 22:04:10
 * Description:
 */
public class Iphone implements Comparable<Iphone>, Serializable
{
    private static final long serialVersionUID = -2553740936632558776L;
    private int id;
    private int age;
    private String name;

    public Iphone()
    {
    }

    public Iphone(int id, int age, String name)
    {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Iphone{" + "id=" + id + ", age=" + age + ", name='" + name + '\'' + '}';
    }

    @Override
    public int compareTo(Iphone o)
    {
        if (this.age - o.age == 0)
        {
            return o.id - this.id;
        }
        return this.age - o.age;
    }


}
