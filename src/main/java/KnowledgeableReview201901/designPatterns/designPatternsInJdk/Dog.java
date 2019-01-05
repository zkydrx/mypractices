package KnowledgeableReview201901.designPatterns.designPatternsInJdk;

import java.util.Objects;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-05
 * Time: 16:50:04
 * Description:
 */
public class Dog implements Cloneable
{
    private Long id;
    private String name;
    private String age;
    private String color;
    private String weight;

    public Dog()
    {
    }

    public Dog(Long id, String name, String age, String color, String weight)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.color = color;
        this.weight = weight;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getAge()
    {
        return age;
    }

    public void setAge(String age)
    {
        this.age = age;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getWeight()
    {
        return weight;
    }

    public void setWeight(String weight)
    {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        Dog dog = (Dog) o;
        return Objects.equals(id, dog.id) && Objects.equals(name, dog.name) && Objects.equals(age, dog.age) &&
                Objects.equals(color, dog.color) && Objects
                .equals(weight, dog.weight);
    }

    @Override
    public int hashCode()
    {

        return Objects.hash(id, name, age, color, weight);
    }

    @Override
    public String toString()
    {
        return "Dog{" + "id=" + id + ", name='" + name + '\'' + ", age='" + age + '\'' + ", color='" + color + '\'' +
                ", weight='" + weight + '\'' + '}';
    }
}
