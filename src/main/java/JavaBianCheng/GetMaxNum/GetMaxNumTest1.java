package JavaBianCheng.GetMaxNum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-30
 * Time: 09:21
 * Description:
 */
class GetMaxNumTest1
{
    GetMaxNum getMaxNum = new GetMaxNum();

    @BeforeEach
    void setUp()
    {
        System.out.println("start...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("end...");
    }

    @Test
    void getMaxNum()
    {
        char[] x1 = {'a', 'b', 'c', 'd'};

        List permutation = getMaxNum.permutation(x1, 0, x1.length - 1);
        System.out.println(permutation);
    }

    @Test
    void permutation()
    {
    }

    @Test
    void swap()
    {
    }

    @Test
    void swapNum()
    {
    }

}