package KnowledgeableReview201901.java.string;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-15
 * Time: 16:45:07
 * Description:
 */
public class TestString
{
    @Test
    public void test()
    {
        String a = "a";
        String b = "a";
        if (a == b)
        {
            System.out.println("a==b指向同一个地址");
        }
        String c = new String("d");

    }
}
