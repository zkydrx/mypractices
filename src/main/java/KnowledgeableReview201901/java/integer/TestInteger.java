package KnowledgeableReview201901.java.integer;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-01-15
 * Time: 16:47:21
 * Description:
 */
public class TestInteger
{
    Logger logger = LoggerFactory.getLogger(TestInteger.class);
    @Test
    public void test()
    {
        Integer a = 1;
        Integer b = 1;
        if (a.equals(b))
        {
            logger.info("a==b 指向同一个地址");
        }
        else
        {
            logger.info("a != b他俩是两个对象");
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
        logger.info("a==b::{}",a==b);
    }
}
