package KnowledgeableReview201901.java.interfaces;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-15
 * Time: 13:04:42
 * Description:
 */
public class HighPerFormanceComputer
{
    private String name;
    private String price;
    private Long cpus;

    public HighPerFormanceComputer()
    {
    }

    public HighPerFormanceComputer(String name, String price, Long cpus)
    {
        this.name = name;
        this.price = price;
        this.cpus = cpus;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPrice()
    {
        return price;
    }

    public void setPrice(String price)
    {
        this.price = price;
    }

    public Long getCpus()
    {
        return cpus;
    }

    public void setCpus(Long cpus)
    {
        this.cpus = cpus;
    }


    @Override
    public String toString()
    {
        return "HighPerFormanceComputer{" + "name='" + name + '\'' + ", price='" + price + '\'' + ", cpus=" + cpus + '}';
    }
}
