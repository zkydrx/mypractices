package KnowledgeableReview201901.java.integer;

import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-15
 * Time: 16:47:21
 * Description:
 */
public class TestInteger
{
    @Test
    public void test()
    {
        Integer a = 1;
        Integer b = 1;
        if (a == b)
        {
            System.out.println("a==b 指向同一个地址");
        }
        else
        {
            System.out.println("a != b他俩是两个对象");
        }
    }

    /**
     * Integer自动拆箱为int再去比
     * (因为在Integer进行了拆箱之后：是int和int 相比；拆箱方法：intValue())
     */
    @Test
    public void testIntAndInteger()
    {
        Integer a = 1;
        int b = 1;
        System.out.println(a==b);
    }
}
