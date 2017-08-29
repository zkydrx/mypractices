package JavaBianCheng.Fibonacci;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Abbot
 * Date: 2017-08-30
 * Time: 01:28
 * Description:
 */
class FibonacciTest
{
    @BeforeEach
    void setUp()
    {
        System.out.println("Starting...");
    }

    @AfterEach
    void tearDown()
    {
        System.out.println("Ending...");
    }

    @Test
    void getFibonacciForN()
    {
        Fibonacci fibonacci = new Fibonacci();
        List fibonacciForN = fibonacci.getFibonacciForN(10);
        System.out.println(fibonacciForN);
    }

}