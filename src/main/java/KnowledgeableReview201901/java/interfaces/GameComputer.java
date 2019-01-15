package KnowledgeableReview201901.java.interfaces;

import cn.hutool.core.date.DateUtil;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-15
 * Time: 13:02:59
 * Description:
 */
public abstract class GameComputer extends HighPerFormanceComputer implements Apple,Alienware,Computer
{
    protected String name;
    String weight;

    public GameComputer(String name, String weight)
    {
        this.name = name;
        this.weight = weight;
    }

    public GameComputer(String name, String price, Long cpus, String name1, String weight)
    {
        super(name, price, cpus);
        this.name = name1;
        this.weight = weight;
    }


    public void printColor()
    {
        System.out.println("Blue,Red,Green");

    }


    public static void main(String[] args)
    {
        System.out.println(DateUtil.date());

    }

}
