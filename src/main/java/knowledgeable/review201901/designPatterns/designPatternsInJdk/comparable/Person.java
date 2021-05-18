package knowledgeable.review201901.designPatterns.designPatternsInJdk.comparable;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-06
 * Time: 10:58:13
 * Description:
 */
public class Person implements Comparable<Person>
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    public Person()
    {
    }


    @Override
    public String toString()
    {
        return String.format("{name=%s,age=%d}", name, age);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public int compareTo(Person o)
    {
        return name.compareTo(o.name);
    }
}
