package knowledgeable.review201901.stack;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-06
 * Time: 11:47:09
 * Description:
 */
public class StackDemo
{

    static void showpush(Stack st, int a)
    {
        st.push(new Integer(a));
        System.out.println("push(" + a + ")");
        System.out.println("stack: " + st);
    }

    static void showpop(Stack st)
    {
        System.out.print("pop -> ");
        Integer a = (Integer) st.pop();
        System.out.println(a);
        System.out.println("stack: " + st);
    }

    public static void main(String args[])
    {
        Stack st = new Stack();
        System.out.println("stack: " + st);
        showpush(st, 1);
        showpush(st, 2);
        showpush(st, 3);
        showpop(st);
        showpop(st);
        showpop(st);
        try
        {
            showpop(st);
        }
        catch (EmptyStackException e)
        {
            System.out.println("empty stack");
        }
    }
}
