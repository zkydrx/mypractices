package com.lintcode.www.ToyFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-10-07
 * Time: 00:46
 * Description:
 */
public class ToyFactory
{

    public Toy getToy(String type)
    {
        if(type == "Dog")
        {
            return new Dog();
        }
        else if(type =="Cat")
        {
            return new Cat();
        }
        return null;
    }

    public static void main(String[] args)
    {
        ToyFactory tf = new ToyFactory();
        Toy toy = tf.getToy("Dog");
        toy.talk();
    }
}
