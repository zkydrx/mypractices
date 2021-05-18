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
        /**
         * attention：String compare to another String by Equals();
         */
        if (type.equals("Dog"))
        {
            return new Dog();
        }
        else if (type.equals("Cat"))
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
        Toy toy1 = tf.getToy("Cat");
        toy1.talk();
    }
}
