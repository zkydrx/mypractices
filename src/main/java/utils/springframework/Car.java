package utils.springframework;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2018-08-08
 * Time: 20:25:57
 * Description:
 */
public class Car
{
    private String name;
    private BigDecimal price;
    private BigDecimal height;
    private BigDecimal weight;
    private String tradeMark;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getHeight()
    {
        return height;
    }

    public void setHeight(BigDecimal height)
    {
        this.height = height;
    }

    public BigDecimal getWeight()
    {
        return weight;
    }

    public void setWeight(BigDecimal weight)
    {
        this.weight = weight;
    }

    public String getTradeMark()
    {
        return tradeMark;
    }

    public void setTradeMark(String tradeMark)
    {
        this.tradeMark = tradeMark;
    }
}
