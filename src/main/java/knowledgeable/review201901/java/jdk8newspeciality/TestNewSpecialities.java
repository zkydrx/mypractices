package knowledgeable.review201901.java.jdk8newspeciality;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * Author: zky
 * Date: 2019-02-03
 * Time: 11:55:42
 * Description:
 */
public class TestNewSpecialities
{
    @Test
    public void testOne()
    {
        Arrays.asList("a", "d", "b", "c", "h", "e").forEach(e -> System.out.println(e));
    }
}
